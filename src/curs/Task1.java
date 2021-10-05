package curs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;


/*Написать метод для подсчета количества элементов в целочисленной коллекции, которые имеют
        одно из 3-х свойств: нечетные числа, простые числа, числа-палиндромы. Тип свойства задаётся в
        аргументах метода.*/
public class Task1 {


    public static void test(List<Integer> l,int a) {

        switch (a) {
            case 0 -> System.out.println("Количество нечетных элементов: " +
                    l.stream().filter((v) -> v % 2 != 0).count());
            case 1 -> System.out.println("Количество простых элементов: " +
                    l.stream().filter(Task1::isPrime).count());
            case 2 -> System.out.println("Количество полиндромов : " +
                    l.stream().filter(Task1::isPalindrom).count());
        }
    }



    private static boolean isPalindrom(int numbers) {
        if (numbers >= 10) {
            return numbers == IntStream.iterate(numbers, i -> i / 10).map(n -> n % 10)
                    .limit(String.valueOf(numbers).length()).
                            reduce(0, (a, b) -> a = a * 10 + b);
        }
        return false;
    }

    private static boolean isPrime(int numbers) {
        if (numbers < 2) return false;
        for (int i = 2; i <= numbers / 2; i++) {
            if (numbers % i == 0)
                return false;
        }
        return true;
    }


    public static void main(String[] args) {

        List<Integer> listOfInteger = Arrays.asList(103, 88, 251, 1, 6, 12321, 26, 12, 31);
        System.out.println(listOfInteger);
        test(listOfInteger,2);
    }

}
