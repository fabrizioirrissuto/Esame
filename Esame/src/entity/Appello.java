package entity;

import java.util.ArrayList;

public class Appello {
public int id;
private Corso corso_appello;	
private ArrayList<Data> Lista_date;
private ArrayList<Studente> ListaStudenti_prenotati;

public Appello(int id) {
	Lista_date=new ArrayList<Data>();
	ListaStudenti_prenotati=new ArrayList<Studente>();
	this.id=id;
}


public Corso associaCorso(Corso c) {
	this.corso_appello=c;
	return corso_appello;
	
}
public void AssociaData(Data d) {
	Lista_date.add(d);
	
}
public void InserisciStudentePrenotato(Studente s) {
	ListaStudenti_prenotati.add(s);
	}
public void VisualizzaStudentiPrenotati() {
	for(Studente s : ListaStudenti_prenotati) {
		System.out.println(s);
		System.out.println("\n");
	}
}
public ArrayList<Studente> get_arrayListStud() {
	return ListaStudenti_prenotati ;
}
public int getId() {
	return id;
}
public Corso getCorsoAppello() {
	return corso_appello;
}

public boolean VerificaStudente(Studente t) {
	boolean b=false;
	for(Studente s : ListaStudenti_prenotati) {
		if(s.getMatricola()==t.getMatricola()) {
			b=true;
		}
	}
	return b;
}
public boolean NessunoStudentePrenotato() {
	boolean re=false;
	if(ListaStudenti_prenotati.isEmpty()) {
		re=true;
	}
	return re;
}




public String toString() {
	StringBuffer buf=new StringBuffer();
	buf.append("ID APPELLO: "+id+"\n"+"CORSO DI RIFERIMENTO: "+"\n"+corso_appello+"\n"+"DATE: "+"\n");
	for(Data d : Lista_date) {
		buf.append(d+"\n");
		
	}
	return buf.toString();
	
}

	
}
