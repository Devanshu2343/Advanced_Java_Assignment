package org.example.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "prescriptions")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medicines;
    private String dosage;
    private LocalDate issuedDate;
    private boolean active;

    public Prescription() {}

    public Prescription(String medicines, String dosage, LocalDate issuedDate, boolean active) {
        this.medicines = medicines;
        this.dosage = dosage;
        this.issuedDate = issuedDate;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public LocalDate getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(LocalDate issuedDate) {
        this.issuedDate = issuedDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}