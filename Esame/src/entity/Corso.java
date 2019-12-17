package entity;

public class Corso {
public int CodiceCorso;	
private String NomeCorso;
private int CFU;
private Docente DocenteCorso;

public Corso(int CodiceCorso,String NomeCorso,int CFU) {
	this.CodiceCorso=CodiceCorso;
	this.NomeCorso= new String(NomeCorso);
	this.CFU=CFU;
}

public Docente Associa_docente(Docente d) {
	this.DocenteCorso=d;
	return DocenteCorso;
	
}

public int TrovaIdDocente(Corso c) {
	int app;
	app=c.DocenteCorso.getId();
	return app;
	
}
public int getCodiceCorso() {
	return CodiceCorso;
}

public int getDocente() {
	int app;
	app=DocenteCorso.getId();
	return app;
}



public String toString() {
	return "Codice Corso: "+CodiceCorso+"\n"+"Nome Corso: "+NomeCorso+"\n"+"Numero CFU: "+CFU+"\n"+"Nome Docente:"+DocenteCorso.getNome()+"\n"+"Cognome Docente:"+DocenteCorso.getCognome();
}

}
