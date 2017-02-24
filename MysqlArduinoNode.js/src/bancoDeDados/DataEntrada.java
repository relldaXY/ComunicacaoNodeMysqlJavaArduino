package bancoDeDados;

import java.sql.Connection;
import java.sql.SQLException;

import modelo.LogicaCadastro;

public class DataEntrada {
	Conexao conexao = new Conexao();
	Connection c = conexao.conectarComBD();
	
	
	public void inserirSim(String numeroMatricula){
		java.sql.PreparedStatement pst;
		
	try{
		String sql = "update tblCadastro set Presente=? where NumeroMatricula=?";
		pst = c.prepareStatement(sql);
		pst.setString(1, "Sim");
		pst.setInt(2, Integer.parseInt(numeroMatricula));
		pst.executeUpdate();
		
	}catch(SQLException e ){
			e.printStackTrace();
	}
	}
}
