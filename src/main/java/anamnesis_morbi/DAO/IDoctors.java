package anamnesis_morbi.DAO;

import anamnesis_morbi.Model.Doctor;

import java.util.List;
import java.util.Map;

/**
 * Created by dmitriigavrylov on 15.03.17.
 */
public interface IDoctors {
    Doctor getDoctor(int doctodId);
    void setDoctor(int doctorId, String doctorName, String doctorEmail, int doctorPass);
    void updateDoctor(int doctorId, String doctorName, String doctorEmail, int doctorPass);
    void deleteDoctor(int doctodId);
    List<Doctor> getAll();
}
