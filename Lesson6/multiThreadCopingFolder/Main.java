package multiThreadCopingFolder;

import java.io.File;

public class Main {
	public static void main(String[] args) {

		File folder = new File("myFolder");
		File folderCopyA = new File("myfolderCopyA");
		File folderCopyB = new File("myfolderCopyB_multyThread");
		File[] folderFiles = folder.listFiles();
		for (File file : folderFiles) {
			System.out.println(file);
		}
		FileThread fThAlone = new FileThread("myfolderCopyA", folderFiles, 0, folderFiles.length - 1);
		FileThread fThMultiOne = new FileThread("myfolderCopyB_multyThread", folderFiles, 0, folderFiles.length / 2);
		FileThread fThMultiTwo = new FileThread("myfolderCopyB_multyThread", folderFiles, folderFiles.length / 2,
				folderFiles.length - 1);
		Thread thOne = new Thread(fThMultiOne);
		Thread thTwo = new Thread(fThMultiTwo);

		System.out.println();
		long time = System.currentTimeMillis();
		fThAlone.run();
		File[] aloneCopyFolder = folderCopyA.listFiles();
		for (File file : aloneCopyFolder) {
			System.out.println(file);
		}
		System.out.println("Main_File copy is finisched in -> " + (System.currentTimeMillis() - time));
		System.out.println();
		System.out.println();
		time = System.currentTimeMillis();
		thOne.start();
		thTwo.start();
		try {
			thOne.join();
			thTwo.join();
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		File[] multyCopyFolder = folderCopyB.listFiles();
		for (File file : multyCopyFolder) {
			System.out.println(file);
		}
		System.out.println("Multy_File copy is finisched in -> " + (System.currentTimeMillis() - time));

	}
}
