package com.epam.articleweb.articlesdao;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
class IdGeneratorIncrementer implements IdGenerator {
    private int id = 0;

    private Object lock = new Object();

    @Override
    public int generate() {
        synchronized (lock) {
            id++;
        }
        return id;
    }
}
