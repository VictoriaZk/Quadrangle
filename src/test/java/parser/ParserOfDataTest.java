package parser;

import by.epam.training.zhak.victoria.task1.parser.ParserOfData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ParserOfDataTest {
    private ParserOfData parserOfData;

    @BeforeClass
    public void setUp() {
        parserOfData = new ParserOfData();
    }

    @DataProvider(name = "dataForParsingLines")
    public Object[][] dataForParsingLines() {
        return new Object[][]{
                {       Arrays.asList("2 0 0 0 2 0 1 0 1 0 1 1", "-1 2 3 2 2 1 2.23 2 4.6 1.08 -0.94 2.87"),
                        Arrays.asList(Arrays.asList(2.0, 0.0, 0.0, 0.0, 2.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0),
                                Arrays.asList(-1.0, 2.0, 3.0, 2.0, 2.0, 1.0, 2.23, 2.0, 4.6, 1.08, -0.94, 2.87))
                }
        };
    }

    @DataProvider(name = "dataForParsingLinesTestNegative")
    public Object[][] dataForParsingLinesTestNegative() {
        return new Object[][]{
                {Collections.singletonList("2.0 0.0f 0 0 -2 0 1 0 1 0 1 1 Ad.2 0 0 =0 2 0 1 0 1 0 1 1"),
                        Collections.emptyList()}
        };
    }

    @Test(dataProvider = "dataForParsingLines")
    public void parsingLinesTestPositive(List<String> lines, List<List<Double>> expectedResult) {
        List<List<Double>> actual = parserOfData.parse(lines);
        Assert.assertEquals(actual, expectedResult);
    }

    @Test(dataProvider = "dataForParsingLinesTestNegative")
    public void parsingLinesTestNegative(List<String> lines, List<List<Double>> expectedResult) {
        List<List<Double>> actual = parserOfData.parse(lines);
        Assert.assertEquals(actual, expectedResult);
    }
}
