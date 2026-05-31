package controlador;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.CasaHogwarts;
import modelo.Duelo;
import modelo.Escoba;
import modelo.Estudiante;
import modelo.Habilidad;
import modelo.Hechizo;
import modelo.Juego;
import modelo.Locacion;
import modelo.ObjetoMagico;
import modelo.Personaje;
import modelo.Pocion;
import modelo.Profesor;
import modelo.Varita;

public class JuegoController {
    private Juego juego;
    private ArrayList<Personaje> personajes;

    public JuegoController() {
        this.juego = new Juego("El mejor juego de Hogwarts Legacy");
        this.personajes = new ArrayList<>();
        juego.getPlataformas().add("PC");
        juego.getPlataformas().add("Consola");
    }

    public Juego getJuego() {
        return juego;
    }

    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }

    public Locacion crearLocacion(String nombre, String descripcion) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return null;
        }
        Locacion locacion = new Locacion(nombre.trim(), descripcion == null ? "" : descripcion.trim());
        juego.agregarLocacion(locacion);
        return locacion;
    }

    public Personaje crearPersonaje(String tipo, String nombre, CasaHogwarts casa, int nivelMagia) {
        if (nombre == null || nombre.trim().isEmpty() || casa == null) {
            return null;
        }
        if (nivelMagia < 0) {
            nivelMagia = 0;
        }

        Personaje personaje;
        if ("Profesor".equalsIgnoreCase(tipo)) {
            personaje = new Profesor(nombre.trim(), casa, nivelMagia);
        } else {
            personaje = new Estudiante(nombre.trim(), casa, nivelMagia);
        }

        personajes.add(personaje);
        return personaje;
    }

    public void agregarHabilidad(Personaje personaje, String nombre, String descripcion) {
        if (personaje != null && nombre != null && !nombre.trim().isEmpty()) {
            personaje.agregarHabilidad(new Habilidad(nombre.trim(), descripcion == null ? "" : descripcion.trim()));
        }
    }

    public void agregarObjetosBasicos(Personaje personaje, boolean tieneVarita, boolean tieneEscoba, boolean tienePocion) {
        if (personaje == null) {
            return;
        }

        if (tieneVarita) {
            personaje.agregarObjeto(new Varita());
        }
        if (tieneEscoba) {
            personaje.agregarObjeto(new Escoba());
        }
        if (tienePocion) {
            personaje.agregarObjeto(new Pocion());
        }
    }

    public void agregarObjetoManual(Personaje personaje, ObjetoMagico objeto) {
        if (personaje != null && objeto != null) {
            personaje.agregarObjeto(objeto);
        }
    }

    public void registrarHechizoBasico(Personaje personaje, String nombre, int poder) {
        if (personaje instanceof Estudiante estudiante && nombre != null && !nombre.trim().isEmpty()) {
            estudiante.aprenderHechizo(new Hechizo(nombre.trim(), Math.max(0, poder)));
        }
        if (personaje instanceof Profesor profesor && nombre != null && !nombre.trim().isEmpty()) {
            profesor.ensenarHechizo(new Hechizo(nombre.trim(), Math.max(0, poder)));
        }
    }

    public String simularDuelo(Personaje p1, Personaje p2) {
        Duelo duelo = new Duelo(p1, p2);
        duelo.iniciar();
        duelo.finalizar();
        return duelo.getResultado();
    }

    public String listarPersonajes() {
        StringBuilder sb = new StringBuilder();
        for (Personaje personaje : personajes) {
            sb.append(personaje).append("\n");
        }
        return sb.toString();
    }

    public String listarLocaciones() {
        StringBuilder sb = new StringBuilder();
        for (Locacion locacion : juego.getLocaciones()) {
            sb.append(locacion).append("\n");
        }
        return sb.toString();
    }

    public void guardarJuegoStub() {
        juego.guardar();
        JOptionPane.showMessageDialog(null, "Esta opción no está disponible de momento.", "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    public void cargarJuegoStub() {
        juego.cargar();
        JOptionPane.showMessageDialog(null, "Esta opción no está disponible de momento.", "Info", JOptionPane.INFORMATION_MESSAGE);
    }
}
