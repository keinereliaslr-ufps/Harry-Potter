package modelo;

import java.util.ArrayList;

public class Personaje {
    private String nombre;
    private CasaHogwarts casa;
    private int nivelMagia;
    private ArrayList<Habilidad> habilidades;
    private ArrayList<ObjetoMagico> inventario;

    public Personaje() {
        this.habilidades = new ArrayList<>();
        this.inventario = new ArrayList<>();
    }

    public Personaje(String nombre, CasaHogwarts casa, int nivelMagia) {
        this();
        this.nombre = nombre;
        this.casa = casa;
        this.nivelMagia = nivelMagia;
    }

    public void hablar() {
        System.out.println(nombre + ": Hola, soy de " + casa);
    }

    public void mover() {
        System.out.println(nombre + " se mueve por Hogwarts.");
    }

    public void interactuarCon(Personaje p) {
        System.out.println(nombre + " interactua con " + p.getNombre());
    }

    public void hablarCon(Personaje p) {
        System.out.println(nombre + " habla con " + p.getNombre());
    }

    public void hablarConProfesor(Profesor p) {
        System.out.println(nombre + " habla con el profesor " + p.getNombre());
    }

    public void agregarHabilidad(Habilidad habilidad) {
        if (habilidad != null) {
            habilidades.add(habilidad);
        }
    }

    public void agregarObjeto(ObjetoMagico objeto) {
        if (objeto != null) {
            inventario.add(objeto);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CasaHogwarts getCasa() {
        return casa;
    }

    public void setCasa(CasaHogwarts casa) {
        this.casa = casa;
    }

    public int getNivelMagia() {
        return nivelMagia;
    }

    public void setNivelMagia(int nivelMagia) {
        this.nivelMagia = nivelMagia;
    }

    public ArrayList<Habilidad> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }

    public ArrayList<ObjetoMagico> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<ObjetoMagico> inventario) {
        this.inventario = inventario;
    }

    @Override
    public String toString() {
        return nombre + " - " + getClass().getSimpleName() + " - " + casa + " - Magia: " + nivelMagia;
    }
}
