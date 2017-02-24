package visao;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import excecoes.VisitanteJaCadastradoException;
import modelo.Visitantes;

public class TelaDeAcessoVisitante extends JInternalFrame{
	JFrame frame = new JFrame();
	JLabel lblEntrada;
	JLabel lblNomeVisitante, lblTelefone;
	JTextField txtNomeVisitante, txtTelefone;
	JButton btnLiberar;
	Container contentPane = frame.getContentPane();
	
	public Visitantes cadastradorDeVisitantes;
	
	public TelaDeAcessoVisitante(){
		setTitle("Controle de Acesso");
		setSize(550,200);
		setLayout(null);
		setResizable(false);
		setClosable(true);
		setIconifiable(true);
		setVisible(true);
		
		lblEntrada = new JLabel("Entrada");
		lblNomeVisitante = new JLabel("Nome do Visitante:");
		lblTelefone = new JLabel("Telefone:");
		txtNomeVisitante = new JTextField();
		txtTelefone = new JTextField();
		btnLiberar = new JButton("Liberar Acesso");
		contentPane.setLayout(null);
		
		
		frame.add(lblEntrada);
		frame.add(lblNomeVisitante);
		frame.add(lblTelefone);
		frame.add(txtNomeVisitante);
		frame.add(txtTelefone);
		frame.add(btnLiberar);
		
		lblEntrada.setBounds(220, 0, 150,25);
		lblNomeVisitante.setBounds(100, 40, 150, 25);
		lblTelefone.setBounds(100, 80, 150, 25);
		txtNomeVisitante.setBounds(250,40, 200, 25);
		txtTelefone.setBounds(250, 80, 150, 25);
		btnLiberar.setBounds(180, 120, 150,30);
		
		//inicializando cadastrador
		cadastradorDeVisitantes = new Visitantes();
		
		//eventos
		
		btnLiberar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				btnLiberarActionPerformed(e);
			}
		});
		
	}
	
	private void btnLiberarActionPerformed(ActionEvent e){
		Visitantes novo = new Visitantes(txtNomeVisitante.getText(), txtTelefone.getText());
		try {
			cadastradorDeVisitantes.cadastrarVisitantes(novo);
			JOptionPane.showMessageDialog(null, "Entrada liberada. Seja Bem vindo!");
		} catch (VisitanteJaCadastradoException e1) {
			e1.printStackTrace();
		} 
	}
}
