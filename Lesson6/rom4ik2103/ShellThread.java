package ru.bk.rom4ik2103;

public class ShellThread implements Runnable {
	private int[] array;
	
	
	public ShellThread(int[] array) {
		super();
		this.array = array;
	}

	public ShellThread() {
		super();
	}

	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}

	@Override
	public void run() {
		shellSorting();


	}

	public void shellSorting() {
		
		int step = this.array.length / 2;
		while (step > 0) {
			for (int i = 0; i < (this.array.length - step); i++) {
				int j = i;
				while (j >= 0 && this.array[j] > this.array[j + step]) {
					int temp = this.array[j];
					this.array[j] = this.array[j + step];
					this.array[j + step] = temp;
					j--;
				}
			}
			step /= 2;
		}
		
	}
}
