package com.emir.albayrak.ws.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "announcement")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private int studentId;
    @Column
    private int teacherId;
    @Column
    private String text;
}
