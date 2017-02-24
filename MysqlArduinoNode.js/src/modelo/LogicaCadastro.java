package modelo;

import java.util.Date;

public class LogicaCadastro {
	private int NumeroMatricula;
	private String Nome;
	private String ValorMensalidade;
	private String Senha;
	private String Presente;
	private String Vencimento;
	private String Pagou;
	private String Idade;
	
	public LogicaCadastro(){
		
	}

	public LogicaCadastro(int numeroMatricula, String nome, String valorMensalidade, String senha, String Presente, String vencimento,
			String pagou, String idade) {
		NumeroMatricula = numeroMatricula;
		Nome = nome;
		valorMensalidade = valorMensalidade;
		Senha = senha;
		Presente = Presente;
		Vencimento = vencimento;
		Pagou = pagou;
		Idade = idade;
	}

	public int getNumeroMatricula() {
		return NumeroMatricula;
	}

	public void setNumeroMatricula(int string) {
		NumeroMatricula = string;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getValorMensalidade() {
		return ValorMensalidade;
	}

	public void setValorMensalidade(String valorMensalidade) {
		ValorMensalidade = valorMensalidade;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}

	public String getPresente() {
		return Presente;
	}

	public void setPresente(String presente) {
		Presente = presente;
	}

	public String getVencimento() {
		return Vencimento;
	}

	public void setVencimento(String vencimento) {
		Vencimento = vencimento;
	}

	public String getPagou() {
		return Pagou;
	}

	public void setPagou(String pagou) {
		Pagou = pagou;
	}

	public String getIdade() {
		return Idade;
	}

	public void setIdade(String idade) {
		Idade = idade;
	}
	
	
}
