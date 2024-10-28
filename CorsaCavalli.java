import java.util.*;

public class CorsaCavalli {
    // Costanti per definire il passo minimo e massimo dei cavalli
    public static final int PASSO_MINIMO = 1; 
    public static final int PASSO_MASSIMO = 10; 

    public static void main(String[] args) {
        // Uso di Scanner per l'input dell'utente
        try (Scanner scanner = new Scanner(System.in)) {
            // Richiesta della lunghezza del percorso
            System.out.print("Inserisci la lunghezza del percorso della gara (in metri): ");
            int lunghezzaPercorso = scanner.nextInt();

            // Richiesta del numero di cavalli partecipanti
            System.out.print("Inserisci il numero di cavalli che partecipano alla gara: ");
            int numeroCavalli = scanner.nextInt();
            scanner.nextLine();

            List<Thread> cavalli = new ArrayList<>(); // Lista per memorizzare i thread dei cavalli

            // Creazione dei thread per ogni cavallo
            for (int i = 1; i <= numeroCavalli; i++) {
                System.out.print("Inserisci il nome del cavallo " + i + ": ");
                String nomeCavallo = scanner.nextLine();
                Cavallo cavallo = new Cavallo(nomeCavallo, lunghezzaPercorso); // Crea un nuovo oggetto Cavallo
                cavalli.add(new Thread(cavallo)); // Aggiunge il thread della corsa alla lista
            }

            System.out.println("La gara sta per iniziare");

            // Avvio di tutti i thread dei cavalli
            for (Thread cavallo : cavalli) {
                cavallo.start();
            }

            // Attesa che tutti i thread dei cavalli terminino
            for (Thread cavallo : cavalli) {
                try {
                    cavallo.join(); // Aspetta che il thread termini
                } catch (InterruptedException e) {
                    e.printStackTrace(); // Gestione delle eccezioni
                }
            }
        }

        System.out.println("La gara è terminata"); 
    }
}
