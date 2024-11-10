package JsonStudentData;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import static org.apache.http.impl.client.HttpClients.createDefault;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ParsedStudents{

    public static ArrayList<Student> parseJSON(String url) throws ParseException {
        ArrayList<Student> studentList = new ArrayList<>();
        CloseableHttpClient httpClient = createDefault();
        HttpGet request = new HttpGet(url);

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String urlData = EntityUtils.toString(entity);
                JSONParser parser = new JSONParser();
                JSONArray jsonArray = (JSONArray) parser.parse(urlData);

                for (Object obj : jsonArray) {
                    JSONObject jsonObject = (JSONObject) obj;
                    Student student = new Student(
                            ((Long) jsonObject.get("id")).intValue(),
                            (String) jsonObject.get("first_name"),
                            (String) jsonObject.get("gender"),
                            (String) jsonObject.get("email"),
                            jsonObject.get("gpa") instanceof Double ? (Double) jsonObject.get("gpa") : Double.parseDouble((String) jsonObject.get("gpa")));
                    studentList.add(student);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return studentList;
    }

    public static void main(String[] args) throws ParseException {
        ArrayList<Student> studentList = parseJSON("https://hccs-advancejava.s3.amazonaws.com/student.json");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter one of the students name:");
        String name = scanner.nextLine();
        for (Student student : studentList) {
            if (name.equalsIgnoreCase(student.getFirstName())) {
                System.out.println("Here is the students profile:\n" + student.getGpa() +"\n"+ student.getEmail() +"\n"+ student.getGender() +"\n"+ student.getId() +"\n");
            }
        }


    }

}