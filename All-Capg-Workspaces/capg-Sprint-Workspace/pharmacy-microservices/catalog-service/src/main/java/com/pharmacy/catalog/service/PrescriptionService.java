package com.pharmacy.catalog.service;

import com.pharmacy.catalog.dto.PrescriptionResponse;
import com.pharmacy.catalog.entity.Prescription;
import com.pharmacy.catalog.exception.PrescriptionNotFoundException;
import com.pharmacy.catalog.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepo;

    public PrescriptionService(PrescriptionRepository prescriptionRepo) {
        this.prescriptionRepo = prescriptionRepo;
    }

    public PrescriptionResponse upload(Long customerId, String email, String imageUrl) {
        Prescription p = new Prescription();
        p.setCustomerId(customerId);
        p.setCustomerEmail(email);
        p.setImageUrl(imageUrl);
        return toResponse(prescriptionRepo.save(p));
    }

    public List<PrescriptionResponse> getPending() {
        return prescriptionRepo.findByStatus(Prescription.PrescriptionStatus.PENDING)
                .stream().map(this::toResponse).collect(Collectors.toList());
    }

    public List<PrescriptionResponse> getByCustomer(Long customerId) {
        return prescriptionRepo.findByCustomerId(customerId)
                .stream().map(this::toResponse).collect(Collectors.toList());
    }

    public PrescriptionResponse approve(Long id) {
        Prescription p = findOrThrow(id);
        p.setStatus(Prescription.PrescriptionStatus.APPROVED);
        return toResponse(prescriptionRepo.save(p));
    }

    public PrescriptionResponse reject(Long id, String reason) {
        Prescription p = findOrThrow(id);
        p.setStatus(Prescription.PrescriptionStatus.REJECTED);
        p.setRejectionReason(reason);
        return toResponse(prescriptionRepo.save(p));
    }

    private Prescription findOrThrow(Long id) {
        return prescriptionRepo.findById(id)
                .orElseThrow(() -> new PrescriptionNotFoundException("Prescription not found with id: " + id));
    }

    private PrescriptionResponse toResponse(Prescription p) {
        PrescriptionResponse r = new PrescriptionResponse();
        r.setId(p.getId());
        r.setCustomerId(p.getCustomerId());
        r.setCustomerEmail(p.getCustomerEmail());
        r.setImageUrl(p.getImageUrl());
        r.setStatus(p.getStatus().name());
        r.setRejectionReason(p.getRejectionReason());
        r.setUploadedAt(p.getUploadedAt());
        return r;
    }
}
