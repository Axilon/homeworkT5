package ru.bk.rom4ik2103;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		FileCopingAction fca = new FileCopingAction();
		fca.setFile(new File("Статут.doc"));
		fca.setFolderAdress(new File("СтатутCopy.doc"));
		ThreadCopier copier = new ThreadCopier(fca);
		TreadWriter writer = new TreadWriter(fca);
		Thread thOne = new Thread(copier);
		Thread thTwo = new Thread(writer);
		long time = System.currentTimeMillis();
		thOne.start();
		thTwo.start();
		System.out.println("left time ->" + ( System.currentTimeMillis()-time));
	}

}
