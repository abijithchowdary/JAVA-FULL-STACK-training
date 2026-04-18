package com.pharmacy.catalog.service;

import com.pharmacy.catalog.dto.MedicineRequest;
import com.pharmacy.catalog.dto.MedicineResponse;
import com.pharmacy.catalog.entity.Category;
import com.pharmacy.catalog.entity.Medicine;
import com.pharmacy.catalog.exception.CategoryNotFoundException;
import com.pharmacy.catalog.exception.MedicineNotFoundException;
import com.pharmacy.catalog.repository.CategoryRepository;
import com.pharmacy.catalog.repository.MedicineRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MedicineServiceTest {

    @Mock MedicineRepository medicineRepo;
    @Mock CategoryRepository categoryRepo;

    @InjectMocks MedicineService medicineService;

    private Medicine medicine;
    private MedicineRequest request;

    @BeforeEach
    void setUp() {
        Category cat = new Category();
        cat.setId(1L);
        cat.setName("Antibiotics");

        medicine = new Medicine();
        medicine.setId(1L);
        medicine.setName("Amoxicillin");
        medicine.setPrice(new BigDecimal("50.00"));
        medicine.setStockQuantity(100);
        medicine.setRequiresPrescription(false);
        medicine.setCategory(cat);

        request = new MedicineRequest();
        request.setName("Amoxicillin");
        request.setPrice(new BigDecimal("50.00"));
        request.setStockQuantity(100);
        request.setRequiresPrescription(false);
        request.setCategoryId(1L);
    }

    @Test
    void getAll_returnsAllMedicines() {
        when(medicineRepo.findAll()).thenReturn(List.of(medicine));
        List<MedicineResponse> result = medicineService.getAll();
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getName()).isEqualTo("Amoxicillin");
    }

    @Test
    void getById_returnsCorrectMedicine() {
        when(medicineRepo.findById(1L)).thenReturn(Optional.of(medicine));
        MedicineResponse result = medicineService.getById(1L);
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getName()).isEqualTo("Amoxicillin");
    }

    @Test
    void getById_throwsWhenNotFound() {
        when(medicineRepo.findById(99L)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> medicineService.getById(99L))
                .isInstanceOf(MedicineNotFoundException.class)
                .hasMessageContaining("99");
    }

    @Test
    void create_savesAndReturnsMedicine() {
        when(categoryRepo.findById(1L)).thenReturn(Optional.of(medicine.getCategory()));
        when(medicineRepo.save(any(Medicine.class))).thenReturn(medicine);

        MedicineResponse result = medicineService.create(request);
        assertThat(result.getName()).isEqualTo("Amoxicillin");
        verify(medicineRepo).save(any(Medicine.class));
    }

    @Test
    void create_throwsWhenCategoryNotFound() {
        when(categoryRepo.findById(1L)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> medicineService.create(request))
                .isInstanceOf(CategoryNotFoundException.class);
    }

    @Test
    void update_updatesExistingMedicine() {
        when(medicineRepo.findById(1L)).thenReturn(Optional.of(medicine));
        when(categoryRepo.findById(1L)).thenReturn(Optional.of(medicine.getCategory()));
        when(medicineRepo.save(any(Medicine.class))).thenReturn(medicine);

        MedicineResponse result = medicineService.update(1L, request);
        assertThat(result.getName()).isEqualTo("Amoxicillin");
    }

    @Test
    void update_throwsWhenMedicineNotFound() {
        when(medicineRepo.findById(99L)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> medicineService.update(99L, request))
                .isInstanceOf(MedicineNotFoundException.class);
    }

    @Test
    void delete_deletesSuccessfully() {
        when(medicineRepo.existsById(1L)).thenReturn(true);
        medicineService.delete(1L);
        verify(medicineRepo).deleteById(1L);
    }

    @Test
    void delete_throwsWhenNotFound() {
        when(medicineRepo.existsById(99L)).thenReturn(false);
        assertThatThrownBy(() -> medicineService.delete(99L))
                .isInstanceOf(MedicineNotFoundException.class);
    }

    @Test
    void search_returnsMatchingMedicines() {
        when(medicineRepo.findByNameContainingIgnoreCase("amox")).thenReturn(List.of(medicine));
        List<MedicineResponse> result = medicineService.search("amox");
        assertThat(result).hasSize(1);
    }

    @Test
    void search_returnsEmptyWhenNoMatch() {
        when(medicineRepo.findByNameContainingIgnoreCase("xyz")).thenReturn(List.of());
        List<MedicineResponse> result = medicineService.search("xyz");
        assertThat(result).isEmpty();
    }
}
