package by.epam.training.zhak.victoria.task1.generator;

import com.google.common.annotations.VisibleForTesting;

public class Generator {
    private static long id = 0L;

    @VisibleForTesting
    static void setId(long id) {
        Generator.id = id;
    }
    public long generateId(){
        return ++id;
    }
}
