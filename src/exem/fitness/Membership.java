package exem.fitness;

import java.time.LocalDate;

public class Membership {
    private String name;
    private String surname;
    private int yearOfBirth;
    private Membership membership;

    //Каждый абонемент хранит дату регистрации (текущая дата) и дату окончания регистрации.
   public static LocalDate dateOfRegistration = LocalDate.now();
    public static LocalDate dateEndOfRegistration;
    public static TypeOfMembership type;



    // Каждый абонемент хранит информацию о владельце. Данные о владельце: имя, фамилия, год рождения.
    public Membership (String name, String surname, int yearOfBirth, TypeOfMembership type){
        if (name == null || surname == null){
            throw new IllegalArgumentException("Имя и/или фамилия не может быть null");
        }
        if (yearOfBirth < 1900){
            throw new IllegalArgumentException("год рождения не может быть меньше 1900г");
        }
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.type = type;

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

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public LocalDate getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(LocalDate dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public static LocalDate getDateEndOfRegistration() {
        return dateEndOfRegistration;
    }

    public static void setDateEndOfRegistration(LocalDate dateEndOfRegistration) {
        Membership.dateEndOfRegistration = dateEndOfRegistration;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public TypeOfMembership getType() {
        return type;
    }

    public void setType(TypeOfMembership type) {
        this.type = type;
    }


}

