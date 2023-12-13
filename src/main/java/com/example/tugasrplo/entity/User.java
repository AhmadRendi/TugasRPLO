package com.example.tugasrplo.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.print.attribute.standard.MediaSize;
import java.util.Set;

@Data
@Entity(name = "tbl_user")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String names;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
}
