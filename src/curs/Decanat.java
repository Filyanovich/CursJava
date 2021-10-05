package curs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Decanat {
    private final String name;
    private List<String> students = new ArrayList<>();


    public Decanat(String name) {
        this.name = name;
    }

    public void addStudent(ReentrantLock lock, String name) {
        lock.lock();
        students.add(name);
        System.out.println("Студент " + name + " записался на факутальтив в деканате " + this.name);
        lock.unlock();
    }

    public int getCountStudent() {
        return students.size();
    }
}
