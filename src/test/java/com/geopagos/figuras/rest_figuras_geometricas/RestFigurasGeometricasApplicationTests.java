package com.geopagos.figuras.rest_figuras_geometricas;

import com.geopagos.figuras.rest_figuras_geometricas.Factory.BOFactory;
import com.geopagos.figuras.rest_figuras_geometricas.Factory.Factory;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.BO.FigureBO;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.VO.Circle;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.VO.Square;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.VO.Triangle;
import com.geopagos.figuras.rest_figuras_geometricas.geometrics.VO.Figure;
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
		Factory factory = new Factory();
		assertEquals(factory.getFigure("Circulo").getType(), "Circulo");
		assertEquals(factory.getFigure("Triangulo").getType(), "Triangulo");
		assertEquals(factory.getFigure("Cuadrado").getType(), "Cuadrado");
	}

	@Test
	public void circleCRUDTest(){
		BOFactory dao = new BOFactory(sessionFactory);
		FigureBO figureBO = dao.getDAO("Circulo");
		Figure figure = new Circle(5.5);

		Integer id = figureBO.saveEntity(figure);
		System.out.print(id);
		assertNotEquals(figureBO.getEntityById(id), null);
		assertEquals(figureBO.getEntityById(id).getDiameter(),figure.getDiameter(),0);
		assertNotEquals(figureBO.getEntities().size(),0);
	}

	@Test
	public void triangleCRUDTest(){
		BOFactory dao = new BOFactory(sessionFactory);
		FigureBO figureBO = dao.getDAO("Triangulo");
		Figure figure = new Triangle(5.5,5.5);

		Integer id = figureBO.saveEntity(figure);
		System.out.print(id);
		assertNotEquals(figureBO.getEntityById(id), null);
		assertEquals(figureBO.getEntityById(id).getHeight(),figure.getHeight(),0);
		assertEquals(figureBO.getEntityById(id).getBase(),figure.getBase(),0);
		assertNotEquals(figureBO.getEntities().size(),0);
	}

	@Test
	public void squareCRUDTest(){
		BOFactory dao = new BOFactory(sessionFactory);
		FigureBO figureBO = dao.getDAO("Cuadrado");
		Figure figure = new Square(5.5);

		Integer id = figureBO.saveEntity(figure);
		System.out.print(id);
		assertNotEquals(figureBO.getEntityById(id), null);
		assertEquals(figureBO.getEntityById(id).getHeight(),figure.getHeight(),0);
		assertEquals(figureBO.getEntityById(id).getBase(),figure.getBase(),0);
		assertNotEquals(figureBO.getEntities().size(),0);
	}

}
