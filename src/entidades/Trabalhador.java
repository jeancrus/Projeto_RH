package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades.enums.NivelTrabalhador;

public class Trabalhador {
	private String nome;
	private NivelTrabalhador nivel;
	private Double salarioBase;
	
	private Departamento departamento; //somente um departamento, uma vari�vel
	private List<ContratoHora> contratos = new ArrayList<>(); /**como tem v�rios contratos, tem de ser feito por lista
	e n�o pode ser incluso a lista no construtor**/
	public Trabalhador() {
	}

	public Trabalhador(String nome, NivelTrabalhador nivel, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelTrabalhador getNivel() {
		return nivel;
	}

	public void setNivel(NivelTrabalhador nivel) {
		this.nivel = nivel;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<ContratoHora> getContratos() {//set removido pois n�o pode ser trocada lista pelo set
		return contratos;
	}
	
	public void adcContrato(ContratoHora contrato) { //fazer associa��o de um contrato com o trabalhador
		contratos.add(contrato);
	}
	
	public void rmvContrato(ContratoHora contrato) { //desfazer associa��o de um contrato com o trabalhador
		contratos.remove(contrato);
	}
	
	public double rendimento(int ano, int mes) {
		double soma = salarioBase;
		Calendar cal = Calendar.getInstance();
			for (ContratoHora c : contratos) {//teste para saber se o contrato � desse ano e desse mes para assim adicionar a soma
				cal.setTime(c.getData()); //pegar a data do contrato c e define para data do calendario CAL
				int c_ano = cal.get(Calendar.YEAR); //pega o ano da data calendar cal
				int c_mes = 1 + cal.get(Calendar.MONTH); //pega o mes da data calendar cal e acrescentar +1 pois mes come�a no zero
				if (ano == c_ano && mes == c_mes) { 
					soma += c.valorTotal();
					/**Se o ano for igual ao ano_c e m�s ao mes_c (contrato) � adicionado o valor do contrato a soma**/
				}
				}
			return soma;
			}
	}
