package main;

public class Fumante implements Runnable {
	String recurso;
	Mesa mesa;

	public Fumante(Mesa m, String recurso) {
		this.mesa = m;
		this.recurso = recurso;
	}

	@Override
	public void run() {
		while (true) {
			mesa.verificaFumante(recurso);
		}
	}
}
