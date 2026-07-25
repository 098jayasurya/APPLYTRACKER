package com.portfolio.applytrackr.service;

import com.portfolio.applytrackr.dto.ApplicationRequest;
import com.portfolio.applytrackr.dto.StatusUpdateRequest;
import com.portfolio.applytrackr.entity.JobApplication;
import com.portfolio.applytrackr.enums.ApplicationStatus;
import com.portfolio.applytrackr.exception.ResourceNotFoundException;
import com.portfolio.applytrackr.repository.JobApplicationRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {
    private final JobApplicationRepository repository;

    public ApplicationService(JobApplicationRepository repository) {
        this.repository = repository;
    }

    public JobApplication create(ApplicationRequest request) {
        JobApplication application = new JobApplication();
        application.setCompanyName(request.companyName());
        application.setRole(request.role());
        application.setLocation(request.location());
        application.setStatus(request.status() == null ? ApplicationStatus.APPLIED : request.status());
        application.setApplicationDate(request.applicationDate());
        application.setDeadline(request.deadline());
        application.setNotes(request.notes());
        return repository.save(application);
    }

    public List<JobApplication> findAll() {
        return repository.findAll();
    }

    public JobApplication findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Application not found with id " + id));
    }

    public List<JobApplication> findByStatus(ApplicationStatus status) {
        return repository.findByStatus(status);
    }

    public List<JobApplication> search(String keyword) {
        return repository.findByCompanyNameContainingIgnoreCaseOrRoleContainingIgnoreCase(keyword, keyword);
    }

    public JobApplication updateStatus(Long id, StatusUpdateRequest request) {
        JobApplication application = findById(id);
        application.setStatus(request.status());
        return repository.save(application);
    }

    public void delete(Long id) {
        JobApplication application = findById(id);
        repository.delete(application);
    }
}
