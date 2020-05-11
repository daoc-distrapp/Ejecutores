
package exec;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class TaskFactorial implements Runnable {
    private int n;
    
    public TaskFactorial(int n) {
        this.n = n;
    }

    public void run() {
        long factorial = 1;
        for(int i = 1; i <= n; i++) {
            factorial *= i;
        }
        System.out.println(String.format("El factorial de %d es %d", n, factorial));
    }

}
