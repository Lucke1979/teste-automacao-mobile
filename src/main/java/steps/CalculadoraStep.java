package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import page.CalculadoraPage;

public class CalculadoraStep {
	
	CalculadoraPage calculadora = new CalculadoraPage();
	
	@Dado("que clique no numero cinco")
	public void dado_que_clique_no_numero_5 () {
		calculadora.click("5");
	}
	@E("clicar no operador de soma")
	public void e_clicar_no_operador_de_soma () {
		calculadora.click("add");
	}
	@E("clicar no numero sete")
	public void e_clicar_no_numero_7 () {
		calculadora.click("7");
	}
	@Entao("ao clicar no sinal de igual devo validar o resultado")
	public void e_clicar_no_sinal_de_igual () {
		calculadora.click("eq");
	}

}
