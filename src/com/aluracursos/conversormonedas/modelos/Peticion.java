package com.aluracursos.conversormonedas.modelos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Peticion {
	private String monedaBase;
	private String monedaDestino;
	private Double valor;
	private String direccion;
	private ConversionApi conversionApi;
	private Conversion conversion;
	
	public Peticion(String monedaBase, String monedaDestino, Double valor) {
		super();
		this.monedaBase = monedaBase;
		this.monedaDestino=monedaDestino;
		this.valor=valor;
		this.direccion = "https://v6.exchangerate-api.com/v6/67da8ec104e2306f73b588c6/pair/"+monedaBase+"/"+monedaDestino+"/"+valor;
	}
	
	public void realizarPeticion() throws IOException, InterruptedException  {
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(direccion)).build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		String json = response.body();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		this.conversionApi= gson.fromJson(json, ConversionApi.class);
		
		Conversion conversion=new Conversion(conversionApi, valor);
		
		System.out.println(conversion);
		System.out.println(json);
	}

	
	
}
