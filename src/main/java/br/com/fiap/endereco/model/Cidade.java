package br.com.fiap.endereco.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_CIDADE")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CIDADE")
    @SequenceGenerator(name = "SQ_CIDADE", sequenceName = "SQ_CIDADE")
    @Column(name = "ID_CIDADE")
    private Long id;

    @Column(name = "NM_CIDADE")
    private String nome;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "ID_ESTADO",
            referencedColumnName = "ID_ESTADO",
            foreignKey = @ForeignKey(name = "FK_CIDADE_ESTADO", value = ConstraintMode.CONSTRAINT))
    private Estado estado;

    public Cidade(Long id, String nome, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
    }

    public Cidade() {
    }


    public Long getId() {
        return id;
    }

    public Cidade setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Cidade setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Estado getEstado() {
        return estado;
    }

    public Cidade setEstado(Estado estado) {
        this.estado = estado;
        return this;
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", estado=" + estado +
                '}';
    }
}
