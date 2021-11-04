package br.com.alura;

import br.com.alura.model.NotaFiscal;
import br.com.alura.subscription.NotaFiscalSubscribe;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SubmissionPublisher;

public class TesteEnvioNaoBloqueante2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        NotaFiscal notaFiscal = new NotaFiscal("João", 10.0, LocalDate.now());
        NotaFiscal notaFiscal2 = new NotaFiscal("Paulo", 10.0, LocalDate.now());
        NotaFiscal notaFiscal3 = new NotaFiscal("Ana", 10.0, LocalDate.now());

        SubmissionPublisher<NotaFiscal> publisher = new SubmissionPublisher<>();
        NotaFiscalSubscribe notaFiscalSubscribe = new NotaFiscalSubscribe();
        publisher.subscribe(notaFiscalSubscribe);

        publisher.submit(notaFiscal);
        publisher.submit(notaFiscal2);
        publisher.submit(notaFiscal3);

        System.out.println("Você irá receber a nota fiscal no seu email");

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        scanner.close();

        publisher.close();
    }
}
