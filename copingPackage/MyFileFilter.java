package copingPackage;

import java.io.File;
import java.io.FileFilter;

public class MyFileFilter implements FileFilter {
	private String [] arr;

	public MyFileFilter(String... arr) {
		super();
		this.arr = arr;
	}

	public MyFileFilter() {
		super();
	}
	
	
	private boolean check(String ext){
		for(String stringExt : arr){
			if(stringExt.equals(ext)){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean accept(File pathName) {
		int pointerIndex = pathName.getName().lastIndexOf(".");
		if(pointerIndex == -1){
			return false;
		}
		String ext = pathName.getName().substring(pointerIndex + 1);
		return check(ext);
	}
	
}
