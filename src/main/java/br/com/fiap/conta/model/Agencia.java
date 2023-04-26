package br.com.fiap.conta.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_AGENCIA")
public class Agencia {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_AGENCIA")
    @SequenceGenerator(name = "SQ_AGENCIA", sequenceName = "SQ_AGENCIA")
    @Column(name = "ID_AGENCIA")
    private Long id;

    @Column(name = "NR_AGENCIA")
    private int numero;

    public Agencia() {
    }

    public Agencia(Long id, int numero) {
        this.id = id;
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public Agencia setId(Long id) {
        this.id = id;
        return this;
    }

    public int getNumero() {
        return numero;
    }

    public Agencia setNumero(int numero) {
        this.numero = numero;
        return this;
    }

    @Override
    public String toString() {
        return "Agencia{" +
                "id=" + id +
                ", numero=" + numero +
                '}';
    }
}
