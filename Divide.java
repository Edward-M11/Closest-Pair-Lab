/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package divide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Divide {

    public static ArrayList<punto> lista = new ArrayList<>();

    public static void main(String[] args) {
        crear(10);
        for (Object p : lista) {
            punto a = (punto) p;
            System.out.println(a.x + ", " + a.y);
        }
        fuerza(lista);
        divid(lista);
    }

    public static void crear(int points) {
        Random random = new Random();
        for (int i = 1; i <= points; i++) {
            lista.add(new punto(random.nextInt(20), random.nextInt(20)));
        }
    }

    public static void fuerza(ArrayList<punto> list) {
        double closestd = distance(list.get(0), list.get(1));
        punto pointa = list.get(0), pointb = list.get(1);
        for (punto list1 : list) {
            for (int i = list.indexOf(list1) + 1; i < list.size(); i++) {
                if (distance(list1, list.get(i)) < closestd) {
                    closestd = distance(list1, list.get(i));
                    pointa = list1;
                    pointb = list.get(i);
                }
            }
        }
        System.out.println("The closest points are: (" + pointa.x + ", " + pointa.y + ") and (" + pointb.x + ", " + pointb.y + ")");
        System.out.println("Distance: " + closestd);
    }

    public static void divid(ArrayList<punto> list) {
        int x;
        x = (lista.size() / 2);
        double closestd = distance(list.get(0), list.get(1)), cosesb;
        punto pointa = list.get(0), pointb = list.get(1), pointab, pointbb;
        for (punto list1 : list) {
            for (int i = 0; i < x; i++) {
                if (distance(list1, list.get(i)) < closestd) {
                    closestd = distance(list1, list.get(i));
                    pointa = list1;
                    pointb = list.get(i);
                }
            }
        }
        System.out.println("The closest points are: (" + pointa.x + ", " + pointa.y + ") and (" + pointb.x + ", " + pointb.y + ")");
        System.out.println("Distance: " + closestd);
        cosesb = distance(list.get(x), list.get(x + 1));
        pointab = list.get(x);
        pointbb = list.get(x + 1);
        for (punto list1 : list) {
            for (int j = x; j < lista.size(); j++) {
                if (distance(list1, list.get(j)) < cosesb) {
                    cosesb = distance(list1, list.get(j));
                    pointab = list1;
                    pointbb = list.get(j);
                }
            }
        }
        System.out.println("The closest points are: (" + pointab.x + ", " + pointab.y + ") and (" + pointbb.x + ", " + pointbb.y + ")");
        System.out.println("Distance: " + cosesb);
    }

    public static double distance(punto a, punto b) {

        return Math.sqrt(Math.pow((b.y - a.y), 2) + Math.pow((b.x - a.x), 2));
    }

    public static class punto {

        public int x;
        public int y;

        punto(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
