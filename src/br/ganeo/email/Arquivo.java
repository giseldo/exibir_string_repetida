package br.ganeo.email;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Arquivo {

	private File file;
	
	public Arquivo(String fileName) {
		file = new File(fileName);
	}
	
	public List<String> getLines() {
		List<String> lista = new ArrayList<String>();
		try {
			FileInputStream fstream = new FileInputStream(file);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;

			while ((strLine = br.readLine()) != null) {
				if (!strLine.trim().equals("")) // Removendo linha em branco
					lista.add(strLine);
			}

			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			new Exception("erro ao ler arquivo", e);
		}

		return lista;
	}
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

}
