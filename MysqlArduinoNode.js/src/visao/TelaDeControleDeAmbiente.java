package visao;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class TelaDeControleDeAmbiente extends JInternalFrame{
	public JLabel lblControle;
	public JLabel lblTemperatura;
	public JLabel lblLuminosidade;
	public JLabel lblUmidadeRelativa;
	public JLabel lblVolume;
	
	public JLabel mostraTemperatura;
	public JLabel mostraLuminosidade;
	public JLabel mostraUmidade;
	public JLabel mostraVolume;
	
	public TelaDeControleDeAmbiente(){
		setTitle("Cadastro de Sócios");
		setSize(600, 500);
		setClosable(false);
		setIconifiable(true);
		setLayout(null);
		setVisible(true);
		
		lblControle = new JLabel("Controle de Ambiente");
		lblTemperatura = new JLabel("Temperatura");
		lblLuminosidade = new JLabel("Luminosidade");
		lblUmidadeRelativa = new JLabel("UmidadeRelativa");
		lblVolume = new JLabel("Volume Do Som");
		
		mostraTemperatura = new JLabel("--");
		mostraLuminosidade = new JLabel("--");
		mostraUmidade = new JLabel("--");
		mostraVolume = new JLabel("--");
		
		add(lblControle);
		add(lblTemperatura);
		add(lblLuminosidade);
		add(lblUmidadeRelativa);
		add(lblVolume);
		
		add(mostraTemperatura);
		add(mostraLuminosidade);
		add(mostraUmidade);
		add(mostraVolume);
		
		lblControle.setBounds(200, 50, 200, 50);
		lblTemperatura.setBounds(150,150,200, 25);
		lblLuminosidade.setBounds(150,200,200,25);
		lblUmidadeRelativa.setBounds(150,250,200,25);
		lblVolume.setBounds(150,300,200,25);
		
		mostraVolume.setBounds(350,300,100,25);
		mostraTemperatura.setBounds(350,150, 100, 25);
		mostraLuminosidade.setBounds(350,200,100,25);
		mostraUmidade.setBounds(350,250,100,25);
		
		
	}
}
