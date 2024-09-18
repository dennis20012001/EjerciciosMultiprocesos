package ejercicio1;

import java.io.IOException;

public class Ejer1 {

	public static void main(String[] args) {

		String[] infoProceso = { "notepad" };

		try {
			Runtime.getRuntime().exec(infoProceso);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
