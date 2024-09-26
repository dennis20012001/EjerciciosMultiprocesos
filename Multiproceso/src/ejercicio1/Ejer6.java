package ejercicio1;

import java.io.File;
import java.io.IOException;

public class Ejer6 {

	public static void main(String[] args) throws InterruptedException {

		ProcessBuilder pb = new ProcessBuilder("CMD", "/c", "C:\\Users\\in2dm3-v/procesos.bat");
		try {

			File archivoSalida = new File("C:\\\\Users\\\\in2dm3-v/Desktop/salida.txt");
			pb.redirectOutput(archivoSalida);

			File archivoErrores = new File("C:\\\\Users\\\\in2dm3-v/Desktop/errores.txt");
			pb.redirectError(archivoErrores);

			Process p = pb.start();

			p.waitFor();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}