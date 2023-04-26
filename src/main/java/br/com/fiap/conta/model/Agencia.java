package br.com.fiap.conta.model;

public class Agencia {

    private Long id;
    private int numero;

    public Agencia() {
    }

    public Agencia(Long id, int numero) {
        this.id = id;
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public Agencia setId(Long id) {
        this.id = id;
        return this;
    }

    public int getNumero() {
        return numero;
    }

    public Agencia setNumero(int numero) {
        this.numero = numero;
        return this;
    }

    @Override
    public String toString() {
        return "Agencia{" +
                "id=" + id +
                ", numero=" + numero +
                '}';
    }
}
