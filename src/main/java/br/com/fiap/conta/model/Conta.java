package br.com.fiap.conta.model;

import br.com.fiap.pessoa.model.Pessoa;
import jakarta.persistence.*;

@Entity
@Table(name = "TB_CONTA")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TP_CONTA")
public abstract class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CONTA")
    @SequenceGenerator(name = "SQ_CONTA", sequenceName = "SQ_CONTA")
    @Column(name = "ID_CONTA")
    private Long id;

    @Column(name = "NR_CONTA")
    private int numero;

    @Column(name = "SALDO")
    private double saldo;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "ID_AGENCIA",
            referencedColumnName = "ID_AGENCIA",
            foreignKey = @ForeignKey(name = "FK_AGENCIA_CONTA")
    )
    private Agencia agencia;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "ID_PESSOA",
            referencedColumnName = "ID_PESSOA",
            foreignKey = @ForeignKey(name = "FK_PESSOA_CONTA")
    )
    private Pessoa titular;

    public Conta() {
    }

    public Conta(Long id, int numero, Agencia agencia, double saldo, Pessoa titular) {
        this.id = id;
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = saldo;
        this.titular = titular;
    }

    public Long getId() {
        return id;
    }

    public Conta setId(Long id) {
        this.id = id;
        return this;
    }

    public int getNumero() {
        return numero;
    }

    public Conta setNumero(int numero) {
        this.numero = numero;
        return this;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public Conta setAgencia(Agencia agencia) {
        this.agencia = agencia;
        return this;
    }

    public double getSaldo() {
        return saldo;
    }

    public Conta setSaldo(double saldo) {
        this.saldo = saldo;
        return this;
    }

    public Pessoa getTitular() {
        return titular;
    }

    public Conta setTitular(Pessoa titular) {
        this.titular = titular;
        return this;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "id=" + id +
                ", numero=" + numero +
                ", agencia=" + agencia +
                ", saldo=" + saldo +
                ", titular=" + titular +
                '}';
    }
}
