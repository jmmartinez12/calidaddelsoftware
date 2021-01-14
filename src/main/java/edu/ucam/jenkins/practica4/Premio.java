package edu.ucam.jenkins.practica4;
import java.util.Arrays;

public class Premio {
	
	private Fruta[] frutas;
	private final double dinero;
	
	
	public Premio(Fruta[] frutas, int dinero){
		this.frutas = Arrays.copyOf(frutas, frutas.length);
		this.dinero = dinero;
	}
	
	
	public Fruta[] getFrutas() {
		return Arrays.copyOf(frutas, frutas.length);
	}
	public double getDinero() {
		return dinero;
	}
	

	
	

}
