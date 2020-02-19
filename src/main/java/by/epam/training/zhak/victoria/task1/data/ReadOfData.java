package by.epam.training.zhak.victoria.task1.data;

import by.epam.training.zhak.victoria.task1.exception.ReadingFileException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReadOfData {
    private static final String MESSAGE_FOR_EXCEPTION = "File is not found";
    private static final Logger LOGGER = LogManager.getLogger(ReadOfData.class);

    public List readingLines(String path) throws ReadingFileException {
        List<String> linesWithValues = new ArrayList<String>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(path)))){
            String tmp;
            while ((tmp = bufferedReader.readLine()) != null) {
                linesWithValues.add(tmp);
            }
            LOGGER.info("File was read");
        } catch (IOException ex) {
            LOGGER.info("File is not found");
            throw new ReadingFileException(MESSAGE_FOR_EXCEPTION, ex);
        }
        return linesWithValues;
    }
}
