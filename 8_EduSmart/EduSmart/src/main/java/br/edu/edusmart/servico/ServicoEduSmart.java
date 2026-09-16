package br.edu.edusmart.servico;

import br.edu.edusmart.legado.ApiAcademicaLegada;
import br.edu.edusmart.legado.ApiEmailLegada;
import br.edu.edusmart.legado.ApiSmsLegada;
import br.edu.edusmart.modelo.Avaliacao;
import br.edu.edusmart.modelo.Turma;
import br.edu.edusmart.modelo.Disciplina;
import br.edu.edusmart.modelo.Nota;
import br.edu.edusmart.modelo.Aluno;
import br.edu.edusmart.modelo.Professor;
import br.edu.edusmart.repositorio.RepositorioEmMemoria;
import java.util.ArrayList;
import java.util.List;

/**
 * Serviço inicial deliberadamente concentrado.
 *
 * O projeto foi preparado para permitir que os estudantes identifiquem
 * problemas de responsabilidades, acoplamento, validação, integração,
 * testabilidade e qualidade ao longo das aulas.
 */
public class ServicoEduSmart {
    public final RepositorioEmMemoria<Aluno> alunos =
        new RepositorioEmMemoria<>();
    public final RepositorioEmMemoria<Professor> professores =
        new RepositorioEmMemoria<>();
    public final RepositorioEmMemoria<Disciplina> disciplinas =
        new RepositorioEmMemoria<>();
    public final RepositorioEmMemoria<Turma> turmas =
        new RepositorioEmMemoria<>();
    public final RepositorioEmMemoria<Avaliacao> avaliacoes =
        new RepositorioEmMemoria<>();

    private final List<Nota> notas = new ArrayList<>();

    // Dependências concretas e diretas: problema intencional para análise.
    private final ApiAcademicaLegada apiAcademica = new ApiAcademicaLegada();
    private final ApiEmailLegada apiEmail = new ApiEmailLegada();
    private final ApiSmsLegada apiSms = new ApiSmsLegada();

    public void matricular(String idTurma, String idAluno) {
        Turma turma = turmas.buscar(idTurma);
        Aluno aluno = alunos.buscar(idAluno);

        if (turma == null || aluno == null) {
            return;
        }

        // Problema intencional: não verifica duplicidade, situação ou capacidade.
        turma.idsAlunos.add(idAluno);
    }

    public void criarAvaliacao(Avaliacao avaliacao) {
        if (avaliacao == null) {
            return;
        }

        avaliacoes.salvar(avaliacao.id, avaliacao);
        Turma turma = turmas.buscar(avaliacao.idTurma);

        if (turma != null) {
            turma.idsAvaliacoes.add(avaliacao.id);
        }
    }

    public void lancarNota(String idAvaliacao, String idAluno, double valor) {
        Avaliacao avaliacao = avaliacoes.buscar(idAvaliacao);

        if (avaliacao == null) {
            return;
        }

        // Problema intencional: nota e vínculo do estudante não são validados.
        notas.add(new Nota(idAvaliacao, idAluno, valor));

        // Problema intencional: integração externa misturada à regra acadêmica.
        apiAcademica.enviarNota(idAluno, avaliacao.idTurma, valor);

        // Problema intencional: destinatário fixo e regra de notificação acoplada.
        apiEmail.enviar("aluno@exemplo.com", "Nota lançada: " + valor);
    }

    public double mediaFinal(String idTurma, String idAluno) {
        Turma turma = turmas.buscar(idTurma);

        if (turma == null) {
            return 0;
        }

        List<Double> valores = new ArrayList<>();

        for (Nota nota : notas) {
            Avaliacao avaliacao = avaliacoes.buscar(nota.idAvaliacao);

            if (avaliacao != null
                && idTurma.equals(avaliacao.idTurma)
                && idAluno.equals(nota.idAluno)) {
                valores.add(nota.valor);
            }
        }

        if (valores.isEmpty()) {
            return 0;
        }

        double total = 0;
        for (double valor : valores) {
            total += valor;
        }

        // Problema intencional: ignora os pesos definidos nas avaliações.
        return total / valores.size();
    }

    public void encerrarTurma(String idTurma) {
        Turma turma = turmas.buscar(idTurma);

        if (turma == null) {
            return;
        }

        // Problema intencional: fecha a turma sem validar avaliações/notas pendentes.
        turma.situacao = "CLOSED";

        for (String idAluno : turma.idsAlunos) {
            double media = mediaFinal(idTurma, idAluno);
            apiAcademica.enviarNota(idAluno, idTurma, media);
        }

        // Mantida para evidenciar uma segunda integração externa disponível.
        if (turma.idsAlunos.isEmpty()) {
            apiSms.enviarSms("000000000", "Turma encerrada sem estudantes.");
        }
    }
}
