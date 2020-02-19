package by.epam.training.zhak.victoria.task1.specification.find;

import by.epam.training.zhak.victoria.task1.entity.Quadrangle;
import by.epam.training.zhak.victoria.task1.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class FindById implements Specification <Quadrangle> {
    private static final Logger LOGGER = LogManager.getLogger();
    private long id;

    public FindById(long id){
        this.id = id;
    }

    @Override
    public boolean specified( Quadrangle quadrangle){
        if( id == quadrangle.getId()){
            LOGGER.info("FindById done!");
            return true;
        }
        LOGGER.info("FindById is not done!");
        return false;
    }
}
