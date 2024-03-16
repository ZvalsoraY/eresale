package first.resale.models;

import com.sun.istack.NotNull;
import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    @NotNull
    private String name;
    @Column(name = "patronymic")
    @NotNull
    private String patronymic;
    @Column(name = "surname")
    @NotNull
    private String surname;
    @Column(name = "birthDay")
    @NotNull
    private Date birthDay;
    @Column(name = "phoneNumber")
    @NotNull
    private String phoneNumber;
    @Column(name = "status")
    @NotNull
    private String status;
    @Column(name = "password")
    @NotNull
    private String password;

    public User() {
    }

    public User(long id, String name, String patronymic, String surname, Date birthDay, String phoneNumber, String status, String password) {
        this.id = id;
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public String getPassword() {
        return password;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
