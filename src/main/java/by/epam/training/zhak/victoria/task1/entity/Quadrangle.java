package by.epam.training.zhak.victoria.task1.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import by.epam.training.zhak.victoria.task1.generator.Generator;
import by.epam.training.zhak.victoria.task1.observer.Observable;
import by.epam.training.zhak.victoria.task1.observer.Observer;
import by.epam.training.zhak.victoria.task1.observer.QuadrangleEvent;

public class Quadrangle implements Observable <Observer> {
    private List<Point> points;
    private List<Line>sides;
    private List<Line>diagonals;
    private long id;
    private String name;
    private List<Observer> observers = new ArrayList<>();
    private Generator generator = new Generator();

    public Quadrangle(List<Point> points) {
        this.points = points;
    }

    public Quadrangle(Point firstPoint, Point secondPoint, Point thirdPoint, Point forthPoint){
        points = new ArrayList<>();
        this.points.add(firstPoint);
        this.points.add(secondPoint);
        this.points.add(thirdPoint);
        this.points.add(forthPoint);
        this.id = generator.generateId();
        this.name = id + "quadrangle";
        notifyObservers();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Point> getPoints() {
        return points;
    }

    public List<Line> getSides() {
        sides = new ArrayList<>();
        sides.add(new Line(points.get(0), points.get(1)));
        sides.add(new Line(points.get(1), points.get(2)));
        sides.add(new Line(points.get(2), points.get(3)));
        sides.add(new Line(points.get(3), points.get(0)));
        return sides;
    }

    public List<Line> getDiagonals() {
        diagonals = new ArrayList<>();
        diagonals.add(new Line(points.get(0), points.get(2)));
        diagonals.add(new Line(points.get(1), points.get(3)));
        return diagonals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quadrangle that = (Quadrangle) o;
        return points.equals(that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return "Quadrangle{" +
                "points=" + points +
                '}';
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
      observers.forEach( observer -> observer.handleEvent(new QuadrangleEvent(observer)));
    }
}
