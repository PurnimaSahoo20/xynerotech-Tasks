package com.ps.doctor_booking_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps.doctor_booking_api.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}