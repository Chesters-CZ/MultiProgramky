package cz.chesters.multiprogramky.sibenice;

import cz.chesters.multiprogramky.Mik;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Locale.ROOT;

public class Sibenice {
    public static void play() {
        ArrayList<String> slova = new ArrayList<>();
        int wordPos;
        ArrayList<Pismenko> pismna = new ArrayList<>();
        int score = 0;
        int lives;
        ArrayList<String> guesses = new ArrayList<>();
        String input;
        Scanner scanner = new Scanner(System.in);

        String[] hangman = {

                "          \n" +
                        "          \n" +
                        "   *nic*  \n" +
                        "          \n" +
                        "          \n" +
                        "           \n" +
                        " (11 zivotu)",

                "          \n" +
                        "          \n" +
                        "          \n" +
                        "          \n" +
                        "         A\n" +
                        "        /_\\\n" +
                        " (10 zivotu)",

                "          \n" +
                        "         |\n" +
                        "         |\n" +
                        "         |\n" +
                        "         A\n" +
                        "        /_\\\n" +
                        "  (9 zivotu)",

                "     _____\n" +
                        "         |\n" +
                        "         |\n" +
                        "         |\n" +
                        "         A\n" +
                        "        /_\\\n" +
                        "  (8 zivotu)",

                "     _____\n" +
                        "    |    |\n" +
                        "         |\n" +
                        "         |\n" +
                        "         A\n" +
                        "        /_\\\n" +
                        "  (7 zivotu)",

                "     _____\n" +
                        "    |    |\n" +
                        "    Ö    |\n" +
                        "         |\n" +
                        "         A\n" +
                        "        /_\\\n" +
                        "  (6 zivotu)",

                "     _____\n" +
                        "    |    |\n" +
                        "    Ö    |\n" +
                        "    |    |\n" +
                        "         A\n" +
                        "        /_\\\n" +
                        "  (5 zivotu)",

                "     _____\n" +
                        "    |    |\n" +
                        "    Ö    |\n" +
                        "   /|    |\n" +
                        "         A\n" +
                        "        /_\\\n" +
                        "  (4 zivoty)",

                "     _____\n" +
                        "    |    |\n" +
                        "    Ö    |\n" +
                        "   /|\\   |\n" +
                        "         A\n" +
                        "        /_\\\n" +
                        "  (3 zivoty)",

                "     _____\n" +
                        "    |    |\n" +
                        "    Ö    |\n" +
                        "   /|\\   |\n" +
                        "    A    A\n" +
                        "        /_\\\n" +
                        "  (2 zivoty)",

                "     _____\n" +
                        "    |    |\n" +
                        "    Ö    |\n" +
                        "   /|\\   |\n" +
                        "    A    A\n" +
                        "   /    /_\\\n" +
                        "  (1 zivot!)",

                "     _____\n" +
                        "    |    |\n" +
                        "    Ö    |\n" +
                        "   /|\\   |\n" +
                        "    A    A\n" +
                        "   / \\  /_\\\n" +
                        "  (Prohráls)",
        };

        while (true) {
            try {
                System.out.println(Mik.GREEN + "Zkouším načítat všechna slova českého jazyka (může to chvíli trvat)" + Mik.RESET);
                slova.addAll(List.of(readFileAsString("C:\\Users\\bezou\\Google Drive\\Educanet\\2021-2022\\Programování\\MultiProgramky\\src\\cz\\chesters\\multiprogramky\\sibenice\\slova.txt").toLowerCase(ROOT).split(System.lineSeparator())));
                break;
            } catch (Exception e) {
                System.out.println(Mik.BG_RED + Mik.BLACK + "ERR:" + Mik.RESET + Mik.RED + " Něco se pokazilo při načítání souboru (" + e + ")" + Mik.RESET);
                try {
                    Thread.sleep(500);
                } catch (Exception ignored) {
                }
            }
        }

        System.out.println(Mik.GREEN + "Vítej v Šibenici" + Mik.RESET);
        try {
            Thread.sleep(1000);
        } catch (Exception ignored) {
        }
        maingame:
        while (true) {
            wordguess:
            while (true) {
                pismna.clear();
                lives = 0;
                guesses.clear();

                wordPos = (int) (Math.random() * slova.size());
                for (String ltr : slova.get(wordPos).split(""))
                    pismna.add(new Pismenko(ltr));

                letterguess:
                while (true) {
                    System.out.println(Mik.GREEN + hangman[lives] + Mik.RESET);
                    System.out.println();
                    System.out.println(Mik.GREEN + makeUnderscores(pismna) + Mik.RESET);
                    System.out.println(Mik.GREEN + printGuesses(guesses) + Mik.RESET);

                    System.out.println(Mik.GREEN + "Který písmenko si myslíš, že tam bude?" + Mik.RESET);
                    while (true) {
                        try {
                            input = scanner.nextLine().toLowerCase(ROOT).charAt(0) + "";
                            break;
                        } catch (Exception e) {
                            System.out.println(Mik.BG_YELLOW + Mik.BLACK + "WARN:" + Mik.RESET + Mik.YELLOW + " Zadej nějaký písmenko! (" + e + ")" + Mik.RESET);
                        }
                    }
                    if (guesses.contains(input)) {
                        System.out.println(Mik.GREEN + "Tohle písmenko už jsi zkoušel." + Mik.RESET);
                    } else {
                        guesses.add(input);
                        if (doesWordContain(pismna, input)) {
                            System.out.println(Mik.GREEN + "Dobře ty! Tohle písmenko v tom slově je!" + Mik.RESET);
                        } else {
                            System.out.println(Mik.GREEN + "Je mi líto, ale tohle písmenko tam neni." + Mik.RESET);
                            lives++;
                        }
                        if (lives >= hangman.length - 1) {
                            System.out.println(Mik.GREEN + hangman[lives] + Mik.RESET);
                            System.out.println();
                            System.out.println(Mik.GREEN + makeUnderscores(pismna) + Mik.RESET);
                            System.out.println(Mik.GREEN + printGuesses(guesses) + Mik.RESET);
                            System.out.println(Mik.GREEN + "Prohrál jsi. Slovo bylo " + getWord(pismna) + "." + Mik.RESET);
                            break maingame;
                        }
                        if (hasWon(pismna)) {
                            System.out.println(Mik.GREEN + hangman[lives] + Mik.RESET);
                            System.out.println();
                            System.out.println(Mik.GREEN + makeUnderscores(pismna) + Mik.RESET);
                            System.out.println(Mik.GREEN + printGuesses(guesses) + Mik.RESET);
                            System.out.println(Mik.GREEN + "Gratuluju, tohle slovo máš za sebou!" + Mik.RESET);
                            System.out.println(Mik.GREEN + "Chceš jít do dalšího kola? y/n" + Mik.RESET);
                            input = scanner.nextLine();
                            if (input.charAt(0) != 'y')
                                break maingame;
                            else
                                break letterguess;
                        }
                    }

                }
            }
        }
        System.out.println(Mik.GREEN + "Skončil jsi se skórem " + score + Mik.RESET);
    }

    public static String readFileAsString(String fileName) throws Exception {
        String data;
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public static String makeUnderscores(ArrayList<Pismenko> ps) {
        StringBuilder out = new StringBuilder();
        for (Pismenko p : ps) {
            if (p.visible)
                out.append(p.znak).append(" ");
            else out.append("_ ");
        }
        return out.toString();
    }

    public static String printGuesses(ArrayList<String> ss) {
        StringBuilder out = new StringBuilder();
        for (String s : ss)
            out.append(s).append(", ");
        if (out.length() > 2)
            return out.substring(0, out.length() - 2);
        else return out.toString();
    }

    public static boolean doesWordContain(ArrayList<Pismenko> ps, String s) {
        boolean doesIt = false;
        for (Pismenko p : ps) {
            if ((!p.visible && p.znak.equals(s)) ||
                    (s.equals("a") && (p.znak.equals("á"))) ||
                    (s.equals("s") && (p.znak.equals("š"))) ||
                    (s.equals("z") && (p.znak.equals("ž"))) ||
                    (s.equals("i") && (p.znak.equals("í"))) ||
                    (s.equals("c") && (p.znak.equals("č"))) ||
                    (s.equals("r") && (p.znak.equals("ř"))) ||
                    (s.equals("n") && (p.znak.equals("ň"))) ||
                    (s.equals("d") && (p.znak.equals("ď"))) ||
                    (s.equals("l") && (p.znak.equals("ľ"))) ||
                    (s.equals("t") && (p.znak.equals("ť"))) ||
                    (s.equals("o") && (p.znak.equals("ó") || p.znak.equals("ö"))) ||
                    (s.equals("e") && (p.znak.equals("é") || p.znak.equals("ě"))) ||
                    (s.equals("u") && (p.znak.equals("ú") || p.znak.equals("ů") || p.znak.equals("ü")))) {
                doesIt = true;
                p.visible = true;
            }
        }
        return doesIt;
    }

    public static boolean hasWon(ArrayList<Pismenko> ps) {
        for (Pismenko p : ps)
            if (!p.visible)
                return false;
        return true;
    }

    public static String getWord(ArrayList<Pismenko> ps) {
        StringBuilder out = new StringBuilder();
        for (Pismenko p : ps)
            out.append(p.znak);

        return out.toString();
    }

    /*
    / public static void main(String[] args) throws Exception {
    /     String data = readFileAsString("C:\\Users\\pankaj\\Desktop\\test.java");
    /     System.out.println(data);
    / }
    */
}
