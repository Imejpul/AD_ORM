package com.imejpul.vista;

import com.imejpul.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.swing.*;

public class VentanaPrincipal {
    private JPanel ventanaPpalJPanel;
    private JLabel iconLabel;
    private JMenu bbddMenu;
    private JMenu provMenu;
    private JMenu piezasMenu;
    private JMenu proyMenu;
    private JMenu gestGlobMenu;
    private JMenu Ayuda;
    private JMenu ayudaMenu;
    private static JFrame frame;

    public static void main(String[] args) {
        frame = new JFrame("Principal");
        frame.setContentPane(new VentanaPrincipal().ventanaPpalJPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public VentanaPrincipal() {

        ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("iconfinder_management_2799204.png"));
        iconLabel.setIcon(image);
        iconLabel.setText("");

        /*bbddMenu = new JMenu("BBDD");
        provMenu = new JMenu("Proveedores");
        piezasMenu = new JMenu("Piezas");
        proyMenu = new JMenu("Proyectos");
        gestGlobMenu = new JMenu("Gestion Global");
        ayudaMenu = new JMenu("Ayuda");

        //Proveedores
        JMenuItem gestionDeProveedores = new JMenuItem("Gestion de Proveedores");
        JMenu consultaDeProveedores = new JMenu("Consulta de Proveedores");

        JMenuItem porCodigoProveedores = new JMenuItem("Por Codigo");
        JMenuItem porNombreProveedores = new JMenuItem("Por Nombre");
        JMenuItem porDireccionProveedores = new JMenuItem("Por Direccion");
        consultaDeProveedores.add(porCodigoProveedores);
        consultaDeProveedores.add(porNombreProveedores);
        consultaDeProveedores.add(porDireccionProveedores);
        proveedores.add(gestionDeProveedores);
        proveedores.add(consultaDeProveedores);

        //Piezas
        JMenuItem gestionDePiezas = new JMenuItem("Gestion de Piezas");
        JMenu consultaDePiezas = new JMenu("Consulta de Piezas");
        JMenuItem porCodigoPiezas = new JMenuItem("Por Codigo");
        JMenuItem porNombrePiezas = new JMenuItem("Por Nombre");
        JMenuItem porPrecioPiezas = new JMenuItem("Por Precio");
        consultaDePiezas.add(porCodigoPiezas);
        consultaDePiezas.add(porNombrePiezas);
        consultaDePiezas.add(porPrecioPiezas);
        piezas.add(gestionDePiezas);
        piezas.add(consultaDePiezas);


        //Proyectos
        JMenuItem gestionDeProyectos = new JMenuItem("Gestion de Proyectos");
        JMenu consultaDeProyectos = new JMenu("Consulta de Proyectos");
        JMenuItem porCodigoProyecto = new JMenuItem("Por Codigo");
        JMenuItem porNombreProyecto = new JMenuItem("Por Nombre");
        JMenuItem porCiudadProyecto = new JMenuItem("Por Ciudad");
        consultaDeProyectos.add(porCodigoProyecto);
        consultaDeProyectos.add(porNombreProyecto);
        consultaDeProyectos.add(porCiudadProyecto);
        proyectos.add(gestionDeProyectos);
        proyectos.add(consultaDeProyectos);


        //Gestión Global
        JMenuItem piProProy = new JMenuItem("Piezas, Proveedores Proyectos");
        JMenuItem suministrosPorProveedor = new JMenuItem("Suministros por Proveedor");
        JMenuItem suministrosPorPiezas = new JMenuItem("Suministros por Piezas");
        JMenuItem estadisticas = new JMenuItem("Estadisticas");
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

        menuBar1.add(bbdd);
        menuBar1.add(proveedores);
        menuBar1.add(piezas);
        menuBar1.add(proyectos);
        menuBar1.add(gestionGlobal);
        menuBar1.add(ayuda);

        SessionFactory sesion = HibernateUtil.getSessionFactory();

        Session s = sesion.openSession();

        Piezas p = s.load(Piezas.class, "001");
        Proveedores pv = s.load(Proveedores.class, "p001");
        Proyectos pr = s.load(Proyectos.class, "pr001");

        GestionPK gestionPK = new GestionPK();

        gestionPK.setCodpieza(p.getCodigo());
        gestionPK.setCodproveedor(pv.getCodigo());
        gestionPK.setCodproyecto(pr.getCodigo());

        Gestion g = s.load(Gestion.class, gestionPK);

        System.out.println("Nombre Pieza: " + p.getNombre());
        System.out.println("Nombre Proveedor: " + pv.getNombre());
        System.out.println("Nombre Proyecto: " + pr.getNombre());
        System.out.println("Id Gestion: " + g.getId());*/
    }

}

