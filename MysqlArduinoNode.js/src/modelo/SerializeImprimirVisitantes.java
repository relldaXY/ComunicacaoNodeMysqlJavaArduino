package modelo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import visao.TelaPrincipal;

public class SerializeImprimirVisitantes extends Thread{
	
	TelaPrincipal gravadorDeVisitantes = new TelaPrincipal();
	private ObjectOutputStream escritorDeObjetos;
	private ObjectInputStream leitorDeObjetos;
	
	
	public SerializeImprimirVisitantes(){
	}
	
	public void run(){
		escreverObjeto(gravadorDeVisitantes.cadastroDeVisitantes);
	}
	
	public void escreverObjeto(Object objeto){
		
		try {
			escritorDeObjetos = new ObjectOutputStream(new FileOutputStream("VisitantesCadastrados"));
			escritorDeObjetos.writeObject(objeto);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Object lerObjeto(String nomeDoArquivo){
		
		Object retorno = null;
		
		try {
			leitorDeObjetos = new ObjectInputStream(new FileInputStream(nomeDoArquivo));
			retorno = leitorDeObjetos.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return retorno;
		
	}
	

}
