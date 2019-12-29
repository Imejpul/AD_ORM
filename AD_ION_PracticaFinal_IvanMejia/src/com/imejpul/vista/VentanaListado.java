package com.imejpul.vista;

import com.imejpul.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class VentanaListado {
    private JPanel ventanaListadoJpanel;
    private JTextField textFieldCod;
    private JTextField textFieldDirDesc;
    private JTextField textFieldNom;
    private JTextField textFieldApdsPriceCity;
    private JButton buttonAtrasInicio;
    private JButton buttonAtras;
    private JButton buttonAdelante;
    private JButton buttonAdelanteFin;
    private JLabel infoLabel;
    private JLabel codLabel;
    private JLabel nomLabel;
    private JLabel apdsPrecCityDescLabele;
    private JLabel dirDescLabel;
    private JLabel pagActLabel;
    private JLabel separatorLabel;
    private JLabel totPagLabel;

    private List<Proveedores> listaProv;
    private List<Piezas> listaPieces;
    private List<Proyectos> listaProy;
    private List<Gestion> listaGest;

    public VentanaListado(String opcion) {

        JFrame frame = new JFrame("Listado - " + opcion);
        frame.setContentPane(ventanaListadoJpanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        HibernateGestion gestion = new HibernateGestion();

        switch (opcion) {
            case "Proveedores":
                infoLabel.setText("Lista de " + opcion.toUpperCase());
                codLabel.setText("Codigo de Proveedor");
                nomLabel.setText("Nombre");
                apdsPrecCityDescLabele.setText("Apellidos");
                dirDescLabel.setText("Dirección");
                listaProv = new ArrayList<>();
                listaProv = gestion.loadAllData(Proveedores.class);
                cargarCampos(opcion, 0);
                break;
            case "Piezas":
                infoLabel.setText("Lista de " + opcion.toUpperCase());
                codLabel.setText("Código Pieza");
                nomLabel.setText("Nombre");
                apdsPrecCityDescLabele.setText("Precio");
                dirDescLabel.setText("Descripción");
                listaPieces = new ArrayList<>();
                listaPieces = gestion.loadAllData(Piezas.class);
                cargarCampos(opcion, 0);
                break;
            case "Proyectos":
                infoLabel.setText("Lista de " + opcion.toUpperCase());
                codLabel.setText("Código Proyecto");
                nomLabel.setText("Nombre");
                apdsPrecCityDescLabele.setText("Ciudad");
                dirDescLabel.setVisible(false);
                textFieldDirDesc.setVisible(false);
                listaProy = new ArrayList<>();
                listaProy = gestion.loadAllData(Proyectos.class);
                cargarCampos(opcion, 0);
                break;
            case "Gestion":
                infoLabel.setText("Lista de " + opcion.toUpperCase());
                codLabel.setText("Código Proveedor");
                nomLabel.setText("Código Pieza");
                apdsPrecCityDescLabele.setText("Código Proyecto");
                dirDescLabel.setText("Cantidad");
                listaGest = new ArrayList<>();
                listaGest = gestion.loadAllData(Gestion.class);
                cargarCampos(opcion, 0);
                break;
        }

        buttonAtrasInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cargarCampos(opcion, 0);
            }
        });
        buttonAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int index = obtenerIndexActual(opcion);
                if (index > 0) {
                    cargarCampos(opcion, index - 1);
                }
            }
        });
        buttonAdelante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int index = obtenerIndexActual(opcion);
                int indexTot;
                switch (opcion) {
                    case "Proveedores":
                        indexTot = listaProv.size();
                        break;
                    case "Piezas":
                        indexTot = listaPieces.size();
                        break;
                    case "Proyectos":
                        indexTot = listaProy.size();
                        break;
                    case "Gestion":
                        indexTot = listaGest.size();
                        break;
                    default:
                        indexTot = 0;
                        break;
                }
                if (index < indexTot - 1) {
                    cargarCampos(opcion, index + 1);
                }
            }
        });
        buttonAdelanteFin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int index;
                switch (opcion) {
                    case "Proveedores":
                        index = listaProv.size() - 1;
                        break;
                    case "Piezas":
                        index = listaPieces.size() - 1;
                        break;
                    case "Proyectos":
                        index = listaProy.size() - 1;
                        break;
                    case "Gestion":
                        index = listaGest.size() - 1;
                        break;
                    default:
                        index = 0;
                        break;
                }
                cargarCampos(opcion, index);
            }
        });
    }

    private void cargarCampos(String opcion, int index) {
        switch (opcion) {
            case "Proveedores":
                pagActLabel.setText(String.valueOf(index + 1));
                totPagLabel.setText(String.valueOf(listaProv.size()));

                Proveedores prov = listaProv.get(index);
                textFieldCod.setText(prov.getCodigo());
                textFieldNom.setText(prov.getNombre());
                textFieldApdsPriceCity.setText(prov.getApellidos());
                textFieldDirDesc.setText(prov.getDireccion());
                break;
            case "Piezas":
                pagActLabel.setText(String.valueOf(index + 1));
                totPagLabel.setText(String.valueOf(listaPieces.size()));

                Piezas piece = listaPieces.get(index);
                textFieldCod.setText(piece.getCodigo());
                textFieldNom.setText(piece.getNombre());
                textFieldApdsPriceCity.setText(String.valueOf(piece.getPrecio()));
                textFieldDirDesc.setText(piece.getDescripcion());
                break;
            case "Proyectos":
                pagActLabel.setText(String.valueOf(index + 1));
                totPagLabel.setText(String.valueOf(listaProy.size()));

                Proyectos proy = listaProy.get(index);
                textFieldCod.setText(proy.getCodigo());
                textFieldNom.setText(proy.getNombre());
                textFieldApdsPriceCity.setText(proy.getCiudad());
                break;
            case "Gestion":
                pagActLabel.setText(String.valueOf(index + 1));
                totPagLabel.setText(String.valueOf(listaGest.size()));

                Gestion gestion = listaGest.get(index);
                GestionPK gestionPK = gestion.getId();

                textFieldCod.setText(gestionPK.getCodproveedor());
                textFieldNom.setText(gestionPK.getCodpieza());
                textFieldApdsPriceCity.setText(gestionPK.getCodproyecto());
                textFieldDirDesc.setText(String.valueOf(gestion.getCantidad()));
                break;

        }
    }

    private int obtenerIndexActual(String opcion) {
        switch (opcion) {
            case "Proveedores":
                Proveedores prov = new Proveedores();
                prov.setCodigo(textFieldCod.getText());
                prov.setNombre(textFieldNom.getText());
                prov.setApellidos(textFieldApdsPriceCity.getText());
                prov.setDireccion(textFieldDirDesc.getText());
                for (Proveedores p : listaProv) {
                    if (p.equals(prov)) {
                        return listaProv.indexOf(p);
                    }
                }
            case "Piezas":
                Piezas piece = new Piezas();
                piece.setCodigo(textFieldCod.getText());
                piece.setNombre(textFieldNom.getText());
                piece.setPrecio(Double.parseDouble(textFieldApdsPriceCity.getText()));
                piece.setDescripcion(textFieldDirDesc.getText());
                for (Piezas p : listaPieces) {
                    if (p.equals(piece)) {
                        return listaPieces.indexOf(p);
                    }
                }
            case "Proyectos":
                Proyectos proy = new Proyectos();
                proy.setCodigo(textFieldCod.getText());
                proy.setNombre(textFieldNom.getText());
                proy.setCiudad(textFieldApdsPriceCity.getText());
                for (Proyectos p : listaProy) {
                    if (p.equals(proy)) {
                        return listaProy.indexOf(p);
                    }
                }
            case "Gestion":
                Gestion gestion = new Gestion();
                GestionPK gestionPK = new GestionPK();
                gestionPK.setCodproyecto(textFieldCod.getText());
                gestionPK.setCodpieza(textFieldNom.getText());
                gestionPK.setCodproyecto(textFieldApdsPriceCity.getText());
                gestion.setCantidad(Double.parseDouble(textFieldDirDesc.getText()));
                gestion.setId(gestionPK);
                for (Gestion g : listaGest) {
                    if (g.equals(gestion)) {
                        return listaGest.indexOf(g);
                    }
                }
        }
        return 0;
    }
}
