package modelo;

import java.util.ArrayList;

public class Profesor extends Personaje {
    private ArrayList<Hechizo> hechizosQueEnsenia;

    public Profesor() {
        super();
        this.hechizosQueEnsenia = new ArrayList<>();
    }

    public Profesor(String nombre, CasaHogwarts casa, int nivelMagia) {
        super(nombre, casa, nivelMagia);
        this.hechizosQueEnsenia = new ArrayList<>();
    }

    public void ensenarHechizo(Hechizo h) {
        if (h != null) {
            hechizosQueEnsenia.add(h);
            System.out.println(getNombre() + " enseña " + h.getNombre());
        }
    }

    public void hablarConEstudiante(Estudiante e) {
        if (e != null) {
            System.out.println(getNombre() + " habla con " + e.getNombre());
        }
    }

    public void evaluarEstudiante(Estudiante e) {
        if (e != null) {
            System.out.println(getNombre() + " evalua a " + e.getNombre());
        }
    }

    public ArrayList<Hechizo> getHechizosQueEnsenia() {
        return hechizosQueEnsenia;
    }

    public void setHechizosQueEnsenia(ArrayList<Hechizo> hechizosQueEnsenia) {
        this.hechizosQueEnsenia = hechizosQueEnsenia;
    }
}
