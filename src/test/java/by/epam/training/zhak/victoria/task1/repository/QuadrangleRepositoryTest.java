package by.epam.training.zhak.victoria.task1.repository;

import by.epam.training.zhak.victoria.task1.entity.Point;
import by.epam.training.zhak.victoria.task1.entity.Quadrangle;
import by.epam.training.zhak.victoria.task1.specification.find.FindByCoordinateXY;
import by.epam.training.zhak.victoria.task1.specification.find.FindById;
import by.epam.training.zhak.victoria.task1.specification.find.FindByPerimeter;
import by.epam.training.zhak.victoria.task1.specification.find.FindBySquare;
import by.epam.training.zhak.victoria.task1.specification.sort.SortByCoordinateX;
import by.epam.training.zhak.victoria.task1.specification.sort.SortByCoordinateY;
import by.epam.training.zhak.victoria.task1.specification.sort.SortById;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class QuadrangleRepositoryTest {
    private static final Quadrangle FIRST_QUADRANGLE = new Quadrangle(
            new Point(10, 5),
            new Point(1,3),
            new Point(13, 1),
            new Point(21, 12)
    );

    private static final Quadrangle SECOND_QUADRANGLE = new Quadrangle(
            new Point(1, 0),
            new Point(13,3),
            new Point(12, 21),
            new Point(0, 5)
    );

    private static final Quadrangle THIRD_QUADRANGLE = new Quadrangle(
            new Point(15, 20),
            new Point(1,3),
            new Point(32, 7),
            new Point(17, 12)
    );

    private static final Quadrangle FORTH_QUADRANGLE = new Quadrangle(
            new Point(5, 14),
            new Point(4,0),
            new Point(11, 20),
            new Point(13, 5)
    );

    private Repository<Quadrangle> repository;

    @BeforeClass
    public void setUp() {
        repository = new QuadrangleRepository();
        repository.add(FIRST_QUADRANGLE);
        repository.add(FORTH_QUADRANGLE);
        repository.add(SECOND_QUADRANGLE);
        repository.add(THIRD_QUADRANGLE);
    }

    @Test
    public void findById() {
        List<Quadrangle> resultList = repository.find(new FindById(3));
        List<Quadrangle> expectedResult = Arrays.asList(THIRD_QUADRANGLE);
        Assert.assertEquals(resultList, expectedResult);
    }

    @Test
    public void findByCoordinateXY() {
        List<Quadrangle> resultList = repository.find(new FindByCoordinateXY());
        List<Quadrangle> expectedResult = Arrays.asList(FIRST_QUADRANGLE, SECOND_QUADRANGLE,
                THIRD_QUADRANGLE, FORTH_QUADRANGLE);
        Assert.assertEquals(resultList, expectedResult);
    }

    @Test
    public void findByPerimeter() {
        List<Quadrangle> resultList = repository.find(new FindByPerimeter(6, 65));
        List<Quadrangle> expectedResult = Arrays.asList(FIRST_QUADRANGLE, SECOND_QUADRANGLE,
                FORTH_QUADRANGLE);
        Assert.assertEquals(resultList, expectedResult);
    }

    @Test
    public void findBySquare() {
        List<Quadrangle> resultList = repository.find(new FindBySquare(0, 500));
        List<Quadrangle> expectedResult = Arrays.asList(FIRST_QUADRANGLE, SECOND_QUADRANGLE,
                THIRD_QUADRANGLE, FORTH_QUADRANGLE);
        Assert.assertEquals(resultList, expectedResult);
    }

    @Test
    public void sortById() {
        List<Quadrangle> resultList = repository.sortBy(new SortById());
        List<Quadrangle> expectedResult =
                Arrays.asList(FIRST_QUADRANGLE,
                        SECOND_QUADRANGLE,
                        THIRD_QUADRANGLE,
                        FORTH_QUADRANGLE
                );

        Assert.assertEquals(resultList, expectedResult);
    }

    @Test
    public void sortByCoordinateX() {
        List<Quadrangle> resultList = repository.sortBy(new SortByCoordinateX());
        List<Quadrangle> expectedResult =
                Arrays.asList(SECOND_QUADRANGLE,
                        FORTH_QUADRANGLE,
                        FIRST_QUADRANGLE,
                        THIRD_QUADRANGLE
                );
        Assert.assertEquals(resultList, expectedResult);
    }

    @Test
    public void sortByCoordinateY() {
        List<Quadrangle> resultList = repository.sortBy(new SortByCoordinateY());
        List<Quadrangle> expectedResult =
                Arrays.asList(SECOND_QUADRANGLE,
                        FIRST_QUADRANGLE,
                        FORTH_QUADRANGLE,
                        THIRD_QUADRANGLE
                );

        Assert.assertEquals(resultList, expectedResult);
    }
}
