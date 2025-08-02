package com.ps.doctor_booking_api.service;




import java.util.List;

import org.springframework.stereotype.Service;

import com.ps.doctor_booking_api.entity.Appointment;
import com.ps.doctor_booking_api.entity.Doctor;
import com.ps.doctor_booking_api.exception.ResourceNotFoundException;
import com.ps.doctor_booking_api.repository.AppointmentRepository;
import com.ps.doctor_booking_api.repository.DoctorRepository;

@Service

public class AppointmentService {
	private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;

    public AppointmentService(AppointmentRepository appointmentRepository, DoctorRepository doctorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
    }

    public Appointment createAppointment(Long doctorId, Appointment appointment) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + doctorId));
        appointment.setDoctor(doctor);
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id: " + id));
    }

    public List<Appointment> getAppointmentsByDoctor(Long doctorId) {
        // ensure doctor exists
        doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + doctorId));
        return appointmentRepository.findByDoctorId(doctorId);
    }

    public Appointment updateAppointment(Long id, Appointment updated) {
        Appointment existing = getAppointmentById(id);
        existing.setPatientName(updated.getPatientName());
        existing.setAppointmentTime(updated.getAppointmentTime());
        existing.setReason(updated.getReason());
        existing.setStatus(updated.getStatus());
        // doctor change not allowed here for simplicity; could add logic if needed
        return appointmentRepository.save(existing);
    }

    public void deleteAppointment(Long id) {
        Appointment existing = getAppointmentById(id);
        appointmentRepository.delete(existing);
    }
}
