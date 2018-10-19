package clases;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fecha {   
    private String dia;
    private String mes;
    private String ano;
    private String horas;
    private String minutos;
    private String segundos;
    
    private Date date;
    private SimpleDateFormat simpleDateFormat; 

    public Fecha() {
        this.date = new Date();                
        
        this.simpleDateFormat = new SimpleDateFormat("dd");
        this.dia = this.simpleDateFormat.format(date).toString();
        
        this.simpleDateFormat = new SimpleDateFormat("MM");
        this.mes = this.simpleDateFormat.format(date).toString();
        
        this.simpleDateFormat = new SimpleDateFormat("yyyy");
        this.ano = this.simpleDateFormat.format(date).toString();
        
        this.simpleDateFormat = new SimpleDateFormat("HH");
        this.horas = this.simpleDateFormat.format(date).toString();
        
        this.simpleDateFormat = new SimpleDateFormat("mm");
        this.minutos = this.simpleDateFormat.format(date).toString();
        
        this.simpleDateFormat = new SimpleDateFormat("ss");
        this.segundos = this.simpleDateFormat.format(date).toString();
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

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public String getMinutos() {
        return minutos;
    }

    public void setMinutos(String minutos) {
        this.minutos = minutos;
    }

    public String getSegundos() {
        return segundos;
    }

    public void setSegundos(String segundos) {
        this.segundos = segundos;
    }

    public String getFechaCompleta() {
        String fechaCompleta = this.dia + "/" + this.mes + "/" + this.ano + " " + this.horas + ":" + this.minutos + ":" + this.segundos;
        return fechaCompleta;
    }
}
