package ru.bk.rom4ik2103;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		Ship shipOne = new Ship("Arkadia",10);
		Ship shipTwo = new Ship("Nepotopaemui",15);
		Ship shipThree = new Ship("Ytonuvshiu",8);
		
		ExecutorService exSer = Executors.newFixedThreadPool(2);
		exSer.submit(shipOne);
		exSer.submit(shipTwo);
		exSer.submit(shipThree);
		exSer.shutdown();

	}

}
