package curs;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Student implements Runnable {
    private final String name;
    private List<Decanat> decanList;
    private final ReentrantLock lock;

    public Student(ReentrantLock lock, String name, List<Decanat> decanList) {
        this.lock = lock;
        this.name = name;
        this.decanList = decanList;
    }

    @Override
    public void run() {
        int random = (int) (decanList.size() * Math.random());
        while (decanList.get(random).getCountStudent() == 25) {
            random = (int) (decanList.size() * Math.random());
        }
        decanList.get(random).addStudent(lock, name);
    }
}