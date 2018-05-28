package com.geopagos.figuras.rest_figuras_geometricas.geometrics.BO;

import com.geopagos.figuras.rest_figuras_geometricas.geometrics.VO.Circle;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.VO.Figure;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CircleBO implements FigureBO {
    private SessionFactory sessionFactory;
    Session session;

    public CircleBO(){

    }

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Figure getEntityById(Integer id){
        this.session = sessionFactory.openSession();
        Transaction tx = null;
        Circle result = null;
        System.out.print(id);
        try {

            tx = this.session.beginTransaction();
            result = (Circle) this.session.get(Circle.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            this.session.close();
            return result;
        }
    }

    @Override
    public Integer saveEntity(Figure circle){
        this.session = sessionFactory.openSession();
        Transaction tx = null;
        Integer circleID = null;

        try {
            tx = this.session.beginTransaction();
            circleID = (Integer) this.session.save((Circle) circle);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            this.session.close();
        }
        return circleID;
    }

    @Override
    public List<Figure> getEntities(){
        this.session = sessionFactory.openSession();
        Transaction tx = null;
        List<Figure> result= new ArrayList<Figure>();
        try {

            tx = this.session.beginTransaction();
            List circles = session.createQuery("FROM Circle").list();
            for (Iterator iterator = circles.iterator(); iterator.hasNext();){
                result.add((Circle) iterator.next());
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
    public Boolean deleteEntity(Figure circle){
        this.session = sessionFactory.openSession();
        Boolean result = false;
        Transaction tx = null;

        try {
            tx = this.session.beginTransaction();
            session.delete((Circle) circle);
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
