package cz.chesters.multiprogramky.prumery;

import cz.chesters.multiprogramky.Mik;

import java.util.ArrayList;
import java.util.Scanner;

public class Prumery {
    public static void play() {
        ArrayList<Integer> cisla = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String inp;

        System.out.println(Mik.BG_PURPLE + Mik.BLACK + "Vítej v Kameni, nůžkách a papíru." + Mik.RESET);
        System.out.println(Mik.PURPLE + "Zadej první číslo" + Mik.RESET);
        cisla.add(scanner.nextInt());
        System.out.println();

        while (true) {
            System.out.println(Mik.PURPLE + "Chceš zadat další číslo? y/n" + Mik.RESET);
            //noinspection UnusedAssignment
            inp = scanner.nextLine(); // musí tady bejt, jinak to hází errory
            inp = scanner.nextLine();
            if (inp.toLowerCase().charAt(0) != 'y')
                break;

            System.out.println(Mik.PURPLE + "Zadej další číslo" + Mik.RESET);
            cisla.add(scanner.nextInt());
            System.out.println();
        }

        System.out.println(Mik.PURPLE + "Průměr těchto " + cisla.size() + " čísel je " + (sectiArrayList(cisla) / cisla.size()) + Mik.RESET);
        System.out.println();
    }

    public static int sectiArrayList(ArrayList<Integer> list) {
        int sum = 0;
        for (Integer i : list)
            sum = sum + i;
        return sum;
    }
}
