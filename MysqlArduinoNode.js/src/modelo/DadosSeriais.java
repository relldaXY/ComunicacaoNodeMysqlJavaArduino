package modelo;

public class DadosSeriais {
	public String luminosidade;
	public String umidadeRelativa;
	public String temperatura;
	public String volumeDoSom;
	
	public DadosSeriais(String luminosidade, String umidadeRelativa, String temperatura, String volumeDoSom){
		this.luminosidade = luminosidade;
		this.umidadeRelativa = umidadeRelativa;
		this.temperatura = temperatura;
		this.volumeDoSom = volumeDoSom;
	}
	
	public void recebendoDadosViaComunicacaoSerial(String l){
		String dados[] = new String[8];
		
		dados = l.split(";");
		
		
		temperatura = dados[0];
		umidadeRelativa = dados[1];
		luminosidade = dados[2];
		volumeDoSom = dados[3];
		
			
	}

	public String getLuminosidade() {
		return luminosidade;
	}

	public String getUmidadeRelativa() {
		return umidadeRelativa;
	}

	public String getTemperatura() {
		return temperatura;
	}

	public String getVolume() {
		return volumeDoSom;
	}

	
	
	
}
