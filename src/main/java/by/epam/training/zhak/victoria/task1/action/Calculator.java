package by.epam.training.zhak.victoria.task1.action;

import by.epam.training.zhak.victoria.task1.entity.Line;
import by.epam.training.zhak.victoria.task1.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class Calculator {
    private static final Logger LOGGER = LogManager.getLogger();

    public double calculateCoefficientB(Point firstPoint, Point secondPoint){
        if(firstPoint.getCoordinateX() == secondPoint.getCoordinateX()){
            return 0;
        }
        if(firstPoint.getCoordinateY() == secondPoint.getCoordinateY()){
            return firstPoint.getCoordinateY();
        }
        return ((firstPoint.getCoordinateX()*secondPoint.getCoordinateY()
                - secondPoint.getCoordinateX()*firstPoint.getCoordinateY())/
                (firstPoint.getCoordinateX() - secondPoint.getCoordinateX()));
    }

    public double calculateCoefficientK(Point firstPoint, Point secondPoint){
        if(firstPoint.getCoordinateX() == secondPoint.getCoordinateX()){
            return 1;
        }
        if(firstPoint.getCoordinateY() == secondPoint.getCoordinateY()){
            return 0;
        }
        return ((secondPoint.getCoordinateY() - firstPoint.getCoordinateY())/
                (secondPoint.getCoordinateX() - firstPoint.getCoordinateX()));
    }

    public double calculateSideLength(Point firstPoint, Point secondPoint){
        return Math.sqrt(Math.pow(secondPoint.getCoordinateX() - firstPoint.getCoordinateX(),2)
                + Math.pow(secondPoint.getCoordinateY()-firstPoint.getCoordinateY(),2));
    }

    public double calculatePerimeterOfQuadrangle(List<Line> sides) {
        double perimeterOfQuadrangle = 0;
        for (Line side : sides) {
            perimeterOfQuadrangle +=side.getLength();
        }
        LOGGER.info( "Quadrangle perimeter is " + perimeterOfQuadrangle);
        return perimeterOfQuadrangle;
    }

    public double calculateSquareOfQuadrangle( List <Line> sides, List<Line> diagonals){
        double squareOfQuadrangle;
        ActionsWithQuadrangle actionsWithQuadrangle = new ActionsWithQuadrangle();
        if( actionsWithQuadrangle.checkIsQuadrangleSquare(sides, diagonals)){
            squareOfQuadrangle = sides.get(0).getLength()*4;
        }
        else {
            squareOfQuadrangle = calculateSquareOfTriangle(sides.get(0), diagonals.get(0),
                    calculateTangentOfAngleBetweenTwoLines(sides.get(0), diagonals.get(0))) +
                    calculateSquareOfTriangle(sides.get(3), diagonals.get(0),
                            calculateTangentOfAngleBetweenTwoLines(sides.get(0), diagonals.get(0)));
        }
        LOGGER.info( "Quadrangle square is " + squareOfQuadrangle);
        return squareOfQuadrangle;
    }

    public double calculateTangentOfAngleBetweenTwoLines(Line firstLine, Line secondLine){
        return Math.abs((secondLine.getCoefficientK()-firstLine.getCoefficientK()) /
                (1 + firstLine.getCoefficientK()*secondLine.getCoefficientK()));
    }

    public double calculateSquareOfTriangle( Line firstLine, Line secondLine, double tangent){
        double sin = Math.sqrt((Math.pow(tangent,2))/(1+Math.pow(tangent ,2)));
        return 0.5*firstLine.getLength()*secondLine.getLength()*sin;
    }

}
