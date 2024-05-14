package br.com.alura.screematch.labs.labDatasJava;

import net.bytebuddy.asm.Advice;

import java.time.LocalTime;

public class Horarios {
    public static void main(String[] args) {
        LocalTime hoje = LocalTime.now();
        System.out.println(hoje);
        //formato hh:mm:ss.zzz:

        LocalTime aniversarioHoraGuilherme = LocalTime.of(14,07,20);
        System.out.println(aniversarioHoraGuilherme);
    }
}
