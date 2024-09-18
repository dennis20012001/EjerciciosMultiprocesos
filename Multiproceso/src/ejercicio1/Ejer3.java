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
			NetworkInterface networkInterface = null;
			try {
				networkInterface = NetworkInterface.getByInetAddress(localHost);
			} catch (SocketException e) {
				e.printStackTrace();
			}
			byte[] hardwareAddress = networkInterface.getHardwareAddress();
			for (int i = 0; i < hardwareAddress.length; i++) {
				String hex = String.format("%02X", hardwareAddress[i]);
				System.out.print(hex);
				if (i < hardwareAddress.length - 1) {
					System.out.print("-");
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}
}
