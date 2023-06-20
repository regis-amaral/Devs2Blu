package aula01;

import aula01.interfaces.Oviparo;

public class Galinha extends Animal implements Oviparo  {

	@Override
	public void botarOvo() {
		System.out.println("Galinha botando ovos");
	}

	@Override
	public boolean chocarOvo() {
		System.out.println("Galinha chocando ovos");
		return false;
	}

}
