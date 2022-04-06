package cz.chesters.multiprogramky.kamennuzky;

import cz.chesters.multiprogramky.Mik;

import java.util.Scanner;

public class KamenNuzky {
    public static void play() {
        Scanner scanner = new Scanner(System.in);
        String inp;
        int playerScore = 0;
        int botScore = 0;
        Symboly hrajeHrac;
        Symboly hrajeBot;

        System.out.println(Mik.BG_BLUE + Mik.BLACK + "Vítej v Průměrech" + Mik.RESET);
        while (true) {
            System.out.println(Mik.BLUE + "Vyber si, co ukážeš" + Mik.RESET);
            inp = scanner.nextLine().toLowerCase();
            if (inp.contains("p")) {
                hrajeHrac = Symboly.PAPIR;
            } else if (inp.contains("nu") || inp.contains("nů")) {
                hrajeHrac = Symboly.NUZKY;
            } else if (inp.contains("ka") || inp.contains("ká")) {
                hrajeHrac = Symboly.KAMEN;
            } else {
                System.out.println(Mik.BG_YELLOW + Mik.BLACK + "WARN:" + Mik.RESET + Mik.YELLOW + " Nezvolil jsi platnou hodnotu" + Mik.RESET);
                continue;
            }

            hrajeBot = switch ((int) (Math.random() * 3 + 1)) {
                case 0 -> Symboly.KAMEN;
                case 1 -> Symboly.NUZKY;
                default -> Symboly.PAPIR;
            };
            System.out.println(Mik.BLUE + "Protivník ukázal " + hrajeBot + Mik.RESET);

            if (hrajeBot == hrajeHrac) {
                System.out.println(Mik.BLUE + "Remíza." + Mik.RESET);
            } else if (vyhralClovek(hrajeHrac, hrajeBot)) {
                System.out.println(Mik.BLUE + "Vyhráls!" + Mik.RESET);
                playerScore++;
            } else {
                System.out.println(Mik.BLUE + "Prohráls" + Mik.RESET);
                botScore++;
            }


            stavHry(playerScore, botScore);

            System.out.println();
            System.out.println(Mik.BLUE + "Další kolo? y/n" + Mik.RESET);
            //noinspection UnusedAssignment
            inp = scanner.nextLine(); // musí tady bejt, jinak to hází errory
            inp = scanner.nextLine();
            if (inp.toLowerCase().charAt(0) != 'y')
                break;
        }
    }

    public static void stavHry(int pS, int bS) {
        if (pS > bS)
            System.out.println(Mik.BLUE + "Stav je " + pS + ":" + bS + " pro tebe" + Mik.RESET);
        else if (pS < bS)
            System.out.println(Mik.BLUE + "Stav je " + bS + ":" + pS + " pro protivníka" + Mik.RESET);
        else
            System.out.println(Mik.BLUE + "Stav je " + pS + ":" + bS + Mik.RESET);
    }

    public static boolean vyhralClovek(Symboly plr, Symboly bot) {
        return switch (plr) {
            case KAMEN -> switch (bot) {
                case NUZKY -> true;
                case PAPIR, KAMEN -> false;
            };
            case NUZKY -> switch (bot) {
                case KAMEN, NUZKY -> false;
                case PAPIR -> true;
            };
            case PAPIR -> switch (bot) {
                case NUZKY, PAPIR -> false;
                case KAMEN -> true;
            };
        };
    }

    enum Symboly {
        KAMEN, NUZKY, PAPIR
    }
}
