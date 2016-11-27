package ru.bk.rom4ik2103;

public class Ship implements Runnable{
	private String name;
	private int amountOfBoxes;
	public Ship(String name, int amountOfBoxes) {
		super();
		this.name = name;
		this.amountOfBoxes = amountOfBoxes;
	}
	public Ship() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmountOfBoxes() {
		return amountOfBoxes;
	}
	public void setAmountOfBoxes(int amountOfBoxes) {
		this.amountOfBoxes = amountOfBoxes;
	}
	@Override
	public void run() {
		System.out.println(this.name + " welcome to the dock");
		for (int j = 0; j < amountOfBoxes; j++) {
			try {
				Thread.sleep(500);
				System.out.println("box ¹" + (j + 1) + " was unloaded from the ship " + this.name);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (j == amountOfBoxes - 1) {
				System.out.println(this.name + " was fully unloaded");

			}
		}
		System.out.println(this.name + " lefted the  dock");
		System.out.println("Dock is ready to get new ship for unloading");

	}
	
}
