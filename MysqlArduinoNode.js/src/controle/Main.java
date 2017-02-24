package controle;

import bancoDeDados.DataDados;
import microcontrolador.ComunicacaoSerial;
import visao.TelaDeControleDeAmbiente;
import visao.TelaPrincipal;

public class Main {

	public static void main(String[] args) {
		
		TelaPrincipal tp = new TelaPrincipal();
		tp.setVisible(true);
		
		tp.t = new Thread(){
		
			public void run(){
				TelaDeControleDeAmbiente t = new TelaDeControleDeAmbiente();
				tp.JDControle.add(t);
				t.show();
			
				ComunicacaoSerial comm = new ComunicacaoSerial();
				comm.initialize();
				DataDados atualizarBD = new DataDados();
			
				while(true){
					t.mostraTemperatura.setText(comm.getTemperaturaViaSerial()+"ºC");
					t.mostraLuminosidade.setText(comm.getLuminosidadeViaSerial()+" u.LDR");
					t.mostraUmidade.setText(comm.getUmidadeViaSerial()+"%");
					t.mostraVolume.setText(comm.getVolumeSomViaSerial()+"%");
					atualizarBD.atualizarDadosDoAmbiente(comm);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
				}
			}
		}
	};

	
}
	
}
