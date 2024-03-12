package main;

import java.util.Random;

public class Fornecedor implements Runnable {
	Mesa mesa;
	String[][] opcoes = { { "Tabaco", "Papel" }, { "Tabaco", "Fósforos" }, { "Papel", "Fósforos" } };

	public Fornecedor(Mesa m) {
		this.mesa = m;
	}

	@Override
	public void run() {
		Random random = new Random();
		while (true) {
			int opcao = random.nextInt(0, 3);

			mesa.adicionarRecursos(opcoes[opcao]);
		}

	}
}
