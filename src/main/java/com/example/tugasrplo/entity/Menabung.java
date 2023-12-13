package com.example.tugasrplo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "tbl_menabung")
public class Menabung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String jenisSampah;

    private int berat;

    @ManyToOne
    private User user;
}
