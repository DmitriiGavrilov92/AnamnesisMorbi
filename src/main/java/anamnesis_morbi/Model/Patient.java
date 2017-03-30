package anamnesis_morbi.Model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Map;

/**
 * Created by dmitriigavrylov on 15.03.17.
 */
@DynamoDBTable(tableName = "Patients")
public class Patient implements IPatient {
    private int doctorId;
    private int patientId;
    private Map<String, Object> patientInfo;

//    public Patient(int doctorId, int patientId, Map<String, Object> patientInfo){
//        this.doctorId = doctorId;
//        this.patientId = patientId;
//        this.patientInfo = patientInfo;
//    }

    @DynamoDBIndexHashKey(attributeName = "doctor_id")
    public int getDoctorId(){
        return doctorId;
    }
    public void setDoctorId(int patientId){
        this.patientId = patientId;
    }

    @DynamoDBIndexRangeKey(attributeName = "patient_id")
    public int getPatientId(){
        return patientId;
    }
    public void setPatientId(int patientId){
        this.patientId = patientId;
    }

    @DynamoDBAttribute(attributeName = "patient_info")
    public Map<String, Object> getPatientInfo(){
        return patientInfo;
    }
    public void setPatientInfo(Map<String, Object> patientInfo){
        this.patientInfo = patientInfo;
    }
}
