package com.ps.doctor_booking_api.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

@Data
@Entity
@Table(name = "appointments")

public class Appointment {
	 public enum Status {
	        SCHEDULED,
	        COMPLETED,
	        CANCELLED
	    }

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank(message = "Patient name is required")
	    @Size(min = 2, max = 100, message = "Patient name must be between 2 and 100 characters")
	    private String patientName;

	    @Future(message = "Appointment time must be in the future")
	    private LocalDateTime appointmentTime;

	    @NotBlank(message = "Reason is required")
	    private String reason;

	    @Enumerated(EnumType.STRING)
	    private Status status = Status.SCHEDULED;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "doctor_id", nullable = false)
	    private Doctor doctor;

}
