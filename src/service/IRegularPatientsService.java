package service;

import model.RegularPatients;

import java.util.List;

public interface IRegularPatientsService {
    List<RegularPatients> getAll();
    void deleted (int medicalRecordCode);
    void addRegularPatients(RegularPatients regularPatients);
    int getMaxOrderNumber();
}
