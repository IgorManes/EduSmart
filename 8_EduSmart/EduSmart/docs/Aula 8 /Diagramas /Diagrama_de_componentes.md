[diagrama-componentes-RF-08-01.md](https://github.com/user-attachments/files/32267649/diagrama-componentes-RF-08-01.md)
## Diagrama de componentes — RF-08-01

```mermaid
flowchart TB
    SEC([Secretaria academica])

    subgraph APP["EduSmart - monolito em camadas"]
        direction TB
        MAIN["Main<br/>interface de console"]
        SERV["servico<br/>ServicoEduSmart<br/>matricular()"]
        REPO["repositorio<br/>RepositorioEmMemoria de T<br/>Map em memoria"]
        MOD["modelo<br/>Aluno, Turma, Disciplina,<br/>Professor, Avaliacao, Nota"]
        LEG["legado<br/>ApiAcademicaLegada<br/>ApiEmailLegada / ApiSmsLegada"]
    end

    SEC -->|matricula e codigo da turma| MAIN
    MAIN -->|"matricular(idAluno, idTurma)"| SERV
    SERV -->|buscar / salvar| REPO
    SERV -->|temVaga / adicionarAluno| MOD
    REPO -->|armazena instancias| MOD
    SERV -.->|nao utilizado neste fluxo| LEG
```

A camada `legado` aparece tracejada porque existe no projeto, mas não é acionada pela
matrícula — o acoplamento concreto com `new` afeta `lancarNota()` e `encerrarTurma()`.
