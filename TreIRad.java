import java.util.Scanner;

public class TreIRad {
    public static char[][] brad = new char[3][3];
    public static char nuvarandeSpelare = 'X';
    public static boolean spelSlut = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            initBraden();
            spelSlut = false;

            while (!spelSlut) {
                skrivBraden();
                spelaTur(scanner);
                kontrolleraVinnare();
                bytSpelare();
            }

            skrivBraden();
            System.out.println("Vill du spela igen? (j/n)");
            String svar = scanner.next();
            if (svar.equalsIgnoreCase("n")) {
                break;
            }
        }

        scanner.close();
    }

    public static void initBraden() {
        for (int rad = 0; rad < 3; rad++) {
            for (int kolumn = 0; kolumn < 3; kolumn++) {
                brad[rad][kolumn] = ' ';
            }
        }
    }

    public static void skrivBraden() {
        for (int rad = 0; rad < 3; rad++) {
            for (int kolumn = 0; kolumn < 3; kolumn++) {
                System.out.print(brad[rad][kolumn]);
                if (kolumn < 2) System.out.print(" | ");
            }
            System.out.println();
            if (rad < 2) System.out.println("--+---+--");
        }
    }

    public static void spelaTur(Scanner scanner) {
        int rad, kolumn;
        boolean giltigtDrag;

        do {
            System.out.println("Spelare " + nuvarandeSpelare + ", ange rad (1-3) och kolumn (1-3): ");
            rad = scanner.nextInt() - 1; 
            kolumn = scanner.nextInt() - 1; 

            giltigtDrag = (rad >= 0 && rad < 3 && kolumn >= 0 && kolumn < 3 && brad[rad][kolumn] == ' ');

            if (!giltigtDrag) {
                System.out.println("Ogiltigt drag, försök igen.");
            }
        } while (!giltigtDrag);

        brad[rad][kolumn] = nuvarandeSpelare;
    }

    public static void kontrolleraVinnare() {
      
        for (int i = 0; i < 3; i++) {
            if (brad[i][0] == nuvarandeSpelare && brad[i][1] == nuvarandeSpelare && brad[i][2] == nuvarandeSpelare) {
                spelSlut = true;
                System.out.println("Spelare " + nuvarandeSpelare + " vinner!");
                return;
            }
            if (brad[0][i] == nuvarandeSpelare && brad[1][i] == nuvarandeSpelare && brad[2][i] == nuvarandeSpelare) {
                spelSlut = true;
                System.out.println("Spelare " + nuvarandeSpelare + " vinner!");
                return;
            }
        }

        if (brad[0][0] == nuvarandeSpelare && brad[1][1] == nuvarandeSpelare && brad[2][2] == nuvarandeSpelare) {
            spelSlut = true;
            System.out.println("Spelare " + nuvarandeSpelare + " vinner!");
            return;
        }
        if (brad[0][2] == nuvarandeSpelare && brad[1][1] == nuvarandeSpelare && brad[2][0] == nuvarandeSpelare) {
            spelSlut = true;
            System.out.println("Spelare " + nuvarandeSpelare + " vinner!");
            return;
        }

      
        boolean oavgjort = true;
        for (int rad = 0; rad < 3; rad++) {
            for (int kolumn = 0; kolumn < 3; kolumn++) {
                if (brad[rad][kolumn] == ' ') {
                    oavgjort = false;
                    break;
                }
            }
        }

        if (oavgjort) {
            spelSlut = true;
            System.out.println("Spelet är oavgjort!");
        }
    }

    public static void bytSpelare() {
        nuvarandeSpelare = (nuvarandeSpelare == 'X') ? 'O' : 'X';
    }
}
