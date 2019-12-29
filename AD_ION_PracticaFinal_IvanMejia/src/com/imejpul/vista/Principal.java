package com.imejpul.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal {

    public Principal() {
        JFrame frame = new JFrame("Principal");

        JLabel iconLabel = new JLabel();
        ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("iconfinder_management_2799204.png"));
        iconLabel.setIcon(image);
        iconLabel.setText("");

        JMenuBar menuBar = new JMenuBar();

        JMenu bbdd = new JMenu("BBDD");
        bbdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                System.out.println("BBDD");
            }
        });

        JMenu proveedores = new JMenu("Proveedores");
        JMenu piezas = new JMenu("Piezas");
        JMenu proyectos = new JMenu("Proyectos");
        JMenu gestionGlobal = new JMenu("Gestion Global");
        JMenu ayuda = new JMenu("Ayuda");

        //Proveedores
        JMenuItem gestionDeProveedores = new JMenuItem("Gestion de Proveedores");
        gestionDeProveedores.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                VentanaGestion vg = new VentanaGestion("Proveedores");
            }
        });

        JMenuItem listadoDeProveedores = new JMenuItem("Listado de Proveedores");
        listadoDeProveedores.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                VentanaListado vl = new VentanaListado("Proveedores");
            }
        });

        JMenu consultaDeProveedores = new JMenu("Consulta de Proveedores");

        JMenuItem porCodigoProveedores = new JMenuItem("Por Codigo");
        porCodigoProveedores.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                VentanaConsulta vc = new VentanaConsulta("Codigo", "Proveedores");
            }
        });
        JMenuItem porNombreProveedores = new JMenuItem("Por Nombre");
        porNombreProveedores.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                VentanaConsulta vc = new VentanaConsulta("Nombre", "Proveedores");
            }
        });
        JMenuItem porDireccionProveedores = new JMenuItem("Por Direccion");
        porDireccionProveedores.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                VentanaConsulta vc = new VentanaConsulta("Direccion", "Proveedores");
            }
        });
        consultaDeProveedores.add(porCodigoProveedores);
        consultaDeProveedores.add(porNombreProveedores);
        consultaDeProveedores.add(porDireccionProveedores);

        proveedores.add(gestionDeProveedores);
        proveedores.add(listadoDeProveedores);
        proveedores.add(consultaDeProveedores);

        //Piezas
        JMenuItem gestionDePiezas = new JMenuItem("Gestion de Piezas");
        gestionDePiezas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                VentanaGestion vg = new VentanaGestion("Piezas");
            }
        });

        JMenuItem listadoDePiezas = new JMenuItem("Listado de Piezas");
        listadoDePiezas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                VentanaListado vl = new VentanaListado("Piezas");
            }
        });

        JMenu consultaDePiezas = new JMenu("Consulta de Piezas");

        JMenuItem porCodigoPiezas = new JMenuItem("Por Codigo");
        porCodigoPiezas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                VentanaConsulta vc = new VentanaConsulta("Codigo", "Piezas");
            }
        });

        JMenuItem porNombrePiezas = new JMenuItem("Por Nombre");
        porNombrePiezas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                VentanaConsulta vc = new VentanaConsulta("Nombre", "Piezas");
            }
        });
        consultaDePiezas.add(porCodigoPiezas);
        consultaDePiezas.add(porNombrePiezas);
        piezas.add(gestionDePiezas);
        piezas.add(listadoDePiezas);
        piezas.add(consultaDePiezas);

        //Proyectos
        JMenuItem gestionDeProyectos = new JMenuItem("Gestion de Proyectos");
        gestionDeProyectos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                VentanaGestion vg = new VentanaGestion("Proyectos");
            }
        });

        JMenuItem listadoDeProyectos = new JMenuItem("Listado de Proyectos");
        listadoDeProyectos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                VentanaListado vl = new VentanaListado("Proyectos");
            }
        });

        JMenu consultaDeProyectos = new JMenu("Consulta de Proyectos");

        JMenuItem porCodigoProyecto = new JMenuItem("Por Codigo");
        porCodigoProyecto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                VentanaConsulta vc = new VentanaConsulta("Codigo", "Proyectos");
            }
        });

        JMenuItem porNombreProyecto = new JMenuItem("Por Nombre");
        porNombreProyecto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                VentanaConsulta vc = new VentanaConsulta("Nombre", "Proyectos");
            }
        });

        JMenuItem porCiudadProyecto = new JMenuItem("Por Ciudad");
        porCiudadProyecto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                VentanaConsulta vc = new VentanaConsulta("Ciudad", "Proyectos");
            }
        });
        consultaDeProyectos.add(porCodigoProyecto);
        consultaDeProyectos.add(porNombreProyecto);
        consultaDeProyectos.add(porCiudadProyecto);
        proyectos.add(gestionDeProyectos);
        proyectos.add(listadoDeProyectos);
        proyectos.add(consultaDeProyectos);


        //Gestión Global
        JMenuItem piProProy = new JMenuItem("Piezas, Proveedores Proyectos");
        piProProy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                VentanaPiezasProveedoresProyectos piezasProveedoresProyectos = new VentanaPiezasProveedoresProyectos();
            }
        });

        JMenuItem suministrosPorProveedor = new JMenuItem("Suministros por Proveedor");
        suministrosPorProveedor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                VentanaSuministrosProvedor suministrosProvedor = new VentanaSuministrosProvedor();
            }
        });

        JMenuItem suministrosPorPiezas = new JMenuItem("Suministros por Piezas");
        suministrosPorPiezas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                VentanaSuministroPiezas suministroPiezas = new VentanaSuministroPiezas();
            }
        });
        JMenuItem estadisticas = new JMenuItem("Estadisticas");
        estadisticas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                VentanaEstadisticas estadisticas = new VentanaEstadisticas();
            }
        });
        gestionGlobal.add(piProProy);
        gestionGlobal.add(suministrosPorProveedor);
        gestionGlobal.add(suministrosPorPiezas);
        gestionGlobal.add(estadisticas);

        //Ayuda
        JMenu acercaDe = new JMenu("Acerca de");
        JMenuItem info = new JMenuItem("Developed by imejpul");
        JMenuItem info2 = new JMenuItem("   3º DAM Nocturno");
        JMenuItem info3 = new JMenuItem("   Egibide - Arriaga");
        acercaDe.add(info);
        acercaDe.add(info2);
        acercaDe.add(info3);
        ayuda.add(acercaDe);

        menuBar.add(bbdd);
        menuBar.add(proveedores);
        menuBar.add(piezas);
        menuBar.add(proyectos);
        menuBar.add(gestionGlobal);
        menuBar.add(ayuda);

        //frame.setContentPane(new VentanaPrincipal().ventanaPpalJPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(600, 600);
        //frame.setResizable(false);
        //frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);

    }
}
