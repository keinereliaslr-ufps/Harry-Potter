package modelo;

import java.util.ArrayList;

public class Estudiante extends Personaje {
    private ArrayList<Hechizo> hechizos;

    public Estudiante() {
        super();
        this.hechizos = new ArrayList<>();
    }

    public Estudiante(String nombre, CasaHogwarts casa, int nivelMagia) {
        super(nombre, casa, nivelMagia);
        this.hechizos = new ArrayList<>();
    }

    public void aprenderHechizo(Hechizo h) {
        if (h != null) {
            hechizos.add(h);
            System.out.println(getNombre() + " aprendio " + h.getNombre());
        }
    }

    public void usarHechizo(Hechizo h) {
        if (h != null) {
            System.out.println(getNombre() + " usa " + h.getNombre());
            h.ejecutar();
        }
    }

    public void explorar(Locacion l) {
        if (l != null) {
            System.out.println(getNombre() + " explora " + l.getNombre());
        }
    }

    public void pedirAyuda(Profesor p) {
        if (p != null) {
            System.out.println(getNombre() + " pide ayuda a " + p.getNombre());
        }
    }

    public void conversarConCompanero(Estudiante p) {
        if (p != null) {
            System.out.println(getNombre() + " conversa con " + p.getNombre());
        }
    }

    public ArrayList<Hechizo> getHechizos() {
        return hechizos;
    }

    public void setHechizos(ArrayList<Hechizo> hechizos) {
        this.hechizos = hechizos;
    }
}
