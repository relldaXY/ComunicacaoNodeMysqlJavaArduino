package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controle.Main;
import modelo.SerializeImprimirVisitantes;
import modelo.Visitantes;

public class TelaPrincipal extends JFrame implements Serializable{
	public Thread t;
	
	//menu principal
	JMenuBar JMenuPrincipal;
	
	//menu subprincipal;
	JMenu JMAcesso; 
	JMenu JMCadastro; 
	JMenu JMConsultas;
	JMenu JMControleDePresenca;
	JMenu JMControleDeAmbiente;
	
	//menu do menu subprincipal
	JMenu JMEntrada, JMSaida;
	JMenuItem JMItemDadosCadastrais; 
	JMenuItem JMItemImprimirVisitantes;
	JMenuItem JMItemPrecos;
	JMenuItem JMItemPresentes;
	JMenuItem JMItemControleDeAmbientes;
	
	//menu do menu do menu subprincipal
	JMenuItem JMItemAcessoCliente, JMItemAcessoAdministracao;
	JMenuItem JMItemSaidaCliente;
	
	
	//JDesktopPane
	public JDesktopPane JDControle;
	
	//declarando cadastrador de visitantes
	public ArrayList<Visitantes> cadastroDeVisitantes;
	
	public TelaPrincipal(){
		setTitle("Tela de Gerenciamento");
		setSize(1000, 700);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//criando os menus
		JMenuPrincipal = new JMenuBar();
		
		JMAcesso = new JMenu("Acesso");
		JMCadastro = new JMenu("Cadastro");
		JMConsultas = new JMenu("Consulta");
		JMControleDePresenca = new JMenu("Controle de Presença");
		JMControleDeAmbiente = new JMenu("Controle do Ambiente");
		
		JMEntrada = new JMenu("Entrada");
		JMSaida = new JMenu("Saída");
		
		JMItemDadosCadastrais = new JMenuItem("Alunos");
		
		JMItemImprimirVisitantes = new JMenuItem("Imprimir Visitantes");
		
		JMItemPrecos = new JMenuItem("Preços");
		
		JMItemPresentes = new JMenuItem("Alunos presentes");
		
		JMItemAcessoCliente = new JMenuItem("Alunos");
		JMItemAcessoAdministracao = new JMenuItem("Visitantes");
		JMItemSaidaCliente = new JMenuItem("Alunos");
		
		JMItemControleDeAmbientes = new JMenuItem("Recepção de dados");
		
		//adicionando ao menu principal
		JMenuPrincipal.add(JMAcesso);
		JMenuPrincipal.add(JMCadastro);
		JMenuPrincipal.add(JMConsultas);
		JMenuPrincipal.add(JMControleDePresenca);
		JMenuPrincipal.add(JMControleDeAmbiente);
		
		//adicionando aos submenus
		JMAcesso.add(JMEntrada);
		JMAcesso.add(JMSaida);
		
		JMCadastro.add(JMItemDadosCadastrais);
		JMCadastro.add(JMItemImprimirVisitantes);
		
		JMConsultas.add(JMItemPrecos);
		
		JMControleDePresenca.add(JMItemPresentes);
		
		JMControleDeAmbiente.add(JMItemControleDeAmbientes);
		
		setJMenuBar(JMenuPrincipal);
		
		JDControle = new JDesktopPane();
		getContentPane().add(JDControle);
		
		//adicionando aos menus dos submenus
		
		JMEntrada.add(JMItemAcessoCliente);
		JMEntrada.add(JMItemAcessoAdministracao);
		
		JMSaida.add(JMItemSaidaCliente);
		
		//inicializando cadastrador de visitantes
		cadastroDeVisitantes = new ArrayList<Visitantes>();
		
		//eventos dos menus
		
		JMItemAcessoCliente.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JMItemAcessoClienteActionPerformed(arg0);				
			}
		
		});
		
		JMItemAcessoAdministracao.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JMItemAcessoAdministracaoActionPerformed(arg0);				
			}
		
		});
		
		JMItemSaidaCliente.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JMItemSaidaClienteActionPerformed(arg0);				
			}
		});
		
		JMItemPrecos.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JMItemPrecosActionPerformed(arg0);				
			}
		
		});
		
		JMItemDadosCadastrais.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JMItemDadosCadastraisActionPerformed(arg0);				
			}
		
		});
		
		JMItemImprimirVisitantes.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JMItemImprimirVisitantesActionPerformed(arg0);				
			}
		
		});
		
		JMItemPresentes.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JMItemPresentesActionPerformed(arg0);				
			}
		
		});
		
		JMItemControleDeAmbientes.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JMItemControleDeAmbientesActionPerformed(arg0);				
			}
		
		});
		
		
	}
	
	private void JMItemControleDeAmbientesActionPerformed(ActionEvent e){
		t.start();
	}
	
	private void JMItemPresentesActionPerformed(ActionEvent e){
		TelaDeAlunosPresentes t = new TelaDeAlunosPresentes();
		JDControle.add(t);
		t.show();
	}
	
	private void JMItemAcessoAdministracaoActionPerformed(ActionEvent e){
		TelaDeAcessoVisitante telaDeAcesso = new TelaDeAcessoVisitante();
		JDControle.add(telaDeAcesso);
		telaDeAcesso.show();
	}
	
	private void JMItemPrecosActionPerformed(ActionEvent e){
		TelaDePrecos telaDePrecos = new TelaDePrecos();
		JDControle.add(telaDePrecos);
		telaDePrecos.show();
	}
	
	private void JMItemAcessoClienteActionPerformed(ActionEvent e){
		TelaDeAcessoAlunos telaDeAcesso = new TelaDeAcessoAlunos();
		JDControle.add(telaDeAcesso);
		telaDeAcesso.show();
	}
	
	private void JMItemSaidaClienteActionPerformed(ActionEvent e){
		TelaDeSaidaAlunos telaDeSaidaCliente = new TelaDeSaidaAlunos();
		JDControle.add(telaDeSaidaCliente);
		telaDeSaidaCliente.show();
	}
	
	@SuppressWarnings("deprecation")
	private void JMItemDadosCadastraisActionPerformed(ActionEvent e){
		TelaDeCadastro telaDeCadastro = new TelaDeCadastro();
		JDControle.add(telaDeCadastro);
		telaDeCadastro.show();	
	}
	
	private void JMItemImprimirVisitantesActionPerformed(ActionEvent e){
		SerializeImprimirVisitantes gravar = new SerializeImprimirVisitantes();
		gravar.start();
	}
	
}
