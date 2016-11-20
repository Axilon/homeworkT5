package checkFolder;

import java.io.File;

public class CheckThread implements Runnable {
	private File folder;
	private int count;
	
	public CheckThread(File folder, int count) {
		super();
		this.folder = folder;
		this.setCount(count);

	}
	public CheckThread() {
		super();
	}
	public File getFolder() {
		return folder;
	}
	public void setFolder(File folder) {
		this.folder = folder;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public void run() {
		Thread.currentThread();
		for (;;) {
			try {
				if (count - folderChecker() == 0) {
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (count - folderChecker() > 0) {
				System.out.println("Something was delited from the folder");
				break;
			}
			if (count - folderChecker() < 0) {
				System.out.println("Something was added to the folder");
				break;
			}
		}
	}
		
		
	private int folderChecker(){
		File [] fileArray = folder.listFiles();
		int count=0;
		for(int i = 0;i<fileArray.length;i++){
			count++;
		}
		return count;
	}
}
