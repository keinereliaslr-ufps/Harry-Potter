package modelo;

public class ObjetoMagico {
    private String nombre;
    private String descripcion;

    public ObjetoMagico() {
    }

    public ObjetoMagico(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void activar() {
        System.out.println("Activando objeto: " + nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
