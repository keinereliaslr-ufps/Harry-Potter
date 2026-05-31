package vista;

import controlador.JuegoController;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.CasaHogwarts;
import modelo.Personaje;

public class VistaGestionPersonaje extends JFrame {
    private final JuegoController controller;
    private final DefaultListModel<Personaje> modeloPersonajes;

    public VistaGestionPersonaje(JuegoController controller) {
        this.controller = controller;
        this.modeloPersonajes = new DefaultListModel<>();
        initComponents();
        cargarCasas();
        refrescarLista();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        setTitle("Gestion de Personajes");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        javax.swing.JLabel lblTipo = new javax.swing.JLabel("Tipo:");
        cmbTipo = new javax.swing.JComboBox<>(new String[] { "Estudiante", "Profesor" });

        javax.swing.JLabel lblNombre = new javax.swing.JLabel("Nombre:");
        txtNombre = new javax.swing.JTextField(15);

        javax.swing.JLabel lblCasa = new javax.swing.JLabel("Casa:");
        cmbCasa = new javax.swing.JComboBox<>();

        javax.swing.JLabel lblNivel = new javax.swing.JLabel("Nivel Magia:");
        spnNivel = new javax.swing.JSpinner(new javax.swing.SpinnerNumberModel(1, 0, 100, 1));

        javax.swing.JLabel lblHabilidad = new javax.swing.JLabel("Habilidad:");
        txtHabilidad = new javax.swing.JTextField(12);

        javax.swing.JLabel lblDescripcion = new javax.swing.JLabel("Descripcion:");
        txtDescripcion = new javax.swing.JTextField(12);

        chkVarita = new javax.swing.JCheckBox("Tiene varita");
        chkEscoba = new javax.swing.JCheckBox("Tiene escoba");
        chkPocion = new javax.swing.JCheckBox("Tiene pocion");

        btnCrear = new javax.swing.JButton("Crear");
        btnAgregarHabilidad = new javax.swing.JButton("Agregar Habilidad");
        btnListar = new javax.swing.JButton("Listar");

        lstPersonajes = new javax.swing.JList<>(modeloPersonajes);
        javax.swing.JScrollPane scroll = new javax.swing.JScrollPane(lstPersonajes);

        javax.swing.JPanel formPanel = new javax.swing.JPanel(new java.awt.GridLayout(0, 2, 6, 6));
        formPanel.add(lblTipo);
        formPanel.add(cmbTipo);
        formPanel.add(lblNombre);
        formPanel.add(txtNombre);
        formPanel.add(lblCasa);
        formPanel.add(cmbCasa);
        formPanel.add(lblNivel);
        formPanel.add(spnNivel);
        formPanel.add(lblHabilidad);
        formPanel.add(txtHabilidad);
        formPanel.add(lblDescripcion);
        formPanel.add(txtDescripcion);
        formPanel.add(chkVarita);
        formPanel.add(chkEscoba);
        formPanel.add(chkPocion);

        javax.swing.JPanel botones = new javax.swing.JPanel();
        botones.add(btnCrear);
        botones.add(btnAgregarHabilidad);
        botones.add(btnListar);

        getContentPane().setLayout(new java.awt.BorderLayout(8, 8));
        getContentPane().add(formPanel, java.awt.BorderLayout.NORTH);
        getContentPane().add(scroll, java.awt.BorderLayout.CENTER);
        getContentPane().add(botones, java.awt.BorderLayout.SOUTH);

        btnCrear.addActionListener(e -> crearPersonaje());
        btnAgregarHabilidad.addActionListener(e -> agregarHabilidad());
        btnListar.addActionListener(e -> refrescarLista());

        setSize(650, 500);
        setLocationRelativeTo(null);
    }

    private void cargarCasas() {
        cmbCasa.setModel(new DefaultComboBoxModel<>(CasaHogwarts.values()));
    }

    private void crearPersonaje() {
        String tipo = (String) cmbTipo.getSelectedItem();
        String nombre = txtNombre.getText();
        CasaHogwarts casa = (CasaHogwarts) cmbCasa.getSelectedItem();
        int nivel = (int) spnNivel.getValue();

        Personaje personaje = controller.crearPersonaje(tipo, nombre, casa, nivel);
        if (personaje == null) {
            JOptionPane.showMessageDialog(this, "Datos invalidos para crear personaje.");
            return;
        }

        controller.agregarObjetosBasicos(personaje, chkVarita.isSelected(), chkEscoba.isSelected(), chkPocion.isSelected());

        String habilidad = txtHabilidad.getText();
        String descripcion = txtDescripcion.getText();
        if (habilidad != null && !habilidad.trim().isEmpty()) {
            controller.agregarHabilidad(personaje, habilidad, descripcion);
        }

        controller.registrarHechizoBasico(personaje, "Hechizo Inicial", 5);

        JOptionPane.showMessageDialog(this, "Personaje creado: " + personaje.getNombre());
        refrescarLista();
        limpiarFormulario();
    }

    private void agregarHabilidad() {
        Personaje personaje = lstPersonajes.getSelectedValue();
        if (personaje == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un personaje en la lista.");
            return;
        }
        String habilidad = txtHabilidad.getText();
        String descripcion = txtDescripcion.getText();
        controller.agregarHabilidad(personaje, habilidad, descripcion);
        JOptionPane.showMessageDialog(this, "Habilidad agregada.");
        refrescarLista();
    }

    private void refrescarLista() {
        modeloPersonajes.clear();
        for (Personaje personaje : controller.getPersonajes()) {
            modeloPersonajes.addElement(personaje);
        }
    }

    private void limpiarFormulario() {
        txtNombre.setText("");
        txtHabilidad.setText("");
        txtDescripcion.setText("");
        chkVarita.setSelected(false);
        chkEscoba.setSelected(false);
        chkPocion.setSelected(false);
        spnNivel.setValue(1);
        cmbTipo.setSelectedIndex(0);
        cmbCasa.setSelectedIndex(0);
    }

    private javax.swing.JButton btnAgregarHabilidad;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnListar;
    private javax.swing.JCheckBox chkEscoba;
    private javax.swing.JCheckBox chkPocion;
    private javax.swing.JCheckBox chkVarita;
    private javax.swing.JComboBox<CasaHogwarts> cmbCasa;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JList<Personaje> lstPersonajes;
    private javax.swing.JSpinner spnNivel;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtHabilidad;
    private javax.swing.JTextField txtNombre;
}
