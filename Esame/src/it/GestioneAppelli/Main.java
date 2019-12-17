package it.GestioneAppelli;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.time.LocalDate;


import control.GestioneAppello;
import control.GestioneCorso;
import entity.Appello;
import entity.Corso;
import entity.Data;
import entity.Docente;
import entity.Studente;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		GestioneCorso gestionecorso=new GestioneCorso();
		GestioneAppello gestioneappello=new GestioneAppello();
		Docente Docente1=new Docente(52,"Roberto","Natella");
		Docente Docente2=new Docente(87,"Roberto","Pietrantuono");
		Docente Docente3=new Docente(38,"Giorgio","Ventre");
		gestionecorso.AggiungiDocente(Docente1);
		gestionecorso.AggiungiDocente(Docente2);
		gestionecorso.AggiungiDocente(Docente3);
		boolean uscita=true;
		int scelta;
		
		
		salta:
		while(uscita==true) {	
		
			
		System.out.println("BENVETUTO UTENTE");
		System.out.println("CHI SEI?");
		System.out.println("DIGITA 1 PER STUDENTE");
		System.out.println("DIGITA 2 PER DOCENTE");
		System.out.println("DIGITA 3 PER RESPONSABILE SEGRETERIA");
		System.out.println("DIGITA 4 PER USCIRE");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		scelta =Integer.parseInt(bufferedReader.readLine());
			
		
	
	switch(scelta) {
	case 1:
		System.out.println("BENVENUTO NELL'AREA STUDENTI");
		System.out.println("DIGITA 1 PER PRENOTARE UN APPELLO  \nDIGITA 2 PER TORNARE AL MENU PRINCIPALE ");
		BufferedReader bufferedReader100 = new BufferedReader(new InputStreamReader(System.in));
		int scelt_stud =Integer.parseInt(bufferedReader100.readLine());
		switch(scelt_stud) {
		case 1:
			Appello appello2=null;
			boolean presente=false;
			System.out.println("AREA PRENOTAZIONI");
			System.out.println("INSERISCI LA TUA MATRICOLA: ");
			BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(System.in));
			int matr =Integer.parseInt(bufferedReader1.readLine());
			System.out.println("INSERISCI IL TUO NOME: ");
			BufferedReader bufferedReader77 = new BufferedReader(new InputStreamReader(System.in));
			String Nome = bufferedReader77.readLine();
			System.out.println("INSERISCI IL TUO COGNOME: ");
			BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(System.in));
			String Cognome = bufferedReader2.readLine();
			Studente st=new Studente(matr,Nome,Cognome);
			System.out.println("-------------------------------------- \n");
			System.out.println("-------------------------------------- \n");
			System.out.println("-------------------------------------- \n");
			System.out.println("BENVENUTO: "+Nome+" "+Cognome);
			System.out.println("APPELLI PRENOTABILI: ");
			System.out.println("-------------------------------------- \n");
			presente=gestioneappello.NessunAppello();
			if(presente) {
				System.out.println("NON ESISTONO APPELLI NEL SISTEMA");
			}
			else {
				gestioneappello.VisualizzaAppelli();
				System.out.println("INSERISCI ID DELL'APPELLO DA PRENOTARE: ");
				BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(System.in));
				int scelta_appello =Integer.parseInt(bufferedReader3.readLine());
				appello2=gestioneappello.TrovaAppello(scelta_appello);
				if(appello2==null) {
					System.out.println("ERRORE APPELLO NON TROVATO");
				}
				else {
					boolean v=false;
					v=appello2.VerificaStudente(st);
					if(v==true) {
						System.out.println("SEI GIA' PRENOTATO PER QUESTO APPELLO");
					}
					else {
						gestioneappello.PrenotaStudente(appello2, st);
					}
					
				}
			}
		
			
			
			
			System.out.println("PREMI 1 PER TORNARE AL MENU PRINCIPALE \nPREMI 2 PER USCIRE DAL PROGRAMMA");
			BufferedReader bufferedReader78 = new BufferedReader(new InputStreamReader(System.in));
				int scelta_utente =Integer.parseInt(bufferedReader78.readLine()); 
				if(scelta_utente==1) {
					break;
				
				}
				else {
					break salta  ;
				}
		case 2:
			break;
		}
		
			

	break;
	
	
		
	case 2:
		System.out.println("BENVENUTO NELL'AREA DOCENTI");
		System.out.println("DIGITA 1 PER CREARE UN APPELLO \nDIGITA 2 PER CONSULTARE GLI STUDENTI PRENOTATI AD UN APPELLO \nDIGITA 3 PER TORNARE AL MENU PRINCIPALE ");
		BufferedReader bufferedReader10 = new BufferedReader(new InputStreamReader(System.in));
		int scelt_doc =Integer.parseInt(bufferedReader10.readLine());
		switch(scelt_doc) {
		case 1:
			
			
			
			System.out.println("CREA APPELLO");
			Appello appelloCreato=null;
			Corso corsotrovato=null;
			System.out.println("-------------------------------------- \n");
			System.out.println("INSERISCI ID DOCENTE ");
			BufferedReader bufferedReader111 = new BufferedReader(new InputStreamReader(System.in));
			int scelta_id =Integer.parseInt(bufferedReader111.readLine());
			System.out.println("INSERISCI IL CODICE CORSO DA ASSOCIARE: ");
			BufferedReader bufferedReader11 = new BufferedReader(new InputStreamReader(System.in));
			int scelta_cor =Integer.parseInt(bufferedReader11.readLine());
			
			corsotrovato=gestionecorso.TrovaCorso(scelta_cor,scelta_id);
			if(corsotrovato==null) {
				System.out.println("CORSO NON TROVATO O CORSO NON DEL DOCENTE ");
			}
			else {
				
				System.out.println("DA QUANTE DATE E' COMPOSTO L'APPELLO?  ");
				BufferedReader bufferedReader12 = new BufferedReader(new InputStreamReader(System.in));
				int num_date =Integer.parseInt(bufferedReader12.readLine());
				appelloCreato=gestioneappello.Crea_Appello();
				for(int i=0;i<num_date;i++) {
					int z=i+1;
					System.out.println("AGGIUNGI DATA ESAME "+z+" di "+num_date);
					System.out.println("-------------------------------------- \n");
					System.out.println("INSERISCI IL GIORNO(gg) ");
					BufferedReader bufferedReader15 = new BufferedReader(new InputStreamReader(System.in));
					int giorno =Integer.parseInt(bufferedReader15.readLine());
					System.out.println("INSERISCI IL MESE(mm) ");
					BufferedReader bufferedReader16 = new BufferedReader(new InputStreamReader(System.in));
					int mese =Integer.parseInt(bufferedReader16.readLine());
					System.out.println("INSERISCI IL L'ANNO(aaaa) ");
					BufferedReader bufferedReader14 = new BufferedReader(new InputStreamReader(System.in));
					int anno =Integer.parseInt(bufferedReader14.readLine());
					LocalDate data_i = LocalDate.of(anno,mese,giorno);
					System.out.println("INSERISCI TIPO PROVA");
					BufferedReader bufferedReader17 = new BufferedReader(new InputStreamReader(System.in));
					String TipoProva = bufferedReader17.readLine();
					System.out.println("INSERISCI LUOGO");
					BufferedReader bufferedReader18 = new BufferedReader(new InputStreamReader(System.in));
					String TipoLuogo = bufferedReader18.readLine();
					
					
					Data dataCreata=new Data(data_i,TipoProva,TipoLuogo);
					appelloCreato.AssociaData(dataCreata);
					
					
					
				}
				
				appelloCreato.associaCorso(corsotrovato);
				gestioneappello.Aggiungi_Appello(appelloCreato);
				System.out.println("APPELLO CREATO ID: "+appelloCreato.getId());
			}
			
			System.out.println("PREMI 1 PER TORNARE AL MENU PRINCIPALE \nPREMI 2 PER USCIRE DAL PROGRAMMA");
			BufferedReader bufferedReader87 = new BufferedReader(new InputStreamReader(System.in));
				int scelta_utente2 =Integer.parseInt(bufferedReader87.readLine()); 
				if(scelta_utente2==1) {
					break;
				
				}
				else {
					break salta  ;
				}
			
			
			case 2:
			Appello appelloAppoggio;
			boolean vedi=false;
			System.out.println("SCEGLI ID APPELLO:");
			BufferedReader bufferedReader9 = new BufferedReader(new InputStreamReader(System.in));
			int id_a =Integer.parseInt(bufferedReader9.readLine());
			System.out.println("INSERISCI IL TUO ID DOCENTE:");
			BufferedReader bufferedReader20 = new BufferedReader(new InputStreamReader(System.in));
			int id_p =Integer.parseInt(bufferedReader20.readLine());
			appelloAppoggio=gestioneappello.TrovaAppelloDocente(id_a, id_p);
			if(appelloAppoggio==null) {
				System.out.println("IMPOSSIBILE TROVARE APPELLO O APPELLO NON ACCESSIBILE");
			}
			else {
				if(vedi=appelloAppoggio.NessunoStudentePrenotato()) {
					System.out.println("NESSUNO STUDENTE PRENOTATO ALL'APPELLO");
				}
				else {
					appelloAppoggio.VisualizzaStudentiPrenotati();
				}
				
			}
			
			System.out.println("PREMI 1 PER TORNARE AL MENU PRINCIPALE \nPREMI 2 PER USCIRE DAL PROGRAMMA");
			BufferedReader bufferedReader787 = new BufferedReader(new InputStreamReader(System.in));
				int scelta_utente3 =Integer.parseInt(bufferedReader787.readLine()); 
				if(scelta_utente3==1) {
					break;
				
				}
				else {
					break salta  ;
				}
			
			
			case 3:
				break;
			
			

			
			
		}
		
		
		
		break;
		
		
		
		
		
		
		
		
		
		
		
		
	
	case 3:
		
		System.out.println("BENVENUTO NELL'AREA DELLA SEGRETERIA DIDATTICA");
		System.out.println("DIGITA 1 PER CREARE UN CORSO \nDIGITA 2 PER CONSULTARE GLI STUDENTI PRENOTATI AD UN APPELLO \nDIGITA 3 PER TORNARE AL MENU PRINCIPALE ");
		BufferedReader bufferedReader4 = new BufferedReader(new InputStreamReader(System.in));
		int scelt_segr =Integer.parseInt(bufferedReader4.readLine());
		
		switch(scelt_segr) {
		case 1:
			Docente docenteAppoggio=null;
			int y=0;
			System.out.println("INSERISCI CODICE CORSO: ");
			BufferedReader bufferedReader5 = new BufferedReader(new InputStreamReader(System.in));
			int cod =Integer.parseInt(bufferedReader5.readLine());
			System.out.println("INSERISCI NOME CORSO ");
			BufferedReader bufferedReader6 = new BufferedReader(new InputStreamReader(System.in));
			String Nom = bufferedReader6.readLine();
			System.out.println("INSERISCI CFU: ");
			BufferedReader bufferedReader7 = new BufferedReader(new InputStreamReader(System.in));
			int cfu =Integer.parseInt(bufferedReader7.readLine());
			System.out.println("INSERISCI l'ID DEL DOCENTE DEL CORSO ");
			BufferedReader bufferedReader8 = new BufferedReader(new InputStreamReader(System.in));
			int id_d =Integer.parseInt(bufferedReader8.readLine());
			
			docenteAppoggio=gestionecorso.TrovaDocente(id_d);
			y=gestionecorso.CorsoEsistente(cod);
			if((docenteAppoggio==null)||(y==1) ) {
				
				System.out.println("DOCENTE NON TROVATO O CORSO GIA' ESISTENTE");
			}
			else {
				
				Corso corso=new Corso(cod,Nom,cfu);
				corso.Associa_docente(docenteAppoggio);
				gestionecorso.AggiungiCorso(corso);
				
				System.out.println("CORSO CREATO CON SUCCESSO!");
				
			}
			
			System.out.println("PREMI 1 PER TORNARE AL MENU PRINCIPALE \nPREMI 2 PER USCIRE DAL PROGRAMMA");
			BufferedReader bufferedReader87 = new BufferedReader(new InputStreamReader(System.in));
				int scelta_utente2 =Integer.parseInt(bufferedReader87.readLine()); 
				if(scelta_utente2==1) {
					break;
				
				}
				else {
					break salta  ;
				}
			
		case 2:
			Appello appelloAppoggio=null;
			int id_a=0;
			boolean vuoto=false;
			boolean nessuno=false;
			System.out.println("SCEGLI ID APPELLO:");
			BufferedReader bufferedReader9 = new BufferedReader(new InputStreamReader(System.in));
			id_a =Integer.parseInt(bufferedReader9.readLine());
			vuoto=gestioneappello.NessunAppello();
			if(vuoto) {
				System.out.println("NESSUN APPELLO PRESENTE");
			}
			else  {
				appelloAppoggio=gestioneappello.TrovaAppello(id_a);
				if(appelloAppoggio==null) {
					System.out.println("APPELLO NON PRESENTE");
			}
				else {
					nessuno=appelloAppoggio.NessunoStudentePrenotato();
					if(nessuno) {
						System.out.println("NESSUN STUDENTE PRENOTATO");
					}
					else {
						appelloAppoggio.VisualizzaStudentiPrenotati();
					}
				}
				
				
				
			}
			
			
			
			System.out.println("PREMI 1 PER TORNARE AL MENU PRINCIPALE \nPREMI 2 PER USCIRE DAL PROGRAMMA");
			BufferedReader bufferedReader85 = new BufferedReader(new InputStreamReader(System.in));
				int scelta_utente4 =Integer.parseInt(bufferedReader85.readLine()); 
				if(scelta_utente4==1) {
					break;
				
				}
				else {
					break salta  ;
				}
		case 3:
			break;
		
		}
		
		
		
		break;
		
		
		case 4:
			break salta;
		
		default:
			break;
		
		
		
		
		
		
	
	
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		}
		System.out.println("GRAZIE E ARRIVEDERCI");
	}
}
