# Guia da documentação do projeto EduSmart

Este arquivo indica **onde colocar cada tipo de material** produzido durante as aulas.

## Por onde começar

1. Leia o `README.md` da raiz para entender o projeto.
2. Leia `docs/atividades/README-Cronograma.md` para localizar a aula.
3. Abra `docs/atividades/README-Aula-XX.md` para saber o que fazer.
4. Registre cada resultado na pasta indicada abaixo.

## Onde colocar cada coisa

| O que foi produzido | Onde salvar |
|---|---|
| Contexto, problema, atores e sistemas externos | `docs/contexto/` |
| Requisitos e rastreabilidade | `docs/requisitos/` |
| Descrição da arquitetura e componentes | `docs/arquitetura/` |
| Diagramas | `docs/diagramas/` |
| Decisões arquiteturais | `docs/adr/` |
| Evidências específicas de uma aula | `docs/evidencias/aula-XX/` |
| Instruções das aulas | `docs/atividades/` |
| Modelos reutilizáveis | `docs/modelos/` |
| Guias auxiliares de Maven, JUnit e conferência | `docs/anexos/` |

## Regra para as pastas por aula

Não crie `docs/aula-01`, `docs/aula-02` e assim por diante para guardar toda a documentação. A documentação deve permanecer organizada por **tipo de artefato**.

Exemplo na Aula 05:

- arquitetura: atualize `docs/arquitetura/componentes.md`;
- diagrama: atualize `docs/diagramas/componentes/componentes-atual.md`;
- decisão relevante: crie o ADR sequencial em `docs/adr/`;
- saída de teste, captura ou registro específico da aula: use `docs/evidencias/aula-05/`.

Assim, sempre existe um lugar claro para consultar o estado atual do projeto.

## Estado inicial e estado atual

Os arquivos com `inicial` ou `legado` preservam o ponto de partida. Os arquivos com `atual` ou `atualizados` devem acompanhar a evolução do EduSmart.

Exemplos:

- `contexto/contexto-inicial.md` → `contexto/contexto-atual.md`;
- `requisitos/requisitos-iniciais.md` → `requisitos/requisitos-atualizados.md`;
- `arquitetura/arquitetura-inicial.md` → `arquitetura/arquitetura-atual.md`;
- `diagramas/turmas/turmas-legado.md` → `diagramas/turmas/turmas-atual.md`.
