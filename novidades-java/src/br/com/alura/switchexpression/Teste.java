package br.com.alura.switchexpression;

public class Teste {

    // Switch expressions - Java 14
    public static void main(String[] args) {
        String nome = "João";
        switch (nome) {
            case "Renata" -> System.out.println("Acertou: " + nome);
            case "João" -> System.out.println("Acertou: " + nome);
            default -> System.out.println("Nenhum nome encontrado!!");
        }
    }
}
