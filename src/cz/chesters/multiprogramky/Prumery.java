package cz.chesters.multiprogramky;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Prumery {
    public static void play() {
        ArrayList<Integer> cisla = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String inp;

        System.out.println(Mik.BG_BLUE + Mik.BLACK + "Vítej v Průměrech" + Mik.RESET);
        System.out.println(Mik.BLUE + "Zadej první číslo" + Mik.RESET);
        cisla.add(scanner.nextInt());
        System.out.println();

        while (true) {
            System.out.println(Mik.BLUE + "Chceš zadat další číslo? y/n" + Mik.RESET);
            inp = scanner.nextLine();
            inp = scanner.nextLine();
            if (inp.toLowerCase().charAt(0) != 'y')
                break;

            System.out.println(Mik.BLUE + "Zadej další číslo" + Mik.RESET);
            cisla.add(scanner.nextInt());
            System.out.println();
        }

        System.out.println(Mik.BLUE + "Průměr těchto " + cisla.size() + " čísel je " + (sectiArrayList(cisla) / cisla.size()) + Mik.RESET);
        System.out.println();
    }

    public static int sectiArrayList(ArrayList<Integer> list) {
        int sum = 0;
        for (Integer i : list)
            sum = +i;
        return sum;
    }
}
