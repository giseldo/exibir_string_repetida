package br.ganeo.email;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import static junit.framework.Assert.*;

import org.junit.Test;

public class TestArquivo {

	@Test
	public void testExecutar() {

		List<String> linhasTotais = new Arquivo("c:\\email.txt").getLines();
		List<String> linhasTotaisMenosUm = new Arquivo("c:\\email.txt").getLines();
		
		Assert.assertNotNull(linhasTotais);
		Assert.assertNotNull(linhasTotaisMenosUm);

		for (String linha : linhasTotais) {
			int index = 0;
			// remove o proprio registro antes de interar			
			for (String linhaAserRemovida : linhasTotaisMenosUm) {
				if (linhaAserRemovida.equals(linha)) {
					index  = linhasTotaisMenosUm.indexOf(linhaAserRemovida);
				}
			}
			
			linhasTotaisMenosUm.remove(index);
			assertTrue(linhasTotaisMenosUm.size()<linhasTotais.size());
	
			for (String linhaArquivoOriginal : linhasTotaisMenosUm) {
				if (linha.equals(linhaArquivoOriginal)) {
					System.out.println(linhaArquivoOriginal);
					fail("não devem existir arquivos repetidos");
				}
			}
			
		}
		
	}

}

