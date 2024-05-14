package br.com.alura.screematch.labs.labDatasJava;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Formatando {
    public static void main(String[] args) {
        LocalDateTime hoje = LocalDateTime.now();
        System.out.println(hoje);

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        LocalDateTime agora = LocalDateTime.now();
        System.out.println(hoje.format(formatador));

        //https://cursos.alura.com.br/course/java-trabalhando-lambdas-streams-spring-framework/task/136770
    }
}
