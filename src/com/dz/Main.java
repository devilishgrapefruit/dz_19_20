package com.dz;

import java.util.*;

public class Main {
static String getCarNumber(){
    String CarNumber="";
    Random r = new Random();
    int c = (int) (Math.random() * 10);
    CarNumber+=(char) ('A' + r.nextInt(25)); // добавляем первую букву
    for (int i=0;i<3;i++) // три одинаковые цифры
        CarNumber = CarNumber + c;
    for (int i=0;i<2;i++) // две буквы
        CarNumber = CarNumber + (char) ('A' + r.nextInt(25));
        c =(int) (Math.random() * (199-1) + 1); // регион
        CarNumber = CarNumber + c;
    return CarNumber;
}
    public static void main(String[] args) {
        ArrayList<String> a =new ArrayList<String>();
        System.out.println("Введите n: ");
        int n = new Scanner(System.in).nextInt();
        for (int i=0; i< n;i++) {
            a.add(getCarNumber());
            System.out.println(a.get(i));
        }
        a.sort(Collections.reverseOrder());
        HashSet<String> hash = new HashSet<String>(a);
        TreeSet tree = new TreeSet(a);
        Scanner sc =new Scanner(System.in);
        System.out.println("Введите автомобильный номер:");
        String finder= sc.nextLine();
        boolean b = a.contains(finder);
        long m = System.currentTimeMillis();
        System.out.print("Прямой перебор: " + finder + " ");
        if (b)
            System.out.print("найден");
        else
            System.out.print("не найден");
        System.out.println(", поиск занял: "+ (double) (System.currentTimeMillis() - m) +" мс");
        m = System.currentTimeMillis();
        int u = Collections.binarySearch(a,finder,Collections.reverseOrder());
        if (u>=0)
            System.out.print("Бинарный поиск:" + finder + " найден, поиск занял: "+
                    (double) (System.currentTimeMillis() - m) +" мс");
        else
            System.out.println("Бинарный поиск: " +  finder + " не найден, поиск занял: "+
                    (double) (System.currentTimeMillis() - m) +" мс");
        m = System.currentTimeMillis();
        b=hash.contains(finder);
        System.out.print("Поиск в HashSet: ");
        if (b)
            System.out.print("найден");
        else
            System.out.print("не найден");
        System.out.println(", поиск занял: "+ (double) (System.currentTimeMillis() - m) +" мс");
        m = System.currentTimeMillis();
        b=tree.contains(finder);
        System.out.print("Поиск в TreeSet: ");
        if (b)
            System.out.print("найден");
        else
            System.out.print("не найден");
        System.out.println(", поиск занял: "+ (double) (System.currentTimeMillis() - m) +" мс");
    }
}
