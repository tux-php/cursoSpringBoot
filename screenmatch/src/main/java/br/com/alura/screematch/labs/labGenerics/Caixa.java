package br.com.alura.screematch.labs.labGenerics;

public class Caixa <T>{
    private T conteudo;
    public T getConteudo(){
        return conteudo;
    }
    public void setConteudo(T conteudo){
        this.conteudo = conteudo;
    }

    public<T> T somaConteudoNaCaixa(T valor){
        if(this.conteudo instanceof Integer c && valor instanceof Integer i){
            Integer resultado = c + i;
            return (T) resultado;
        }else if(this.conteudo instanceof Double c && valor instanceof Double i){
            Double resultado = c + i;
            return (T) resultado;
        }else if(this.conteudo instanceof String c && valor instanceof String s){
            String resultado = c + "\n" + s;
            return (T) resultado;
        }
        return null;
    }
}
