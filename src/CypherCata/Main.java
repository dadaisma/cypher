package CypherCata;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduïu una frase: ");
        String frase = scanner.nextLine();

        int canvi = 13;

        Cyprando cyprando = new Cyprando();
        String[] paraulasCifrates = cyprando.splitFrase(frase, canvi);

        System.out.println("Les paraules xifrades a la frase són:");
        for (String paraula : paraulasCifrates) {
            System.out.println(paraula);
        }

        scanner.close();
    }

    public static class Cyprando {

        public String[] splitFrase(String frase, int canvi) {
            // split()
            String[] parole = frase.split(" ");

            //  Cesare
            for (int i = 0; i < parole.length; i++) {
                parole[i] = cifraCesare(parole[i], canvi);
            }

            return parole;
        }

        private String cifraCesare(String paraula, int canvi) {
            StringBuilder risultato = new StringBuilder();

            for (int i = 0; i < paraula.length(); i++) {
                char carattere = paraula.charAt(i);

                // uppercase?
                if (Character.isLowerCase(carattere)) {
                    carattere = (char) ('a' + (carattere - 'a' + canvi) % 26);
                } else if (Character.isUpperCase(carattere)) {
                    carattere = (char) ('A' + (carattere - 'A' + canvi) % 26);
                }

                risultato.append(carattere);
            }

            return risultato.toString();
        }
    }
}
