package com.geopagos.figuras.rest_figuras_geometricas;

import com.geopagos.figuras.rest_figuras_geometricas.Factory.Factory;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.DAO.CircleDAO;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.DAO.FigureDAO;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.DAO.SquareDAO;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.DAO.TriangleDAO;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.BO.Circle;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.BO.Square;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.BO.Triangle;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.BO.Figure;
import org.hibernate.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestFigurasGeometricasApplicationTests {
	@Autowired
	SessionFactory sessionFactory;

	@Test
	public void circleTest() {
		Double diameter = 10.0;
		Figure circulo = new Circle(diameter);
		Double area = 3.14 * diameter/2 * diameter/2;
		Double base = null;
		Double height = null;

		// assert statements
		assertEquals(circulo.getArea(), area);
		assertEquals(circulo.getDiameter(), diameter);
		assertEquals(circulo.getBase(), null);
		assertEquals(circulo.getHeight(), null);
		assertEquals(circulo.getType(), "Circulo");
	}

	@Test
	public void squareTest() {
		Double diameter = null;
		Double length = 10.0;
		Figure square = new Square(length);
		Double area = length*length;

		// assert statements
		assertEquals(square.getArea(), area);
		assertEquals(square.getDiameter(), null);
		assertEquals(square.getBase(), length);
		assertEquals(square.getHeight(), length);
		assertEquals(square.getType(), "Cuadrado");
	}

	@Test
	public void triangleTest() {
		Double diameter = null;
		Double base = 10.0;
		Double height = 5.0;
		Figure triangle = new Triangle(base, height);
		Double area = (base*height)/2;

		// assert statements
		assertEquals(triangle.getArea(), area);
		assertEquals(triangle.getDiameter(), null);
		assertEquals(triangle.getBase(), base);
		assertEquals(triangle.getHeight(), height);
		assertEquals(triangle.getType(), "Triangulo");
	}

	@Test
	public void factoryTest() {
		Factory factory = new Factory("Circulo");
		assertEquals(factory.getFigure().getType(), "Circulo");

		factory = new Factory("Triangulo");
		assertEquals(factory.getFigure().getType(), "Triangulo");

		factory = new Factory("Cuadrado");
		assertEquals(factory.getFigure().getType(), "Cuadrado");
	}

	@Test
	public void circleCRUDTest(){

		FigureDAO figureDAO = new CircleDAO(this.sessionFactory);
		Figure figure = new Circle(5.5);

		Integer id = figureDAO.saveEntity(figure);
		System.out.print(id);
		assertNotEquals(figureDAO.getEntityById(id), null);
		assertEquals(figureDAO.getEntityById(id).getDiameter(),figure.getDiameter(),0);
		assertNotEquals(figureDAO.getEntities().size(),0);
	}

	@Test
	public void triangleCRUDTest(){

		FigureDAO figureDAO = new TriangleDAO(this.sessionFactory);
		Figure figure = new Triangle(5.5,5.5);

		Integer id = figureDAO.saveEntity(figure);
		System.out.print(id);
		assertNotEquals(figureDAO.getEntityById(id), null);
		assertEquals(figureDAO.getEntityById(id).getHeight(),figure.getHeight(),0);
		assertEquals(figureDAO.getEntityById(id).getBase(),figure.getBase(),0);
		assertNotEquals(figureDAO.getEntities().size(),0);
	}

	@Test
	public void squareCRUDTest(){

		FigureDAO figureDAO = new SquareDAO(this.sessionFactory);
		Figure figure = new Square(5.5);

		Integer id = figureDAO.saveEntity(figure);
		System.out.print(id);
		assertNotEquals(figureDAO.getEntityById(id), null);
		assertEquals(figureDAO.getEntityById(id).getHeight(),figure.getHeight(),0);
		assertEquals(figureDAO.getEntityById(id).getBase(),figure.getBase(),0);
		assertNotEquals(figureDAO.getEntities().size(),0);
	}

}
