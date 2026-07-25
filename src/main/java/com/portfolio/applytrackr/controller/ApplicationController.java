package com.portfolio.applytrackr.controller;

import com.portfolio.applytrackr.dto.ApplicationRequest;
import com.portfolio.applytrackr.dto.StatusUpdateRequest;
import com.portfolio.applytrackr.entity.JobApplication;
import com.portfolio.applytrackr.enums.ApplicationStatus;
import com.portfolio.applytrackr.service.ApplicationService;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {
    private final ApplicationService service;

    public ApplicationController(ApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<JobApplication> create(@Valid @RequestBody ApplicationRequest request) {
        JobApplication created = service.create(request);
        return ResponseEntity.created(URI.create("/api/applications/" + created.getId())).body(created);
    }

    @GetMapping
    public List<JobApplication> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public JobApplication findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/status/{status}")
    public List<JobApplication> findByStatus(@PathVariable ApplicationStatus status) {
        return service.findByStatus(status);
    }

    @GetMapping("/search")
    public List<JobApplication> search(@RequestParam String keyword) {
        return service.search(keyword);
    }

    @PatchMapping("/{id}/status")
    public JobApplication updateStatus(@PathVariable Long id, @Valid @RequestBody StatusUpdateRequest request) {
        return service.updateStatus(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
