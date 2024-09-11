package model;

import java.time.LocalDate;

public abstract class MedicalRecord {
    private String numericalOrder;
    private int medicalRecordCode;
    private String name;
    private LocalDate dateOfAdmission;
    private LocalDate hospitalDischargeDate;
    private String reasonForHospitalization;

    public MedicalRecord() {}

    public MedicalRecord(String numericalOrder, int medicalRecordCode, String name, LocalDate dateOfAdmission, LocalDate hospitalDischargeDate, String reasonForHospitalization) {
        this.numericalOrder = numericalOrder;
        this.medicalRecordCode = medicalRecordCode;
        this.name = name;
        this.dateOfAdmission = dateOfAdmission;
        this.hospitalDischargeDate = hospitalDischargeDate;
        this.reasonForHospitalization = reasonForHospitalization;
    }

    public String getNumericalOrder() {
        return numericalOrder;
    }

    public void setNumericalOrder(String numericalOrder) {
        this.numericalOrder = numericalOrder;
    }

    public int getMedicalRecordCode() {
        return medicalRecordCode;
    }

    public void setMedicalRecordCode(int medicalRecordCode) {
        this.medicalRecordCode = medicalRecordCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(LocalDate dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public LocalDate getHospitalDischargeDate() {
        return hospitalDischargeDate;
    }

    public void setHospitalDischargeDate(LocalDate hospitalDischargeDate) {
        this.hospitalDischargeDate = hospitalDischargeDate;
    }

    public String getReasonForHospitalization() {
        return reasonForHospitalization;
    }

    public void setReasonForHospitalization(String reasonForHospitalization) {
        this.reasonForHospitalization = reasonForHospitalization;
    }

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "numericalOrder='" + numericalOrder + '\'' +
                ", medicalRecordCode=" + medicalRecordCode +
                ", name='" + name + '\'' +
                ", dateOfAdmission=" + dateOfAdmission +
                ", hospitalDischargeDate=" + hospitalDischargeDate +
                ", reasonForHospitalization='" + reasonForHospitalization + '\'' +
                '}';
    }
}
