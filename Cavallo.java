import java.util.Random;

public class Cavallo implements Runnable {
    private String nome;
    private int lunghezzaPercorso;
    private int distanzaPercorsa = 0;
    private Random random = new Random();

    public Cavallo(String nome, int lunghezzaPercorso) {
        this.nome = nome;
        this.lunghezzaPercorso = lunghezzaPercorso;
    }

    @Override
    public void run() {
        System.out.println(nome + " è pronto!");
        while (distanzaPercorsa < lunghezzaPercorso) {
            int passo = random.nextInt(CorsaCavalli.PASSO_MASSIMO - CorsaCavalli.PASSO_MINIMO + 1) + CorsaCavalli.PASSO_MINIMO;
            distanzaPercorsa += passo;
            if (distanzaPercorsa > lunghezzaPercorso) {
                distanzaPercorsa = lunghezzaPercorso;
            }
            System.out.println(nome + " ha percorso " + distanzaPercorsa + " metri.");
            try {
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(nome + " ha terminato la gara");
    }
}
