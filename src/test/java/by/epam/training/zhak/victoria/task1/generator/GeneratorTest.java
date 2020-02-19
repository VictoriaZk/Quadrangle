package by.epam.training.zhak.victoria.task1.generator;

import org.testng.Assert;

import org.testng.annotations.Test;

public class GeneratorTest {
    private Generator generator;

    GeneratorTest() {
    generator = new Generator();
    Generator.setId(0);
}

    @Test
    public void generateId(){
        long actualId = generator.generateId();
        long expectedId = 1;
        Assert.assertEquals(actualId, expectedId);
    }
}
