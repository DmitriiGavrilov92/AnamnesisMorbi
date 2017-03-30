package anamnesis_morbi.DAO;

import anamnesis_morbi.Model.Patient;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by dmitriigavrylov on 15.03.17.
 */
public class Patients implements IPatients {

    private static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(
            new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-west-2"))
            .build();

    private static DynamoDB dynamoDB = new DynamoDB(client);

    private static DynamoDBMapper mapper = new DynamoDBMapper(client);

    private static String tableName = "Patients";

    private static Table table = dynamoDB.getTable("Patients");


    public Patient getPatient(int doctodId, int patientId){
        Patient item = mapper.load(Patient.class, doctodId, patientId);
        return item;
    }

    public void setPatient(int doctorId, int patientId, Map<String, Object> patientInfo){
        Patient item = new Patient();
        item.setDoctorId(doctorId);
        item.setPatientId(patientId);
        item.setPatientInfo(patientInfo);


        // Save the item (patient).

        mapper.save(item);

    }
    public void updatePatient(int doctorId, int patientId, Map<String, Object> patientInfo){
        Patient item = getPatient(doctorId, patientId);

        item.setPatientInfo(patientInfo);

        // Save the item (patient).

        mapper.save(item);
    }
    public void deletePatient(int doctodId, int patientId){
        Patient item = getPatient(doctodId,patientId);
        mapper.delete(item);
    }

    public List<Patient> getAll(){
        List<Patient> items = mapper.scan(Patient.class, new DynamoDBScanExpression());
        return items;
    }

//    public void createTable() throws Exception{
//
//
//        try {
//            System.out.println("Attempting to create table; please wait...");
//            Table table = dynamoDB.createTable(tableName,
//                    Arrays.asList(
//                            new KeySchemaElement("doctor_id", KeyType.HASH), //Partition key
//                            new KeySchemaElement("patient_id", KeyType.RANGE)), //Sort key
//                    Arrays.asList(
//                            new AttributeDefinition("doctor_id", ScalarAttributeType.N),
//                            new AttributeDefinition("patient_id", ScalarAttributeType.N)),
//                    new ProvisionedThroughput(10L, 10L));
//            table.waitForActive();
//            System.out.println("Success.  Table status: " + table.getDescription().getTableStatus());
//
//        } catch (Exception e) {
//            System.err.println("Unable to create table: ");
//            System.err.println(e.getMessage());
//        }
//
//
//    }
}
