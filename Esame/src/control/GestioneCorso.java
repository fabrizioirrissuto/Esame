package control;

import java.util.ArrayList;

import entity.Appello;
import entity.Corso;
import entity.Docente;

public class GestioneCorso {
	private Docente docenteTrovato;
	
	
	
	private Corso corsoTrovato;
	ArrayList<Corso> Lista_corsi;
	ArrayList<Docente> Lista_docenti;
	public GestioneCorso() {
		Lista_corsi=new ArrayList<Corso>();
		Lista_docenti=new ArrayList<Docente>();
	}
	public void AggiungiCorso(Corso c) {
		Lista_corsi.add(c);
	}

 public void visualizza_corsi() {
	 for(Corso c: Lista_corsi) {
		 System.out.println(c);
		 System.out.println("\n");
	 }
 }

 public void AggiungiDocente(Docente d) {
		Lista_docenti.add(d);
	}
 
 public int CorsoEsistente(int codiceCorso) {
	 int r=0;
	 esci:
	 for(Corso c: Lista_corsi) {
		if(c.getCodiceCorso()==codiceCorso) {
			r=1;
			break esci;
		}
	 
 }
	 return r;
 }
 
 public Docente TrovaDocente(int id){
	 		docenteTrovato=null;
	 		for(Docente d: Lista_docenti) {
			 	if(d.getId()==id) {
			 		docenteTrovato=d;
			 		
			 		
			 		
			 	}
			 
	}
		return docenteTrovato;
		
	}
 public Corso TrovaCorso(int id,int id_doc){
	 corsoTrovato=null;
	 
		for(Corso c: Lista_corsi) {
			 	if((c.getCodiceCorso()==id) && (c.getDocente()==id_doc)) {
			 		corsoTrovato=c;
			 	}
			 	
	}
		return corsoTrovato;
	}
 
	
}


