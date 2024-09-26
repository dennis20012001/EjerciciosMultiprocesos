package ejercicio1;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Ejer3 {

	public static void main(String[] args) throws SocketException {

		InetAddress localHost;
		try {
			localHost = InetAddress.getLocalHost();
			NetworkInterface interfaz = null;
			try {
				interfaz = NetworkInterface.getByInetAddress(localHost);
			} catch (SocketException e) {
				e.printStackTrace();
			}
			byte[] direccionMac = interfaz.getHardwareAddress();
			for (int i = 0; i < direccionMac.length; i++) {
				String hexadecimal = String.format("%02X", direccionMac[i]);
				System.out.print(hexadecimal);
				if (i < direccionMac.length - 1) {
					System.out.print("-");
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}
}
