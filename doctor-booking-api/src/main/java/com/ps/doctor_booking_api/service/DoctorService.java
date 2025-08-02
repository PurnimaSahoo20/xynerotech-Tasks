package com.ps.doctor_booking_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ps.doctor_booking_api.entity.Doctor;
import com.ps.doctor_booking_api.exception.ResourceNotFoundException;
import com.ps.doctor_booking_api.repository.DoctorRepository;

@Service
public class DoctorService {
	 private final DoctorRepository doctorRepository;

	    public DoctorService(DoctorRepository doctorRepository) {
	        this.doctorRepository = doctorRepository;
	    }

	    public Doctor createDoctor(Doctor doctor) {
	        return doctorRepository.save(doctor);
	    }

	    public List<Doctor> getAllDoctors() {
	        return doctorRepository.findAll();
	    }

	    public Doctor getDoctorById(Long id) {
	        return doctorRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + id));
	    }

	    public Doctor updateDoctor(Long id, Doctor updatedDoctor) {
	        Doctor doctor = getDoctorById(id);
	        doctor.setName(updatedDoctor.getName());
	        doctor.setSpecialization(updatedDoctor.getSpecialization());
	        doctor.setContact(updatedDoctor.getContact());
	        return doctorRepository.save(doctor);
	    }

	    public void deleteDoctor(Long id) {
	        Doctor doctor = getDoctorById(id);
	        doctorRepository.delete(doctor);
	    }
}
