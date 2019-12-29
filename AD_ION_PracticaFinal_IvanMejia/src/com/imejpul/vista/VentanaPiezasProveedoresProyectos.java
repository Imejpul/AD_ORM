package com.imejpul.vista;

import com.imejpul.HibernateGestion;
import com.imejpul.Piezas;
import com.imejpul.Proveedores;
import com.imejpul.Proyectos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class VentanaPiezasProveedoresProyectos {
    private JPanel piProvProyJpanel;
    private JButton insertarButton;
    private JButton modificarButton;
    private JButton eliminarButton;
    private JButton listadoButton;
    private JComboBox comboBoxProv;
    private JComboBox comboBoxPieza;
    private JComboBox comboBoxProyecto;
    private JLabel titleJlabel;
    private JLabel provLabel;
    private JLabel piezaLabel;
    private JLabel proyectoLabel;
    private JTextField textFieldNomProv;
    private JTextField textFieldApdosProv;
    private JTextField textFieldDirProv;
    private JTextField textFieldNomPieza;
    private JTextField textFieldPrecioPieza;
    private JTextField textFieldDescPieza;
    private JTextField textFieldNomPoyecto;
    private JTextField textFieldCityProyecto;
    private JTextField textFieldCantidad;
    private JLabel cantLabel;

    private List<Proveedores> proveedoresList;
    private List<Piezas> piezasList;
    private List<Proyectos> proyectosList;

    public VentanaPiezasProveedoresProyectos() {
        JFrame frame = new JFrame("Piezas - Proveedores - Proyectos");
        frame.setContentPane(piProvProyJpanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        comboBoxProv.addItem("Elije CODIGO");
        comboBoxPieza.addItem("Elije CODIGO");
        comboBoxProyecto.addItem("Elije CODIGO");

        HibernateGestion gestion = new HibernateGestion();

        //PROVEEDORES
        proveedoresList = new ArrayList<>();
        proveedoresList = gestion.loadAllData(Proveedores.class);

        for (Proveedores p : proveedoresList) {
            comboBoxProv.addItem(p.getCodigo().toUpperCase());
        }

        comboBoxProv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!comboBoxProv.getSelectedItem().toString().equalsIgnoreCase("Elije CODIGO")) {
                    cargarCamposProveedor(comboBoxProv.getSelectedItem().toString());
                }
            }
        });

        //PIEZAS
        piezasList = new ArrayList<>();
        piezasList = gestion.loadAllData(Piezas.class);

        for (Piezas p : piezasList) {
            comboBoxPieza.addItem(p.getCodigo().toUpperCase());
        }

        comboBoxPieza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!comboBoxPieza.getSelectedItem().toString().equalsIgnoreCase("Elije CODIGO")) {
                    cargarCamposPieza(comboBoxPieza.getSelectedItem().toString());
                }
            }
        });

        //PROYECTOS
        proyectosList = new ArrayList<>();
        proyectosList = gestion.loadAllData(Proyectos.class);

        for (Proyectos p : proyectosList) {
            comboBoxProyecto.addItem(p.getCodigo().toUpperCase());
        }

        comboBoxProyecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!comboBoxProyecto.getSelectedItem().toString().equalsIgnoreCase("Elije CODIGO")) {
                    cargarCamposProyecto(comboBoxProyecto.getSelectedItem().toString());
                }
            }
        });


        listadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                VentanaListado vl = new VentanaListado("Gestion");
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!comboBoxProv.getSelectedItem().toString().equalsIgnoreCase("Elije CODIGO") &&
                        !comboBoxPieza.getSelectedItem().toString().equalsIgnoreCase("Elije CODIGO") &&
                        !comboBoxProyecto.getSelectedItem().toString().equalsIgnoreCase("Elije CODIGO")
                ) {
                    String codPieza = comboBoxPieza.getSelectedItem().toString();
                    String codProv = comboBoxProv.getSelectedItem().toString();
                    String codProyecto = comboBoxProyecto.getSelectedItem().toString();
                    if (gestion.eliminarTuplaGestion(codProv, codPieza, codProyecto)) {
                        JOptionPane.showMessageDialog(frame, "¡Tupla eliminada con exito en Gestion!");
                        limpiarCampos();
                    } else {
                        JOptionPane.showMessageDialog(frame, "¡Error al eliminar en BBDD!.");
                        limpiarCampos();
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "¡Debe elegir código en todos los campos!.");
                }
            }
        });
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!comboBoxProv.getSelectedItem().toString().equalsIgnoreCase("Elije CODIGO") &&
                        !comboBoxPieza.getSelectedItem().toString().equalsIgnoreCase("Elije CODIGO") &&
                        !comboBoxProyecto.getSelectedItem().toString().equalsIgnoreCase("Elije CODIGO")
                ) {
                    double cant;
                    String codPieza = comboBoxPieza.getSelectedItem().toString();
                    String codProv = comboBoxProv.getSelectedItem().toString();
                    String codProyecto = comboBoxProyecto.getSelectedItem().toString();
                    if (!textFieldCantidad.getText().equalsIgnoreCase("")) {
                        cant = Double.parseDouble(textFieldCantidad.getText().trim());
                        if (gestion.actualizarTuplaGestion(codProv, codPieza, codProyecto, cant)) {
                            JOptionPane.showMessageDialog(frame, "¡Tupla actualizada con exito en Gestion!");
                            limpiarCampos();
                        } else {
                            JOptionPane.showMessageDialog(frame, "¡Error al actualizar en BBDD!.");
                            limpiarCampos();
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "¡Debe introducir una cantidad!.");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "¡Debe elegir código en todos los campos!.");
                }
            }
        });
        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!comboBoxProv.getSelectedItem().toString().equalsIgnoreCase("Elije CODIGO") &&
                        !comboBoxPieza.getSelectedItem().toString().equalsIgnoreCase("Elije CODIGO") &&
                        !comboBoxProyecto.getSelectedItem().toString().equalsIgnoreCase("Elije CODIGO")
                ) {
                    double cant;
                    String codPieza = comboBoxPieza.getSelectedItem().toString();
                    String codProv = comboBoxProv.getSelectedItem().toString();
                    String codProyecto = comboBoxProyecto.getSelectedItem().toString();
                    if (!textFieldCantidad.getText().equalsIgnoreCase("")) {
                        cant = Double.parseDouble(textFieldCantidad.getText().trim());
                        if (gestion.insertarTuplaGesion(codProv, codPieza, codProyecto, cant)) {
                            JOptionPane.showMessageDialog(frame, "¡Tupla insertada con exito en Gestion!");
                            limpiarCampos();
                        } else {
                            JOptionPane.showMessageDialog(frame, "¡Error al introducir en BBDD!.");
                            limpiarCampos();
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "¡Debe introducir una cantidad!.");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "¡Debe elegir código en todos los campos!.");
                }
            }
        });
    }

    private void limpiarCampos() {
        //COMBOS
        comboBoxProv.setSelectedIndex(0);
        comboBoxPieza.setSelectedIndex(0);
        comboBoxProyecto.setSelectedIndex(0);

        //PROVEEDORES
        textFieldNomProv.setText("");
        textFieldApdosProv.setText("");
        textFieldDirProv.setText("");

        //PIEZAS
        textFieldNomPieza.setText("");
        textFieldPrecioPieza.setText("");
        textFieldDescPieza.setText("");

        //PROYECTO
        textFieldNomPoyecto.setText("");
        textFieldCityProyecto.setText("");
    }

    private void cargarCamposProveedor(String codigo) {
        for (Proveedores p : proveedoresList) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                textFieldNomProv.setText(p.getNombre());
                textFieldApdosProv.setText(p.getApellidos());
                textFieldDirProv.setText(p.getDireccion());
            }
        }
    }

    private void cargarCamposPieza(String codigo) {
        for (Piezas p : piezasList) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                textFieldNomPieza.setText(p.getNombre());
                textFieldPrecioPieza.setText(String.valueOf(p.getPrecio()));
                textFieldDescPieza.setText(p.getDescripcion());
            }
        }
    }

    private void cargarCamposProyecto(String codigo) {
        for (Proyectos p : proyectosList) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                textFieldNomPoyecto.setText(p.getNombre());
                textFieldCityProyecto.setText(p.getCiudad());
            }
        }
    }
}
