package br.edu.edusmart.legado;
public class ApiAcademicaLegada {
 public String enviarNota(String idAluno,String idTurma,double nota){
  return idAluno+"|"+idTurma+"|"+nota+"|OK";
 }
}
