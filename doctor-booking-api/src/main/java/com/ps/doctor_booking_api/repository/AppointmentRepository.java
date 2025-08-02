package com.ps.doctor_booking_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps.doctor_booking_api.entity.Appointment;

import java.util.List;

public interface AppointmentRepository  extends JpaRepository<Appointment, Long> {
	List<Appointment> findByDoctorId(Long doctorId);
}
