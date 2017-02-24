package bancoDeDados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import modelo.LogicaCadastro;

public class DataPresentes {
	Conexao conexao = new Conexao();
	Connection c = conexao.conectarComBD();
	
	public DefaultTableModel mostrarPresentes(){
		String coluna [] = {"Nº Matricula", "Nome"};
		DefaultTableModel alunosPresentes = new DefaultTableModel(null, coluna);
		String nome [] = new String[2];
		String sql = "select * from tblCadastro";
		java.sql.PreparedStatement pst;
		
		try{	
			pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				nome[0]= rs.getString("NumeroMatricula");
				nome[1]= rs.getString("Nome");
				
				if(rs.getString("Presente").equals("Sim"))
				alunosPresentes.addRow(nome);
		}
		
		return alunosPresentes;
		
		}catch(SQLException e){
			e.printStackTrace();
			
			return null;
		}
	}
	
	
}
