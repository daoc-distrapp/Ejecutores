
package forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class Main {
    public static final int MAX_NUM_BY_TASK = 100;
    private final List<Integer> numeros;
    private final ForkJoinPool fjPool;
    
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        Random r = new Random();
        numeros = new ArrayList<>();
        for(int i = 0; i < 2000; i++) numeros.add(r.nextInt(1000));
        
        System.out.println("Procesadores: " + Runtime.getRuntime().availableProcessors());
        
        fjPool = new ForkJoinPool();
        int sumatoria = fjPool.invoke(new Task(numeros));
        
        System.out.println("Sumatoria: " + sumatoria);
    }

     
}
