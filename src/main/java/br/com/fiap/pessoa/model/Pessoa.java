package br.com.fiap.pessoa.model;

import br.com.fiap.endereco.model.Endereco;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SQ_PESSOA"
    )
    @SequenceGenerator(
            name = "SQ_PESSOA",
            sequenceName = "SQ_PESSOA",
            initialValue = 1
    )
    @Column(name = "ID_PESSOA")
    private
    Long id;

    @Column(name = "NM_PESSOA")
    private
    String nome;

    @Column(name = "DT_NASCIMENTO")
    private
    LocalDate nascimento;


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "ID_ENDERECO",
            referencedColumnName = "ID_ENDERECO",
            foreignKey = @ForeignKey(name = "FK_PESSOA_ENDERECO", value = ConstraintMode.CONSTRAINT))
    private Endereco endereco;


    public Pessoa() {
    }

    public Pessoa(Long id, String nome, LocalDate nascimento, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public Pessoa setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Pessoa setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public Pessoa setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
        return this;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Pessoa setEndereco(Endereco endereco) {
        this.endereco = endereco;
        return this;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nascimento=" + nascimento +
                ", endereco=" + endereco +
                '}';
    }
}
