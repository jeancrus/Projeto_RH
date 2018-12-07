package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.ContratoHora;
import entidades.Departamento;
import entidades.Trabalhador;
import entidades.enums.NivelTrabalhador;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");//mascarando o sdf com o formato dd/MM/yyyy exemplo: 07/12/2018
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.print("Entre com o nome do departamento: ");
		String nomeDepartamento = sc.nextLine();
		System.out.println("------Dados do trabalhador----");
		System.out.print("Nome: ");
		String nomeTrabalhador = sc.nextLine();
		System.out.print("Nível: ");
		String nivelTrabalhador = sc.nextLine();
		System.out.print("Base salarial: ");
		double baseSalarial = sc.nextDouble();
		//agora instanciar um trabalhador com os dados informados acima, convertendo o nivelTrabalhador enum para uma string e instanciar
		//a classe departamento para que receba o nome do departamento, nome e base salarial não precisa, pois não são classes que necessistem ser instanciadas 
		Trabalhador trab = new Trabalhador(nomeTrabalhador, NivelTrabalhador.valueOf(nivelTrabalhador), baseSalarial, new Departamento(nomeDepartamento));
		System.out.print("Quantos contratos esse trabalhador terá? ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
		System.out.println("Digite o contrato #" + i + ": ");
		System.out.print("Data (DD/MM/YYYY): ");
		Date dataContrato = sdf.parse(sc.next()); //converte string para data
		System.out.print("Valor por hora: ");
		double valorPorHora = sc.nextDouble();
		System.out.print("Duração (horas): ");
		int horas = sc.nextInt();
		ContratoHora contrato = new ContratoHora(dataContrato, valorPorHora, horas);
		trab.adcContrato(contrato);
		/**leva ao metodo adcontrato da classe trabalhador que adiciona o contrutor contrato do contratohora  a lista contracts da classe contrahora dentro da 
		 * classe trabalhador e por fim adicionada ao objeto trab instancia pela classe trabalhador
		 * **/
		}
		System.out.println();
		System.out.print("Entre com o mês e ano para calcular o salario (MM/YYYY): ");
		String mesEAno = sc.next();
		int mes = Integer.parseInt(mesEAno.substring(0, 2));
		int ano = Integer.parseInt(mesEAno.substring(3, 7));
		System.out.println("Nome: " + trab.getNome());
		System.out.println("Departamento: " + trab.getDepartamento().getName());//obj trab, acessar o outro obj dentro dele e enfim acessar o nome de seu obj
		System.out.printf("Salario para %d/%d: R$ %.2f",mes,ano,trab.rendimento(ano, mes));
		
		
		sc.close();

	}

}
