package copingPackage;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		MyFileFilter mFF = new MyFileFilter("doc", "docx");
		File folder = new File("myFolder");
		File[] fileList1 = folder.listFiles();				//¬ыводим список всего содержимого каталога
		for (File file : fileList1) {
			System.out.println(file);
		}
		System.out.println();
		
		File[] fileList = folder.listFiles(mFF);		//¬ыводи отсортированный по заданным параметрам список всего содержимого каталога
		for (File file : fileList) {
			System.out.println(file);
		}
		
		File copyFolder = new File("myFolderCopy");		//—оздаЄм новый каталог и копируем в него файлы нужного разрешени€
		copyFolder.mkdirs();
		for (int i = 0; i < fileList.length; i++) {

			File newFile = new File("myFolderCopy/" + fileList[i].getName());
			try {
				newFile.createNewFile();

			} catch (IOException e) {
				System.out.println("Copy to new folder error");
			}
			

		}
		System.out.println();
			File[] fileListCopy = copyFolder.listFiles();		//¬ыводим список всего содержимого нового каталога

			for (File file : fileListCopy) {
				System.out.println(file);
			}

	}

}
