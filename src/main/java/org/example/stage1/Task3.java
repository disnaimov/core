package org.example.stage1;
/*
Реализовать “домашний синглтон” - то есть класс - синглтон, который создается только в одном экземпляре.
 */
public class Task3 {

   private static Task3 instance;

   private Task3(){}

    public static Task3 getInstance() {
       if (instance == null) {
           instance = new Task3();
       }
       return instance;
    }

    static class Singleton {
        public static void main(String[] args) {
            Task3 singleton1 =  Task3.getInstance();
            Task3 singleton2 = Task3.getInstance();

            System.out.println(singleton1 == singleton2);
        }
    }
}
