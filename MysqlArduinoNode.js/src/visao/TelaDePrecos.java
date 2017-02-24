package visao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import modelo.LogicaPrecos;

public class TelaDePrecos extends JInternalFrame{
	JLabel lblCalcMensalidade;
		
	JLabel lblFidelidade;
	JComboBox cmbFidelidade;
	private String[] fidelidade = {"12", "6", "3", "0"};
	
	JLabel lblAulasSemanais;
	JComboBox cmbAulasSemanais;
	private String[] frequencia = {"7", "3", "2"};
	
	JLabel lblPreco;
	JLabel lblResultado;
	
	JButton btnCalcular;
	
	public TelaDePrecos(){
		setTitle("Consulta de Preços");
		setSize(500, 400);
		setClosable(true);
		setIconifiable(true);
		setLayout(null);
		setVisible(true);
		
		//instanciando objetos
		lblCalcMensalidade = new JLabel("Cálculo da Mensalidade");
		
		lblFidelidade  = new JLabel("Fidelidade(meses): ");
		cmbFidelidade = new JComboBox(fidelidade);
		
		lblAulasSemanais  = new JLabel("Quantidade de aulas por semana:");
		cmbAulasSemanais = new JComboBox(frequencia);
		
		lblPreco = new JLabel("Preço");
		lblResultado = new JLabel("0,00");
		lblResultado.setForeground(Color.red);
		
		btnCalcular = new JButton("Calcular");
		//adicionando ao Frame
		
		add(lblCalcMensalidade);
		
		add(lblFidelidade);
		add(cmbFidelidade);
		
		add(lblAulasSemanais);
		add(cmbAulasSemanais);
		
		add(btnCalcular);
		
		add(lblPreco);
		add(lblResultado);
		
		//posicionando
		
		lblCalcMensalidade.setBounds(150, 20, 200, 25);
		
		lblFidelidade.setBounds(50, 100, 250, 25);
		cmbFidelidade.setBounds(300, 100, 100,25);
		
		lblAulasSemanais.setBounds(50, 150, 250, 25);
		cmbAulasSemanais.setBounds(300, 150, 100, 25);
		
		btnCalcular.setBounds(50, 250,120,25);
		lblPreco.setBounds(50, 300, 250, 25);
		lblResultado.setBounds(300, 300, 150, 25);
		
		btnCalcular.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				jbtnCalcularActionPerformed(e);
			}
		});
		
	}
	
	private void jbtnCalcularActionPerformed(ActionEvent e){
		int selecao0 = cmbAulasSemanais.getSelectedIndex();
		int selecao1 = cmbFidelidade.getSelectedIndex();
		LogicaPrecos lp = new LogicaPrecos((String)cmbAulasSemanais.getItemAt(selecao0),(String) cmbFidelidade.getItemAt(selecao1));
		int resultado = lp.calcularMensalidade(lp.getFrequencia(), lp.getFidelidade());
		String mostrarResultado = Integer.toString (resultado);
		lblResultado.setText(mostrarResultado);
	}
	
}
