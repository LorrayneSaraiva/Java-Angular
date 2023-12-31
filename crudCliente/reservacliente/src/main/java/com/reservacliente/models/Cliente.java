package com.reservacliente.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = true)
    private String email;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    public static Object builder() {

        return null;
    }
}
