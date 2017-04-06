package it.polito.tdp.libretto.model;

import java.util.*;

public class Model {
	private List<Esame> esami;
	
	public Model(){
		this.esami= new ArrayList<Esame>(); 
	}
	/**
	 * aggiunge un nuovo esame all'elenco degli esami presenti
	 * verificando che non ci sia gia'
	 * @param e
	 * @return true se l'ha inserito, false se esisteva gia'
	 */
	public boolean addEsame(Esame e){
		if(!esami.contains(e)){//CONTAINS CHIAMA IL METODO EQUALS NON COMPARETO!!!
			esami.add(e);
		    return true;
		}
		else return false;
	}
	/**
	 * ricerca se esite un'esame con il codice indicato
	 * se esiste lo restituisce
	 * altrimenti ritorna null
	 * @param codice
	 * @return l'esame trovato o null se non trovato
	 */
	public Esame trovaEsame(String codice){
		int posizione= esami.indexOf( new Esame(codice, null, null));
		if(posizione==-1)
			return null;
		else return esami.get(posizione);
	}
	

}
