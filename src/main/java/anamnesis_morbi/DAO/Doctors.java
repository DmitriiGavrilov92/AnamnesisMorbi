package anamnesis_morbi.DAO;

import anamnesis_morbi.Model.Doctor;
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
public class Doctors implements IDoctors {
    private static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(
            new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-west-2"))
            .build();

    private static DynamoDB dynamoDB = new DynamoDB(client);

    private static DynamoDBMapper mapper = new DynamoDBMapper(client);

    private static String tableName = "Doctors";

    private static Table table = dynamoDB.getTable("Doctors");

    public Doctor getDoctor(int doctodId){
        Doctor item = mapper.load(Doctor.class, doctodId);
        return item;
    }

    public void setDoctor(int doctorId, String doctorName, String doctorEmail, int doctorPass){
        Doctor item = new Doctor();
        item.setDoctorId(doctorId);
        item.setDoctorName(doctorName);
        item.setDoctorEmail(doctorEmail);
        item.setDoctorPass(doctorPass);


        // Save the item (patient).

        mapper.save(item);

    }
    public void updateDoctor(int doctorId, String doctorName, String doctorEmail, int doctorPass){
        Doctor item = getDoctor(doctorId);

        item.setDoctorName(doctorName);
        item.setDoctorEmail(doctorEmail);
        item.setDoctorPass(doctorPass);

        // Save the item (patient).

        mapper.save(item);
    }
    public void deleteDoctor(int doctodId){
        Doctor item = getDoctor(doctodId);
        mapper.delete(item);
    }

    public List<Doctor> getAll(){
        List<Doctor> items = mapper.scan(Doctor.class, new DynamoDBScanExpression());
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
