# Sistemas externos

| Sistema externo | Responsabilidade | Evidência inicial no código |
|---|---|---|
| Sistema acadêmico | Receber notas e resultados finais | `legacy/ApiAcademicaLegada.java` e chamadas diretas em `ServicoEduSmart` |
| E-mail | Enviar avisos aos estudantes | `legacy/ApiEmailLegada.java` e chamada direta em `ServicoEduSmart` |
| SMS | Canal alternativo disponível no legado | `legacy/ApiSmsLegada.java` |

## Situação inicial

As integrações são acessadas diretamente pelo serviço central. Essa decisão é intencional no estado inicial e poderá ser analisada quanto a dependências, falhas, testabilidade, segurança, desempenho e comunicação entre sistemas nas aulas correspondentes.
