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

    /*
     * Constantes
     */
    public final static String ORDER_ASC = "ASC";
    public final static String ORDER_DESC = "DESC";

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
    Medalha m3 = new Medalha();
    Medalha m4 = new Medalha();
    Medalha m5 = new Medalha();

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
        integrantesDoGrupo();

        criarEstudantes();
        criarAtividades();
        criarMedalhas();
        criarResponsaveis();

        consultaA();
        consultaB();
        consultaC();
        consultaD();
        consultaE();
        consultaF();
        consultaG();
        consultaH();
    }

    public void integrantesDoGrupo() {
        System.out.println("Integrantes do grupo:");
        System.out.println("Andrews Moehlecke, Bernardo Rocha, Diogo Rodrigues e Gabriel Mello.");
        System.out.println("<----------------------------------------------------------------->");
    }

    /*
     * Listar atividades por título ou descrição (operador containing)
     */
    public void consultaA() {
        List<Atividade> atividades = atividadeService.findAllByTituloOrDescricao("Atividade 2",
                "Qual a cor do cavalo branco de Napoleão?");

        System.out.println("Consulta A)");
        System.out.println("Atividades com o título ou a descrição:");
        System.out.println("------------------------");

        for (Atividade atividade : atividades) {
            System.out.println(atividade.toString());
            System.out.println("------------------------");
        }
        System.out.println();
    }

    /*
     * Listar atividades por usuário (parâmetro: id ou objeto usuário)
     */
    public void consultaB() {
        List<Atividade> atividades = atividadeService.findAllByIdEstudante(1L);

        System.out.println("Consulta B)");
        System.out.println("Atividades do estudante pelo id:");
        System.out.println("------------------------");

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
            System.out.println("------------------------");
        }
        System.out.println();
    }

    /*
     * Listar medalhas por usuário (parâmetro: id ou objeto usuário)
     */
    public void consultaC() {
        List<Medalha> medalhas = medalhaService.findAllByIdEstudante(1L);

        System.out.println("Consulta C)");
        System.out.println("Medalhas do estudante:");
        System.out.println("------------------------");

        for (Medalha medalha : medalhas) {
            System.out.println(medalha.toString());
            System.out.println("------------------------");
        }
        System.out.println();
    }

    /*
     * Listar usuários que possuem determinada medalha (parâmetro: id medalha ou
     * objeto medalha)
     */
    public void consultaD() {
        List<Estudante> estudantes = estudanteService.findAllByIdMedalha(1L);

        System.out.println("Consulta D)");
        System.out.println("Estudantes que possuem a medalha:");
        System.out.println("------------------------");

        for (Estudante estudante : estudantes) {
            System.out.println(estudante.toString());
            System.out.println("------------------------");
        }
        System.out.println();
    }

    /*
     * Listar atividades por intervalo de data de avaliação (parâmetros: data
     * inicial e data final)
     */
    public void consultaE() {
        List<EstudanteAtividade> estudanteAtividades = estudanteAtividadeService
                .findAllBetween(LocalDateTime.now().minusDays(2), LocalDateTime.now().plusDays(1));

        System.out.println("Consulta E)");
        System.out.println("Atividades avaliadas entre "
                + LocalDateTime.now().minusDays(2)
                + " e "
                + LocalDateTime.now().plusDays(1));

        System.out.println("------------------------");

        for (EstudanteAtividade estudanteAtividade : estudanteAtividades) {
            System.out.println(estudanteAtividade.toString());
            System.out.println("------------------------");
        }
        System.out.println();
    }

    /*
     * Listar usuários ordenados por quantidade de medalhas (parâmetro: sentido do
     * ordenamento)
     */
    public void consultaF() {
        // List<Estudante> estudantes =
        // estudanteService.findAllOrderByMedalhas(ORDER_ASC);
        List<Estudante> estudantes = estudanteService.findAllOrderByMedalhas(ORDER_DESC);

        System.out.println();
        System.out.println("Consulta F)");
        System.out.println("Estudantes ordenados por quantidade de medalhas:");
        System.out.println("------------------------");

        for (Estudante estudante : estudantes) {
            System.out.println(estudante.toString());
            System.out.println("------------------------");
        }
        System.out.println();
    }

    /*
     * Listar medalhas que ainda não foram ganhas (não possuem um usuário associado)
     */
    public void consultaG() {
        List<Medalha> medalhas = medalhaService.findAllByEstudantesIsNull();

        System.out.println();
        System.out.println("Consulta G)");
        System.out.println("Medalhas que ainda não foram ganhas:");
        System.out.println("------------------------");

        for (Medalha medalha : medalhas) {
            System.out.println(medalha.toString());
            System.out.println("------------------------");
        }
        System.out.println();
    }

    /*
     * Listar usuários por avaliação na atividade (aqui deve ser definido o tipo de
     * parâmetro, se será o valor de uma nota ou um feedback específico)
     */
    public void consultaH() {
        List<EstudanteAtividade> estudanteAtividades = estudanteAtividadeService.findAllByNotaBetween(9.4, 10.0);

        System.out.println("Consulta H)");
        System.out.println("Estudantes que avaliaram a atividade com nota entre 9.4 e 10.0:");
        System.out.println("------------------------");

        for (EstudanteAtividade estudanteAtividade : estudanteAtividades) {
            System.out.println(estudanteAtividade.toString());
            System.out.println("------------------------");
        }
        System.out.println();
    }

    // --------------------------------------------------------------------------------------------------------------------//

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
            m1.setId(1L);
            m1.setTitulo("Melhor estudante de todos os tempos!");

            m2.setId(2L);
            m2.setTitulo("Pior estudante de todos os tempos!");

            m3.setId(3L);
            m3.setTitulo("Lacta da Sociedade!");

            m4.setId(4L);
            m4.setTitulo("Programador HTML!");

            m5.setId(5L);
            m5.setTitulo("Programador que não fez gambiarra");

            e1.addMedalha(m1);
            e2.addMedalha(m2);
            e2.addMedalha(m3);

            medalhaService.save(m1);
            medalhaService.save(m2);
            medalhaService.save(m3);
            medalhaService.save(m4);
            medalhaService.save(m5);

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
