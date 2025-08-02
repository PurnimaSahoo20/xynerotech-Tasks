package com.ps.doctor_booking_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

@Data
@Entity
@Table(name = "doctors")

public class Doctor {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank(message = "Name is required")
	    @Size(min = 2, max = 50, message = "Name must be between 2–50 characters")
	    private String name;

	    @NotBlank(message = "Specialization is required")
	    private String specialization;

	    @NotBlank(message = "Contact is required")
	    private String contact;

}
