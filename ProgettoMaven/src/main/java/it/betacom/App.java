package it.betacom;

import com.google.gson.Gson;
import it.betacom.model.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Student student = new Student();

        student.setNome("Michele");
        student.setEta(21);

        Gson gson = new Gson();
        String json = gson.toJson(student);
        System.out.println("Oggetto convertito in JSON " + json);

        Student parsedStudent = gson.fromJson(json, Student.class);
        System.out.println("JSON convertito in oggetto " + parsedStudent);

    }
}
