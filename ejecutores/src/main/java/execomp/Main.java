/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execomp;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author diego
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        ExecutorCompletionService<Long> ecs = new ExecutorCompletionService<>(pool);
        
        Random rnd = new Random();
        for(int i = 0; i < 50; i++) {
            int n = rnd.nextInt(15);
            ecs.submit(new TaskFactorial(n));
        }
        
        pool.shutdown();
        
        long total = 0;
        for(int i = 0; i < 50; i++) {       
            try {
                total += ecs.take().get();        
            } catch (InterruptedException | ExecutionException ex) {
                ex.printStackTrace();
            }
        }
        
        System.out.println("TOTAL: " + total);
    }
    
}
