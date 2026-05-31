package modelo;

import java.util.ArrayList;

public class Juego {
    private String titulo;
    private ArrayList<String> plataformas;
    private ArrayList<Locacion> locaciones;

    public Juego() {
        this.plataformas = new ArrayList<>();
        this.locaciones = new ArrayList<>();
    }

    public Juego(String titulo) {
        this();
        this.titulo = titulo;
    }

    public void iniciar() {
        System.out.println("Iniciando juego: " + titulo);
    }

    public void guardar() {
        System.out.println("Guardar no implementado: este proyecto no usa archivos.");
    }

    public void cargar() {
        System.out.println("Cargar no implementado: este proyecto no usa archivos.");
    }

    public void agregarLocacion(Locacion locacion) {
        if (locacion != null) {
            locaciones.add(locacion);
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<String> getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(ArrayList<String> plataformas) {
        this.plataformas = plataformas;
    }

    public ArrayList<Locacion> getLocaciones() {
        return locaciones;
    }

    public void setLocaciones(ArrayList<Locacion> locaciones) {
        this.locaciones = locaciones;
    }

    @Override
    public String toString() {
        return "Juego{" + "titulo='" + titulo + '\'' + ", plataformas=" + plataformas + ", locaciones=" + locaciones.size() + '}';
    }
}
