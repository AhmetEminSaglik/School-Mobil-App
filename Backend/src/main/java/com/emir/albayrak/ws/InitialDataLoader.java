package com.emir.albayrak.ws;

import com.emir.albayrak.ws.business.abstracts.ParentService;
import com.emir.albayrak.ws.business.abstracts.UserService;
import com.emir.albayrak.ws.model.HeadMaster;
import com.emir.albayrak.ws.model.Parent;
import com.emir.albayrak.ws.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import utility.CustomLog;

@Component
public class InitialDataLoader implements CommandLineRunner {
    private UserService userService;
    private ParentService parentService;
    private CustomLog customLog = new CustomLog(getClass());


    @Autowired
    public InitialDataLoader(UserService userService, ParentService parentService) {
        this.userService = userService;
        this.parentService = parentService;
    }

    @Override
    public void run(String... args) throws Exception {

        saveHeadMaster();
        saveStudent();
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
        headMaster = (HeadMaster) userService.save(headMaster);
        customLog.info("Headmaster is saved. Now find all User in db : " + headMaster);
    }

    private void saveStudent() {
        Student student = new Student();
        student.setName("Ahmet Emin");
        student.setLastname("Saglik");
        student.setUsername("385931");
        student.setPassword("pass");

        student = (Student) userService.save(student);
        customLog.info("Student is saved. Now find all User in db : " + student);
        userService.findAll().forEach(System.out::println);
        saveParent(student.getId());
    }

    private void saveParent(int studentId) {
        Parent parent = new Parent();
        parent.setStudentId(studentId);
        parent.setName("Veli Hasan");
        parent.setLastname("Can");
        parent.setPhoneNo("505 505 55 00");
        parent = parentService.save(parent);
        customLog.info("Parent is saved. Now find all Parent in db : " + parentService.find(studentId));
    }
}
