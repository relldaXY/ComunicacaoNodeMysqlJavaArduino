package modelo;

public class LogicaPrecos {
	private int frequencia;
	private int fidelidade;
	private static int custoDaAula = 5;
	
	public LogicaPrecos(){
		
	}

	public LogicaPrecos(String frequencia, String fidelidade){
		this.frequencia = Integer.parseInt(frequencia);
		this.fidelidade = Integer.parseInt(fidelidade);
	}

	public int getFrequencia() {
		return frequencia;
	}

	public int getFidelidade() {
		return fidelidade;
	}
	
	private double getCoeficienteRellda(){
		return getFrequencia()*0.015;
	}
	
	public double descontoDaFidelidade(){
		return getFidelidade()*custoDaAula*getCoeficienteRellda();
	}

	public int calcularMensalidade(int frequencia, int fidelidade) {
		return (int) (4*(getFrequencia()*custoDaAula - descontoDaFidelidade()));
	}
	
	
	
	
	
}
