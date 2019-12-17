package entity;

import java.time.LocalDate;

public class Data {
	private LocalDate data;
	private String tipoprova;
	private String tipoluogo;
	
public Data(LocalDate data,String tipoprova,String tipoluogo) {
	this.data=data;
	this.tipoprova=new String(tipoprova);
	this.tipoluogo=new String(tipoluogo);
	
}
public String toString() {
	return "Data: "+data+" "+"Tipo prova: "+tipoprova+" "+"Tipo luogo: "+tipoluogo+" ";
}


	
}
