package aula01;

import java.util.Date;

import aula01.interfaces.Mamifero;
import aula01.interfaces.Oviparo;

public class Ornitorrinco extends Animal implements Oviparo, Mamifero {
	
	private float tamanhoBico;
	private float tamanhoCauda;
	private boolean temVeneno;
	
	
	public Ornitorrinco() {
		// TODO Auto-generated constructor stub
	}
	
	public Ornitorrinco(String especie, String nome, float peso, float altura, Date dataNascimento, float tamanhoBico,
			float tamanhoCauda, boolean temVeneno) {
		super(especie, nome, peso, altura, dataNascimento);
		this.tamanhoBico = tamanhoBico;
		this.tamanhoCauda = tamanhoCauda;
		this.temVeneno = temVeneno;
	}

	public float getTamanhoBico() {
		return tamanhoBico;
	}

	public void setTamanhoBico(float tamanhoBico) {
		this.tamanhoBico = tamanhoBico;
	}

	public float getTamanhoCauda() {
		return tamanhoCauda;
	}

	public void setTamanhoCauda(float tamanhoCauda) {
		this.tamanhoCauda = tamanhoCauda;
	}

	public boolean isTemVeneno() {
		return temVeneno;
	}

	public void setTemVeneno(boolean temVeneno) {
		this.temVeneno = temVeneno;
	}

	@Override
	public void botarOvo() {
		System.out.println("Ornitorinco botando ovos");	
	}

	@Override
	public boolean chocarOvo() {
		System.out.println("Ornitorinco chocando ovos");
		return false;
	}

	@Override
	public void mamar() {
		// TODO Auto-generated method stub
		
	}

}
