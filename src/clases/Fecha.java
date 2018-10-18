package clases;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fecha {
    private SimpleDateFormat simpleDateFormat;
    private Date date;     
    
    private String dia;
    private String mes;
    private String ano;

    public Fecha() {                
        date = new Date();        
        
        simpleDateFormat = new SimpleDateFormat("dd");
        this.dia = simpleDateFormat.format(date).toString();
        
        simpleDateFormat = new SimpleDateFormat("MM");
        this.mes = simpleDateFormat.format(date).toString();
        
        simpleDateFormat = new SimpleDateFormat("yyyy");
        this.ano = simpleDateFormat.format(date).toString();
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}
