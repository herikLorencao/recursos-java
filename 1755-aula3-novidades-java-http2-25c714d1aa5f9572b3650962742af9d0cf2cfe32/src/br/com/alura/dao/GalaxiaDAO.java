package br.com.alura.dao;

import java.util.List;
import java.util.Map;

public class GalaxiaDAO {

	public void listar() {
		Map<String, List<String>> galaxias = Map.of("nome",
				List.of("A Pequena Nuvem de Magalhaes", "A Grande Nuvem de Magalhaes", "A galaxia de Andrameda"));
		System.out.println("[" + galaxias + "]");
	}
}
