package ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejer5 {
	/**
	 * Haz un programa que detecte si el bloc de notas se está ejecutando y en caso
	 * afirmativo cree un proceso que lo elimine de la ejecución (matar el proceso).
	 * 
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		try {
			//Ejecutamos en taskList para sabves si notepad esta ejecutando
			Process p = Runtime.getRuntime().exec("tasklist");
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String linea;
			//Condicion si esta ejecutando dar true, saldria de bucle si seria true
			boolean notepadEnEjecucion = false;

			while ((linea = br.readLine()) != null) {
				if (linea.contains("notepad.exe")) {
					notepadEnEjecucion = true;
					break;
				}
			}

			if (notepadEnEjecucion) {
				Runtime.getRuntime().exec("taskkill /F /IM notepad.exe");
			} else {
				System.out.println("Notepad no está en ejecución.");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
