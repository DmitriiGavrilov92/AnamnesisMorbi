package anamnesis_morbi.Model;

/**
 * Created by dmitriigavrylov on 15.03.17.
 */
public interface IDoctor {
    void setDoctorId(int doctorId);
    int getDoctorId();

    void setDoctorName(String doctorName);
    String getDoctorName();

    void setDoctorEmail(String doctorEmail);
    String getDoctorEmail();

    void setDoctorPass(int doctorPass);
    int getDoctorPass();
}
