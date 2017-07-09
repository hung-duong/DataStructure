package edu.mum.SystemDesignAndMemoryLimits.stock;

/**
 * Created by hungduong on 7/9/17.
 */
public interface Observer {
    void update(String symbol, float close, float high, float low, long volume);
}
