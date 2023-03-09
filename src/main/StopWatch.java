package main;

public class StopWatch {
    private static long startTime;
    public StopWatch() {}
    public static void start(){
        startTime = System.nanoTime();
    }    
    public static long finish(){
        return System.nanoTime() - startTime;
    }
}
