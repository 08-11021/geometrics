package com.geopagos.figuras.rest_figuras_geometricas.geometrics.DAO;

import com.geopagos.figuras.rest_figuras_geometricas.geometrics.BO.Triangle;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.BO.Figure;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TriangleDAO implements FigureDAO{
    SessionFactory sessionFactory;
    Session session;

    public TriangleDAO(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Figure getEntityById(Integer id){
        this.session = sessionFactory.openSession();
        Transaction tx = null;
        Triangle result = null;
        try {

            tx = this.session.beginTransaction();
            result = (Triangle) session.get(Triangle.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            return result;
        }
    }

    @Override
    public Integer saveEntity(Figure triangle){
        this.session = this.sessionFactory.openSession();
        Transaction tx = null;
        Integer triangleID = null;

        try {
            tx = this.session.beginTransaction();
            triangleID = (Integer) this.session.save((Triangle) triangle);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            this.session.close();
        }
        return triangleID;
    }

    @Override
    public List<Figure> getEntities(){
        this.session = sessionFactory.openSession();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        List<Figure> result= new ArrayList<Figure>();
        try {

            tx = session.beginTransaction();
            List triangles = session.createQuery("FROM Triangle").list();
            for (Iterator iterator = triangles.iterator(); iterator.hasNext();){
                result.add((Triangle) iterator.next());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            return result;
        }
    }

    @Override
    public Boolean deleteEntity(Figure triangle){
        this.session = sessionFactory.openSession();
        Boolean result = false;
        Transaction tx = null;

        try {
            tx = this.session.beginTransaction();
            session.delete((Triangle) triangle);
            tx.commit();
            result = true;
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

}

