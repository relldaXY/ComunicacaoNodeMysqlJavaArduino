package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import bancoDeDados.DataCadastro;
import modelo.LogicaCadastro;

public class TelaDeCadastro extends JInternalFrame{
	private JLabel lblNumeroMatricula, lblNomeCompleto, lblValorMensalidade, lblSenha, lblPresente, lblDiaDePagamento, lblIdade, lblPagamentoRealizado;
	
	private JTextField txtNumeroMatricula, txtNomeCompleto, txtValorMensalidade, txtBuscar ,txtIdade; 
	private JPasswordField passSenha;
	
	private JComboBox cmbPresente;
	String []presente = {"Sim", "Não"};
	private JComboBox cmbDiaDePagamento;
	String []diaPagamento = {"dia 5","dia 10","dia 15","dia 20","dia 25","dia 30"};
	private JComboBox cmbPagamentoEfetuado;
	String []pagamentoEfetuado = {"Sim", "Não"};
	
	
	private JButton btnNovo, btnEditar, btnSalvar, btnBuscar, btnCancelar, btnEliminar;
	
	private String[] titulos = {"Nº Matrícula", "Nome","CPF","Idade","Telefone", "Senha", "Vencimento", "Pagou?"};
	
	private JTable tblCadastro;
	private JScrollPane scrCadastro;
	private DefaultTableModel modeloCadastro;
	
	public TelaDeCadastro(){
		setTitle("Cadastro de Sócios");
		setSize(900, 600);
		setClosable(true);
		setIconifiable(true);
		setLayout(null);
		setVisible(true);
		
		//criando componentes
		lblNumeroMatricula = new JLabel("Numero de Matrícula: ");
		lblNomeCompleto = new JLabel("Nome Completo: ");
		lblValorMensalidade = new JLabel("Valor da mensalidade: ");
		lblPresente = new JLabel("Presente no momento: ");
		lblSenha = new JLabel("Senha de acesso: ");
		lblIdade = new JLabel("Idade");
		lblDiaDePagamento = new JLabel("Dia de Vencimento: ");
		lblPagamentoRealizado = new JLabel("Pagamento efetuado: ");
		
		
		txtNumeroMatricula = new JTextField();
		txtNomeCompleto = new JTextField();
		txtValorMensalidade = new JTextField();
		cmbDiaDePagamento = new JComboBox(diaPagamento);
		cmbPresente = new JComboBox(presente);
		cmbPagamentoEfetuado = new JComboBox(pagamentoEfetuado);
		txtIdade = new JTextField();
		txtBuscar = new JTextField();
		passSenha = new JPasswordField();
		
		btnSalvar = new JButton("Salvar");
		btnNovo = new JButton("Novo");
		btnEditar = new JButton("Editar");
		btnBuscar = new JButton("Buscar");
		btnCancelar = new JButton("Cancelar");
		btnEliminar = new JButton("Eliminar");
		
		modeloCadastro = new DefaultTableModel(null, titulos);
		tblCadastro = new JTable(modeloCadastro);
		scrCadastro = new JScrollPane(tblCadastro);
		
		//adicionando os componentes
		add(lblNumeroMatricula);
		add(lblValorMensalidade);
		add(lblIdade);
		add(lblDiaDePagamento);
		add(lblSenha);
		add(lblNomeCompleto);
		add(lblPresente);
		add(lblPagamentoRealizado);
				
		add(txtValorMensalidade);
		add(txtIdade);
		add(cmbDiaDePagamento);
		add(txtNomeCompleto);
		add(txtNumeroMatricula);
		add(cmbPresente);
		add(passSenha);
		add(cmbPagamentoEfetuado);
		add(txtBuscar);
				
		add(btnEditar);
		add(btnSalvar);
		add(btnBuscar);
		add(btnCancelar);
		add(btnEliminar);
		add(btnNovo);
				
		add(scrCadastro);
				
		//posicionamento
				
		lblNumeroMatricula.setBounds(30,40, 200, 25);
		lblNomeCompleto.setBounds(440,40, 150, 25);
		lblValorMensalidade.setBounds(30,70, 200, 25);
		lblIdade.setBounds(440,70, 150, 25);
		lblPresente.setBounds(30,100, 200, 25);
		lblSenha.setBounds(440,100, 200, 25);
		lblDiaDePagamento.setBounds(30,130, 200, 25);
		lblPagamentoRealizado.setBounds(440,130, 200, 25);
				
		txtNumeroMatricula.setBounds(230,40, 150, 25);
		txtNomeCompleto.setBounds(610,40, 250, 25);
		txtValorMensalidade.setBounds(230,70, 150, 25);
		txtIdade.setBounds(610,70, 250, 25);
		cmbPresente.setBounds(230,100, 150, 25);
		cmbDiaDePagamento.setBounds(230,130, 150, 25);
		cmbPagamentoEfetuado.setBounds(610, 130, 250, 25);
		passSenha.setBounds(610, 100, 150, 25);
		
		txtBuscar.setBounds(30, 220, 170, 25);
		btnBuscar.setBounds(210,220,100,25);
		btnNovo.setBounds(320,220,100,25); 
		btnSalvar.setBounds(430,220,100, 25); 
		btnEditar.setBounds(540,220,100,25); 
		btnCancelar.setBounds(650,220,100,25); 
		btnEliminar.setBounds(760,220,100,25); 		
		
		scrCadastro.setBounds(30, 260, 830,250);
		
		desabilitar();
		
		btnNovo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnNovoActionPerformed(evt);
			}
		});
		
		btnEditar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnEditarActionPerformed(evt);
			}
		});
		
		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnCancelarActionPerformed(evt);
			}
		});
		
		btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnSalvarActionPerformed(evt);
			}
		});
		
		btnEliminar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnEliminarActionPerformed(evt);
			}
		});
		
		tblCadastro.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent evt){
				tblCadastroMouseClicked(evt);
			}
		});
		
		btnBuscar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnBuscarActionPerformed(evt);
			}
		});
		
		mostrarCadastros();
	}
	
	
	private void btnBuscarActionPerformed(ActionEvent evt){
		buscarCadastro(txtBuscar.getText());
	}
	
	
	public void mostrarCadastros(){
		DataCadastro cadastrados = new DataCadastro();
		modeloCadastro = cadastrados.mostrarOsCadastrados();
		tblCadastro.setModel(modeloCadastro);
	}
	
	public void desabilitar(){
		txtNumeroMatricula.setEnabled(false);
		txtNomeCompleto.setEnabled(false);
		txtValorMensalidade.setEnabled(false);
		cmbPresente.setEnabled(false);
		passSenha.setEnabled(false);
		txtIdade.setEnabled(false);
		cmbDiaDePagamento.setEnabled(false);
		cmbPagamentoEfetuado.setEnabled(false);
		
		btnSalvar.setEnabled(false); 
		btnNovo.setEnabled(true); 
		btnEditar.setEnabled(true); 
		btnBuscar.setEnabled(true); 
		btnCancelar.setEnabled(false); 
		btnEliminar.setEnabled(true);
		
	}
	
	private void btnNovoActionPerformed(ActionEvent evt){
		txtNumeroMatricula.setEnabled(false);
		txtNomeCompleto.setEnabled(true);
		txtValorMensalidade.setEnabled(true);
		cmbPresente.setEnabled(true);
		passSenha.setEnabled(true);
		txtIdade.setEnabled(true);
		cmbDiaDePagamento.setEnabled(true);
		cmbPagamentoEfetuado.setEnabled(true);
		
		btnSalvar.setEnabled(true); 
		btnNovo.setEnabled(false); 
		btnEditar.setEnabled(false); 
		btnBuscar.setEnabled(false); 
		btnCancelar.setEnabled(true); 
		btnEliminar.setEnabled(false);
		
		txtNumeroMatricula.setText("");
		txtNomeCompleto.setText("");
		txtValorMensalidade.setText("");
		passSenha.setText("");
		txtIdade.setText("");
	}
	
	private void btnEditarActionPerformed(ActionEvent evt){
		txtNumeroMatricula.setEnabled(false);
		txtNomeCompleto.setEnabled(true);
		txtValorMensalidade.setEnabled(true);
		cmbPresente.setEnabled(true);
		passSenha.setEnabled(true);
		cmbDiaDePagamento.setEnabled(true);
		cmbPagamentoEfetuado.setEnabled(true);
		txtIdade.setEnabled(true);
		
		btnSalvar.setEnabled(true); 
		btnNovo.setEnabled(false); 
		btnEditar.setEnabled(false); 
		btnBuscar.setEnabled(false); 
		btnCancelar.setEnabled(true); 
		btnEliminar.setEnabled(false);
	}
	
	private void btnCancelarActionPerformed(ActionEvent evt){
		txtNumeroMatricula.setEnabled(false);
		txtNomeCompleto.setEnabled(false);
		txtValorMensalidade.setEnabled(false);
		cmbPresente.setEnabled(false);
		passSenha.setEnabled(false);
		cmbDiaDePagamento.setEnabled(false);
		cmbPagamentoEfetuado.setEnabled(false);
		txtIdade.setEnabled(false);
		
		btnSalvar.setEnabled(false); 
		btnNovo.setEnabled(true); 
		btnEditar.setEnabled(true); 
		btnBuscar.setEnabled(true); 
		btnCancelar.setEnabled(false); 
		btnEliminar.setEnabled(true);
	}
	
	private void btnEliminarActionPerformed(ActionEvent evt){
		if(!txtNumeroMatricula.getText().equals("")){
			int confirmar = JOptionPane.showConfirmDialog(this, "Deseja eliminar o registro?","Confirmar",2);
			if(confirmar == 0){
				LogicaCadastro dados = new LogicaCadastro();
				DataCadastro funcao = new DataCadastro();
				dados.setNumeroMatricula(Integer.parseInt(txtNumeroMatricula.getText()));
				String mensagem = funcao.eliminarCadastro(dados);
				JOptionPane.showMessageDialog(this, mensagem);
				mostrarCadastros();
			}
		}
	}
	
	private void btnSalvarActionPerformed(ActionEvent evt){
		if(txtNumeroMatricula.getText().equals("")){
			DataCadastro cad = new DataCadastro();
			LogicaCadastro lcad = new LogicaCadastro();
			
			lcad.setIdade(txtIdade.getText());
			
			lcad.setSenha(passSenha.getText());
			
			lcad.setValorMensalidade(txtValorMensalidade.getText());
			
			lcad.setNome(txtNomeCompleto.getText());
			
			int selecao0 = cmbPresente.getSelectedIndex();
			lcad.setPresente((String) cmbPresente.getItemAt(selecao0));
			
			int selecao1 = cmbDiaDePagamento.getSelectedIndex();
			lcad.setVencimento((String) cmbDiaDePagamento.getItemAt(selecao1));
			
			int selecao2 = cmbPagamentoEfetuado.getSelectedIndex();
			lcad.setPagou((String) cmbPagamentoEfetuado.getItemAt(selecao2));
			
			
			String msg = cad.inserirCadastro(lcad);
			JOptionPane.showMessageDialog(rootPane, msg);
			
		}else{
			DataCadastro cad = new DataCadastro();
			LogicaCadastro lcad = new LogicaCadastro();
			
			lcad.setIdade(txtIdade.getText());
			
			lcad.setSenha(passSenha.getText());
			
			lcad.setValorMensalidade(txtValorMensalidade.getText());
			
			lcad.setNome(txtNomeCompleto.getText());
			
			int selecao0 = cmbPresente.getSelectedIndex();
			lcad.setPresente((String) cmbPresente.getItemAt(selecao0));
			
			int selecao1 = cmbDiaDePagamento.getSelectedIndex();
			lcad.setVencimento((String) cmbDiaDePagamento.getItemAt(selecao1));
			
			int selecao2 = cmbPagamentoEfetuado.getSelectedIndex();
			lcad.setPagou((String) cmbPagamentoEfetuado.getItemAt(selecao2));
			lcad.setNumeroMatricula(Integer.parseInt(txtNumeroMatricula.getText()));
			
			String msg = cad.editarCadastro(lcad);
			JOptionPane.showMessageDialog(rootPane, msg);
		}
		mostrarCadastros();
		
		txtNumeroMatricula.setEnabled(false);
		txtNomeCompleto.setEnabled(false);
		txtValorMensalidade.setEnabled(false);
		cmbPresente.setEnabled(false);
		passSenha.setEnabled(false);
		cmbDiaDePagamento.setEnabled(false);
		cmbPagamentoEfetuado.setEnabled(false);
		txtIdade.setEnabled(false);
		
		btnSalvar.setEnabled(false); 
		btnNovo.setEnabled(true); 
		btnEditar.setEnabled(true); 
		btnBuscar.setEnabled(true); 
		btnCancelar.setEnabled(false); 
		btnEliminar.setEnabled(true);
	}
	
	private void tblCadastroMouseClicked(MouseEvent evt){
		int fila = tblCadastro.rowAtPoint(evt.getPoint());
		txtNumeroMatricula.setText(tblCadastro.getValueAt(fila, 0).toString());
		txtNomeCompleto.setText(tblCadastro.getValueAt(fila, 1).toString());
		txtValorMensalidade.setText(tblCadastro.getValueAt(fila, 2).toString());
		txtIdade.setText(tblCadastro.getValueAt(fila, 3).toString());
		passSenha.setText(tblCadastro.getValueAt(fila, 4).toString());
		cmbPresente.setSelectedItem(tblCadastro.getValueAt(fila, 5).toString());
		cmbDiaDePagamento.setSelectedItem(tblCadastro.getValueAt(fila, 6).toString());
		cmbPagamentoEfetuado.setSelectedItem(tblCadastro.getValueAt(fila, 7).toString());
	}
	
	private void buscarCadastro(String dado){
		DefaultTableModel meuModelo;
		DataCadastro minhaFuncao = new DataCadastro();
		meuModelo = minhaFuncao.buscarCadastro(dado);
		tblCadastro.setModel(meuModelo);
	}
	
	
	
	
}
