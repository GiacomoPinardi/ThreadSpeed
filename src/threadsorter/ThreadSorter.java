
package threadsorter;

public class ThreadSorter {

    public static void main(String[] args) {
        
        Sorter A = new Sorter(10000, 3);
        Sorter B = new Sorter(10, 2);
        
        A.start();
        System.out.println("Thread A started!");
        B.start();
        System.out.println("Thread B started!\n");
        
        boolean allFinished = false;
        
        boolean AFinished = false;
        boolean BFinished = false;        
        
        while (!allFinished) {
            if (A.checkFinished() && B.checkFinished()) {
                allFinished = true;
            }
            
            if (A.checkFinished() && !AFinished) {
                AFinished = true;
                System.out.println("Thread A has finished! [" + A.getDuration() + "ms]");
                // A.getResult();
            }
            if (B.checkFinished() && !BFinished) {
                BFinished = true;
                System.out.println("Thread B has finished! [" + B.getDuration() + "ms]");
                // B.getResult();
            }
        }
        
        System.out.println("\nThread A & B have finished!");
    }
    
}
