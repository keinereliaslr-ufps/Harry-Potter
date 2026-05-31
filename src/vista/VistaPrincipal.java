package vista;

import controlador.JuegoController;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Personaje;

public class VistaPrincipal extends JFrame {
    private final JuegoController controller;
    private final DefaultListModel<String> modeloLocaciones;

    public VistaPrincipal(JuegoController controller) {
        this.controller = controller;
        this.modeloLocaciones = new DefaultListModel<>();
        initComponents();
    }

    private void initComponents() {
        setTitle("Harry Potter - Juego Hogwarts");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        javax.swing.JLabel lblTitulo = new javax.swing.JLabel("Titulo del juego:");
        txtTitulo = new javax.swing.JTextField(controller.getJuego().getTitulo(), 20);

        javax.swing.JLabel lblLocacion = new javax.swing.JLabel("Locacion:");
        txtLocacion = new javax.swing.JTextField(12);
        javax.swing.JLabel lblDescripcion = new javax.swing.JLabel("Descripcion:");
        txtDescripcion = new javax.swing.JTextField(12);

        btnIniciar = new javax.swing.JButton("Iniciar Juego");
        btnGuardar = new javax.swing.JButton("Guardar (stub)");
        btnCargar = new javax.swing.JButton("Cargar (stub)");
        btnCrearLocacion = new javax.swing.JButton("Agregar Locacion");
        btnGestionarPersonajes = new javax.swing.JButton("Gestionar Personajes");
        btnSimularDuelo = new javax.swing.JButton("Simular Duelo");
        btnListar = new javax.swing.JButton("Listar");

        lstLocaciones = new javax.swing.JList<>(modeloLocaciones);
        javax.swing.JScrollPane scrollLocaciones = new javax.swing.JScrollPane(lstLocaciones);

        javax.swing.JPanel superior = new javax.swing.JPanel(new java.awt.GridLayout(0, 2, 6, 6));
        superior.add(lblTitulo);
        superior.add(txtTitulo);
        superior.add(lblLocacion);
        superior.add(txtLocacion);
        superior.add(lblDescripcion);
        superior.add(txtDescripcion);

        javax.swing.JPanel botones = new javax.swing.JPanel();
        botones.add(btnIniciar);
        botones.add(btnGuardar);
        botones.add(btnCargar);
        botones.add(btnCrearLocacion);
        botones.add(btnGestionarPersonajes);
        botones.add(btnSimularDuelo);
        botones.add(btnListar);

        getContentPane().setLayout(new java.awt.BorderLayout(8, 8));
        getContentPane().add(superior, java.awt.BorderLayout.NORTH);
        getContentPane().add(scrollLocaciones, java.awt.BorderLayout.CENTER);
        getContentPane().add(botones, java.awt.BorderLayout.SOUTH);

        btnIniciar.addActionListener(e -> iniciarJuego());
        btnGuardar.addActionListener(e -> controller.guardarJuegoStub());
        btnCargar.addActionListener(e -> controller.cargarJuegoStub());
        btnCrearLocacion.addActionListener(e -> crearLocacion());
        btnGestionarPersonajes.addActionListener(e -> abrirGestionPersonajes());
        btnSimularDuelo.addActionListener(e -> simularDuelo());
        btnListar.addActionListener(e -> listarLocaciones());

        setSize(900, 500);
        setLocationRelativeTo(null);
    }

    private void iniciarJuego() {
        controller.getJuego().setTitulo(txtTitulo.getText());
        controller.getJuego().iniciar();
        JOptionPane.showMessageDialog(this, "Juego iniciado: " + controller.getJuego().getTitulo());
    }

    private void crearLocacion() {
        String nombre = txtLocacion.getText();
        String descripcion = txtDescripcion.getText();
        if (controller.crearLocacion(nombre, descripcion) == null) {
            JOptionPane.showMessageDialog(this, "Ingrese nombre de locacion valido.");
            return;
        }
        listarLocaciones();
        txtLocacion.setText("");
        txtDescripcion.setText("");
    }

    private void abrirGestionPersonajes() {
        new VistaGestionPersonaje(controller).setVisible(true);
    }

    private void simularDuelo() {
        if (controller.getPersonajes().size() < 2) {
            JOptionPane.showMessageDialog(this, "Necesita minimo 2 personajes para un duelo.");
            return;
        }

        Personaje p1 = controller.getPersonajes().get(0);
        Personaje p2 = controller.getPersonajes().get(1);
        String resultado = controller.simularDuelo(p1, p2);
        JOptionPane.showMessageDialog(this, resultado);
    }

    private void listarLocaciones() {
        modeloLocaciones.clear();
        controller.getJuego().getLocaciones().forEach(loc -> modeloLocaciones.addElement(loc.toString()));
    }

    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnCrearLocacion;
    private javax.swing.JButton btnGestionarPersonajes;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnSimularDuelo;
    private javax.swing.JList<String> lstLocaciones;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtLocacion;
    private javax.swing.JTextField txtTitulo;
}
