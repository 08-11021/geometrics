package com.geopagos.figuras.rest_figuras_geometricas;

import java.util.List;

import com.geopagos.figuras.rest_figuras_geometricas.geometrics.DAO.CircleDAO;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.DAO.FigureDAO;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.DAO.SquareDAO;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.DAO.TriangleDAO;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.BO.Circle;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.BO.Square;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.BO.Triangle;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.BO.Figure;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class FiguresController {
    @Autowired
    SessionFactory sessionFactory;

    //POST METHODS
    @RequestMapping(value="/triangle", method=POST)
    public Integer regTriangle(@RequestParam(name="base", defaultValue="0.0") Double base, @RequestParam(name="height", defaultValue="5.0") Double height) {
        FigureDAO figureDAO = new TriangleDAO(this.sessionFactory);
        Figure figure = new Triangle(base,height);
        return figureDAO.saveEntity(figure);
    }

    @RequestMapping(value="/circle", method=POST)
    public Integer regCircle(@RequestParam(name="diameter", defaultValue="0.0") Double diameter) {
        FigureDAO figureDAO = new CircleDAO(this.sessionFactory);
        Figure figure = new Circle(diameter);
        return figureDAO.saveEntity(figure);
    }

    @RequestMapping(value="/square", method=POST)
    public Integer regSquare(@RequestParam(name="length", defaultValue="0.0") Double length) {
        FigureDAO figureDAO = new SquareDAO(this.sessionFactory);
        Figure figure = new Square(length);
        return figureDAO.saveEntity(figure);
    }

    //GET METHODS
    @RequestMapping(value="/circle", method=GET)
    public List<Figure> getCircle() {
        FigureDAO figureDAO = new CircleDAO(this.sessionFactory);
        return figureDAO.getEntities();
    }

    @RequestMapping(value="/triangle", method=GET)
    public List<Figure> getTriangle() {
        FigureDAO figureDAO = new TriangleDAO(this.sessionFactory);
        return figureDAO.getEntities();
    }

    @RequestMapping(value="/square", method=GET)
    public List<Figure> getSquare() {
        FigureDAO figureDAO = new SquareDAO(this.sessionFactory);
        return figureDAO.getEntities();
    }


    //GET by id METHODS
    @RequestMapping(value="/circle/{id}", method=GET)
    public Circle getCircle(@PathVariable("id") Integer id) {
        FigureDAO figureDAO = new CircleDAO(this.sessionFactory);
        return (Circle)figureDAO.getEntityById(id);
    }

    @RequestMapping(value="/triangle/{id}", method=GET)
    public Triangle getTriangle(@PathVariable("id") Integer id) {
        FigureDAO figureDAO = new TriangleDAO(this.sessionFactory);
        return (Triangle)figureDAO.getEntityById(id);
    }

    @RequestMapping(value="/square/{id}", method=GET)
    public Square getSquare(@PathVariable("id") Integer id) {
        FigureDAO figureDAO = new SquareDAO(this.sessionFactory);
        return (Square)figureDAO.getEntityById(id);
    }

}