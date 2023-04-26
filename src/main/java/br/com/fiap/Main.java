package br.com.fiap;

import br.com.fiap.conta.model.Agencia;
import br.com.fiap.conta.model.Conta;
import br.com.fiap.conta.model.ContaCorrente;
import br.com.fiap.conta.model.ContaPoupanca;
import br.com.fiap.endereco.model.Cidade;
import br.com.fiap.endereco.model.Endereco;
import br.com.fiap.endereco.model.Estado;
import br.com.fiap.endereco.model.Pais;
import br.com.fiap.pessoa.model.PF;
import br.com.fiap.pessoa.model.PJ;
import br.com.fiap.pessoa.model.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("maria-db");
        EntityManager manager = factory.createEntityManager();

        Pais br = new Pais();
        br.setNome("Brasil");

        Estado uf = new Estado();
        uf.setNome("São Paulo").setSigla("SP").setPais(br);

        Cidade sp = new Cidade();
        sp.setEstado(uf).setNome("São Paulo");

        Endereco end = new Endereco();
        end.setCidade(sp).setCEP("06086120").setLogradouro("Rua do Benezinho").setNumero("505").setComplemento("AP");


        PF bene = new PF();
        bene.setNome("Benefrancis do Nascimento").setNascimento(LocalDate.of(1977, 3, 8));
        bene.setCPF("21312165464").setRG("132132185");
        bene.setEndereco(end);

        PJ sl = new PJ();
        sl.setCNPJ("2131654654654").setNome("Super Lojas Benezinho").setNascimento(LocalDate.now().minusYears(5));
        sl.setInscricaoEstadual("213132132");
        sl.setEndereco(end);

        Agencia agPaulista = new Agencia();
        agPaulista.setNumero(1);


        ContaCorrente ccBene = new ContaCorrente();
        ccBene.setLimite(1000);
        ccBene.setSaldo(30000).setTitular(bene).setNumero(8818).setAgencia(agPaulista);

        ContaPoupanca cpBene = new ContaPoupanca();
        cpBene.setAniversario(MonthDay.now().getDayOfMonth())
                .setAgencia(agPaulista)
                .setSaldo(1_000_000)
                .setNumero(1008818)
                .setTitular(bene);

        ContaCorrente ccSLB = new ContaCorrente();
        ccSLB.setLimite(1_000_000);
        ccSLB.setSaldo(35_000_000).setTitular(sl).setAgencia(agPaulista).setNumero(8819);

        manager.getTransaction().begin();

        List<Pessoa> pessoas = Arrays.asList(bene, sl);

        pessoas.forEach(manager::persist);

        List<Conta> contas = Arrays.asList(ccBene,cpBene, ccSLB);

        contas.forEach(manager::persist);

        manager.getTransaction().commit();

        contas.forEach(System.out::println);
    }

}