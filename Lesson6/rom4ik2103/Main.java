package ru.bk.rom4ik2103;

import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		long time;
		int[] array = new int[10000];
		int[] arrayPart1 = new int[(array.length / 2)];
		int[] arrayPart2 = new int[(array.length / 2)];
		
		Random r = new Random();
		int k = 0;
		for (int i = 0; i < array.length; i++) {
			int randNum =r.nextInt(20000) ;
			array[i] = randNum;
			if(i<=(array.length/2)-1){
				arrayPart1[i]=randNum;
				}if(i>=array.length/2){
					arrayPart2[k]=randNum;
					k++;
				}
			
		}	
//		System.arraycopy(array, 0, arrayPart1, 0, arrayPart1.length);
//		System.arraycopy(array, (array.length / 2) - 1, arrayPart2, 0, arrayPart2.length);

		ShellThread sTh = new ShellThread(array);
		ShellThread sThOne = new ShellThread(arrayPart1);
		ShellThread sThTwo = new ShellThread(arrayPart2);
		Thread thPart1 = new Thread(sThOne);
		Thread thPart2 = new Thread(sThTwo);

		time = System.currentTimeMillis();
		sTh.run();
		System.out.println(Arrays.toString(array));
		System.out.println();
		System.out.println("Main_Shell sorting is finisched in -> " + (System.currentTimeMillis() - time));

		time = System.currentTimeMillis();
		thPart1.start();
		thPart2.start();
		try {
			thPart1.join();
			thPart2.join();

		} catch (InterruptedException e) {
			System.out.println(e);
		}
		
		System.out.println();
		System.out.println(Arrays.toString(pasteSort(arrayPart1, arrayPart2)));
		System.out.println("Multi_Thread_Shell sorting is finisched in -> " + (System.currentTimeMillis() - time));

	}
	private static int[] pasteSort(int[]arrayPart1,int[]arrayPart2){
		int[] arrayPart3 = new int[arrayPart1.length + arrayPart2.length];
		int i = 0;
		int j = 0;
		for (int k = 0; k < arrayPart3.length; k++) {
			if (i > arrayPart1.length - 1) {
				int a = arrayPart2[j];
				arrayPart3[k] = a;
				j++;
			} else if (j > arrayPart2.length - 1) {
				int a = arrayPart1[i];
				arrayPart3[k] = a;
				i++;
			} else if (arrayPart1[i] < arrayPart2[j]) {
				int a = arrayPart1[i];
				arrayPart3[k] = a;
				i++;
			} else {
				int b = arrayPart2[j];
				arrayPart3[k] = b;
				j++;
			}
		}return arrayPart3;
	}
}
