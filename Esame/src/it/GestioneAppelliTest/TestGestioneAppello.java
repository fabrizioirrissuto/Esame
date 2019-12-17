package it.GestioneAppelliTest;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;


import org.junit.After;

import org.junit.Before;

import org.junit.Test;

import control.GestioneAppello;
import entity.Appello;
import entity.Corso;
import entity.Data;
import entity.Docente;
import entity.Studente;

public class TestGestioneAppello {
 GestioneAppello gestioneappello ;
 Corso corso;
 Corso corso1;
 Appello appello;
 Appello appello1;
 Studente studente;
 Data data;
 Data data1;
 int id1=1;
 int id2=2;
 LocalDate data_evento;
 LocalDate data_evento1;
	@Before
	public void setUp() throws Exception {
		gestioneappello=new GestioneAppello();
		 appello=new Appello(id1);
		 data_evento = LocalDate.of(2019, Month.AUGUST, 31);
		 data=new Data( data_evento,"scritta","da definire");
		 corso=new Corso(140,"ingegneria del software",9);
		 Docente Docente1=new Docente(52,"Roberto","Natella");
		 corso.Associa_docente(Docente1);
		 appello.AssociaData(data);
		 appello.associaCorso(corso);
		 studente=new Studente(21,"fabrizio","irrissuto");
		 
		 gestioneappello.Aggiungi_Appello(appello);
		 gestioneappello.PrenotaStudente(appello, studente);
		 appello1=new Appello(id2);
		 data_evento1 = LocalDate.of(2023, Month.AUGUST, 31);
		 data1=new Data( data_evento1,"orale","sgt4");
		 corso1=new Corso(135,"sistemi operativi",9);
		 Docente Docente2=new Docente(87,"Roberto","Pietrantuono");
		 corso1.Associa_docente(Docente2);
		 appello1.AssociaData(data1);
		 appello1.associaCorso(corso1);
		 appello.InserisciStudentePrenotato(studente);
	}
	
	@After
	public void tearDown() throws Exception {
		gestioneappello=null;
		
		
		}

	@Test
	public void test01VisualizzaStudentiAppelloNonPresente() {
		
		int id_inserito=7;
		Appello appelloappoggio=null;
		appelloappoggio=gestioneappello.TrovaAppello(id_inserito);
		assertNull(appelloappoggio);
		
		
		
	}
	@Test
	public void test02VisualizzaStudentiAppelloPresenteNessunPrenotato() {
		
		
		
	}

}
