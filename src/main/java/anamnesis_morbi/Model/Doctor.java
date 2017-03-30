package anamnesis_morbi.Model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * Created by dmitriigavrylov on 15.03.17.
 */
@DynamoDBTable(tableName = "Doctors")
public class Doctor implements IDoctor {
    private int doctorId;
    private String doctorName;
    private String doctorEmail;
    private int doctorPass;

    @DynamoDBHashKey(attributeName = "doctor_id")
    public int getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    @DynamoDBAttribute(attributeName = "doctor_name")
    public String getDoctorName() {
        return doctorName;
    }
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    @DynamoDBAttribute(attributeName = "doctor_email")
    public String getDoctorEmail() {
        return doctorEmail;
    }
    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    @DynamoDBAttribute(attributeName = "doctor_pass")
    public int getDoctorPass() {
        return doctorPass;
    }
    public void setDoctorPass(int doctorPass) {
        this.doctorPass = doctorPass;
    }
}
