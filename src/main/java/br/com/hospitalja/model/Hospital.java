package br.com.hospitalja.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@SequenceGenerator(name = "hospital", sequenceName = "SQ_HOSPITAL", allocationSize = 1)
public class Hospital {

    @Id
    @GeneratedValue(generator = "hospital", strategy = GenerationType.SEQUENCE)
    private int codigo;

    @Column(nullable = false, length = 20)
    private String nome;

    @Column(nullable = false, length = 3)
    private String fila;

    private int numero;

    private int quarto;
}
