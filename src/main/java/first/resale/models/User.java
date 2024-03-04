package first.resale.models;

import javax.xml.crypto.Data;

//@Entity
//@Table(name = "t_user")
public class User {
    private int id;
    private String name;
    private String password;
    private String patronymic;
    private String surname;
    private Data birthDate;
    private String phoneNumber;
    private String status;

    public User() {
    }

    public User(int id, String name, String password, String patronymic, String surname, Data birthDate, String phoneNumber, String status) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.patronymic = patronymic;
        this.surname = surname;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public Data getBirthDate() {
        return birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthDate(Data birthDate) {
        this.birthDate = birthDate;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
