package Main;

import java.util.Scanner;

import Class.Clinica;

public class Main {

	public static void main(String[] args) {

		Clinica saude = new Clinica("saude");
		Scanner in = new Scanner(System.in);
		int escolha = 0;
		while (escolha != 3) {
			System.out.println("--------Clinica Saude Perfeita--------");
			System.out.println("Digite 1 para cadastrar cliente");
			System.out.println("Digite 2 para agendar consulta");
			System.out.println("Digite 3 para visualizar todos os agendamentos");
			System.out.println("Digite 4 para sair do sistema");
			escolha = in.nextInt();

			switch (escolha) {
			case 1:
				saude.cadastrarCliente();
				break;
			case 2:
				saude.agendar();
				break;
			case 3:
				saude.mostrarAgendaMedico();
				break;
			case 4:
				break;
			default:
				System.out.println("Opção invalida");
				break;
			}

		}

	}

}
