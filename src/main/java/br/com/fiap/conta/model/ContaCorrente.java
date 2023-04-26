package br.com.fiap.conta.model;

import br.com.fiap.pessoa.model.Pessoa;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CONTA_CORRENTE")
public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente() {
    }

    public ContaCorrente(Long id, int numero, Agencia agencia, double saldo, Pessoa titular, double limite) {
        super(id, numero, agencia, saldo, titular);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public ContaCorrente setLimite(double limite) {
        this.limite = limite;
        return this;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "limite=" + limite +
                "} " + super.toString();
    }
}
