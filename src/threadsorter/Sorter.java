
package threadsorter;

import java.util.ArrayList;
import java.util.Random;

public class Sorter extends Thread {
    
    private boolean finished = false;
    
    private int randomNumbers, times;
    
    private Random r;
    
    long timeElapse;

    public Sorter(int randomNumber, int times) {
        this.randomNumbers = randomNumber;
        this.times = times;
        
        r = new Random();
    }
    
    @Override
    public void run () {
        long startTime = System.currentTimeMillis();
        
        for (int i = 0; i < times; i++) {
            ArrayList<Integer> numbers = this.generate();
            ArrayList<Integer> sorted = this.sort(numbers);
        }
        
        this.timeElapse = System.currentTimeMillis() - startTime;
        //
        this.finished = true;
    }
    
    public ArrayList<Integer> generate () {
        // generate new numbers
        ArrayList<Integer> numbers = new ArrayList<>();
        
        for (int i = 0; i < this.randomNumbers; i++) {
            numbers.add(r.nextInt(1000000000));
        }
        
        return numbers;
    }
    
    public ArrayList<Integer> sort (ArrayList<Integer> a) {
        // sort numbers
        boolean sorted = false;
        
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < a.size()-1; i++) {
                if (a.get(i) > a.get(i+1)) {
                    int tmp = a.get(i+1);
                    a.set(i+1, a.get(i));
                    a.set(i, tmp);
                    
                    sorted = false;
                }                
            }
        }
        
        return a;
    }
        
    public boolean checkFinished () {
        return this.finished;
    }
    
    public long getDuration () {
        return this.timeElapse;
    }
    
}
