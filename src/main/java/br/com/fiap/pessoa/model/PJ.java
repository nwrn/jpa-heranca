package br.com.fiap.pessoa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
public class PJ extends Pessoa {

    @Column(name = "NR_CNPJ")
    private String CNPJ;

    @Column(name = "NR_IE")
    private String InscricaoEstadual;


    public PJ() {
    }

    public PJ(Long id, String nome, LocalDate nascimento, String CNPJ, String inscricaoEstadual) {
        super(id, nome, nascimento);
        this.CNPJ = CNPJ;
        InscricaoEstadual = inscricaoEstadual;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public PJ setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
        return this;
    }

    public String getInscricaoEstadual() {
        return InscricaoEstadual;
    }

    public PJ setInscricaoEstadual(String inscricaoEstadual) {
        InscricaoEstadual = inscricaoEstadual;
        return this;
    }

    @Override
    public String toString() {
        return "PJ{" +
                "CNPJ='" + CNPJ + '\'' +
                ", InscricaoEstadual='" + InscricaoEstadual + '\'' +
                "} " + super.toString();
    }
}
