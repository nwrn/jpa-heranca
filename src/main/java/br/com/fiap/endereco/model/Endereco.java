package br.com.fiap.endereco.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_ENDERECO")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ENDERECO")
    @SequenceGenerator(name = "SQ_ENDERECO", sequenceName = "SQ_ENDERECO")
    @Column(name = "ID_ENDERECO")
    private   Long id;

    private  String logradouro;
    private  String numero;
    private String complemento;
    private String CEP;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "ID_CIDADE",
            referencedColumnName = "ID_CIDADE",
            foreignKey = @ForeignKey(name = "FK_ENDERECO_CIDADE", value = ConstraintMode.CONSTRAINT))
   private Cidade cidade;


    public Endereco() {
    }

    public Endereco(Long id, String logradouro, String numero, String complemento, String CEP, Cidade cidade) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.CEP = CEP;
        this.cidade = cidade;
    }


    public Long getId() {
        return id;
    }

    public Endereco setId(Long id) {
        this.id = id;
        return this;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public Endereco setLogradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public Endereco setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public String getComplemento() {
        return complemento;
    }

    public Endereco setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public String getCEP() {
        return CEP;
    }

    public Endereco setCEP(String CEP) {
        this.CEP = CEP;
        return this;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public Endereco setCidade(Cidade cidade) {
        this.cidade = cidade;
        return this;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", logradouro='" + logradouro + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", CEP='" + CEP + '\'' +
                ", cidade=" + cidade +
                '}';
    }
}
