
package exec;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class Main {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        
        Random rnd = new Random();
        for(int i = 0; i < 5000; i++) {
            int n = rnd.nextInt(20);
            
            pool.execute(new TaskFactorial(n));
        }
        
        pool.shutdown();
    }
    
}
