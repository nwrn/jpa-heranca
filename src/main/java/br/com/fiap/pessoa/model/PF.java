package br.com.fiap.pessoa.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("PF")
public class PF extends Pessoa {

    @Column(name = "NR_CPF")
    private String CPF;

    @Column(name = "NR_RG")
    private String RG;

    public PF() {
    }

    public PF(Long id, String nome, LocalDate nascimento, String CPF, String RG) {
        super(id, nome, nascimento);
        this.CPF = CPF;
        this.RG = RG;
    }

    public String getCPF() {
        return CPF;
    }

    public PF setCPF(String CPF) {
        this.CPF = CPF;
        return this;
    }

    public String getRG() {
        return RG;
    }

    public PF setRG(String RG) {
        this.RG = RG;
        return this;
    }

    @Override
    public String toString() {
        return "PF{" +
                "CPF='" + CPF + '\'' +
                ", RG='" + RG + '\'' +
                ", id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", nascimento=" + getNascimento() +
                "} " + super.toString();
    }
}
