package br.com.alura.screematch.labs.labDatasJava;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Date;

public class Datas {
    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);

        LocalDate niverFernando = LocalDate.of(1983, Month.MAY,04);
        System.out.println(niverFernando);

        int idade = hoje.getYear() - niverFernando.getYear();
        System.out.println("Idade: " + idade + " anos");

        //Pegando diferenca de dias
        Period periodo = Period.between(hoje,niverFernando);
        System.out.println(periodo);
        // P-17Y-2M-4D.
        //
        //Isso significa um período de 17 anos, 2 meses e 4 dias.

        //Padrao completo de Date
        String pattern = "E, dd MM yyyy HH:mm:ss z";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        System.out.println(date);
    }
}
