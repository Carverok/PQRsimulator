package clases;

public class PQR {
    private String nombreObjeto;
    private String nombreDestino;
    private String descripcion;
    private String estado;
    private String nombreOrigen;
    private Fecha fecha;

    public PQR() {
        this.nombreObjeto  = "";
        this.nombreDestino = "";
        this.descripcion = "";
        this.estado = "";
        this.nombreOrigen = "";
        this.fecha = null;
    }

    public PQR(String nombreObjeto, String nombreDestino, String descripcion, String estado, String nombreOrigen, Fecha fecha) {
        this.nombreObjeto = nombreObjeto;
        this.nombreDestino = nombreDestino;
        this.descripcion = descripcion;
        this.estado = estado;
        this.nombreOrigen = nombreOrigen;
        this.fecha = fecha;
    }    

    public String getNombreObjeto() {
        return nombreObjeto;
    }

    public void setNombreObjeto(String nombreObjeto) {
        this.nombreObjeto = nombreObjeto;
    }

    public String getNombreDestino() {
        return nombreDestino;
    }

    public void setNombreDestino(String nombreDestino) {
        this.nombreDestino = nombreDestino;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreOrigen() {
        return nombreOrigen;
    }

    public void setNombreOrigen(String nombreOrigen) {
        this.nombreOrigen = nombreOrigen;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }
}
