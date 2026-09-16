package br.edu.edusmart.modelo;
import java.util.*;
public class Turma {
 public String id; public String idDisciplina; public String idProfessor; public String situacao="OPEN";
 public List<String> idsAlunos=new ArrayList<>();
 public List<String> idsAvaliacoes=new ArrayList<>();
 public Turma(String id,String idDisciplina,String idProfessor){this.id=id;this.idDisciplina=idDisciplina;this.idProfessor=idProfessor;}
}
