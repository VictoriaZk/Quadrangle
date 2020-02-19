package by.epam.training.zhak.victoria.task1.observer;

public interface Observable<T> {
    void addObserver(T obj);
    void removeObserver(T obj);
    void notifyObservers();
}
