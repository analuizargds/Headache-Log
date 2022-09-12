package model;

/**
 * Classe utilizada no controlerPain
 * Serve para modelar uma dor
 * @author Ana Luiza Rodrigues da Silva
 */

import java.util.Date;

public class Pain {
	private Date date;
    private String variety;
    private String area;
    private int time;
    private int intensity;
    private String cause;
    
    public Pain(Date date, String variety, String area, int time, int intensity, String cause){
        this.date = date;
        this.variety = variety;
        this.area = area;
        this.time = time;
        this.intensity = intensity;
        this.cause = cause;
        
    }
    

    public Pain() {

    }
    
    public Date getDate(){
        return date;
    }
    
    public void setDate(Date date){
        this.date = date;
    }
    

    public String getVariety() {
        return variety;
    }
    
    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getArea() {
        return area;
    }
    
    public void setArea(String area) {
        this.area = area;
    }

    public int getTime() {
        return time;
    }
    
    public void setTime(int time) {
        this.time = time;
    }

    public int getIntensity() {
        return intensity;
    }
    
    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

}
