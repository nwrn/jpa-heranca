package br.com.fiap;

import br.com.fiap.model.conta.Agencia;
import br.com.fiap.model.conta.ContaCorrente;
import br.com.fiap.pessoa.model.PF;
import br.com.fiap.pessoa.model.PJ;
import br.com.fiap.pessoa.model.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("maria-db");
        EntityManager manager = factory.createEntityManager();

        PF bene = new PF();
        bene.setRG("13213213");
        bene.setCPF("21321321");
        bene.setNome("Benefrancis do Nascimento");
        bene.setNascimento(LocalDate.of(1977, 3, 8));

        var supermercado = new PJ();
        supermercado.setCNPJ("2131254654");
        supermercado.setInscricaoEstadual("2132465464");
        supermercado.setNascimento(LocalDate.now().minusYears(5));
        supermercado.setNome("Super Mercados Benezinho");

        var agencia = new Agencia();
        agencia.setNumero(1);

        var ccGustavo = new ContaCorrente();
        ccGustavo.setSaldo(56078);
        ccGustavo.setLimite(99999);
        ccGustavo.setAgencia(agencia);
        ccGustavo.addTitular(bene);

        manager.getTransaction().begin();
        List<Pessoa> pessoas = Arrays.asList(bene, supermercado);
        pessoas.forEach(manager::persist);
        manager.getTransaction().commit();
        pessoas.forEach(System.out::println);
    }
}