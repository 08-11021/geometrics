package com.geopagos.figuras.rest_figuras_geometricas.geometrics.DAO;

import com.geopagos.figuras.rest_figuras_geometricas.geometrics.BO.Square;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.BO.Figure;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SquareDAO implements FigureDAO{
    SessionFactory sessionFactory;
    Session session;

    public SquareDAO(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Figure getEntityById(Integer id){
        this.session = sessionFactory.openSession();
        Transaction tx = null;
        Square result = null;
        try {

            tx = this.session.beginTransaction();
            result = (Square) session.get(Square.class, id);
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
    public Integer saveEntity(Figure square){
        this.session = sessionFactory.openSession();
        Transaction tx = null;
        Integer squareID = null;

        try {
            tx = this.session.beginTransaction();
            squareID = (Integer) session.save(square);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return squareID;
    }

    @Override
    public List<Figure> getEntities(){
        this.session = sessionFactory.openSession();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        List<Figure> result= new ArrayList<Figure>();
        try {

            tx = session.beginTransaction();
            List squares = session.createQuery("FROM Square").list();
            for (Iterator iterator = squares.iterator(); iterator.hasNext();){
                result.add((Square) iterator.next());
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
    public Boolean deleteEntity(Figure square){
        this.session = sessionFactory.openSession();
        Boolean result = false;
        Transaction tx = null;

        try {
            tx = this.session.beginTransaction();
            session.delete((Square) square);
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
