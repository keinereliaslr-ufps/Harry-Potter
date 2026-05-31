package modelo;

public class CriaturaMagica extends Personaje {
    private String tipo;

    public CriaturaMagica() {
        super();
    }

    public CriaturaMagica(String nombre, CasaHogwarts casa, int nivelMagia, String tipo) {
        super(nombre, casa, nivelMagia);
        this.tipo = tipo;
    }

    public void atacar() {
        System.out.println(getNombre() + " ataca como criatura de tipo " + tipo);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
