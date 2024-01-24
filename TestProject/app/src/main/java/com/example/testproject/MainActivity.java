package com.example.testproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testproject.model.EnumBranch;
import com.example.testproject.model.LoginCredentials;
import com.example.testproject.model.Student;
import com.example.testproject.model.Teacher;
import com.example.testproject.restapi.student.concretes.ManagerAllStudent;
import com.example.testproject.restapi.teacher.concretes.ManagerAllTeacher;
import com.example.testproject.utility.StrictModePolicy;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ManagerAllTeacher managerAllTeacher = null;// ManagerAllTeacher.getInstance(getApplicationContext());
    private ManagerAllStudent managerAllStudent = null;//ManagerAllStudent.getInstance(getApplicationContext());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictModePolicy.enable();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        managerAllTeacher = ManagerAllTeacher.getInstance(getApplicationContext());
        managerAllStudent = ManagerAllStudent.getInstance(getApplicationContext());

        TextView tv = findViewById(R.id.txt);
        String text = "";
//        text = loginStudent();
//      text = loginTeacher();
//        text = findStudentById(3);
  //      text = saveStudent();
//        text = saveTeacher();
//      text = getAllTeachers();
        text = getAllStudents();

        tv.setText(text);


    }

    private String loginStudent() {
        LoginCredentials credentials = new LoginCredentials();
        credentials.setUsername("385931");
        credentials.setPassword("pass");
        Student student = managerAllStudent.login(credentials);
//        User user = ManagerAllStudent.getInstance().login(credentials);
        if (student == null) {
            String msg = "student is : " + student;
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            return msg;
        }
        StringBuilder sb = new StringBuilder("");
//        sb.append(user.toString()).append("\n\n");
        sb.append(student.toString());
        return sb.toString();
    }

    private String findStudentById(int studentId) {
        Student student = managerAllStudent.getStudentById(studentId);
//        User user = ManagerAllStudent.getInstance().login(credentials);
        if (student == null) {
            String msg = "student is : " + student;
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            return msg;
        }
        StringBuilder sb = new StringBuilder("");
//        sb.append(user.toString()).append("\n\n");
        sb.append(student.toString());
        return sb.toString();
    }


    private String saveStudent() {
        Student student = new Student();
        student.setNo("383838");
        student.setPassword("pass");
        student.setUsername("Mustafa123");
        student.setParentId(3);
        student.setName("Mustafa");
        student.setLastname("KARAMAN");
        student = managerAllStudent.saveStudent(student);
//        User user = ManagerAllStudent.getInstance().login(credentials);
        if (student == null) {
            String msg = "SAVED student is : " + student;
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            return msg;
        }
        StringBuilder sb = new StringBuilder("STUDENT IS SAVED");
//        sb.append(user.toString()).append("\n\n");
        sb.append(student.toString());
        return sb.toString();
    }

    private String getAllStudents() {
        List<Student> list = managerAllStudent.getAllStudents();

        if (list == null) {
            String msg = "student List  is : " + list;
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            return msg;
        }


        StringBuilder sb = new StringBuilder();
        for (Student tmp : list) {
            sb.append(tmp).append("\n");
        }
        return sb.toString();
    }


    private String loginTeacher() {
        LoginCredentials credentials = new LoginCredentials();
        credentials.setUsername("hacer");
        credentials.setPassword("pass");
//        Teacher teacher = ManagerAllTeacher.getInstance().login(credentials);
        Teacher teacher = managerAllTeacher.login(credentials);
//        User user = ManagerAllTeacher.getInstance().login(credentials);
        StringBuilder sb = new StringBuilder("");
//        sb.append(user.toString()).append("\n\n");

        if (teacher == null) {
            String msg = "teacher is : " + teacher;
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            return msg;
        }
        sb.append(teacher.toString());
        return sb.toString();
    }

    private String saveTeacher() {
        Teacher teacher = new Teacher();
        teacher.setBranch(EnumBranch.MATHEMATIC.name());
        teacher.setGraduatedUniversity("KTU");
        teacher.setPassword("pass");
        teacher.setUsername("12Teacher Mat");
        teacher.setName("Student name");
        teacher.setLastname("Student lastname");
        teacher = managerAllTeacher.saveTeacher(teacher, getApplicationContext());
//        User user = ManagerAllStudent.getInstance().login(credentials);
        if (teacher == null) {
            String msg = "SAVED Teacher is : " + teacher;
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            return msg;
        }
        StringBuilder sb = new StringBuilder("TEACHER IS SAVED");
//        sb.append(user.toString()).append("\n\n");
        sb.append(teacher.toString());
        return sb.toString();
    }

    private String getAllTeachers() {
        String text = "";
        List<Teacher> list = managerAllTeacher.getAllTeacher();

        if (list == null) {
            String msg = "teacher List  is : " + list;
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            return msg;
        }

        StringBuilder sb = new StringBuilder();
        for (Teacher tmp : list) {
            sb.append(tmp).append("\n");
        }
        return sb.toString();
    }

}