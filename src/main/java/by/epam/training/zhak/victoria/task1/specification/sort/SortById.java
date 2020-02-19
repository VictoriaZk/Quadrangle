package by.epam.training.zhak.victoria.task1.specification.sort;

import by.epam.training.zhak.victoria.task1.entity.Quadrangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class SortById implements Comparator<Quadrangle> {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public int compare( Quadrangle quadrangleFirst, Quadrangle quadrangleSecond ){
        if (quadrangleFirst.getId() > quadrangleSecond.getId() ){
            LOGGER.info("Sorting by id is done: ");
            return 1;
        }
        else {
            if (quadrangleFirst.getId() < quadrangleSecond.getId()){
                LOGGER.info("Sorting by id is done: ");
                return -1;
            }
            else {
                LOGGER.info("Sorting by id is done: ");
                return 0;
            }
        }
    }
}
