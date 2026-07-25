package com.portfolio.applytrackr.repository;

import com.portfolio.applytrackr.entity.JobApplication;
import com.portfolio.applytrackr.enums.ApplicationStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    List<JobApplication> findByStatus(ApplicationStatus status);

    List<JobApplication> findByCompanyNameContainingIgnoreCaseOrRoleContainingIgnoreCase(String company, String role);
}
