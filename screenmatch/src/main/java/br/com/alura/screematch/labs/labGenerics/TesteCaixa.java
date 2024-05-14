package br.com.alura.screematch.labs.labGenerics;

public class TesteCaixa {
    public static void main(String[] args) {
        Caixa<String> caixaDeTexto = new Caixa<>();
        caixaDeTexto.setConteudo("Guardando texto na minha caixa!");

        Caixa<Integer> caixaDeIdade = new Caixa<>();
        caixaDeIdade.setConteudo(30);
        System.out.println(caixaDeIdade.somaConteudoNaCaixa(26));

        Caixa<Double> caixaDeValor = new Caixa<>();
        caixaDeValor.setConteudo(150.50);
        System.out.println(caixaDeValor.somaConteudoNaCaixa(350.50));
        System.out.println(caixaDeValor.somaConteudoNaCaixa("texto"));
    }
}
