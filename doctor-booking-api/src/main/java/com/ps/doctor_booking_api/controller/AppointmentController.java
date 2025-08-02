package com.ps.doctor_booking_api.controller;




import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ps.doctor_booking_api.entity.Appointment;
import com.ps.doctor_booking_api.service.AppointmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/appointments")

public class AppointmentController {
	private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    // Create appointment for a given doctor
    @PostMapping("/doctor/{doctorId}")
    public ResponseEntity<Appointment> createAppointment(@PathVariable Long doctorId,
                                                         @Valid @RequestBody Appointment appointment) {
        return ResponseEntity.ok(appointmentService.createAppointment(doctorId, appointment));
    }

    // Get all appointments
    @GetMapping
    public ResponseEntity<List<Appointment>> getAll() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    // Get appointment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getById(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.getAppointmentById(id));
    }

    // Get appointments for a doctor
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Appointment>> getByDoctor(@PathVariable Long doctorId) {
        return ResponseEntity.ok(appointmentService.getAppointmentsByDoctor(doctorId));
    }

    // Update appointment
    @PutMapping("/{id}")
    public ResponseEntity<Appointment> update(@PathVariable Long id,
                                              @Valid @RequestBody Appointment appointment) {
        return ResponseEntity.ok(appointmentService.updateAppointment(id, appointment));
    }

    // Delete appointment
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }
}
