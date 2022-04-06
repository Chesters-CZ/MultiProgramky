package cz.chesters.multiprogramky;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Dobré poledne, tady několik miniprográmků v jednom.");
        while (true) {
            try {
                System.out.println("Prosím, zvolte si prográmek, který chcete rozběhnout");
                System.out.print("Máte na výběr z: ");
                System.out.print(Mik.BLACK + Mik.BG_BLUE + "PRUMERY" + Mik.RESET + ", ");
                System.out.print(Mik.BLACK + Mik.BG_PURPLE + "KAMEN NUZKY PAPIR" + Mik.RESET + ", ");
                System.out.print(Mik.BLACK + Mik.BG_GREEN + "SIBENICE" + Mik.RESET);
                System.out.println();

                String inp = scanner.nextLine();
                System.out.println();
                if (inp.toLowerCase().contains("prum")) {
                    Prumery.play();
                    System.out.println("Dáme ještě nějakej?");
                    if (scanner.nextLine().toLowerCase().charAt(0) != 'y')
                        System.exit(0);
                } else if (inp.toLowerCase().contains("kamen nuzky") || inp.toLowerCase().contains("kamennuzky")) {
                    KamenNuzky.play();
                    System.out.println("Dáme ještě nějakej?");
                    if (scanner.nextLine().toLowerCase().charAt(0) != 'y')
                        System.exit(0);
                } else if (inp.toLowerCase().contains("sibenice")) {
                    // Sibenice.play();
                    System.out.println("Tohle zatim neni implementovany.");
                    //System.out.println("Dáme ještě nějakej?");
                    if (scanner.nextLine().toLowerCase().charAt(0) != 'y')
                        System.exit(0);
                } else {
                    System.out.println();
                    System.out.println(Mik.BG_YELLOW + Mik.BLACK + "WARN:" + Mik.RESET + Mik.YELLOW + " Nezvolil jsi platnou hodnotu" + Mik.RESET);
                    System.out.println();
                }
            } catch (Exception e) {
                System.out.println(Mik.BG_RED + Mik.BLACK + "ERR:" + Mik.RESET + Mik.RED + " Něco se pokazilo (" + e + ")" + Mik.RESET);
            }
        }
    }
}
