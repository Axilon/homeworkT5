package forTwoFiles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		File fileA = new File("a.txt");
		if(fileA.exists()==true)System.out.println("vse ok");
		if(!(fileA.exists()==true))System.out.println("vse ne-ok");
		File fileB = new File("b.txt");
		
		newFile(arrLength(fileA),arrLength(fileB));

	}
	
	private static String[] arrLength(File file){
		int count = 0;
		String[]textArray = null;
		String text = "";
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
				text=br.readLine();
				textArray = text.split("[ ]");
				
		} catch (IOException e) {
			System.out.println(e);
		}
		return textArray;
	}
	
	public static void newFile(String[] a, String[] b) {
		File fileC = new File("c.txt");
		try {
			fileC.createNewFile();
		} catch (IOException e) {
			System.out.println("Error of creating a new file");
		}
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileC))) {
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < b.length; j++) {
					if (a[i].equalsIgnoreCase(b[j])) {

						bw.write(a[i].toString());
						bw.write(" ");

					}
				}

			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
