package br.com.fiap.endereco.model;


import jakarta.persistence.*;

@Entity
@Table(name = "TB_ESTADO")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ESTADO")
    @SequenceGenerator(name = "SQ_ESTADO", sequenceName = "SQ_ESTADO")
    @Column(name = "ID_ESTADO")
    private Long id;

    @Column(name = "NM_ESTADO")
    private String nome;

    @Column(name = "SG_ESTADO")
    private String sigla;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "ID_PAIS",
            referencedColumnName = "ID_PAIS",
            foreignKey = @ForeignKey(name = "FK_ESTADO_PAIS", value = ConstraintMode.CONSTRAINT))
    private Pais pais;

    public Estado() {
    }

    public Estado(Long id, String nome, String sigla, Pais pais) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.pais = pais;
    }


    public Long getId() {
        return id;
    }

    public Estado setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Estado setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getSigla() {
        return sigla;
    }

    public Estado setSigla(String sigla) {
        this.sigla = sigla;
        return this;
    }

    public Pais getPais() {
        return pais;
    }

    public Estado setPais(Pais pais) {
        this.pais = pais;
        return this;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                ", pais=" + pais +
                '}';
    }

}
