package main;

public class Main {
	public static void main(String[] args) {
		Mesa mesa = new Mesa();
		
		Thread fornecedor = new Thread(new Fornecedor(mesa));
		
		Thread fumante1 = new Thread(new Fumante(mesa, "Tabaco"));
		Thread fumante2 = new Thread(new Fumante(mesa, "Papel"));
		Thread fumante3 = new Thread(new Fumante(mesa, "Fósforos"));
		
		fornecedor.start();
		
		fumante1.start();
		fumante2.start();
		fumante3.start();
	}
}
