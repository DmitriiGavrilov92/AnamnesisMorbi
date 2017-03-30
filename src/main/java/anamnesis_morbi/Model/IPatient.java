package anamnesis_morbi.Model;

import java.util.Map;

/**
 * Created by dmitriigavrylov on 15.03.17.
 */
public interface IPatient {

    int getDoctorId();
    void setDoctorId(int doctorId);

    int getPatientId();
    void setPatientId(int patientId);

    Map<String, Object> getPatientInfo();
    void setPatientInfo(Map<String, Object> patientInfo);
}
