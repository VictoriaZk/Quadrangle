package by.epam.training.zhak.victoria.task1.specification.find;

import by.epam.training.zhak.victoria.task1.entity.Quadrangle;
import by.epam.training.zhak.victoria.task1.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class FindByCoordinateXY implements Specification<Quadrangle> {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final double COORDINATEX = 0;
    private static final double COORDINATEY = 0;

    /**
     *
     This method selects quadrangles that are located in the first quarter of the coordinate plane.
     * @param quadrangle
     * @return
     */
    public boolean specified(Quadrangle quadrangle){
        if (quadrangle.getPoints().stream().allMatch(point -> point.getCoordinateX() >= COORDINATEX)
        && quadrangle.getPoints().stream().allMatch(point -> point.getCoordinateY() >= COORDINATEY)){
            LOGGER.info("FindByCoordinateXY is done!");
            return true;
        }
        LOGGER.info("FindByCoordinateXY is not done!");
        return false;
    }
}
