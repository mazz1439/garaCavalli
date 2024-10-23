import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CorsaCavalli {
    public static final int PASSO_MINIMO = 1; 
    public static final int PASSO_MASSIMO = 10; 

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Inserisci la lunghezza del percorso della gara (in metri): ");
            int lunghezzaPercorso = scanner.nextInt();

            System.out.print("Inserisci il numero di cavalli che partecipano alla gara: ");
            int numeroCavalli = scanner.nextInt();
            scanner.nextLine();  

            List<Thread> cavalli = new ArrayList<>();

            for (int i = 1; i <= numeroCavalli; i++) {
                System.out.print("Inserisci il nome del cavallo " + i + ": ");
                String nomeCavallo = scanner.nextLine();
                Cavallo cavallo = new Cavallo(nomeCavallo, lunghezzaPercorso);
                cavalli.add(new Thread(cavallo));
            }

            System.out.println("La gara sta per iniziare");

            for (Thread cavallo : cavalli) {
                cavallo.start();
            }

            for (Thread cavallo : cavalli) {
                try {
                    cavallo.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("La gara è terminata");
    }
}
