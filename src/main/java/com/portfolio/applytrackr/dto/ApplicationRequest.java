package com.portfolio.applytrackr.dto;

import com.portfolio.applytrackr.enums.ApplicationStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record ApplicationRequest(
        @NotBlank(message = "Company name is required")
        String companyName,

        @NotBlank(message = "Role is required")
        String role,

        String location,

        ApplicationStatus status,

        @NotNull(message = "Application date is required")
        LocalDate applicationDate,

        LocalDate deadline,

        String notes
) {
}
