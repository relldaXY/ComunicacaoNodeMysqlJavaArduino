package bancoDeDados;

import java.sql.Connection;
import java.sql.SQLException;

import microcontrolador.ComunicacaoSerial;
import modelo.LogicaCadastro;

public class DataDados {
	Conexao conexao = new Conexao();
	Connection c = conexao.conectarComBD();
	
	public void atualizarDadosDoAmbiente(ComunicacaoSerial cs){
		java.sql.PreparedStatement pst;
	try{
		String sql = "update tblDados set Temperatura=?, LDR=?, Umidade=?, Volume=? where id=1";
		pst = c.prepareStatement(sql);
		pst.setString(1, cs.getTemperaturaViaSerial());
		pst.setString(2, cs.getLuminosidadeViaSerial());
		pst.setString(3, cs.getUmidadeViaSerial());
		pst.setString(4, cs.getVolumeSomViaSerial());
		
		pst.executeUpdate();
	}catch(SQLException e ){
			e.printStackTrace();
	}
	}
}
