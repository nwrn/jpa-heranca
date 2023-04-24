package br.com.fiap.endereco.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_PAIS")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PAIS")
    @SequenceGenerator(name = "SQ_PAIS", sequenceName = "SQ_PAIS")
    @Column(name = "ID_PAIS")
    private
    Long id;

    @Column(name = "NM_PAIS")
    private
    String nome;


    public Pais() {
    }

    public Pais(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public Pais setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Pais setNome(String nome) {
        this.nome = nome;
        return this;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
