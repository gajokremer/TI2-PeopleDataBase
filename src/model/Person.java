package model;

import javafx.scene.image.Image;

import java.util.Arrays;

public class Person {

    private String code;
    private String name;
    private String surname;
    private Gender gender;
    private String birthDate;
    private double height;
    private String nationality;
    private Image photo;

    public Person(String name, String surname, Gender gender, String birthDate, double height,
                  String nationality) {

        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthDate = birthDate;
        this.height = height;
        this.nationality = nationality;
//        this.photo = photo;

        this.code = generateCode();
    }

    public Person() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Image getPhoto() {
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    private String generateCode() {

        return String.valueOf(Arrays.hashCode(new String[]{code + name + surname +
                String.valueOf(gender) + birthDate + String.valueOf(height) + nationality + photo}));
    }

    @Override
    public String toString() {
        return "Person{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + gender +
                ", birthDate='" + birthDate + '\'' +
                ", height=" + height +
                ", nationality='" + nationality + '\'' +
                ", photo=" + photo +
                '}';
    }
}