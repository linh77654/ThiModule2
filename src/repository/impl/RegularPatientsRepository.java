package repository.impl;

import model.RegularPatients;
import repository.IRegularPatientsRepository;
import utility.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;

public class RegularPatientsRepository implements IRegularPatientsRepository {

    private static final String FILE_PATH = "src/datal/medical_records.csv";

    @Override
    public List<RegularPatients> getAll() {



        List<String> stringList = ReadAndWrite.readFileCSVToListString(FILE_PATH);
        List<RegularPatients> regularPatientsList = new ArrayList<>();

      
        for (String string : stringList) {
            try {
                RegularPatients regularPatients = RegularPatients.parseFromCSV(string);
                regularPatientsList.add(regularPatients);
            } catch (Exception e) {
                System.out.println("Lỗi khi phân tích dòng CSV: " + string);
                e.printStackTrace();
            }
        }
        return regularPatientsList;
    }

    @Override
    public void delete(int medicalRecordCode) {
        List<RegularPatients> regularPatientsList = getAll();
        regularPatientsList.removeIf(patient -> patient.getMedicalRecordCode() == medicalRecordCode);
        saveToCSV(regularPatientsList);
    }

    @Override
    public void add(RegularPatients regularPatients) {
        List<RegularPatients> regularPatientsList = getAll();
        regularPatientsList.add(regularPatients);
        saveToCSV(regularPatientsList);
    }

    // Phương thức lưu dữ liệu xuống file CSV
    private void saveToCSV(List<RegularPatients> regularPatientsList) {
        List<String> stringList = new ArrayList<>();
        for (RegularPatients patient : regularPatientsList) {
            stringList.add(patient.toCSV());
        }
        ReadAndWrite.writeStringListToFile(FILE_PATH, stringList, false);
    }
}
