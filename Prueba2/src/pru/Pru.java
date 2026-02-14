package pru;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class Pru {

	public static void main(String[] args) {

		
		try {
			
			System.out.println(File.separator);
			
	/*

	CAMBIO UNO	
	CAMBIO DOS

for (int i = 0; i < 5000; i++) {
	
	
	
	escribir("cadena3 "+i);
	Thread.sleep(100);
	
}*/

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
public static void escribir(String texto) throws IOException {
	 
		
		File archivo = new File("C:/Users/Admin/Downloads/PruebaG.txt");

	    if (!archivo.exists()) {
	        archivo.createNewFile();
	    }

	    FileOutputStream fos = null;
	    FileChannel canal = null;
	    FileLock lock = null;

	    try {
	    	
	        fos = new FileOutputStream(archivo, true);
	        canal = fos.getChannel();
	        lock = canal.lock();

	        fos.write((texto+System.lineSeparator()).getBytes());
	        fos.flush();

	    } catch (IOException e) {
	        System.err.println("Error escribiendo archivo: " + e.getMessage());
	        throw e; // <<--- vuelve a lanzar la excepción
	    } finally {
	        if (lock != null) lock.release();
	        if (canal != null) canal.close();
	        if (fos != null) fos.close();
	    }
	}

}

