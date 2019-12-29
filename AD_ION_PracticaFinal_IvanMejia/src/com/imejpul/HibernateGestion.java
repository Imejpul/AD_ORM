package com.imejpul;

import org.hibernate.*;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.swing.*;
import java.util.List;

public class HibernateGestion {

    private SessionFactory sesionFactory;
    private Session session;
    private Transaction tx;

    public <T> List<T> loadAllData(Class<T> type) {
        obtenerSessionFactory_Session();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);
        criteria.from(type);
        return session.createQuery(criteria).getResultList();
    }

    public boolean insertarTupla(Object o) {
        obtenerSessionFactory_Session();
        tx = session.beginTransaction();
        try {
            session.save(o);
            try {
                tx.commit();
                return true;
            } catch (ConstraintViolationException e) {
                System.out.printf("MENSAJE:%s%n", e.getMessage());
                System.out.printf("COD ERROR:%d%n", e.getErrorCode());
                System.out.printf("ERROR SQL:%s%n", e.getSQLException().getMessage());
            }

        } catch (TransientPropertyValueException e) {
            System.out.printf("MENSAJE:%s%n", e.getMessage());
            System.out.printf("Propiedad:%s%n", e.getPropertyName());
        }
        session.close();
        return false;
    }

    public boolean insertarTuplaGesion(String codProv, String codPieza, String codProy, Double cantidad) {
        obtenerSessionFactory_Session();
        tx = session.beginTransaction();

        Piezas p = session.load(Piezas.class, codPieza);
        Proveedores pv = session.load(Proveedores.class, codProv);
        Proyectos pr = session.load(Proyectos.class, codProy);

        GestionPK gestionPK = new GestionPK();

        gestionPK.setCodpieza(p.getCodigo());
        gestionPK.setCodproveedor(pv.getCodigo());
        gestionPK.setCodproyecto(pr.getCodigo());

        Gestion o = new Gestion();
        o.setId(gestionPK);
        o.setCantidad(cantidad);

        try {
            session.save(o);
            try {
                tx.commit();
                return true;
            } catch (ConstraintViolationException e) {
                System.out.printf("MENSAJE:%s%n", e.getMessage());
                System.out.printf("COD ERROR:%d%n", e.getErrorCode());
                System.out.printf("ERROR SQL:%s%n", e.getSQLException().getMessage());
            }
        } catch (TransientPropertyValueException e) {
            System.out.printf("MENSAJE:%s%n", e.getMessage());
            System.out.printf("Propiedad:%s%n", e.getPropertyName());
        }
        session.close();
        return false;
    }

    public boolean actualizarTuplaProv(Proveedores p) {
        obtenerSessionFactory_Session();
        tx = session.beginTransaction();
        Proveedores proveedor;
        try {
            proveedor = session.load(Proveedores.class, p.getCodigo());
            if (!p.getNombre().equalsIgnoreCase("")) {
                proveedor.setNombre(p.getNombre());
            }
            if (!p.getApellidos().equalsIgnoreCase("")) {
                proveedor.setApellidos(p.getApellidos());
            }
            if (!p.getDireccion().equalsIgnoreCase("")) {
                proveedor.setDireccion(p.getDireccion());
            }
            session.update(proveedor); //modifica el objeto
            tx.commit();
            return true;

        } catch (ConstraintViolationException c) {
            System.out.printf("MENSAJE:%s%n", c.getMessage());
            System.out.printf("COD ERROR:%d%n", c.getErrorCode());
            System.out.printf("ERROR SQL:%s%n", c.getSQLException().getMessage());
        } catch (Exception o) {
            System.out.printf("MENSAJE:%s%n", o.getMessage());
        }
        session.close();
        return false;
    }

    public boolean actualizarTuplaPiece(Piezas p) {
        obtenerSessionFactory_Session();
        tx = session.beginTransaction();
        Piezas pieza;
        try {
            pieza = session.load(Piezas.class, p.getCodigo());
            if (!p.getNombre().equalsIgnoreCase("")) {
                pieza.setNombre(p.getNombre());
            }
            if (!String.valueOf(p.getPrecio()).equalsIgnoreCase("")) {
                pieza.setPrecio(p.getPrecio());
            }
            if (!p.getDescripcion().equalsIgnoreCase("")) {
                pieza.setDescripcion(p.getDescripcion());
            }
            session.update(pieza); //modifica el objeto
            tx.commit();
            return true;

        } catch (ConstraintViolationException c) {
            System.out.printf("MENSAJE:%s%n", c.getMessage());
            System.out.printf("COD ERROR:%d%n", c.getErrorCode());
            System.out.printf("ERROR SQL:%s%n", c.getSQLException().getMessage());
        } catch (Exception o) {
            System.out.printf("MENSAJE:%s%n", o.getMessage());
        }
        session.close();
        return false;
    }

    public boolean actualizarTuplaProy(Proyectos p) {
        obtenerSessionFactory_Session();
        tx = session.beginTransaction();
        Proyectos proyecto;
        try {
            proyecto = session.load(Proyectos.class, p.getCodigo());
            if (!p.getNombre().equalsIgnoreCase("")) {
                proyecto.setNombre(p.getNombre());
            }
            if (!p.getCiudad().equalsIgnoreCase("")) {
                proyecto.setCiudad(p.getCiudad());
            }
            session.update(proyecto); //modifica el objeto
            tx.commit();
            return true;

        } catch (ConstraintViolationException c) {
            System.out.printf("MENSAJE:%s%n", c.getMessage());
            System.out.printf("COD ERROR:%d%n", c.getErrorCode());
            System.out.printf("ERROR SQL:%s%n", c.getSQLException().getMessage());
        } catch (Exception o) {
            System.out.printf("MENSAJE:%s%n", o.getMessage());
        }
        session.close();
        return false;
    }

    public boolean actualizarTuplaGestion(String codProv, String codPieza, String codProy, Double cant) {
        obtenerSessionFactory_Session();
        tx = session.beginTransaction();

        Piezas p = session.load(Piezas.class, codPieza);
        Proveedores pv = session.load(Proveedores.class, codProv);
        Proyectos pr = session.load(Proyectos.class, codProy);

        GestionPK gestionPK = new GestionPK();

        gestionPK.setCodpieza(p.getCodigo());
        gestionPK.setCodproveedor(pv.getCodigo());
        gestionPK.setCodproyecto(pr.getCodigo());

        Gestion gestion;

        try {
            gestion = session.load(Gestion.class, gestionPK);
            gestion.setCantidad(cant);
            session.update(gestion); //modifica el objeto
            tx.commit();
            return true;

        } catch (ObjectNotFoundException o) {
            System.out.printf("MENSAJE:%s%n", o.getMessage());
        } catch (ConstraintViolationException c) {
            System.out.printf("MENSAJE:%s%n", c.getMessage());
            System.out.printf("COD ERROR:%d%n", c.getErrorCode());
            System.out.printf("ERROR SQL:%s%n", c.getSQLException().getMessage());
        } catch (Exception e) {
            System.out.printf("MENSAJE:%s%n", e.getMessage());
            e.printStackTrace();
        }
        session.close();
        return false;
    }

    public boolean eliminarTuplaProveedores(String codigo) {
        obtenerSessionFactory_Session();
        tx = session.beginTransaction();

        Proveedores proveedores = session.load(Proveedores.class, codigo);
        try {
            session.delete(proveedores);
            tx.commit();
            return true;
        } catch (ConstraintViolationException c) {
            System.out.printf("MENSAJE:%s%n", c.getMessage());
            System.out.printf("COD ERROR:%d%n", c.getErrorCode());
            System.out.printf("ERROR SQL:%s%n", c.getSQLException().getMessage());
        } catch (Exception o) {
            System.out.printf("MENSAJE:%s%n", o.getMessage());
        }
        session.close();
        return false;
    }

    public boolean eliminarTuplaPiezas(String codigo) {
        obtenerSessionFactory_Session();
        tx = session.beginTransaction();

        Piezas pieza = session.load(Piezas.class, codigo);
        try {
            session.delete(pieza);
            tx.commit();
            return true;
        } catch (ConstraintViolationException c) {
            System.out.printf("MENSAJE:%s%n", c.getMessage());
            System.out.printf("COD ERROR:%d%n", c.getErrorCode());
            System.out.printf("ERROR SQL:%s%n", c.getSQLException().getMessage());
        } catch (Exception o) {
            System.out.printf("MENSAJE:%s%n", o.getMessage());
        }
        session.close();
        return false;
    }

    public boolean eliminarTuplaProyectos(String codigo) {
        obtenerSessionFactory_Session();
        tx = session.beginTransaction();

        Proyectos proyecto = session.load(Proyectos.class, codigo);
        try {
            session.delete(proyecto);
            tx.commit();
            return true;
        } catch (ObjectNotFoundException o) {
            System.out.printf("MENSAJE:%s%n", o.getMessage());
        } catch (ConstraintViolationException c) {
            System.out.printf("MENSAJE:%s%n", c.getMessage());
            System.out.printf("COD ERROR:%d%n", c.getErrorCode());
            System.out.printf("ERROR SQL:%s%n", c.getSQLException().getMessage());
        } catch (Exception e) {
            System.out.printf("MENSAJE:%s%n", e.getMessage());
            e.printStackTrace();
        }
        session.close();
        return false;
    }

    public boolean eliminarTuplaGestion(String codProv, String codPieza, String codProy) {
        obtenerSessionFactory_Session();
        tx = session.beginTransaction();

        Piezas p = session.load(Piezas.class, codPieza);
        Proveedores pv = session.load(Proveedores.class, codProv);
        Proyectos pr = session.load(Proyectos.class, codProy);

        GestionPK gestionPK = new GestionPK();

        gestionPK.setCodpieza(p.getCodigo());
        gestionPK.setCodproveedor(pv.getCodigo());
        gestionPK.setCodproyecto(pr.getCodigo());

        Gestion gestion = session.load(Gestion.class, gestionPK);
        try {
            session.delete(gestion);
            tx.commit();
            return true;
        } catch (ObjectNotFoundException o) {
            System.out.printf("MENSAJE:%s%n", o.getMessage());
        } catch (ConstraintViolationException c) {
            System.out.printf("MENSAJE:%s%n", c.getMessage());
            System.out.printf("COD ERROR:%d%n", c.getErrorCode());
            System.out.printf("ERROR SQL:%s%n", c.getSQLException().getMessage());
        } catch (Exception e) {
            System.out.printf("MENSAJE:%s%n", e.getMessage());
            e.printStackTrace();
        }
        session.close();
        return false;
    }

    public Object consultarTupla(String codigo) {
        obtenerSessionFactory_Session();
        //TODO: LOAD OBJETO
        /*Piezas p = session.load(Piezas.class, "001");
        Proveedores pv = session.load(Proveedores.class, "p001");
        Proyectos pr = session.load(Proyectos.class, "pr001");*/
        return new Object();
    }

    public Gestion consultarTuplaGestion(String codProv, String codPieza, String codProy) {
        obtenerSessionFactory_Session();

        GestionPK gestionPK = new GestionPK();

        gestionPK.setCodpieza(codProv);
        gestionPK.setCodproveedor(codPieza);
        gestionPK.setCodproyecto(codProy);

        Gestion g = session.load(Gestion.class, gestionPK);
        return g;
    }

    public void obtenerSessionFactory_Session() {
        sesionFactory = HibernateUtil.getSessionFactory();
        session = sesionFactory.openSession();
    }


}
