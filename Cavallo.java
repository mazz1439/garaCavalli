import java.util.*;

public class Cavallo implements Runnable {
    private String nome; // Nome del cavallo
    private int lunghezzaPercorso; // Lunghezza totale del percorso della gara
    private int distanzaPercorsa = 0; // Distanza attuale percorsa dal cavallo
    private Random random = new Random(); // Oggetto Random per generare numeri casuali

    // Costruttore che inizializza il nome e la lunghezza del percorso
    public Cavallo(String nome, int lunghezzaPercorso) {
        this.nome = nome;
        this.lunghezzaPercorso = lunghezzaPercorso;
    }

    // Metodo run che viene eseguito quando il thread del cavallo inizia
    @Override
    public void run() {
        System.out.println(nome + " è pronto!"); 
        // Ciclo fino a quando il cavallo non ha percorso l'intero percorso
        while (distanzaPercorsa < lunghezzaPercorso) {
            // Genera un passo casuale tra PASSO_MINIMO e PASSO_MASSIMO
            int passo = random.nextInt(CorsaCavalli.PASSO_MASSIMO - CorsaCavalli.PASSO_MINIMO + 1) + CorsaCavalli.PASSO_MINIMO;
            distanzaPercorsa += passo; // Aggiunge il passo alla distanza percorsa

            // Se la distanza percorsa supera la lunghezza del percorso, la imposta al massimo
            if (distanzaPercorsa > lunghezzaPercorso) {
                distanzaPercorsa = lunghezzaPercorso;
            }
            // Stampa la distanza attuale percorsa dal cavallo
            System.out.println(nome + " ha percorso " + distanzaPercorsa + " metri.");
            try {
                Thread.sleep(500); // Pausa di 500 ms per simulare il tempo di corsa
            } catch (InterruptedException e) {
                e.printStackTrace(); // Gestione delle eccezioni in caso di interruzione del thread
            }
        }
        System.out.println(nome + " ha terminato la gara");
    }
}
