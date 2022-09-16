package Class;

import java.util.ArrayList;

public class Medico {

	 private String nome;
	    ArrayList<Agenda> agendamentos = new ArrayList<Agenda>();


	    public Medico(String nome) {
	        this.nome = nome;
	    }

	    public boolean verificarDisponibilidade(int hora,int dia) {
	        for (Agenda agendamento : agendamentos) {
	            if (agendamento.getHora() == hora && agendamento.getDia() == dia) {
	                return false;
	            }
	        }
	        return true;
	    }

	    public void anotarNaAgenda(int hora,int dia, Cliente cliente) {
	        Agenda agendamento = new Agenda();
	        agendamento.setHora(hora);
	        agendamento.setDia(dia);
	        agendamento.setClienteAgendado(cliente);
	        agendamentos.add(agendamento);

	        System.out.println("consulta agendada com sucesso!");

	    }
	    public void mostrarAgenda() {
	        for (Agenda agendamento : agendamentos) {
	            System.out.println("-----------Agendamentos Marcados---------");
	            System.out.println("Nome: "  + agendamento.getClienteAgendado().getNomeCliente() +", Dia do mês: "+ agendamento.getDia() + ", as "+agendamento.getHora() +" horas");
	        }

	    }

}
