package com.example.demo.controller;

import com.example.demo.entity.RiskAssessment;
import com.example.demo.service.RiskAssessmentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/risk-assessments")
public class RiskAssessmentController {

    private final RiskAssessmentService service;

    public RiskAssessmentController(RiskAssessmentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RiskAssessment> postData5(@Valid @RequestBody RiskAssessment riskAssessment) {
        return ResponseEntity.ok(service.postData5(riskAssessment));
    }

    @GetMapping
    public ResponseEntity<List<RiskAssessment>> getAllData5() {
        return ResponseEntity.ok(service.getAllData5());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteData5(@PathVariable Long id) {
        service.deleteData5(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiskAssessment> getData5(@PathVariable Long id) {
        return ResponseEntity.ok(service.getData5(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RiskAssessment> updateData5(
            @PathVariable Long id,
            @Valid @RequestBody RiskAssessment riskAssessment) {
        return ResponseEntity.ok(service.updateData5(id, riskAssessment));
    }
}