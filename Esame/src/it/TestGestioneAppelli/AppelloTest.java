package it.TestGestioneAppelli;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import control.GestioneAppello;
import control.GestioneCorso;
import entity.Appello;
import entity.Corso;
import entity.Data;
import entity.Docente;
import entity.Studente;

public class AppelloTest {

	

//test 1:ricerco per id,un appello e non è presente nessun appello
	@Test
	public void test1VisualizzaStudentiPrenotati() {
		GestioneAppello gestioneappello=new GestioneAppello();
		boolean lista_vuota;
		lista_vuota=false;
		int id_appello;
		id_appello=7;
		lista_vuota=gestioneappello.NessunAppello();
		assertTrue(lista_vuota);
		System.out.println("NESSUN APPELLO PRESENTE");
		
	}
	//test2:ricerco per id un appello ,ci sono appelli,appello non presente
	@Test
	public void test2VisualizzaStudentiPrenotati() {
		GestioneAppello gestioneappello=new GestioneAppello();
		int id_appello;
		id_appello=7;
		Appello appelloAppoggio=null;
		appelloAppoggio=gestioneappello.TrovaAppello(id_appello);
		assertNull(appelloAppoggio);
		System.out.println("APPELLO NON PRESENTE");
		
	}
	//test3:ricerco per id un appello,ci sono appelli,nessuno studente prenotato
	@Test
	public void test3VisualizzaStudentiPrenotati() {
		boolean nessuno;
		nessuno=false;
		int id_app;
		id_app=7;
		GestioneAppello gestioneappello=new GestioneAppello();
		GestioneCorso gestionecorso=new GestioneCorso();
		 Docente Docente1=new Docente(52,"Roberto","Natella");
		Corso corso=new Corso(140,"ingegneria del software",9);
		LocalDate  data_evento;
		data_evento = LocalDate.of(2019, Month.AUGUST, 31);
		Data data=new Data(data_evento,"scritta","sgt5");
		corso.Associa_docente(Docente1);
		Appello appellob=new Appello(7);
		appellob.associaCorso(corso);
		appellob.AssociaData(data);
		gestioneappello.Aggiungi_Appello(appellob);
		Appello appelloapp=null;
		appelloapp=gestioneappello.TrovaAppello(id_app);
		nessuno=appelloapp.NessunoStudentePrenotato();
		assertTrue(nessuno);
		System.out.println("NESSUN STUDENTE PRENOTATO");
		
		
	}
	//test4:ricerco per id un appello,ci sono appelli,visualizzo 1o+  studente/i prenotato/i
	@Test
	public void test4VisualizzaStudentiPrenotati() {
		boolean presenti;
		presenti=false;
		int id_app;
		id_app=7;
		GestioneAppello gestioneappello=new GestioneAppello();
		GestioneCorso gestionecorso=new GestioneCorso();
		 Docente Docente1=new Docente(52,"Roberto","Natella");
		Corso corso=new Corso(140,"ingegneria del software",9);
		LocalDate  data_evento;
		data_evento = LocalDate.of(2019, Month.AUGUST, 31);
		Data data=new Data(data_evento,"scritta","sgt5");
		corso.Associa_docente(Docente1);
		Appello appellob=new Appello(7);
		appellob.associaCorso(corso);
		appellob.AssociaData(data);
		gestioneappello.Aggiungi_Appello(appellob);
		Appello appelloapp=null;
		appelloapp=gestioneappello.TrovaAppello(id_app);
		Studente studente=new Studente(44,"Fabrizio","Irrissuto");
		appellob.InserisciStudentePrenotato(studente);
		presenti=appellob.NessunoStudentePrenotato();
		assertFalse(presenti);
		appellob.VisualizzaStudentiPrenotati();
		//visualizzo studenti prenotati
		
		
	}
	
	
	
	
	

}
