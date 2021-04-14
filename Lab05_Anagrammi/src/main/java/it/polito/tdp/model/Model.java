package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.DAO.AnagrammaDAO;

public class Model {
	
	private AnagrammaDAO anagrammaDao;
	
	public Model() {
		anagrammaDao = new AnagrammaDAO();
	}
	
	public boolean corretto (String parola) {
		return this.anagrammaDao.isCorrect(parola);
	}
	
	public List<String> risolvi (String parola) {
		
		List<String> risultato = new ArrayList<>();
		permuta ("",parola, 0,risultato);
		return risultato;
	}
	
	private void permuta (String parziale, String lettere, int livello, List<String> risultato) {
		if (lettere.length()==0) // caso terminale
			risultato.add(parziale);
		else {
			for (int pos=0; pos<lettere.length();pos++) {
				
				char tentativo = lettere.charAt(pos);
				
				String nuovaParziale = parziale + tentativo;
				String nuovaLettere = lettere.substring(0,pos)+lettere.substring(pos+1);
				
				permuta(nuovaParziale, nuovaLettere,livello+1, risultato);
			}
		}
			
	}


}
