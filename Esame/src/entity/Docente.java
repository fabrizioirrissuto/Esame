package entity;

public class Docente {
	public int id;
	private String Nome;
	private String Cognome;
	
	public Docente() {
		Nome="";
		Cognome="";
		
	}
	
	public Docente(int id,String Nome,String Cognome) {
		this.id=id;
		this.Nome=new String(Nome);
		this.Cognome=new String(Cognome);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String Nome) {
		this.Nome = Nome;
	}
	public String getCognome() {
		return Cognome;
	}
	public void setCognome(String Cognome) {
		this.Cognome = Cognome;
	}	
	
	
	
}
