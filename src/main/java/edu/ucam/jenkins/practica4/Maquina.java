package edu.ucam.jenkins.practica4;

import java.util.Arrays;
import java.util.Random;

public class Maquina {
	
	private final int numCasillas;
	private double precioJugada;
	private double credito;
	private final Premio[] premios;
	
	public Maquina(int numCasillas, double precioJugada, Premio... premios){
		this.numCasillas = numCasillas;
		this.precioJugada = precioJugada;
		credito = 0;
		this.premios = premios;
	}
	
	
	public double cobrar (){
		double aux = credito;
		credito = 0;
		return aux;	
	}
	
	public Fruta[] jugar(){
		if (credito < precioJugada) return null;
		else {
			credito-=precioJugada;
			Fruta[] frutas = Fruta.values();
			Fruta[] combinacion = new Fruta[numCasillas];
			Random generador = new Random();
			int index;
			for (int i=0; i<numCasillas; i++) {

				index = generador.nextInt(frutas.length);
				combinacion[i] = frutas[index];
			}
			for (Premio premio : premios) {
				
				if (Arrays.equals(combinacion, premio.getFrutas())){
					incrementarCredito(premio.getDinero());
					break;
				}
				
				
			}
		return combinacion;
		}	
	}
	
	
	
	public int getNumCasillas() {
		return numCasillas;
	}
	
	public void setPrecioJugada(double precioJugada) {
		this.precioJugada = precioJugada;
	}
	
	public double getPrecioJugada() {
		return precioJugada;
	}
	
	public double getCredito() {
		return credito;
	}
	
	public Premio[] getPremios() {
		return Arrays.copyOf(premios, premios.length);
	}
	
	public void incrementarCredito(double cantidad){
		credito += cantidad;
	}

	
	
}
