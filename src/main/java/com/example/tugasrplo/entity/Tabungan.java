package com.example.tugasrplo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "tbl_tabungan")
public class Tabungan {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private User user;

    private int saldo;

}
