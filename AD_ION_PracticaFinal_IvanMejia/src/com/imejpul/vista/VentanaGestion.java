package com.imejpul.vista;

import com.imejpul.HibernateGestion;
import com.imejpul.Piezas;
import com.imejpul.Proveedores;
import com.imejpul.Proyectos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaGestion {

    private JPanel gestionJpanel;
    private JLabel CRUDLabel;
    private JTextField codTextField;
    private JTextField nomTextField;
    private JTextField apdsPriceCityTextField;
    private JTextField dirDescHiddenTextField;
    private JLabel codLabel;
    private JLabel nomLabel;
    private JLabel apdsPriceCityLabel;
    private JLabel dirDescHiddenLabel;
    private JButton limpiarButton;
    private JButton InsertarButton;
    private JButton ModificarButton;
    private JButton Eliminarbutton;

    private HibernateGestion gestion;

    public VentanaGestion(String opcion) {

        JFrame frame = new JFrame("Gestión - " + opcion);
        frame.setContentPane(gestionJpanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        gestion = new HibernateGestion();
        setFields(opcion);

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clearTextfields();
            }
        });
        InsertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (checkNotNullValues(opcion)) {
                    if(gestion.insertarTupla(getTextfieldsValues(opcion))){
                        JOptionPane.showMessageDialog(frame, "¡Tupla insertada con exito en " + opcion + "!");
                        clearTextfields();
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Error: Campos NOTNULL vacíos.");
                }
            }
        });
        ModificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (checkNotNullCode()) {
                    switch (opcion) {
                        case "Proveedores":
                            if(gestion.actualizarTuplaProv((Proveedores) getTextfieldsValues(opcion))){
                                JOptionPane.showMessageDialog(frame, "¡Tupla actualizada con exito en " + opcion + "!");
                                clearTextfields();
                            }
                            break;
                        case "Piezas":
                            if(gestion.actualizarTuplaPiece((Piezas) getTextfieldsValues(opcion))){
                                JOptionPane.showMessageDialog(frame, "¡Tupla actualizada con exito en " + opcion + "!");
                                clearTextfields();
                            }
                            break;
                        case "Proyectos":
                            if(gestion.actualizarTuplaProy((Proyectos) getTextfieldsValues(opcion))){
                                JOptionPane.showMessageDialog(frame, "¡Tupla actualizada con exito en " + opcion + "!");
                                clearTextfields();
                            }
                            break;
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Campos CODIGO vacío.");
                }

            }
        });
        Eliminarbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (checkNotNullCode()) {
                    switch (opcion) {
                        case "Proveedores":
                            if(gestion.eliminarTuplaProveedores(codTextField.getText())){
                                JOptionPane.showMessageDialog(frame, "¡Tupla elminada con exito en " + opcion + "!");
                                clearTextfields();
                            }
                            break;
                        case "Piezas":
                            if(gestion.eliminarTuplaPiezas(codTextField.getText())){
                                JOptionPane.showMessageDialog(frame, "¡Tupla elminada con exito en " + opcion + "!");
                                clearTextfields();
                            }
                            break;
                        case "Proyectos":
                            if(gestion.eliminarTuplaProyectos(codTextField.getText())){
                                JOptionPane.showMessageDialog(frame, "¡Tupla elminada con exito en " + opcion + "!");
                                clearTextfields();
                            }
                            break;
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Campos CODIGO vacío.");
                }
            }
        });
    }

    private void setFields(String opcion) {
        switch (opcion) {
            case "Proveedores":
                codLabel.setText("Código Proveedor");
                nomLabel.setText("Nombre");
                apdsPriceCityLabel.setText("Apellidos");
                dirDescHiddenLabel.setText("Dirección");
                break;
            case "Piezas":
                codLabel.setText("Código Pieza");
                nomLabel.setText("Nombre");
                apdsPriceCityLabel.setText("Precio");
                dirDescHiddenLabel.setText("Descripción");
                break;
            case "Proyectos":
                codLabel.setText("Código Proyecto");
                nomLabel.setText("Nombre");
                apdsPriceCityLabel.setText("Ciudad");
                dirDescHiddenLabel.setVisible(false);
                dirDescHiddenTextField.setVisible(false);
                break;
        }
    }

    private void clearTextfields() {
        codTextField.setText("");
        nomTextField.setText("");
        apdsPriceCityTextField.setText("");
        dirDescHiddenTextField.setText("");
    }

    private Object getTextfieldsValues(String opcion) {
        switch (opcion) {
            case "Proveedores":
                Proveedores p = new Proveedores();
                p.setCodigo(codTextField.getText());
                p.setNombre(nomTextField.getText());
                p.setApellidos(apdsPriceCityTextField.getText());
                p.setDireccion(dirDescHiddenTextField.getText());
                return p;
            case "Piezas":
                Piezas pce = new Piezas();
                pce.setCodigo(codTextField.getText());
                pce.setNombre(nomTextField.getText());
                if (!apdsPriceCityTextField.getText().equalsIgnoreCase("")) {
                    pce.setPrecio(Double.parseDouble(apdsPriceCityTextField.getText()));
                }
                pce.setDescripcion(dirDescHiddenTextField.getText());
                return pce;
            case "Proyectos":
                Proyectos pry = new Proyectos();
                pry.setCodigo(codTextField.getText());
                pry.setNombre(nomTextField.getText());
                pry.setCiudad(apdsPriceCityTextField.getText());
                return pry;
        }
        return null;
    }

    private boolean checkNotNullValues(String opcion) {
        switch (opcion) {
            case "Proveedores":
                return !codTextField.getText().equalsIgnoreCase("") &&
                        !nomTextField.getText().equalsIgnoreCase("") &&
                        !apdsPriceCityTextField.getText().equalsIgnoreCase("") &&
                        !dirDescHiddenTextField.getText().equalsIgnoreCase("");
            case "Piezas":
                return !codTextField.getText().equalsIgnoreCase("") &&
                        !nomTextField.getText().equalsIgnoreCase("") &&
                        !apdsPriceCityTextField.getText().equalsIgnoreCase("");
            case "Proyectos":
                return !codTextField.getText().equalsIgnoreCase("") &&
                        !nomTextField.getText().equalsIgnoreCase("");
        }
        return false;
    }

    private boolean checkNotNullCode() {
        return !codTextField.getText().equalsIgnoreCase("");
    }
}
