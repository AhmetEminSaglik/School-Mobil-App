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
    @OneToOne
    private Teacher teacher;
    @OneToOne
    private Student student;
    @Column
    private String courseName;
    @Column
    private int vizeResult;
    @Column
    private int finalResult;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getVizeResult() {
        return vizeResult;
    }

    public void setVizeResult(int vizeResult) {
        this.vizeResult = vizeResult;
    }

    public int getFinalResult() {
        return finalResult;
    }

    public void setFinalResult(int finalResult) {
        this.finalResult = finalResult;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", teacher=" + teacher.getName() +
                ", teacher branch=" + teacher.getBranch() +
                ", student=" + student.getName() +
                ", courseName='" + courseName + '\'' +
                ", vizeResult=" + vizeResult +
                ", finalResult=" + finalResult +
                '}';
    }
}
