package com.tungbk.contactmanagement.model;

import lombok.*;

import javax.persistence.*;
import java.io.File;
import java.io.Serializable;

@Entity
@Table(name = "USER")
@Data
@ToString
@NoArgsConstructor
public class User implements Serializable, Comparable<User> {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "COMPANY")
    private String company;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "NOTE")
    private String note;

    @Column(name = "IMAGES")
    private File images;

    @Override
    public int compareTo(User o) {
        String compareFirstName = o.getFirstName();
        if (this.firstName.equals(compareFirstName)){
            String compareLastName = o.getLastName();
            return this.lastName.toLowerCase().compareTo(compareLastName.toLowerCase());
        }
        return this.firstName.toLowerCase().compareTo(compareFirstName.toLowerCase());
    }
}
