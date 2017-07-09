package edu.mum.SystemDesignAndMemoryLimits.stock;

/**
 * Created by hungduong on 7/9/17.
 */
public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}
