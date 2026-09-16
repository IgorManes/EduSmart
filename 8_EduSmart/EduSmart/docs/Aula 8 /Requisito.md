| Req. | Interface | Modelo | Arquitetura | Código |
|---|---|---|---|---|
| RF-08-01 — Matricular aluno em turma ativa, recusando quando a turma atingiu a capacidade máxima | Menu de matrícula no console (`Main`): entrada de matrícula do aluno e código da turma; saída com mensagem de sucesso ou recusa | Diagrama de sequência da matrícula + `Turma.capacidadeMaxima` / `Turma.temVaga()` | Camada `servico` (`ServicoEduSmart`) apoiada em `repositorio` (`RepositorioEmMemoria<Turma>`) e `modelo` | `ServicoEduSmart.matricular(...)` + `Turma.temVaga()` + teste `deveRecusarMatriculaEmTurmaCheia` |
