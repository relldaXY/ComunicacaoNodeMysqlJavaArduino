package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import bancoDeDados.Conexao;
import bancoDeDados.DataSaida;

public class TelaDeSaidaAlunos extends JInternalFrame{
	JLabel JlblSaida;
	JLabel JlblNumeroMatricula, JlblSenha, JlblImagem;
	public JTextField JtxtNumeroMatricula;
	public JPasswordField JpassSenha;
	JButton JbtnEntrar;
	JButton JbtnSair;
	
	public TelaDeSaidaAlunos(){
		setTitle("Controle de Acesso");
		setSize(550,200);
		setResizable(false);
		setClosable(true);
		setIconifiable(true);
		setLayout(null);
		setVisible(true);
		
		
		//instanciando objetos
		JlblSaida = new JLabel("Saída");
		JlblNumeroMatricula = new JLabel("Matrícula");
		JlblSenha = new JLabel("Senha");
		JtxtNumeroMatricula = new JTextField();
		JpassSenha = new JPasswordField();
		JbtnEntrar = new JButton("Entrar");
		JbtnSair = new JButton("Sair");
		
		//adicionando ao JFrame
		add(JlblSaida);
		add(JlblNumeroMatricula);
		add(JtxtNumeroMatricula);
		add(JlblSenha);
		add(JpassSenha);
		add(JbtnEntrar);
		add(JbtnSair);
		
		//posicionando elementos
		JlblSaida.setBounds(250, 0, 100, 50);
		
		JlblNumeroMatricula.setBounds(100, 50, 150, 25);
		JtxtNumeroMatricula.setBounds(300, 50, 150, 25);
		
		JlblSenha.setBounds(100, 80, 150, 25);
		JpassSenha.setBounds(300, 80, 150, 25);
		
		JbtnEntrar.setBounds(100, 125, 150, 40);
		JbtnSair.setBounds(300, 125, 150, 40);
		
		//eventos
		
		JbtnEntrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				jbtnEntrarActionPerformed(e);
			}
		});
		
		
		JbtnSair.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				jbtnSairActionPerformed(e);
			}
		});
		
	}
	
	private void jbtnEntrarActionPerformed(ActionEvent e){
		liberarAcesso(verificarAcesso());
		dispose();
	}
	
	private void jbtnSairActionPerformed(ActionEvent e){
		dispose();
	}
	
	public int verificarAcesso(){
		Conexao c = new Conexao();
		c.conectarComBD();
		
		ResultSet r;
		
		r = c.getQuery("select * from tblCadastro");
			
		try{
			while(r.next()){
					//nroMatricula = r.getString("NumeroMatricula");
					//senha = r.getString("Senha");
				if(r.getString("NumeroMatricula").equals(JtxtNumeroMatricula.getText()) && r.getString("Senha").equals(JpassSenha.getText())){
					retirarPresenca(r.getString("NumeroMatricula"));
					return 1;
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return 0;
	}
	
	public void liberarAcesso(int n){
		if(n == 1){
			JOptionPane.showMessageDialog(null, "Até a próxima!");
		}
		else
			JOptionPane.showMessageDialog(null, "Por favor. Digite Novamente!!");
			TelaDeSaidaAlunos telaDeSaidaCliente = new TelaDeSaidaAlunos();
		    telaDeSaidaCliente.setVisible(true);
	}
	
	private void retirarPresenca(String numeroMatricula){
		DataSaida saida = new DataSaida();
		saida.inserirNao(numeroMatricula);
	}
	
	
}
