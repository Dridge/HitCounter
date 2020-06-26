package richard.eldridge.hitcounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class HitCounter {

	public static final int PORT_NUMBER = 63457;
	private Socket socket;

	public HitCounter() {
		System.out.println("Server is running");
		try {
			socket = new Socket("localhost", PORT_NUMBER);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String answer = in.readLine();
			
			System.out.println("I am visitor number " + answer);
		} catch (IOException e) {
			System.out.println("Client exception caught");
			e.printStackTrace();
		} finally {
			System.out.println("Closing socket");
			try {
				if(socket != null) {
					socket.close();
				}
			} catch (Exception e) {
				//yikes, oh well.
			}
		}
	}

	public static void main(String[] args) {
		new HitCounter();
	}

}
