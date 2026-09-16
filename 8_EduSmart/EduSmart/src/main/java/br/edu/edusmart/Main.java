package br.edu.edusmart;

import br.edu.edusmart.modelo.Avaliacao;
import br.edu.edusmart.modelo.Turma;
import br.edu.edusmart.modelo.Disciplina;
import br.edu.edusmart.modelo.Aluno;
import br.edu.edusmart.modelo.Professor;
import br.edu.edusmart.servico.ServicoEduSmart;

public class Main {
    public static void main(String[] args) {
        ServicoEduSmart servico = new ServicoEduSmart();

        servico.alunos.salvar(
            "A1",
            new Aluno("A1", "Aluno Demo", "aluno@exemplo.com")
        );
        servico.professores.salvar(
            "P1",
            new Professor("P1", "Professor Demo", "prof@exemplo.com")
        );
        servico.disciplinas.salvar(
            "C1",
            new Disciplina("C1", "Design de Software", 80)
        );
        servico.turmas.salvar(
            "T1",
            new Turma("T1", "C1", "P1")
        );

        servico.matricular("T1", "A1");
        servico.matricular("T1", "A1"); // problema intencional: matrícula duplicada é aceita

        servico.criarAvaliacao(
            new Avaliacao("AV1", "T1", "EXAM", 0.6)
        );
        servico.criarAvaliacao(
            new Avaliacao("AV2", "T1", "PROJECT", 0.4)
        );

        servico.lancarNota("AV1", "A1", 8.0);
        servico.lancarNota("AV2", "A1", 10.0);

        servico.encerrarTurma("T1");

        System.out.println(
            "MEDIA=" + servico.mediaFinal("T1", "A1")
        );
        System.out.println(
            "STATUS=" + servico.turmas.buscar("T1").situacao
        );
    }
}
