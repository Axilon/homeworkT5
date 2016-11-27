package ru.bk.rom4ik2103;

import java.io.File;

public class FileCopingAction {
	private File file;
	private File folderAdress;
	private byte[]buffer;
	private int byteread;
	
	private boolean turn = false;
	private boolean stop = false;
	
	public FileCopingAction(File file,File folderAdress,int byteread, byte[]buffer) {
		super();
		this.file = file;
				this.folderAdress=folderAdress;
				this.byteread=byteread;
				this.buffer=buffer;
				
		}

	public int getByteread() {
		return byteread;
	}

	public void setByteread(int byteread) {
		this.byteread = byteread;
	}

	public FileCopingAction() {
		super();
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}


	public File getFolderAdress() {
		return folderAdress;
	}

	public void setFolderAdress(File folderAdress) {
		this.folderAdress = folderAdress;
	}

public synchronized void setBuffer(byte[]buffer){
		for(;turn==true;){
			try{
				wait();
			}catch(InterruptedException e){
				System.out.println(e);
			}
		}
		this.buffer=buffer;
		turn=true;
		notifyAll();
	}
	public synchronized byte[] getBuffer(){
	for(;turn==false;){
		try{
			wait();
		}catch(InterruptedException e){
			System.out.println(e);
		}
		}
		 byte[]buffer=this.buffer;
		 turn=false;
		 notifyAll();
		 return buffer;
	}
	
public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	
	
}
