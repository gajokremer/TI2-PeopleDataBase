package model;

import javafx.scene.image.Image;

import java.util.Comparator;
import java.util.Objects;

public class Person {

    private int code;
    private String name;
    private String surname;
    private Gender gender;
    private String birthDate;
    private double height;
    private String nationality;
    private Image photo;

    public Person(String name, String surname, Gender gender, String birthDate,
                  double height, String nationality) {

        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthDate = birthDate;
        this.height = height;
        this.nationality = nationality;
//        this.photo = photo;

//        this.code = generateCode();
        this.code = hashCode();
    }

    public Person() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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

    public String getFullName() {
        return this.name + " " + this.surname;
    }

    public void setFullName(String name, String surname) {
        this.name = name;
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

//    private String generateCode() {
//
////        return String.valueOf(Arrays.hashCode(new String[]{name + surname +
////                String.valueOf(gender) + birthDate + String.valueOf(height) + nationality + photo}));
//
//        int code = Arrays.hashCode(new String[]{name + surname + gender +
//                birthDate + height + nationality + photo});
//
//        System.out.println("-Code: " + code);
//
//        return String.valueOf(code);
//    }

    @Override
    public String toString() {
//        return "Person{" +
//                "code='" + code + '\'' +
//                ", name='" + name + '\'' +
//                ", surname='" + surname + '\'' +
//                ", gender=" + gender +
//                ", birthDate='" + birthDate + '\'' +
//                ", height=" + height +
//                ", nationality='" + nationality + '\'' +
//                ", photo=" + photo +
//                '}';

        return "code='" + code + '\'' +
//        return  ", height=" + height +
                ", full name='" + (name + " " + surname) + '\'';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, gender, birthDate, height, nationality, photo);
    }

//    @Override
//    public int compareTo(Person o) {
//
//        return Integer.compare(code, o.getCode());
////        return Double.compare(height, o.getHeight());
//    }
}