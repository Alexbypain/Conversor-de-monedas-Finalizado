package com.aluracursos.conversormonedas.modelos;



public class Conversion {
	private String monedaBase;
	private String monedaCambio;
	private Double valorBase;
	private Double valorCambio;
	
	public Conversion(ConversionApi conversionApi, Double valor ) {
		// TODO Auto-generated constructor stub
		this.monedaBase=conversionApi.base_code();
		this.monedaCambio=conversionApi.target_code();
		this.valorBase=valor;
		this.valorCambio=Double.valueOf(conversionApi.conversion_result());

}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "El valor "+valorBase+"["+monedaBase+"]"+" Corresponde al valor final de =>>> "+valorCambio+" ["+monedaCambio+"]";
	}
}