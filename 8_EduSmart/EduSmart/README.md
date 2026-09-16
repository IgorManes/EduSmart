# EduSmart — Projeto Semestral

O EduSmart simula uma plataforma educacional com cursos, turmas, professores, alunos, matrículas, avaliações, notas e notificações.

O código inicial **compila e executa**, mas representa um sistema legado propositalmente imperfeito. O aluno deverá analisar e evoluir o projeto conforme os conteúdos das aulas.

## Comece por aqui

1. Leia este arquivo.
2. Leia `docs/README.md` para saber onde salvar cada tipo de material.
3. Consulte `docs/atividades/README-Cronograma.md`.
4. Na aula atual, abra `docs/atividades/README-Aula-XX.md`.

## Estrutura principal

- `src/main/java/`: código do sistema;
- `src/test/java/`: testes que serão criados/evoluídos nas atividades;
- `docs/contexto/`: contexto e stakeholders;
- `docs/requisitos/`: requisitos e rastreabilidade;
- `docs/arquitetura/`: arquitetura e componentes;
- `docs/diagramas/`: diagramas Mermaid/UML;
- `docs/adr/`: decisões arquiteturais;
- `docs/evidencias/aula-XX/`: evidências específicas das aulas;
- `docs/atividades/`: instruções de cada aula;
- `docs/modelos/`: modelos reutilizáveis;
- `docs/anexos/`: guias auxiliares.

## Escopo inicial

- cursos e turmas;
- professores e alunos;
- matrícula;
- avaliações e notas;
- cálculo de resultado;
- notificações;
- integração com sistema acadêmico externo.

## Execução

Requer Java 17.

```bash
javac -d out $(buscar src/main/java -nome "*.java")
java -cp out br.edu.edusmart.Main
```

