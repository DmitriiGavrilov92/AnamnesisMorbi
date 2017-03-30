package anamnesis_morbi.DAO;

import anamnesis_morbi.Model.Patient;

import java.util.List;
import java.util.Map;

/**
 * Created by dmitriigavrylov on 15.03.17.
 */
public interface IPatients {
    Patient getPatient(int doctodId, int patientId);
    void setPatient(int doctorId, int patientId, Map<String, Object> patientInfo);
    void updatePatient(int doctorId, int patientId, Map<String, Object> patientInfo);
    void deletePatient(int doctodId, int patientId);
    List<Patient> getAll();
}
