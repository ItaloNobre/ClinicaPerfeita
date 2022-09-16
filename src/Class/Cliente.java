package Class;

public class Cliente {
	
	  private String nomeCliente;
	    private double cpf;


	    public Cliente(String nomeCliente, double cpf) {
	        this.nomeCliente = nomeCliente;
	        this.cpf = cpf;
	    }

	    public String getNomeCliente() {
	        return nomeCliente;
	    }
}
