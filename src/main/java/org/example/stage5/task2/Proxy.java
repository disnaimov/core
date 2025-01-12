package org.example.stage5.task2;

public class Proxy implements Subject{
    private RealSubject realSubject;
    @Override
    public void request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }

        System.out.println("Прокси, проверка доступа к реальному объекту");

        realSubject.request();
    }
}
