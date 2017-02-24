package bancoDeDados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

import modelo.LogicaCadastro;

public class DataCadastro {
	Conexao conexao = new Conexao();
	Connection c = conexao.conectarComBD();
	
	
	public DefaultTableModel mostrarOsCadastrados(){
		String colunas [] = {"Nº Matrícula", "Nome","ValorMensalidade","Idade","Senha", "Presente", "Vencimento", "Pagou?"};
		DefaultTableModel modeloCadastro = new DefaultTableModel(null, colunas);
		String dados [] = new String[8];
		String sql = "select * from tblCadastro";
		java.sql.PreparedStatement pst;
		
		try{	
			pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				dados[0]= rs.getString("NumeroMatricula");
				dados[1]= rs.getString("Nome");
				dados[2]= rs.getString("ValorMensalidade");
				dados[3]= rs.getString("Idade");
				dados[4]= rs.getString("Senha");
				dados[5]= rs.getString("Presente");
				dados[6]= rs.getString("Vencimento");
				dados[7]= rs.getString("Pagou");
				
				modeloCadastro.addRow(dados);
		}
		
		return modeloCadastro;
		
		}catch(SQLException e){
			e.printStackTrace();
			
			return null;
		}
	}
	
	
	public String inserirCadastro(LogicaCadastro cadastro){
		java.sql.PreparedStatement pst;
		
	try{
		
		
		String sql = "insert into tblCadastro (NumeroMatricula, Nome, ValorMensalidade, Idade, Senha, Presente, Vencimento, Pagou) values(?,?,?,?,?,?,?,?)";
		
		pst = c.prepareStatement(sql);
		pst.setInt(1, cadastro.getNumeroMatricula());
		pst.setString(2, cadastro.getNome());
		pst.setString(3, cadastro.getValorMensalidade());
		pst.setString(4, cadastro.getIdade());
		pst.setString(5, cadastro.getSenha());
		pst.setString(6, cadastro.getPresente());
		pst.setString(7, cadastro.getVencimento());
		pst.setString(8, cadastro.getPagou());
		pst.executeUpdate();
		return "Inserido corretamente";
	}catch(SQLException e ){
			e.printStackTrace();
		return "Problema ao inserir"; 
	}
	}
	
	
	
	
	public String editarCadastro(LogicaCadastro cadastro){
		java.sql.PreparedStatement pst;
	try{
		String sql = "update tblCadastro set Nome=?, ValorMensalidade=?, Idade=?, Senha=?, Presente=?, Vencimento=?, Pagou=? where NumeroMatricula=?";
		pst = c.prepareStatement(sql);
		pst.setString(1, cadastro.getNome());
		pst.setString(2, cadastro.getValorMensalidade());
		pst.setString(3, cadastro.getIdade());
		pst.setString(4, cadastro.getSenha());
		pst.setString(5, cadastro.getPresente());
		pst.setString(6, cadastro.getVencimento());
		pst.setString(7, cadastro.getPagou());
		pst.setInt(8, cadastro.getNumeroMatricula());
		pst.executeUpdate();
		return "Editado corretamente";
	}catch(SQLException e ){
			e.printStackTrace();
		return "Problema ao editar"; 
	}
	}
	
	public DefaultTableModel buscarCadastro(String buscar){
		try{
			DefaultTableModel modeloCadastro;
			String colunas [] = {"Nº Matrícula", "Nome","ValorMensalidade","Idade","Senha", "Presente", "Vencimento", "Pagou?"};
			String dados[] = new String[8]; 
			modeloCadastro = new DefaultTableModel(null, colunas);
			String sql = "SELECT * FROM tblCadastro WHERE NumeroMatricula='"+buscar+"'";
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rst = pst.executeQuery(sql);
			
			
			while(rst.next()){
				dados[0]= rst.getString("NumeroMatricula");
				dados[1]= rst.getString("Nome");
				dados[2]= rst.getString("ValorMensalidade");
				dados[3]= rst.getString("Idade");
				dados[4]= rst.getString("Senha");
				dados[5]= rst.getString("Presente");
				dados[6]= rst.getString("Vencimento");
				dados[7]= rst.getString("Pagou");
				
				modeloCadastro.addRow(dados);
			}
			return modeloCadastro;
			
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, ex);
			return null;
		}
	}
	
	public String eliminarCadastro(LogicaCadastro cadastro){
		try{
			String sql = "DELETE FROM `Clube`.`tblCadastro` WHERE `tblCadastro`.`NumeroMatricula` =?";
			//String sql = "DROP * FROM tblCadastro WHERE NumeroMatricula=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setInt(1, cadastro.getNumeroMatricula());
			pst.executeUpdate();
			
			return "Registro eliminado com sucesso";
			
		}catch(SQLException ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, ex);
			return "Problema ao eliminar usuario";
		}
	}
	
}
