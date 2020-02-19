package by.epam.training.zhak.victoria.task1.specification.sort;

import by.epam.training.zhak.victoria.task1.entity.Quadrangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Comparator;

public class SortByName implements Comparator <Quadrangle> {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public int compare (Quadrangle quadrangleFirst, Quadrangle quadrangleSecond){
        if (quadrangleFirst.getName().charAt(0) > quadrangleSecond.getName().charAt(0)){
            LOGGER.info("Sorting by name is done: ");
            return 1;
        }
        else {
            if(quadrangleFirst.getName().charAt(0) < quadrangleSecond.getName().charAt(0)){
                LOGGER.info("Sorting by name is done: ");
                return -1;
            }
            else{
                LOGGER.info("Sorting by name is done: ");
                return 0;
            }
        }
    }
}
