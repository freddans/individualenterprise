package com.freddan.individualenterprise.entity;

import jakarta.persistence.*;

@Entity
@Table(name="admins")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
