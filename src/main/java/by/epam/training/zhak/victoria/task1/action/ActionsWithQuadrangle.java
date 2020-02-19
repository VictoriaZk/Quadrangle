package by.epam.training.zhak.victoria.task1.action;

import by.epam.training.zhak.victoria.task1.entity.Line;
import by.epam.training.zhak.victoria.task1.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class ActionsWithQuadrangle {
    private static final Logger LOGGER = LogManager.getLogger();

    public boolean arePointsCreateQuadrangle(List<Point>points){
        if( (points.get(0).getCoordinateX() - points.get(2).getCoordinateX())*
                (points.get(1).getCoordinateY() - points.get(2).getCoordinateY()) == (points.get(1).getCoordinateX() -
                points.get(2).getCoordinateX())*(points.get(0).getCoordinateY() - points.get(2).getCoordinateY())){
            LOGGER.info("Points don not create quadrangle");
            return false;
        }
        if( (points.get(0).getCoordinateX() - points.get(3).getCoordinateX())*
                (points.get(1).getCoordinateY() - points.get(3).getCoordinateY()) == (points.get(1).getCoordinateX() -
                points.get(3).getCoordinateX())*(points.get(0).getCoordinateY() - points.get(3).getCoordinateY())){
            LOGGER.info("Points don not create quadrangle");
            return false;
        }
        if ((points.get(0).getCoordinateX() - points.get(3).getCoordinateX())*
        (points.get(2).getCoordinateY() - points.get(3).getCoordinateY()) == (points.get(2).getCoordinateX() -
                points.get(3).getCoordinateX())*(points.get(0).getCoordinateY() - points.get(3).getCoordinateY())){
            LOGGER.info("Points don not create quadrangle");
            return false;
        }
        if ((points.get(1).getCoordinateX() - points.get(3).getCoordinateX())*
                (points.get(2).getCoordinateY() - points.get(3).getCoordinateY()) == (points.get(2).getCoordinateX() -
                points.get(3).getCoordinateX())*(points.get(1).getCoordinateY() - points.get(3).getCoordinateY())){
            LOGGER.info("Points don not create quadrangle");
            return false;
        }
        LOGGER.info("Points create quadrangle");
    return true;
    }

    public boolean checkIsQuadrangleTrapezium(List<Line> sides){
        if (sides.get(0).getCoefficientK() == sides.get(2).getCoefficientK() &&
        sides.get(1).getCoefficientK()!=sides.get(3).getCoefficientK() ||
                sides.get(0).getCoefficientK() != sides.get(2).getCoefficientK() &&
                        sides.get(1).getCoefficientK()==sides.get(3).getCoefficientK()){
            LOGGER.info("Quadrangle is a trapezium." );
            return true;
        }
        return false;
    }

    public boolean checkIsQuadrangleSquare(List<Line>sides, List<Line>diagonals){
        if(sides.get(0).getLength() == sides.get(1).getLength() &&
                (sides.get(0).getCoefficientK() == sides.get(2).getCoefficientK()) &&
                        (sides.get(1).getCoefficientK()==sides.get(3).getCoefficientK())){
            if (diagonals.get(0).getLength() == diagonals.get(1).getLength()){
            LOGGER.info("Quadrangle is square.");
            return true;
        }
          else{
              LOGGER.info("Quadrangle is rhombus.");
              return false;
        }
        }
        return false;
    }

    public boolean checkIsQuadrangleRhombus(List<Line>sides, List<Line>diagonals){
        return checkIsQuadrangleSquare(sides, diagonals);
    }
}
