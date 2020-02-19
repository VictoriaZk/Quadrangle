package by.epam.training.zhak.victoria.task1.entity;

import by.epam.training.zhak.victoria.task1.action.Calculator;

public class Line {

    private double coefficientK;
    private double coefficientB;
    private double length;
    private Point borderPointOne;
    private Point borderPointTwo;
    private Calculator calculator = new Calculator();

    public Line(Point firstPoint, Point secondPoint){
        this.borderPointOne = firstPoint;
        this.borderPointTwo = secondPoint;
        this.coefficientK = calculator.calculateCoefficientK(firstPoint,secondPoint);
        this.coefficientB = calculator.calculateCoefficientB(firstPoint,secondPoint);
        this.length = calculator.calculateSideLength(firstPoint,secondPoint);
    }

    public Point getBorderPointOne() {
        return borderPointOne;
    }

    public Point getBorderPointTwo() {
        return borderPointTwo;
    }

    public double getLength() {
        return length;
    }

    public double getCoefficientK() {
        return coefficientK;
    }

    public double getCoefficientB(){
        return coefficientB;
    }

}
