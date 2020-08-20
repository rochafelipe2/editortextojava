package Controller;

import java.io.File;

import javax.swing.JFileChooser;

public abstract class ControllerArquivo {

	protected File arquivo = null;
	public abstract String ler();
	public abstract boolean escrever(boolean append);
	
	
	public File getArquivo() {
		return arquivo;
	}
	public void setArquivo(String textoBotao) {
		String pastaHome = System.getProperty("user.home");
		JFileChooser escolher = new JFileChooser(pastaHome);
		
		if(escolher.showDialog(null, textoBotao) == JFileChooser.APPROVE_OPTION){
			arquivo = escolher.getSelectedFile();
		}
	}
	
}
