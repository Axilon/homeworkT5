package ru.bk.rom4ik2103;

import java.io.FileOutputStream;
import java.io.IOException;

public class TreadWriter implements Runnable {
	private FileCopingAction fca;
	 
	public TreadWriter(FileCopingAction fca) {
		super();
		this.fca = fca;
	}

	@Override
	public void run() {
		for(;!fca.isStop();){
		try (FileOutputStream fos = new FileOutputStream(fca.getFolderAdress(),true)) {
			
			int byteread = fca.getByteread();
			fos.write(fca.getBuffer(),0,byteread);
		} catch (IOException e) {
			System.out.println(e);
		}
		}
	}

}
