package modelo;

import javax.swing.JOptionPane;

import excecoes.VisitanteJaCadastradoException;
import visao.TelaPrincipal;

public class Visitantes {
	private int numeroDeVisitas;
	private String nome;
	private String telefone;
	
	TelaPrincipal cV = new TelaPrincipal();
	
	public Visitantes(){
	}
	
	public Visitantes(String nome, String telefone){
		this.nome = nome;
		this.telefone = telefone;
	}
	
	public void cadastrarVisitantes(Visitantes v) throws VisitanteJaCadastradoException{
		if(!cV.cadastroDeVisitantes.contains(v)){
			cV.cadastroDeVisitantes.add(v);
			JOptionPane.showMessageDialog(null, "Visitante cadastrado!");
		}	
		else
			throw new VisitanteJaCadastradoException("Visitante já cadastrado!");
		maisUmaVisita();
	}
	
	
	private void maisUmaVisita(){
		numeroDeVisitas++;
	}
	
	public int getNumeroDeVisitas(){
		return numeroDeVisitas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
}
