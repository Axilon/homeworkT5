package multiThreadCopingFolder;

import java.io.File;
import java.io.IOException;

public class FileThread implements Runnable {
	
	private String folderAdress;
	private File[] fileArray;
	private int min;
	private int max;

	public FileThread( String folderAdress, File[] fileArray,int min,int max) {
		super();
		
		this.folderAdress = folderAdress;
		this.fileArray = fileArray;
		this.min=min;
		this.max = max;
		
	}
	public FileThread() {
		super();
	}
	public String getfolderAdress() {
		return folderAdress;
	}
	public void setfolderAdress(String folderAdress) {
		this.folderAdress = folderAdress;
	}
	public File[] getFileArray() {
		return fileArray;
	}
	public void setFileArray(File[] fileArray) {
		this.fileArray = fileArray;
	}
	
		
	
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	@Override
	public void run() {
		fileCopy();
		
	} private void fileCopy(){
		File folderCopy = new File(this.folderAdress);
		folderCopy.mkdirs();		
		for(int i = min;i<max;i++){
			File newFile = new File(this.folderAdress+"/"+fileArray[i].getName());
			try {
				newFile.createNewFile();
			} catch (IOException e) {
				System.out.println(e);
			}
			
		}
		
	}
		
	

}
