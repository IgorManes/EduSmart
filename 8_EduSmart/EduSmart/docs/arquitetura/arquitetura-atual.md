# Arquitetura atual - estado inicial para evolução

O EduSmart está organizado, no estado inicial, em poucos grupos de responsabilidades:

- `model`: entidades e estruturas de dados do domínio acadêmico;
- `repository`: armazenomento em memória;
- `service`: orquestração das principais regras e integrações;
- `legacy`: APIs externas simuladas;
- `Main`: montagem e execução de um cenário demonstrativo.

## Característica intencional do estado inicial

`ServicoEduSmart` concentra regras acadêmicas, acesso a repositórios, cálculo, validações insuficientes, notificações e chamadas ao sistema acadêmico externo. Essa concentração existe deliberadamente para permitir diagnóstico e evolução incremental durante a disciplina.

Este documento deve ser atualizado quando a estrutura real do projeto mudar. Não trate esta versão como arquitetura final.
