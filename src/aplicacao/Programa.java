package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import entidades.Departamento;
import entidades.Trabalhador;
import entidades.enums.NivelTrabalhador;

public class Programa {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("Entre com o nome do departamento: ");
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
		System.out.print("Quantos contratos esse trablhador terá? ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
		System.out.println("Digite o contrato #" + i + ": ");
		
		
		}
		sc.close();

	}

}
