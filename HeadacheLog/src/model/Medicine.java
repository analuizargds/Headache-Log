package model;

/**
 * Classe utilizada no ControlerMedicine
 * Serve para modelar um remédio
 * @author Ana Luiza Rodrigues da Silva
 */

import java.util.Date;

public class Medicine {
	private String name;
    private int dosage;
    private String unit ;
    private Date date;
    
    
    public Medicine(String name, int dosage, String unit, Date date){
        this.name = name;
        this.dosage = dosage;
        this.unit = unit;
        this.date = date;
    }
    

    public Medicine() {
    	
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public int getDosage(){
        return dosage;
    }
    
    public void setDosage(int dosage){
        this.dosage = dosage;
    }
    
    public String getUnit(){
        return unit;
    }
    
    public void setUnit(String unit){
        this.unit = unit;
    }
    
    public Date getDate() {
    	return date;
    }
    
    public void setDate(Date date) {
    	this.date = date;
    }

}
