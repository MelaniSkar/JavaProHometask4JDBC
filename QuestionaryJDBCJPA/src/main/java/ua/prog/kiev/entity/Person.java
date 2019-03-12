package ua.prog.kiev.entity;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer person_id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "secondname")
    private String secondname;

    @Column(name = "age")
    private Integer age;

    @Column(name = "phone_number")
    private String phoneNumber;

    public Person() {
    }

    public Person(String firstname, String secondname, Integer age, String phoneNumber) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }
}
