package by.epam.training.zhak.victoria.task1.data;


import by.epam.training.zhak.victoria.task1.exception.ReadingFileException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;



public class ReadOfDataTest {
    private ReadOfData dataReader = new ReadOfData();
    private static final String VALID_PATH = "src/test/resources/test.txt";

    @DataProvider
    public static Object[][] dataForReadingLinesTestPositive() {
        return new Object[][]{
                {
                        Arrays.asList("2.0 0.0f 0 0 -2 0 1 0 1 0 1 1",  //input lines
                                "Ad.2 0 0 =0 2 0 1 0 1 0 1 1",
                                "",
                                " 2 0   0 0 2 0 1 0 1 0 1 1"),
                }
        };
    }

    @Test(dataProvider = "dataForReadingLinesTestPositive")
    public void readingLines(List<String> expectedResult) throws ReadingFileException {
        List actual = dataReader.readingLines(VALID_PATH);
        Assert.assertEquals(actual, expectedResult);
    }
}