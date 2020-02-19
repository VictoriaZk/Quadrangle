package by.epam.training.zhak.victoria.task1.specification.find;

import by.epam.training.zhak.victoria.task1.action.Calculator;
import by.epam.training.zhak.victoria.task1.entity.Quadrangle;
import by.epam.training.zhak.victoria.task1.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FindBySquare implements Specification <Quadrangle> {
    private static final Logger LOGGER = LogManager.getLogger();
    private double maxSquare;
    private double minSquare;
    Calculator calculator = new Calculator();

    public FindBySquare( double minSquare, double maxSquare ){
       this.maxSquare = maxSquare;
       this.minSquare = minSquare;
    }

    @Override
    public boolean specified(Quadrangle quadrangle){
        if(calculator.calculateSquareOfQuadrangle(quadrangle.getSides(), quadrangle.getDiagonals()) <=
                maxSquare && calculator.calculateSquareOfQuadrangle(quadrangle.getSides(), quadrangle.getDiagonals()) >=
                minSquare ){
            LOGGER.info("FindBySquare is done!");
            return true;
        }
        LOGGER.info("FindBySquare is not done!");
        return false;
    }
}
