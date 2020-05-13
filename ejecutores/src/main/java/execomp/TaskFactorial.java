
package execomp;

import java.util.concurrent.Callable;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class TaskFactorial implements Callable<Long> {
    private int n;
    
    public TaskFactorial(int n) {
        this.n = n;
    }

    @Override
    public Long call() throws Exception {
        long factorial = 1;
        for(int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
    
}
