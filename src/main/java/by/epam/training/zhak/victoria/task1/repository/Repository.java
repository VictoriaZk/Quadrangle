package by.epam.training.zhak.victoria.task1.repository;


import by.epam.training.zhak.victoria.task1.specification.Specification;

import java.util.Comparator;
import java.util.List;

public interface Repository<T> {
    void add(T obj);
    void remove(T obj);
    void update(T obj);
    List <T> sortBy(Comparator comparator);
    List <T> find(Specification<T> specification);
}
