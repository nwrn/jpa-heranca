package br.com.fiap.conta.model;

import br.com.fiap.pessoa.model.Pessoa;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CONTA_POUPANCA")
@DiscriminatorValue(value = "CP")
public class ContaPoupanca extends Conta {

    //  DayOfWeek aniversario;
    private int aniversario;

    public ContaPoupanca() {
    }

    public ContaPoupanca(Long id, int numero, Agencia agencia, double saldo, Pessoa titular, int aniversario) {
        super(id, numero, agencia, saldo, titular);
        this.aniversario = aniversario;
    }

    public int getAniversario() {
        return aniversario;
    }

    public ContaPoupanca setAniversario(int aniversario) {
        this.aniversario = aniversario;
        return this;
    }

    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "aniversario=" + aniversario +
                "} " + super.toString();
    }
}
