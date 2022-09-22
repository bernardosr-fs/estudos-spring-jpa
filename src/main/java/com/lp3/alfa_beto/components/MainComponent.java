package com.lp3.alfa_beto.components;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lp3.alfa_beto.entities.Atividade;
import com.lp3.alfa_beto.entities.Estudante;
import com.lp3.alfa_beto.entities.EstudanteAtividade;
import com.lp3.alfa_beto.entities.Medalha;
import com.lp3.alfa_beto.entities.Responsavel;
import com.lp3.alfa_beto.services.AtividadeService;
import com.lp3.alfa_beto.services.EstudanteAtividadeService;
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

    EstudanteAtividade ea1 = new EstudanteAtividade();
    EstudanteAtividade ea2 = new EstudanteAtividade();
    EstudanteAtividade ea3 = new EstudanteAtividade();

    Medalha m1 = new Medalha();
    Medalha m2 = new Medalha();

    Responsavel r1 = new Responsavel();
    Responsavel r2 = new Responsavel();

    @Autowired
    private AtividadeService atividadeService;

    @Autowired
    private EstudanteAtividadeService estudanteAtividadeService;

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

        // consultaA();
        // consultaB();
        // consultaC();
        // consultaD();
        consultaE();
    }

    /*
     * Listar atividades por título ou descrição (operador containing)
     */
    public void consultaA() {
        // Deve retornar a1 e a3
        List<Atividade> atividades = atividadeService.findAllByTituloOrDescricao("Atividade 2",
                "Qual a cor do cavalo branco de Napoleão?");

        System.out.println("Consulta A)");
        for (Atividade atividade : atividades) {
            System.out.println(atividade.toString());
        }
        System.out.println();
    }

    /*
     * Listar atividades por usuário (parâmetro: id ou objeto usuário)
     */
    public void consultaB() {
        // Deve ter duas atividades no retorno (ea1 e ea2)
        List<Atividade> atividades = atividadeService.findAllByIdEstudante(1L);

        System.out.println("Consulta B)");
        for (Atividade atividade : atividades) {
            EstudanteAtividade ea = estudanteAtividadeService.findByAtividade(atividade).get();

            System.out.println("Atividade: Id: "
                    + atividade.getId()
                    + ", Titulo: "
                    + atividade.getTitulo()
                    + ", Descricao: "
                    + atividade.getDescricao()
                    + ", Nota: "
                    + ea.getNota()
                    + ", Data: "
                    + ea.getDataDeAvaliacao());
        }
        System.out.println();
    }

    /*
     * Listar medalhas por usuário (parâmetro: id ou objeto usuário)
     */
    public void consultaC() {
        // List<Medalha> medalhas = medalhaService.findAllByEstudante(e1);

        // System.out.println("Medalhas do estudante " + e1.getNome());
        // for (Medalha medalha : medalhas) {
        // System.out.println(medalha.toString());
        // }
    }

    /*
     * Listar usuários que possuem determinada medalha (parâmetro: id medalha ou
     * objeto medalha)
     */
    public void consultaD() {
        // List<Estudante> estudantes = estudanteService.findAllByMedalhas(new
        // ArrayList<>().add(m1));

        // System.out.println("Estudantes com a medalha " + m1.getTitulo());

        // for (Estudante estudante : estudantes) {
        // System.out.println(estudante.toString());
        // }
    }

    /*
     * Listar atividades por intervalo de data de avaliação (parâmetros: data
     * inicial e data final)
     */
    public void consultaE() {
        List<EstudanteAtividade> estudanteAtividades = estudanteAtividadeService
                .findAllBetween(LocalDateTime.now().minusDays(2), LocalDateTime.now().plusDays(1));

        System.out.println("Consulta E)");
        for (EstudanteAtividade estudanteAtividade : estudanteAtividades) {
            System.out.println(estudanteAtividade.toString());
            System.out.println("------------------------");
        }
        System.out.println();
    }

    /*
     * Cria dois estudantes para exemplo
     */
    public void criarEstudantes() {
        if (estudanteService.findAll().size() == 0) {
            e1.setId(1L);
            e1.setNome("ManoGamer");
            e1.setEmail("manog@gmail.com");
            e1.setMatricula("123456INFQ");
            e1.setSenha("admin");

            e2.setId(2L);
            e2.setNome("Bina");
            e2.setEmail("bina@gmail.com");
            e2.setMatricula("654321INFQ");
            e2.setSenha("bina");

            estudanteService.save(e1);
            estudanteService.save(e2);
        }
    }

    /*
     * Cria três atividades de exemplo
     */
    public void criarAtividades() {
        if (atividadeService.findAll().size() == 0) {
            a1.setId(1L);
            a1.setDescricao("Qual a cor do cavalo branco de Napoleão?");
            a1.setTitulo("Atividade Napoleão");

            a2.setId(2L);
            a2.setDescricao("Onde nasceu Napoleão?");
            a2.setTitulo("Atividade Napoleão");

            a3.setId(3L);
            a3.setDescricao("Qual a soma de 2 + 2?");
            a3.setTitulo("Atividade 2");

            ea1.setAtividade(a1);
            ea1.setEstudante(e1);
            ea1.setDataDeAvaliacao(LocalDateTime.now().minusHours(3));
            ea1.setNota(10);

            ea2.setAtividade(a2);
            ea2.setEstudante(e1);
            ea2.setDataDeAvaliacao(LocalDateTime.now().minusHours(4));
            ea2.setNota(9.5);

            ea3.setAtividade(a3);
            ea3.setEstudante(e2);
            ea3.setDataDeAvaliacao(LocalDateTime.now().minusHours(5));
            ea3.setNota(9);

            atividadeService.save(a1);
            atividadeService.save(a2);
            atividadeService.save(a3);

            estudanteAtividadeService.save(ea1);
            estudanteAtividadeService.save(ea2);
            estudanteAtividadeService.save(ea3);
        }
    }

    /*
     * Cria duas medalhas de exemplo
     */
    public void criarMedalhas() {
        if (medalhaService.findAll().size() == 0) {
            m1.setTitulo("Melhor estudante de todos os tempos!");

            m2.setTitulo("Pior estudante de todos os tempos!");

            e1.addMedalha(m1);
            e2.addMedalha(m2);

            medalhaService.save(m1);
            medalhaService.save(m2);

            estudanteService.save(e1);
            estudanteService.save(e2);
        }
    }

    /*
     * Cria dois responsáveis de exemplo
     */
    public void criarResponsaveis() {
        if (responsavelService.findAll().size() == 0) {
            r1.setId(1L);
            r1.setNome("Bill Gates");
            r1.setEmail("bill@gmail.com");
            r1.setCpf("12345678910");
            r1.setSenha("bill123");

            r2.setId(2L);
            r2.setNome("Steve Jobs");
            r2.setEmail("jobs@gmail.com");
            r2.setCpf("01987654321");
            r2.setSenha("jobs123");

            r1.addEstudante(e1);
            r2.addEstudante(e2);

            responsavelService.save(r1);
            responsavelService.save(r2);

            estudanteService.save(e1);
            estudanteService.save(e2);
        }
    }
}
