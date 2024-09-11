package model;

import java.time.LocalDate;

public class RegularPatients extends MedicalRecord {
    private int hospitalFees;

    public RegularPatients() {}

    public RegularPatients(String numericalOrder, int medicalRecordCode, String name, LocalDate dateOfAdmission, LocalDate hospitalDischargeDate, String reasonForHospitalization, int hospitalFees) {
        super(numericalOrder, medicalRecordCode, name, dateOfAdmission, hospitalDischargeDate, reasonForHospitalization);
        this.hospitalFees = hospitalFees;
    }

    public int getHospitalFees() {
        return hospitalFees;
    }

    public void setHospitalFees(int hospitalFees) {
        this.hospitalFees = hospitalFees;
    }


    public static RegularPatients parseFromCSV(String csvLine) {
        String[] fields = csvLine.split(",");
        return new RegularPatients(fields[0], Integer.parseInt(fields[1]), fields[2],
                LocalDate.parse(fields[3]), LocalDate.parse(fields[4]),
                fields[5], Integer.parseInt(fields[6]));
    }

    public String toCSV() {
        return String.join(",", getNumericalOrder(), String.valueOf(getMedicalRecordCode()),
                getName(), getDateOfAdmission().toString(), getHospitalDischargeDate().toString(),
                getReasonForHospitalization(), String.valueOf(hospitalFees));
}


}
