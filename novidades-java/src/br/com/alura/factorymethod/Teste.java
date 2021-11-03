package br.com.alura.factorymethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Teste {

	// Factory de collections - Java 9
	public static void main(String[] args) {
//		ArrayList<String> nomes = new ArrayList<>();
//		nomes.add("primeiroNome");
//		nomes.add("segundoNome");
//		nomes.add("terceiroNome");
//		List<String> nomesImutavel = Collections.unmodifiableList(nomes);
//		System.out.println(nomesImutavel);

		List<String> nomes = List.of("primeiroNome", "segundoNome", "terceiroNome");
		System.out.println(nomes);
	}
}
