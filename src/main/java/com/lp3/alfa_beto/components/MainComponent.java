package com.lp3.alfa_beto.components;

import java.time.LocalDateTime;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lp3.alfa_beto.entities.Atividade;
import com.lp3.alfa_beto.entities.Estudante;
import com.lp3.alfa_beto.entities.Medalha;
import com.lp3.alfa_beto.entities.Responsavel;
import com.lp3.alfa_beto.services.AtividadeService;
import com.lp3.alfa_beto.services.EstudanteService;
import com.lp3.alfa_beto.services.MedalhaService;
import com.lp3.alfa_beto.services.ResponsavelService;

@Component
public class MainComponent {

    Estudante e1 = new Estudante();
    Estudante e2 = new Estudante();

    Atividade a1 = new Atividade();
    Atividade a2 = new Atividade();
    Atividade a3 = new Atividade();

    Medalha m1 = new Medalha();
    Medalha m2 = new Medalha();

    Responsavel r1 = new Responsavel();
    Responsavel r2 = new Responsavel();

    @Autowired
    private AtividadeService atividadeService;

    @Autowired
    private EstudanteService estudanteService;

    @Autowired
    private MedalhaService medalhaService;

    @Autowired
    private ResponsavelService responsavelService;

    @PostConstruct
    public void run() {
        criarEstudantes();
        criarAtividades();
        criarMedalhas();
        criarResponsaveis();
    }

    /*
     * Listar atividades por título ou descrição (operador containing)
     */
    public void consultaA() {

    }

    /*
     * Cria dois estudantes para exemplo
     */
    public void criarEstudantes() {
        e1.setNome("ManoGamer");
        e1.setEmail("manog@gmail.com");
        e1.setMatricula("123456INFQ");
        e1.setSenha("admin");

        e2.setNome("Bina");
        e2.setEmail("bina@gmail.com");
        e2.setMatricula("654321INFQ");
        e2.setSenha("bina");

        estudanteService.save(e1);
        estudanteService.save(e2);
    }

    /*
     * Cria três atividades de exemplo
     */
    public void criarAtividades() {
        a1.setDescricao("Qual a cor do cavalo branco de Napoleão?");
        a1.setTitulo("Atividade Napoleão");
        a1.setNota(10);
        a1.setDataDeAvaliacao(LocalDateTime.now().minusDays(1));

        a2.setDescricao("Onde nasceu Napoleão?");
        a2.setTitulo("Atividade Napoleão");
        a2.setNota(8.5);
        a2.setDataDeAvaliacao(LocalDateTime.now().minusDays(1).minusMinutes(30));

        a3.setDescricao("Qual a soma de 2 + 2?");
        a3.setTitulo("Atividade 2");
        a3.setNota(6);
        a3.setDataDeAvaliacao(LocalDateTime.now().minusDays(2));

        atividadeService.save(a1);
        atividadeService.save(a2);
        atividadeService.save(a3);
    }

    /*
     * Cria duas medalhas de exemplo
     */
    public void criarMedalhas() {
        m1.setTitulo("Melhor estudante de todos os tempos!");

        m2.setTitulo("Pior estudante de todos os tempos!");

        medalhaService.save(m1);
        medalhaService.save(m2);
    }

    /*
     * Cria dois responsáveis de exemplo
     */
    public void criarResponsaveis() {
        r1.setNome("Bill Gates");
        r1.setEmail("bill@gmail.com");
        r1.setCpf("12345678910");
        r1.setSenha("bill123");

        r2.setNome("Steve Jobs");
        r2.setEmail("jobs@gmail.com");
        r2.setCpf("0987654321");
        r2.setSenha("jobs123");

        responsavelService.save(r1);
        responsavelService.save(r2);
    }
}
