package com.portfolio.applytrackr.config;

import com.portfolio.applytrackr.entity.JobApplication;
import com.portfolio.applytrackr.enums.ApplicationStatus;
import com.portfolio.applytrackr.repository.JobApplicationRepository;
import java.time.LocalDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {
    @Bean
    CommandLineRunner seedApplications(JobApplicationRepository repository) {
        return args -> {
            JobApplication first = new JobApplication();
            first.setCompanyName("Acme Cloud");
            first.setRole("Java Backend Intern");
            first.setLocation("Remote");
            first.setStatus(ApplicationStatus.APPLIED);
            first.setApplicationDate(LocalDate.now().minusDays(2));
            first.setDeadline(LocalDate.now().plusDays(10));
            first.setNotes("Submitted resume and Spring Boot portfolio link.");

            JobApplication second = new JobApplication();
            second.setCompanyName("Northstar Fintech");
            second.setRole("Software Engineering Intern");
            second.setLocation("Bengaluru");
            second.setStatus(ApplicationStatus.INTERVIEW);
            second.setApplicationDate(LocalDate.now().minusDays(8));
            second.setDeadline(LocalDate.now().plusDays(3));
            second.setNotes("Prepare REST API and SQL questions.");

            repository.save(first);
            repository.save(second);
        };
    }
}
