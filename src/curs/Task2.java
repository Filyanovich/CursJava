package curs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;


/*Создать класс "Факультатив" на который может записаться 25 студентов. Создать 75 объектов
класса "Студент", которые записываются на Факультатив параллельно в 3-х деканатах. По
завершении записи вывести список зачисленных студентов*/

public class Task2 {


    public static void main(String[] args) {
        Decanat d1 = new Decanat("ФИТР");
        Decanat d2 = new Decanat("ФПТ");
        Decanat d3 = new Decanat("ФЭБУ");

        List<Decanat> decanList = new ArrayList<>();
        decanList.add(d1);
        decanList.add(d2);
        decanList.add(d3);
        ReentrantLock locker = new ReentrantLock();
        for (int i = 0; i < 75; i++) {
            new Thread(new Student(locker, Integer.toString(i), decanList)).start();
        }
    }

}

