package control;

import java.util.ArrayList;

import entity.Appello;
import entity.Corso;
import entity.Studente;

public class GestioneAppello {
private int identificativo=1;	
private Appello appelloAppoggio;
ArrayList<Appello> Lista_appelli;

public GestioneAppello() {
	Lista_appelli=new ArrayList<Appello>();
	
}

public Appello Crea_Appello() {
	
	Appello appelloNuovo=new Appello(identificativo);
	identificativo++;
	return appelloNuovo;
}


public void Aggiungi_Appello(Appello p) {
	Lista_appelli.add(p);
}
public void VisualizzaAppelli() {
	 for(Appello q: Lista_appelli) {
		 System.out.println(q);
		 System.out.println("-----------------------------");
		 System.out.println("\n");
		
	 }

}


public boolean NessunAppello() {
	boolean w=false;
	if(Lista_appelli.isEmpty()) {
		w=true;
	}
	
	return w;
}


	
	
	
	

public void PrenotaStudente(Appello p,Studente w) {
	p.InserisciStudentePrenotato(w);
	System.out.println("PRENOTAZIONE EFFETTUATA CON SUCCESSO!");
	}

public Appello TrovaAppello(int id){
	Appello appelloTrov=null;
	for(Appello q: Lista_appelli) {
		 	if(q.getId()==id) {
		 		appelloTrov=q;
		 	}
		 	
}
	return appelloTrov;
}
public Appello TrovaAppelloDocente(int id,int id_docente){
	Appello appelloBuono=null;
	Corso corso_app;
	int appoggio;
	for(Appello q: Lista_appelli) {
		 	if(q.getId()==id) {
		 		appelloAppoggio=q;
		 		corso_app=appelloAppoggio.getCorsoAppello();
		 		appoggio=corso_app.TrovaIdDocente(corso_app);
		 			if(appoggio==id_docente) {
		 				appelloBuono=appelloAppoggio;
		 			}
		 	}
		 	
}
	return appelloBuono;
}



}
