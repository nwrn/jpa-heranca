package br.com.fiap;

import br.com.fiap.endereco.model.Cidade;
import br.com.fiap.endereco.model.Endereco;
import br.com.fiap.endereco.model.Estado;
import br.com.fiap.endereco.model.Pais;
import br.com.fiap.pessoa.model.PF;
import br.com.fiap.pessoa.model.PJ;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Arrays;

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

        manager.getTransaction().begin();
        Arrays.asList(bene, sl).forEach(manager::persist);
        manager.getTransaction().commit();
    }

}