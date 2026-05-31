package main;

import controlador.JuegoController;
import javax.swing.SwingUtilities;
import vista.VistaPrincipal;

public class JuegoApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JuegoController controller = new JuegoController();
            new VistaPrincipal(controller).setVisible(true);
        });
    }
}
