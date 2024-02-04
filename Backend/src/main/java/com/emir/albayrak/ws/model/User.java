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
        setRoleIdToUser();
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
    protected int roleId;

    @Column
    private String name;
    @Column
    private String lastname;

    public abstract void setRoleIdToUser();

    @Override
    public String toString() {
        return "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}

