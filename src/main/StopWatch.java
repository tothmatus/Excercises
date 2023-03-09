package main;

public class StopWatch {
    private static long startTime;
    private static long endTime;
    public StopWatch() {}
    public static void start(){
        startTime = System.nanoTime();
    }    
    public static long finish(){
        return System.nanoTime() - startTime;
    }
    public static void finishReport(){
        endTime = System.nanoTime() - startTime;
        System.out.println("\nMethod finished in: " + endTime +" ns");

    }
}
