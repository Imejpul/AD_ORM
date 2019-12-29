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

public class VentanaConsulta {
    private JPanel ventanaConsultaJpanel;
    private JButton buscarButton;
    private JTextArea textArea;
    private JTextField campoBusquedatextField;
    private JComboBox comboBox1;
    private JLabel infoCampoLabel;
    private List<Proveedores> proveedoresList;
    private List<Piezas> piezasList;
    private List<Proyectos> proyectosList;

    public VentanaConsulta(String opcion, String tabla) {

        JFrame frame = new JFrame("Consulta por " + opcion + ". " + tabla);
        frame.setContentPane(ventanaConsultaJpanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        HibernateGestion gestion = new HibernateGestion();

        infoCampoLabel.setText("Escribe el " + opcion.toUpperCase() + " o parte del " + opcion.toUpperCase());

        if (opcion.equalsIgnoreCase("Direccion") || opcion.equalsIgnoreCase("Ciudad")) {
            infoCampoLabel.setText("Escribe la " + opcion.toUpperCase() + " o parte de la " + opcion.toUpperCase());
        }

        switch (tabla) {
            case "Proveedores":
                buscarButton.setText("Buscar Proveedor");
                textArea.append("CODIGO: \n\n");
                textArea.append("NOMBRE: \n\n");
                textArea.append("APELLIDOS: \n\n");
                textArea.append("DIRECCIÓN: ");
                proveedoresList = new ArrayList<>();
                proveedoresList = gestion.loadAllData(Proveedores.class);
                break;
            case "Piezas":
                buscarButton.setText("Buscar Piezas");
                textArea.append("CODIGO: \n\n");
                textArea.append("NOMBRE: \n\n");
                textArea.append("PRECIO: \n\n");
                textArea.append("DESCRIPCIÓN: ");
                piezasList = new ArrayList<>();
                piezasList = gestion.loadAllData(Piezas.class);
                break;
            case "Proyectos":
                buscarButton.setText("Buscar Proyectos");
                textArea.append("CODIGO: \n\n");
                textArea.append("NOMBRE: \n\n");
                textArea.append("CIUDAD: ");
                proyectosList = new ArrayList<>();
                proyectosList = gestion.loadAllData(Proyectos.class);
                break;
        }

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String campoBusqueda = campoBusquedatextField.getText().trim().toUpperCase();
                if (ComprobarCargarDatosInicialesTextArea(tabla, campoBusqueda, opcion)) {
                    JOptionPane.showMessageDialog(frame, "¡Tuplas encontradas con exito en " + opcion + "!");
                } else {
                    JOptionPane.showMessageDialog(frame, "¡No se ha encontrado nada!.");
                }

            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (comboBox1.isValid()) {
                    cargarDatosTextArea(comboBox1.getSelectedItem().toString(), tabla, opcion);
                }
            }
        });
    }

    private void cargarDatosTextArea(String campo, String tabla, String opcion) {
        switch (tabla) {
            case "Proveedores":
                for (Proveedores p : proveedoresList) {
                    if (opcion.equalsIgnoreCase("Codigo")) {
                        if (p.getCodigo().equalsIgnoreCase(campo) || p.getCodigo().toUpperCase().startsWith(campo)) {
                            limpiarTextArea();
                            textArea.append("NOMBRE: " + p.getNombre() + "\n\n");
                            textArea.append("CODIGO: " + p.getCodigo() + "\n\n");
                            textArea.append("APELLIDOS: " + p.getApellidos() + "\n\n");
                            textArea.append("DIRECCIÓN: " + p.getDireccion());
                        }
                    } else if (opcion.equalsIgnoreCase("Nombre")) {
                        if (p.getNombre().equalsIgnoreCase(campo) || p.getNombre().toUpperCase().startsWith(campo)) {
                            limpiarTextArea();
                            textArea.append("NOMBRE: " + p.getNombre() + "\n\n");
                            textArea.append("CODIGO: " + p.getCodigo() + "\n\n");
                            textArea.append("APELLIDOS: " + p.getApellidos() + "\n\n");
                            textArea.append("DIRECCIÓN: " + p.getDireccion());
                        }
                    } else {
                        if (p.getDireccion().equalsIgnoreCase(campo) || p.getDireccion().toUpperCase().startsWith(campo)) {
                            limpiarTextArea();
                            textArea.append("NOMBRE: " + p.getNombre() + "\n\n");
                            textArea.append("CODIGO: " + p.getCodigo() + "\n\n");
                            textArea.append("APELLIDOS: " + p.getApellidos() + "\n\n");
                            textArea.append("DIRECCIÓN: " + p.getDireccion());
                        }
                    }
                }
                break;
            case "Piezas":
                for (Piezas p : piezasList) {
                    if (opcion.equalsIgnoreCase("Codigo")) {
                        if (p.getCodigo().equalsIgnoreCase(campo) || p.getCodigo().toUpperCase().startsWith(campo)) {
                            limpiarTextArea();
                            textArea.append("NOMBRE: " + p.getNombre() + "\n\n");
                            textArea.append("CODIGO: " + p.getCodigo() + "\n\n");
                            textArea.append("PRECIO: " + p.getPrecio() + "\n\n");
                            textArea.append("DESCRIPCIÓN: " + p.getDescripcion());
                        }
                    } else if (opcion.equalsIgnoreCase("Nombre")) {
                        if (p.getNombre().equalsIgnoreCase(campo) || p.getNombre().toUpperCase().startsWith(campo)) {
                            limpiarTextArea();
                            textArea.append("NOMBRE: " + p.getNombre() + "\n\n");
                            textArea.append("CODIGO: " + p.getCodigo() + "\n\n");
                            textArea.append("PRECIO: " + p.getPrecio() + "\n\n");
                            textArea.append("DESCRIPCIÓN: " + p.getDescripcion());
                        }
                    }
                }
                break;
            case "Proyectos":
                for (Proyectos p : proyectosList) {
                    if (opcion.equalsIgnoreCase("Codigo")) {
                        if (p.getCodigo().equalsIgnoreCase(campo) || p.getCodigo().toUpperCase().startsWith(campo)) {
                            limpiarTextArea();
                            textArea.append("NOMBRE: " + p.getNombre() + "\n\n");
                            textArea.append("CODIGO: " + p.getCodigo() + "\n\n");
                            textArea.append("CIUDAD: " + p.getCiudad());
                        }
                    } else if (opcion.equalsIgnoreCase("Nombre")) {
                        if (p.getNombre().equalsIgnoreCase(campo) || p.getNombre().toUpperCase().startsWith(campo)) {
                            limpiarTextArea();
                            textArea.append("NOMBRE: " + p.getNombre() + "\n\n");
                            textArea.append("CODIGO: " + p.getCodigo() + "\n\n");
                            textArea.append("CIUDAD: " + p.getCiudad());
                        }
                    } else {
                        if (p.getCiudad().equalsIgnoreCase(campo) || p.getCiudad().toUpperCase().startsWith(campo)) {
                            limpiarTextArea();
                            textArea.append("NOMBRE: " + p.getNombre() + "\n\n");
                            textArea.append("CODIGO: " + p.getCodigo() + "\n\n");
                            textArea.append("CIUDAD: " + p.getCiudad());
                        }
                    }
                }
                break;
        }
    }

    private void limpiarTextArea() {
        textArea.setText("");
    }

    private boolean ComprobarCargarDatosInicialesTextArea(String tabla, String campoBusqueda, String opcion) {
        boolean findSomething = false;
        switch (tabla) {
            case "Proveedores":
                comboBox1.removeAllItems();
                for (Proveedores p : proveedoresList) {
                    switch (opcion) {
                        case "Codigo":
                            if (campoBusqueda.equalsIgnoreCase(p.getCodigo()) || p.getCodigo().toUpperCase().startsWith(campoBusqueda)) {
                                limpiarTextArea();
                                textArea.append("NOMBRE: " + proveedoresList.get(0).getNombre() + "\n\n");
                                textArea.append("CODIGO: " + proveedoresList.get(0).getCodigo() + "\n\n");
                                textArea.append("APELLIDOS: " + proveedoresList.get(0).getApellidos() + "\n\n");
                                textArea.append("DIRECCIÓN: " + proveedoresList.get(0).getDireccion());
                                findSomething = true;
                                comboBox1.addItem(p.getCodigo().toUpperCase());
                            }
                            break;
                        case "Nombre":
                            if (campoBusqueda.equalsIgnoreCase(p.getNombre()) || p.getNombre().toUpperCase().startsWith(campoBusqueda)) {
                                limpiarTextArea();
                                textArea.append("NOMBRE: " + proveedoresList.get(0).getNombre() + "\n\n");
                                textArea.append("CODIGO: " + proveedoresList.get(0).getCodigo() + "\n\n");
                                textArea.append("APELLIDOS: " + proveedoresList.get(0).getApellidos() + "\n\n");
                                textArea.append("DIRECCIÓN: " + proveedoresList.get(0).getDireccion());
                                findSomething = true;
                                comboBox1.addItem(p.getNombre().toUpperCase());
                            }
                            break;
                        case "Direccion":
                            if (campoBusqueda.equalsIgnoreCase(p.getDireccion()) || p.getDireccion().toUpperCase().startsWith(campoBusqueda)) {
                                limpiarTextArea();
                                textArea.append("NOMBRE: " + proveedoresList.get(0).getNombre() + "\n\n");
                                textArea.append("CODIGO: " + proveedoresList.get(0).getCodigo() + "\n\n");
                                textArea.append("APELLIDOS: " + proveedoresList.get(0).getApellidos() + "\n\n");
                                textArea.append("DIRECCIÓN: " + proveedoresList.get(0).getDireccion());
                                findSomething = true;
                                comboBox1.addItem(p.getDireccion().toUpperCase());
                            }
                            break;
                    }
                }
                return findSomething;
            case "Piezas":
                comboBox1.removeAllItems();
                for (Piezas p : piezasList) {
                    switch (opcion) {
                        case "Codigo":
                            if (campoBusqueda.equalsIgnoreCase(p.getCodigo()) || p.getCodigo().toUpperCase().startsWith(campoBusqueda)) {
                                limpiarTextArea();
                                textArea.append("NOMBRE: " + piezasList.get(0).getNombre() + "\n\n");
                                textArea.append("CODIGO: " + piezasList.get(0).getCodigo() + "\n\n");
                                textArea.append("PRECIO: " + piezasList.get(0).getPrecio() + "\n\n");
                                textArea.append("DESCRIPCIÓN: " + piezasList.get(0).getDescripcion());
                                findSomething = true;
                                comboBox1.addItem(p.getCodigo().toUpperCase());
                            }
                            break;
                        case "Nombre":
                            if (campoBusqueda.equalsIgnoreCase(p.getNombre()) || p.getNombre().toUpperCase().startsWith(campoBusqueda)) {
                                limpiarTextArea();
                                textArea.append("NOMBRE: " + piezasList.get(0).getNombre() + "\n\n");
                                textArea.append("CODIGO: " + piezasList.get(0).getCodigo() + "\n\n");
                                textArea.append("PRECIO: " + piezasList.get(0).getPrecio() + "\n\n");
                                textArea.append("DESCRIPCIÓN: " + piezasList.get(0).getDescripcion());
                                findSomething = true;
                                comboBox1.addItem(p.getNombre().toUpperCase());
                            }
                            break;
                    }
                }
                return findSomething;
            case "Proyectos":
                comboBox1.removeAllItems();
                for (Proyectos p : proyectosList) {
                    switch (opcion) {
                        case "Codigo":
                            if (campoBusqueda.equalsIgnoreCase(p.getCodigo()) || p.getCodigo().toUpperCase().startsWith(campoBusqueda)) {
                                limpiarTextArea();
                                textArea.append("NOMBRE: " + proyectosList.get(0).getNombre() + "\n\n");
                                textArea.append("CODIGO: " + proyectosList.get(0).getCodigo() + "\n\n");
                                textArea.append("CIUDAD: " + proyectosList.get(0).getCiudad());
                                findSomething = true;
                                comboBox1.addItem(p.getCodigo().toUpperCase());
                            }
                            break;
                        case "Nombre":
                            if (campoBusqueda.equalsIgnoreCase(p.getNombre()) || p.getNombre().toUpperCase().startsWith(campoBusqueda)) {
                                limpiarTextArea();
                                textArea.append("NOMBRE: " + proyectosList.get(0).getNombre() + "\n\n");
                                textArea.append("CODIGO: " + proyectosList.get(0).getCodigo() + "\n\n");
                                textArea.append("CIUDAD: " + proyectosList.get(0).getCiudad());
                                findSomething = true;
                                comboBox1.addItem(p.getCodigo().toUpperCase());
                            }
                            break;
                        case "Ciudad": {
                            if (campoBusqueda.equalsIgnoreCase(p.getCiudad()) || p.getCiudad().toUpperCase().startsWith(campoBusqueda)) {
                                limpiarTextArea();
                                textArea.append("NOMBRE: " + proyectosList.get(0).getNombre() + "\n\n");
                                textArea.append("CODIGO: " + proyectosList.get(0).getCodigo() + "\n\n");
                                textArea.append("CIUDAD: " + proyectosList.get(0).getCiudad());
                                findSomething = true;
                                comboBox1.addItem(p.getCiudad().toUpperCase());
                            }
                            break;
                        }
                    }
                }
                return findSomething;
        }
        return findSomething;
    }
}
