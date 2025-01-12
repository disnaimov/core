package org.example.stage5.task2;

public class RealSubject implements Subject{
    @Override
    public void request() {
        System.out.println("Выполнение запроса к реальному объекту");
    }
}
