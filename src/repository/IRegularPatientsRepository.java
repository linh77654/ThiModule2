package repository;

import model.RegularPatients;
import java.util.List;

public interface IRegularPatientsRepository {
    List<RegularPatients> getAll();
    void delete(int medicalRecordCode);
    void add(RegularPatients regularPatients);
}
