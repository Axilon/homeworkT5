package checkFolder;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		int count=0;
		File folder = new File ("myFolder");
		File [] filesArray = folder.listFiles();
		for (File file : filesArray) {
			System.out.println(file);
			count++;
		}
		
		CheckThread cTh = new CheckThread(folder,count);
		Thread th = new Thread(cTh);
		th.start();

	}

}
