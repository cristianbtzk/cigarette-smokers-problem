package main;

public class Mesa {
	String recurso1;
	String recurso2;
	boolean turnoFornecedor = true;

	synchronized void adicionarRecursos(String[] opcoes) {
		while (!turnoFornecedor) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		recurso1 = opcoes[0];
		recurso2 = opcoes[1];
		System.out.println("O fornecedor colocou " + opcoes[0] + " e " + opcoes[1] + " na mesa!");

		turnoFornecedor = false;

		notifyAll();
	}

	synchronized void verificaFumante(String recurso) {
		while (turnoFornecedor || recurso1 == recurso || recurso2 == recurso) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Fumante com " + recurso + " pegou os ingredientes da mesa e está preparando o cigarro");
		recurso1 = "";
		recurso2 = "";
		try {
			Thread.sleep(1000);
			System.out.println("Fumante com " + recurso + " está fumando o cigarro");
			Thread.sleep(1000);
			System.out.println();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		turnoFornecedor = true;
		notifyAll();

	}
}
