package modelo;

public class Hechizo {
    private String nombre;
    private int poder;

    public Hechizo() {
    }

    public Hechizo(String nombre, int poder) {
        this.nombre = nombre;
        this.poder = poder;
    }

    public void ejecutar() {
        System.out.println("Hechizo ejecutado: " + nombre + " (poder " + poder + ")");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    @Override
    public String toString() {
        return nombre + " (" + poder + ")";
    }
}
