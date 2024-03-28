package com.freddan.individualenterprise.entity;

import jakarta.persistence.*;

@Entity
@Table(name="members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private Address address;
    @Column(nullable = false)
    private String eMail;
    @Column
    private String phone;
    @Column(nullable = false)
    private String dateOfBirth;
}
