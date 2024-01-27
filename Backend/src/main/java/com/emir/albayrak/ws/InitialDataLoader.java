package com.emir.albayrak.ws;

import com.emir.albayrak.ws.business.abstracts.model.StudentService;
import com.emir.albayrak.ws.business.abstracts.model.UserService;
import com.emir.albayrak.ws.model.HeadMaster;
import com.emir.albayrak.ws.model.Student;
import com.emir.albayrak.ws.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import utility.CustomLog;

@Component
public class InitialDataLoader implements CommandLineRunner {
    private UserService userService;
    private StudentService studentService;
    private CustomLog customLog = new CustomLog(getClass());


    @Autowired
    public InitialDataLoader(UserService userService,
                             StudentService studentService
    ) {
        this.userService = userService;
        this.studentService = studentService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userService.findAll().size() == 0) {
            saveHeadMaster();
            saveTeacher();
            saveStudent();
        } else {
            customLog.info("Users are not saved at the InitialDataLoader. Because it is already filled.");
        }

        Student student = studentService.findAll().get(0);
        customLog.info("Found Student Data : " + student);
//        customLog.info("Found Parent Data Of Student ID(" + student.getId() + ") : " + studentService.findParent(student.getParentId()));
        //        User user = new User("Emir", "ALBAYRAK");
//        User user2 = new User("Ahmet Emin", "SAGLIK");
//        userService.addUser(user);
//        userService.addUser(user2);
//        customLog.info("2 users are added.");
//        customLog.info(user.toString());
//        customLog.info(user2.toString());
    }

    private void saveHeadMaster() {

        HeadMaster headMaster = new HeadMaster();
        headMaster.setName("Emir");
        headMaster.setLastname("Albayrak");
        headMaster.setUsername("emir");
        headMaster.setPassword("pass");
        customLog.info("headmaster to save: " + headMaster);
        headMaster = (HeadMaster) userService.save(headMaster).getData();
        customLog.info("Headmaster is saved. Now find all User in db : " + headMaster);
    }

    private void saveTeacher() {
        Teacher teacher = new Teacher();
        teacher.setName("Hacer");
        teacher.setLastname("Özyurt");
        teacher.setUsername("hacer");
        teacher.setPassword("pass");
        teacher.setBranch("Mobil Uygulama");
        teacher.setGraduatedUniversity("KTU");
        teacher = (Teacher) userService.save(teacher).getData();
        customLog.info("teacher is registered : " + teacher);

    }

    private void saveStudent() {
        Student student = new Student();
        student.setNo("1100");
        student.setName("Ahmet Emin");
        student.setLastname("Saglik");
        student.setUsername("385931");
        student.setPassword("pass");
        student = (Student) userService.save(student).getData();
        customLog.info("Student is saved. Now find all User in db : " + student);
        userService.findAll().forEach(System.out::println);
    }

}
