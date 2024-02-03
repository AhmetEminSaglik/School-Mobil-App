package com.emir.albayrak.ws.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "exams", uniqueConstraints = @UniqueConstraint(columnNames = {"teacher_id", "student_id"}))
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
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @OneToOne
    @JoinColumn(name = "student_id")
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
