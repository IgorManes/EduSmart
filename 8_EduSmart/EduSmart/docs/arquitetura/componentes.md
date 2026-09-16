# Componentes e responsabilidades - visão inicial

| Parte | Responsabilidade observada | Código relacionado |
|---|---|---|
| Aplicação | Montar e executar o cenário demonstrativo | `Main` |
| Serviço acadêmico | Matrícula, avaliações, notas, cálculo, fechamento e integração | `ServicoEduSmart` |
| Repositório em memória | Armazenar objetos por identificador | `RepositorioEmMemoria` |
| Modelo acadêmico | Representar alunos, professores, cursos, turmas, avaliações e notas | turmas em `model/` |
| Sistema acadêmico legado | Receber notas/resultados | `ApiAcademicaLegada` |
| E-mail legado | Enviar mensagens | `ApiEmailLegada` |
| SMS legado | Disponibilizar envio de SMS | `ApiSmsLegada` |

> A tabela descreve o estado inicial. Os estudantes devem revisar fronteiras, responsabilidades e conectores conforme as atividades das aulas.
