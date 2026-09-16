# Requisitos atualizados — EduSmart

Esta lista organiza os requisitos observáveis no projeto atual. Critérios mais detalhados devem ser acrescentados durante as aulas.

## Funcionais

- **RF01** — manter cursos, turmas, professores e alunos.
- **RF02** — matricular alunos em turmas.
- **RF03** — criar avaliações para uma turma.
- **RF04** — registrar notas de alunos.
- **RF05** — calcular a média final do aluno em uma turma.
- **RF06** — publicar notas no sistema acadêmico externo.
- **RF07** — comunicar eventos acadêmicos.
- **RF08** — fechar uma turma e publicar os resultados finais.

## Não funcionais / qualidades esperadas

- **RNF01** — manter o código compreensível e de fácil evolução.
- **RNF02** — preservar consistência entre matrícula, avaliação e nota.
- **RNF03** — isolar dependências de sistemas legados.
- **RNF04** — permitir testar regras acadêmicas sem depender das integrações externas.

## Pontos de evolução identificados

O código inicial ainda permite matrícula duplicada, aceita nota sem validação, pode fechar turma com notas ausentes e o cálculo atual não considera os pesos configurados nas avaliações. Esses pontos devem ser tratados somente quando a atividade da aula solicitar a evolução correspondente.
