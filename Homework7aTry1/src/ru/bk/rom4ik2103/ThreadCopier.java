package ru.bk.rom4ik2103;

import java.io.FileInputStream;
import java.io.IOException;

public class ThreadCopier implements Runnable {
	private FileCopingAction fca;
//	private FileInputStream fis;
	
	public ThreadCopier(FileCopingAction fca) {
		super();
		this.fca = fca;
	}
	@Override
	public void run() {
		try(FileInputStream fis = new FileInputStream(fca.getFile().getAbsolutePath())){
			byte[]buffer =  new byte [1024];
			int byteread = 0;
			for(;(byteread=fis.read(buffer))>0;){
				fca.setByteread(byteread);
				fca.setBuffer(buffer);
				 
			}
		} catch (IOException e) {
			
			System.out.println(e);
		}
		fca.setStop(true);
	}
	
}
