package model;

import java.time.LocalDate;

public class VipPatient extends MedicalRecord{
    private String vipType;
    private String vipExpirationDate;

    public VipPatient(String numericalOrder, int medicalRecordCode, String name, LocalDate dateOfAdmission, LocalDate hospitalDischargeDate, String reasonForHospitalization, String vipType, String vipExpirationDate) {
        super(numericalOrder, medicalRecordCode, name, dateOfAdmission, hospitalDischargeDate, reasonForHospitalization);
        this.vipType = vipType;
        this.vipExpirationDate = vipExpirationDate;
    }

    public String getVipType() {
        return vipType;
    }

    public void setVipType(String vipType) {
        this.vipType = vipType;
    }

    public String getVipExpirationDate() {
        return vipExpirationDate;
    }

    public void setVipExpirationDate(String vipExpirationDate) {
        this.vipExpirationDate = vipExpirationDate;
    }

    @Override
    public String toString() {
        return "VipPatient{" +
                "vipType='" + vipType + '\'' +
                ", vipExpirationDate='" + vipExpirationDate + '\'' +
                "} " + super.toString();
    }}

