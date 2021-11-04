package br.com.alura;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SubmissionPublisher;

import br.com.alura.model.NotaFiscal;
import br.com.alura.wsclient.NotaFiscalWSClient;

public class TesteEnvioNaoBloqueante {

	// Utilização de processamento de forma paralela
	// Essa abordagem usa a estratégia back pressure (no caso evita que o servidor que irá receber os dados seja sobrecarregado
	public static void main(String[] args) {
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
		NotaFiscal primeiraNotaFiscal = new NotaFiscal("Joao", 39.99, LocalDate.now());
		SubmissionPublisher<NotaFiscal> publisher = new SubmissionPublisher<>(newFixedThreadPool, 1);
		NotaFiscalWSClient nfwsc = new NotaFiscalWSClient();
		publisher.consume(nfwsc::enviar);
		publisher.consume(data -> System.out.println("Outra Thread: " + Thread.currentThread().getName()));
		publisher.consume(data -> System.out.println("Mais uma Thread: " + Thread.currentThread().getName()));

		publisher.submit(primeiraNotaFiscal);
		System.out.println("Voce ira receber a nota fiscal no seu e-mail");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		scan.close();
		publisher.close();
	}
}
