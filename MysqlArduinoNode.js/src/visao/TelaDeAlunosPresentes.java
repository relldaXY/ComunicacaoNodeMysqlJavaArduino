package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bancoDeDados.DataCadastro;
import bancoDeDados.DataPresentes;

public class TelaDeAlunosPresentes extends JInternalFrame{
	
	JLabel lblPresentes;
	
	private String[] Nomes = {"Nomes"};
	
	private JTable tblPresentes;
	private JScrollPane scrPresentes;
	private DefaultTableModel modeloPresentes;
	
	JButton btnAtualizar;
	
	
	public TelaDeAlunosPresentes(){
		setTitle("Controle de Acesso");
		setSize(800, 600);
		setClosable(true);
		setIconifiable(true);
		setLayout(null);
		setVisible(true);
		
		lblPresentes = new JLabel("Alunos presentes no momento: ");
		
		modeloPresentes = new DefaultTableModel(null, Nomes);
		tblPresentes = new JTable(modeloPresentes);
		scrPresentes = new JScrollPane(tblPresentes);
		
		btnAtualizar = new JButton("Atualizar");
		
		add(lblPresentes);
		add(btnAtualizar);
		
		add(scrPresentes);
		
		lblPresentes.setBounds(300, 50, 400, 50);
		btnAtualizar.setBounds(200, 100, 400, 50);
		scrPresentes.setBounds(200, 150, 400, 400);
		
		btnAtualizar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				btnAtualizarActionPerformed(e);
			}
		});
		
		mostrarAlunosPresentes();
	}
	
	private void btnAtualizarActionPerformed(ActionEvent e){
		mostrarAlunosPresentes();
	}
	
	private void mostrarAlunosPresentes(){
		DataPresentes presentes = new DataPresentes();
		modeloPresentes = presentes.mostrarPresentes();
		tblPresentes.setModel(modeloPresentes);
	}
}
