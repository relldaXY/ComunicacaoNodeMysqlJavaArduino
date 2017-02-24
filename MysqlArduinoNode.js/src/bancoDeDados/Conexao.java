package bancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class Conexao {
	public Connection minhaConexao;
	private static Conexao INSTANCE = null;
	
	String host = "127.0.0.1";
	String usuario = "root";
	String senha = "rellda";
	String bd = "Clube";
	String driver = "com.mysql.jdbc.Driver";
	
	public Conexao(){
		
	}
	
	public Connection conectarComBD(){
		try{
		Class.forName(driver);
		String newConnectionURL = "jdbc:mysql://" + host + "/" + bd + "?" + "user=" + usuario + "&password=" + senha;
		minhaConexao = DriverManager.getConnection(newConnectionURL);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return minhaConexao;
	}
	
	public void desconectarComBD(){
		try{
			minhaConexao.close();
			JOptionPane.showMessageDialog(null, "Desconexao realizada com sucesso");
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao fechar conexao com o BD");
		}
	}
	
	//padrao singleton
	
	
	private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new Conexao();
        }
    }

	public static Conexao getInstance() {
		if (INSTANCE == null) 
			createInstance();
		return INSTANCE;
	}
	
	
	
	//para consulta
	
	public ResultSet getQuery(String query){
		Statement stmt = null;
		ResultSet resultado = null;
		try{
			stmt = minhaConexao.createStatement();
			resultado = stmt.executeQuery(query);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return resultado;
	}
	
	//para modificacao
	
	public void setQuery(String query){
		Statement stmt = null;
		try{
			stmt = minhaConexao.createStatement();
			stmt.execute(query);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	
}
