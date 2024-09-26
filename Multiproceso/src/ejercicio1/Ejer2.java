package ejercicio1;

import java.io.IOException;
import java.io.InputStream;

public class Ejer2 {

	public static void main(String[] args) {

		ProcessBuilder pb = new ProcessBuilder("CMD","/c","ping 8.8.8.8");
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