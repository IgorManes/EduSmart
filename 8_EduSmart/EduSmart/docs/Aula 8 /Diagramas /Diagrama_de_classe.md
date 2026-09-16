[diagrama-classes-RF-08-01.md](https://github.com/user-attachments/files/32267542/diagrama-classes-RF-08-01.md)
## Diagrama de classes — RF-08-01

```mermaid
classDiagram
    class Aluno {
        -String matricula
        -String nome
        +getMatricula() String
        +getNome() String
    }
    class Turma {
        -String codigo
        -int capacidadeMaxima
        -List~Aluno~ alunos
        +temVaga() boolean
        +getVagasOcupadas() int
        +adicionarAluno(Aluno) void
    }
    class Disciplina {
        -String codigo
        -String nome
        -int cargaHoraria
    }
    class Professor {
        -String registro
        -String nome
    }
    class ResultadoMatricula {
        <<enumeration>>
        MATRICULA_CONFIRMADA
        TURMA_SEM_VAGA
        DADOS_INVALIDOS
    }
    class RepositorioEmMemoria~T~ {
        -Map~String, T~ dados
        +buscar(String) T
        +salvar(String, T) void
        +listarTodos() List~T~
    }
    class ServicoEduSmart {
        -RepositorioEmMemoria~Aluno~ alunos
        -RepositorioEmMemoria~Turma~ turmas
        +matricular(String, String) ResultadoMatricula
        +criarAvaliacao() void
        +lancarNota() void
        +mediaFinal() double
        +encerrarTurma() void
    }
    class Main {
        +main(String[]) void
        -exibirResultado(ResultadoMatricula) void
    }

    Turma "1" o-- "0..*" Aluno : matriculados
    Turma "1" --> "1" Disciplina : refere-se a
    Turma "1" --> "1" Professor : ministrada por
    ServicoEduSmart --> "2" RepositorioEmMemoria : usa
    ServicoEduSmart ..> Turma : consulta temVaga()
    ServicoEduSmart ..> ResultadoMatricula : retorna
    Main --> ServicoEduSmart : matricular()
```

Elementos introduzidos por esta fatia: `capacidadeMaxima`, `temVaga()`,
`getVagasOcupadas()` e o enum `ResultadoMatricula`.
