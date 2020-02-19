package by.epam.training.zhak.victoria.task1.entity;

import by.epam.training.zhak.victoria.task1.action.Calculator;
import by.epam.training.zhak.victoria.task1.observer.Observer;
import by.epam.training.zhak.victoria.task1.observer.QuadrangleEvent;

public class Warehouse implements Observer {
        private long id;
        private double perimeter;
        private double square;
        private Calculator calculator = new Calculator();

        public long getId() {
            return id;
        }

        public double getPerimeter() {
            return perimeter;
        }

        public double getSquare() {
            return square;
        }

        public void handleEvent(QuadrangleEvent quadrangleEvent){
            Quadrangle quadrangle = quadrangleEvent.getQuadrangle();
            id = quadrangle.getId();
            perimeter = calculator.calculatePerimeterOfQuadrangle(quadrangle.getSides());
            square = calculator.calculateSquareOfQuadrangle(quadrangle.getSides(), quadrangle.getDiagonals());
        }
    }
