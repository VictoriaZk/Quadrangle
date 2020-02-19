package by.epam.training.zhak.victoria.task1.specification.find;


import by.epam.training.zhak.victoria.task1.action.Calculator;
import by.epam.training.zhak.victoria.task1.entity.Quadrangle;
import by.epam.training.zhak.victoria.task1.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FindByPerimeter implements Specification <Quadrangle> {
    private static final Logger LOGGER = LogManager.getLogger();
    private double maxPerimeter;
    private double minPerimeter;
    Calculator calculator = new Calculator();

    public FindByPerimeter( double minPerimeter, double maxPerimeter ){
        this.maxPerimeter = maxPerimeter;
        this.minPerimeter = minPerimeter;
    }

    @Override
    public boolean specified(Quadrangle quadrangle){
        LOGGER.trace("FindByPerimeter:");
        return LOGGER.traceExit(calculator.calculatePerimeterOfQuadrangle(quadrangle.getSides()) <=
        maxPerimeter && calculator.calculatePerimeterOfQuadrangle(quadrangle.getSides()) >=
                minPerimeter );

    }
}
