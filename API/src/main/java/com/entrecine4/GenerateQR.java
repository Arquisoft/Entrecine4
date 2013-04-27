package com.entrecine4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * Class for generate QR codes
 * @author Arquisoft - Entrecine4
 *
 */
public class GenerateQR {

	/**
	 * Generate a image with the QR code from a string
	 * @param code
	 */
	public static void generate(String code) {
		try {
			URL url = new URL(
					"http://api.qrserver.com/v1/create-qr-code/?data=" + code);
			InputStream is = url.openStream();
			OutputStream os = new FileOutputStream("Imagen.png");
			byte[] b = new byte[2048];
			int length;

			while ((length = is.read(b)) != -1) {
				os.write(b, 0, length);
			}

			is.close();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
}
