package modelo;

import java.util.ArrayList;

public class Locacion {
    private String nombre;
    private String descripcion;
    private ArrayList<Personaje> personajes;

    public Locacion() {
        this.personajes = new ArrayList<>();
    }

    public Locacion(String nombre, String descripcion) {
        this();
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void agregarPersonaje(Personaje personaje) {
        if (personaje != null) {
            personajes.add(personaje);
        }
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

    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(ArrayList<Personaje> personajes) {
        this.personajes = personajes;
    }

    @Override
    public String toString() {
        return nombre + " - " + descripcion;
    }
}
