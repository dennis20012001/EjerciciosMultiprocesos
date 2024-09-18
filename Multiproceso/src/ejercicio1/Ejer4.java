package ejercicio1;

import java.io.IOException;
import java.io.InputStream;

public class Ejer4 {

	public static void main(String[] args) {

		ProcessBuilder pb = new ProcessBuilder("CMD", "/c", "Tasklist");
		try {
			Process p = pb.start();


			InputStream is = p.getInputStream();
			System.out.println();

			int c;
			while ((c = is.read()) != -1)
				System.out.print((char) c);
			is.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}