package com.emir.albayrak.ws.model;


import jakarta.persistence.*;
import lombok.*;

//@AllArgsConstructor
//@NoArgsConstructor(force = true)
//@RequiredArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type")
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
@Getter
@Setter
public abstract class User {
    public User() {
        setRoleId();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private int roleId;

    @Column
    private String name;
    @Column
    private String lastname;

    abstract void setRoleId();

    @Override
    public String toString() {
        return "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'';
    }
}

