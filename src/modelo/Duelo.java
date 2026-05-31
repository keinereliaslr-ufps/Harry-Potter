package modelo;

public class Duelo {
    private Personaje participante1;
    private Personaje participante2;
    private String resultado;

    public Duelo() {
    }

    public Duelo(Personaje participante1, Personaje participante2) {
        this.participante1 = participante1;
        this.participante2 = participante2;
    }

    public void iniciar() {
        if (participante1 == null || participante2 == null) {
            resultado = "No se pudo iniciar el duelo: faltan participantes.";
            return;
        }

        int poder1 = participante1.getNivelMagia();
        int poder2 = participante2.getNivelMagia();

        if (participante1 instanceof Estudiante estudiante && !estudiante.getHechizos().isEmpty()) {
            poder1 += estudiante.getHechizos().get(0).getPoder();
        }
        if (participante2 instanceof Estudiante estudiante && !estudiante.getHechizos().isEmpty()) {
            poder2 += estudiante.getHechizos().get(0).getPoder();
        }

        if (poder1 > poder2) {
            resultado = "Ganador: " + participante1.getNombre();
        } else if (poder2 > poder1) {
            resultado = "Ganador: " + participante2.getNombre();
        } else {
            resultado = "Empate entre " + participante1.getNombre() + " y " + participante2.getNombre();
        }

        System.out.println("Duelo iniciado entre " + participante1.getNombre() + " y " + participante2.getNombre());
    }

    public void finalizar() {
        System.out.println("Duelo finalizado. " + resultado);
    }

    public Personaje getParticipante1() {
        return participante1;
    }

    public void setParticipante1(Personaje participante1) {
        this.participante1 = participante1;
    }

    public Personaje getParticipante2() {
        return participante2;
    }

    public void setParticipante2(Personaje participante2) {
        this.participante2 = participante2;
    }

    public String getResultado() {
        return resultado;
    }
}
