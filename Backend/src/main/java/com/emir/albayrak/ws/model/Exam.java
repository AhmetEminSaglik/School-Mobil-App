package com.emir.albayrak.ws.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "exams")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @ManyToMany
    private List<Teacher> teacherList;
    @ManyToMany
    private List<Student> studentList;
    @Column
    private  String courseName;
    @Column
    private int vizeResult;
    @Column
    private int finalResult;

}
