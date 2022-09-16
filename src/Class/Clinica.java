package Class;

import java.util.ArrayList;
import java.util.Scanner;

public class Clinica {


    private String nome;
    private Medico bill = new Medico("Bill");
    private Medico fidoBill = new Medico("FidoBill");
    private Medico mulherDoBill = new Medico("MulherDoBill");
    ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    Scanner in = new Scanner(System.in);

    public Clinica(String nome) {

        this.nome = nome;

    }

    public void cadastrarCliente() {
        try {
            System.out.println("------Tela De Cadastro------");
            System.out.println("Digite o nome do Cliente a ser cadastrado");
            String pacienteNome = in.next();
            System.out.println("Digite o Cpf");
            double cpf = in.nextDouble();
            for (Cliente cliente : clientes) {
                if (cliente.getNomeCliente().equalsIgnoreCase(pacienteNome)) {
                	System.out.println("Cliente já consta na nossa base de dados");
                }
            }
            Cliente paciente = new Cliente(pacienteNome, cpf);
            clientes.add(paciente);
            System.out.println("Cadastro ok!");

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar, verifique se os dados estão corretos e tente novamente.");
            cadastrarCliente();
        }

    };

    public boolean verificarCadastro(String paciente) {
        for (Cliente cliente : clientes) {
            if (cliente.getNomeCliente().equalsIgnoreCase(paciente)) {
                return true;
            }

        }
        return false;
    }

    public void agendar() {

        System.out.println("------Tela de Agendamento------");
        System.out.println("Digite o nome do Paciente");
        String paciente = in.next();
        System.out.println("Digite o dia do mês");
        int dia = in.nextInt();
        System.out.println("Escolha o horario");
        System.out.println("Digite-1 para agendar no horario das 7h");
        System.out.println("Digite-2 para agendar no horario das 8h");
        System.out.println("Digite-3 para agendar no horario das 9h");
        System.out.println("Digite-4 para agendar no horario das 10h");
        System.out.println("Digite-5 para agendar no horario das 11h");
        int hora = in.nextInt() + 6;
        if (verificarCadastro(paciente) == true) {
            Medico medico = escolherMedico();
            if (medico.verificarDisponibilidade(hora, dia) == true) {
                System.out.println("Horario disponivel");
                for (Cliente cliente : clientes) {
                    if (cliente.getNomeCliente().equalsIgnoreCase(paciente)) {
                        medico.anotarNaAgenda(hora, dia, cliente);
                    }
                }
            } else {
                System.out.println("Nesse Hóraio já tem consulta marcada");
                System.out.println("Escolha outro horario");
                agendar();
            }
        } else {
            System.out.println("o Cliente nao tem cadastro");
            System.out.println("direcionando para a tela de cadastro");
            cadastrarCliente();
        }
    }

    public void mostrarAgendaMedico() {

        System.out.println("--------------------------------------------");
        System.out.println("Agenda do Dr.Bill");
        bill.mostrarAgenda();
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("Agenda do Dr.fiDoBill");
        fidoBill.mostrarAgenda();
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("Agenda do Dr.mulherDoBill");
        mulherDoBill.mostrarAgenda();
        System.out.println("--------------------------------------------");
    }

    public Medico escolherMedico() {
        System.out.println("Tela- Medicos Parceiros");
        System.out.println("1-Dr.Bill Obstetra/clinicoGeral-");
        System.out.println("2-Dr.fiDoBill Ortopedista/clinicoGeral- ");
        System.out.println("3-Dra.MulherDoBill Pediatra/clinicoGeral- ");
        int medicoEscolhido = in.nextInt();
        switch (medicoEscolhido) {
            case 1:
                return bill;
            case 2:
                return fidoBill;
            case 3:
                return mulherDoBill;

            default:
                return escolherMedico();
        }

    }

}
