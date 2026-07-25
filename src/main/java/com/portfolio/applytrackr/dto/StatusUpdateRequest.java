package com.portfolio.applytrackr.dto;

import com.portfolio.applytrackr.enums.ApplicationStatus;
import jakarta.validation.constraints.NotNull;

public record StatusUpdateRequest(
        @NotNull(message = "Status is required")
        ApplicationStatus status
) {
}
