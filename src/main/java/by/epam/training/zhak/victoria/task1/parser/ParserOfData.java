package by.epam.training.zhak.victoria.task1.parser;
import by.epam.training.zhak.victoria.task1.validation.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class ParserOfData implements Parser {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String REGEX_COORDINATE_DELIMETER = "\\s";
    private Validation validation;

    public ParserOfData() {
        validation = new Validation();
    }

    public List<List<Double>> parse(List<String> strings){
        List<List<Double>> pointList = new ArrayList<>();
        for (String str : strings) {
            if (validation.isValid(str)) {
                String[] values = str.split(REGEX_COORDINATE_DELIMETER);
                List<Double> pointListToAdd = new ArrayList<>();
                for (String value : values) {
                    pointListToAdd.add(Double.parseDouble(value));
                }
                pointList.add(pointListToAdd);
            } else {
                LOGGER.info("Not valid line");
            }
        }
        return pointList;
    }
}

