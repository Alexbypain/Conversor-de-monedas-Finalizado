package com.aluracursos.conversormonedas.principal;

import java.io.IOException;
import java.util.Scanner;

import com.aluracursos.conversormonedas.modelos.Peticion;

public class Principal {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String monedaBase = null;
		String monedaDestino=null;
		int opcion=1;
		Double valor;
		System.out.println("*****************************************");
		System.out.println("Sea bienvenido/a al Conversor de Moneda\n");
		
		try {
		while(true) {
			System.out.println("1) Dólar =>>> Peso argentino");
			System.out.println("2) Peso argentino =>>> Dólar");
			System.out.println("3) Dólar =>>> Real Brasileño");
			System.out.println("4) Real Brasileño =>>> Dólar");
			System.out.println("5) Dólar =>>> Peso Colombiano");
			System.out.println("6) Peso Colombiano =>>> Dólar");
			System.out.println("7) Salir\n");
			
			System.out.println("Elija una opcion válida: ");
			
			
				
			
			opcion = teclado.nextInt();
			
			if(opcion==7) {
				break;
			}
			
			
			switch (opcion) {
			case 1: {
				monedaBase="USD";
				monedaDestino="ARS";
				break;
			}
			case 2:{
				monedaBase="ARS";
				monedaDestino="USD";
				break;
			}
			case 3:{
				monedaBase="USD";
				monedaDestino="BRL";
				break;
			}
			case 4:{
				monedaBase="BRL";
				monedaDestino="USD";
				break;
			}
			case 5:{
				monedaBase="USD";
				monedaDestino="COP";
				break;
			}
			case 6:{
				monedaBase="COP";
				monedaDestino="USD";
				break;
			}
			default:
				System.out.println("Digite una opcion valida y no: "+opcion);
			}
			System.out.println("Ingresa el valor que deseas convertir");
			valor=teclado.nextDouble();
			
			
			Peticion peticion=new Peticion(monedaBase,monedaDestino,valor);
			peticion.realizarPeticion();
		}
			}catch(IllegalArgumentException e) {
				System.out.println("Digite un numero");	
			}catch(Exception e) {
				System.out.println("Digite un numero");
			}
			
			
			
		
		
		
		
	}
}
