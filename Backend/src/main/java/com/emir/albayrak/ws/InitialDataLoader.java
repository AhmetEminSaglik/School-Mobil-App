package com.emir.albayrak.ws;

import com.emir.albayrak.ws.business.abstracts.ParentService;
import com.emir.albayrak.ws.business.abstracts.StudentService;
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
    private StudentService studentService;
    private CustomLog customLog = new CustomLog(getClass());


    @Autowired
    public InitialDataLoader(UserService userService,
                             StudentService studentService,
                             ParentService parentService
    ) {
        this.userService = userService;
        this.studentService = studentService;
        this.parentService = parentService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userService.findAll().size() == 0) {
            saveHeadMaster();
            saveStudent();
        } else {
            customLog.info("Users are not saved at the InitialDataLoader. Because it is already filled.");
        }

        Student student = studentService.findAll().get(0);
        customLog.info("Found Student Data : " + student);
        customLog.info("Found Parent Data Of Student ID(" + student.getId() + ") : " + studentService.findParent(student.getParentId()));
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
        Parent parent = saveParent();
        Student student = new Student();
        student.setName("Ahmet Emin");
        student.setLastname("Saglik");
        student.setUsername("385931");
        student.setPassword("pass");
        student.setParentId(parent.getId());
        student = (Student) userService.save(student);
        customLog.info("Student is saved. Now find all User in db : " + student);
        userService.findAll().forEach(System.out::println);
    }

    private Parent saveParent() {
        Parent parent = new Parent();
        parent.setName("Veli Hasan");
        parent.setLastname("Can");
        parent.setPhoneNo("505 505 55 00");
        parent = parentService.save(parent);
        customLog.info("Parent is saved. Now find all Parent in db : " + parent);
        return parent;
    }
}
