
package forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

/**
 * https://github.com/dordonez-ute-apdist/Ejecutores.git
 * 
 * @author dordonez@ute.edu.ec
 */
public class Main {
    
    public static void main(String[] args) {
        Random r = new Random();
        List<Integer> numeros = new ArrayList<>();
        for(int i = 0; i < 2000; i++) numeros.add(r.nextInt(1000));
        
        System.out.println("Procesadores: " + Runtime.getRuntime().availableProcessors());
        
        ForkJoinPool fjPool = new ForkJoinPool();
        int sumatoria = fjPool.invoke(new Task(numeros));
        
        System.out.println("Sumatoria: " + sumatoria);
    }
     
}
