package by.epam.training.zhak.victoria.task1.validation;

public class Validation {
    private static final String REGEX = "^(-?\\d+\\.?(\\d+)?\\s+){11}(-?\\d+\\.?(\\d+)?\\n*\\s*)$";
    public boolean isValid(String inputLine) {
        return inputLine.matches(REGEX);
    }
}
