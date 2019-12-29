package com.imejpul.vista;

import com.imejpul.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class VentanaSuministrosProvedor {
    private JPanel ventanaSumProvJpanel;
    private JComboBox comboBox1;
    private JTextField textFieldNomProv;
    private JTextField textFieldApdsProv;
    private JTextField textFieldDirProv;
    private JTextField textFieldPiezasSum;
    private JTextField textFieldProyectos;
    private JButton ButtonVerPieceSum;
    private JLabel ProvLabel;
    private JLabel piezasSumLabel;
    private JLabel proyectosLabel;

    private List<Gestion> gestionList;
    private List<Proveedores> proveedoresList;
    private List<Piezas> piezasList;
    private List<Proyectos> proyectosList;

    public VentanaSuministrosProvedor() {

        JFrame frame = new JFrame("Suministros por PROVEEDOR ");
        frame.setContentPane(ventanaSumProvJpanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        comboBox1.addItem("Elije un CODIGO");

        HibernateGestion gestion = new HibernateGestion();

        String cantPiezas = "";

        //GESTION
        gestionList = new ArrayList<>();
        gestionList = gestion.loadAllData(Gestion.class);

        for (Gestion g : gestionList) {
            GestionPK gestionPK = g.getId();
            comboBox1.addItem(gestionPK.getCodproveedor());
        }

        //PROVEEDORES
        proveedoresList = new ArrayList<>();
        proveedoresList = gestion.loadAllData(Proveedores.class);

        //PIEZAS
        piezasList = new ArrayList<>();
        piezasList = gestion.loadAllData(Piezas.class);

        //PROYECTOS
        proyectosList = new ArrayList<>();
        proyectosList = gestion.loadAllData(Proyectos.class);

        //LISTENERS

        ButtonVerPieceSum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String codigo = comboBox1.getSelectedItem().toString();
                cargarCamposProveedor(codigo);
                int cantProy = 0;

                //obtener codigo pieza desde GESTION
                for (Gestion g : gestionList) {
                    GestionPK gestionPK = g.getId();

                    if (gestionPK.getCodproveedor().equalsIgnoreCase(codigo)) {
                        textFieldPiezasSum.setText(String.valueOf(g.getCantidad()));
                        cantProy++;
                    }
                }
                textFieldProyectos.setText(String.valueOf(cantProy));

            }
        });
    }

    private void cargarCamposProveedor(String codigo) {
        for (Proveedores p : proveedoresList) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                textFieldNomProv.setText(p.getNombre());
                textFieldApdsProv.setText(p.getApellidos());
                textFieldDirProv.setText(p.getDireccion());
            }
        }
    }
}
