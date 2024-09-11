package service.impl;

import model.RegularPatients;
import repository.IRegularPatientsRepository;
import repository.impl.RegularPatientsRepository;
import service.IRegularPatientsService;

import java.util.List;

public class RegularPatientsService implements IRegularPatientsService {
    private IRegularPatientsRepository regularPatientsRepository = new RegularPatientsRepository();

    @Override
    public List<model.RegularPatients> getAll() {
        return regularPatientsRepository.getAll();
    }

    @Override
    public void deleted(int medicalRecordCode) {
        regularPatientsRepository.delete(medicalRecordCode);
    }

    @Override
    public void addRegularPatients(model.RegularPatients regularPatients) {
        regularPatientsRepository.add(regularPatients);
    }

    @Override
    public int getMaxOrderNumber() {
        List<RegularPatients> patients = regularPatientsRepository.getAll();
        return patients.stream()
                .mapToInt(p -> Integer.parseInt(p.getNumericalOrder().replace("BA-", "")))
                .max()
                .orElse(0);
}
}
