package com.geopagos.figuras.rest_figuras_geometricas.geometrics.REST;

import java.util.List;

import com.geopagos.figuras.rest_figuras_geometricas.Factory.DAOFactory;
import com.geopagos.figuras.rest_figuras_geometricas.Factory.Factory;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class Figures {
    @Autowired
    SessionFactory sessionFactory;

    @RequestMapping(value="/{figure}", method=POST)
    public ResponseEntity<Integer> regFigure(@PathVariable("figure") String figureType,@RequestParam(name="length",required = false) Double length,
    @RequestParam(name="base",required = false) Double base,@RequestParam(name="height",required = false) Double height,
                             @RequestParam(name="diameter",required = false) Double diameter) {
        try{
            DAOFactory dao = new DAOFactory(sessionFactory);
            Factory factory = new Factory();
            FigureDAO figureDAO = dao.getDAO(figureType);
            Figure figure = factory.getFigure(figureType);

            figure.setDiameter(diameter);
            figure.setBase(base);
            figure.setHeight(height);
            figure.setLength(length);
            return ResponseEntity.ok(figureDAO.saveEntity(figure));
        }catch(Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @RequestMapping(value="/{figure}", method=GET)
    public ResponseEntity<List<Figure>> getFigure(@PathVariable("figure") String figure) {
        try{
            DAOFactory dao = new DAOFactory(sessionFactory);
            FigureDAO figureDAO = dao.getDAO("Cuadrado");
            return ResponseEntity.ok(figureDAO.getEntities());
        }catch(Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @RequestMapping(value="/{figure}/{id}", method=GET)
    public ResponseEntity<Figure> getFigure(@PathVariable("id") Integer id,@PathVariable("figure") String figure) {
        try{
            DAOFactory dao = new DAOFactory(sessionFactory);
            FigureDAO figureDAO = dao.getDAO(figure);
            return ResponseEntity.ok(figureDAO.getEntityById(id));
        }catch(Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

}