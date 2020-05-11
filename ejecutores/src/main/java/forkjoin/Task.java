
package forkjoin;

import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class Task extends RecursiveTask<Integer> {
    private final List<Integer> numeros;
    
    public Task(List<Integer> numeros) {
        this.numeros = numeros;
    }
    
    @Override
    protected Integer compute() {
        if(numeros.size() <= 10) {//tarea manejable; calcula resultado
        	
            int resultado = 0;
            for(int i = 0; i < numeros.size(); i++) resultado += numeros.get(i);
            return resultado;
            
        } else {//tarea muy grande; la divide en dos
        	
            Task left = new Task(numeros.subList(0, numeros.size()/2));//map
            left.fork();
            
            Task right = new Task(numeros.subList(numeros.size()/2, numeros.size()));
            right.fork();
            
            return left.join() + right.join();//reduce
            
        }
    }

}
