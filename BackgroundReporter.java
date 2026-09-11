package campustracker;

public class BackgroundReporter extends Thread {

    private static int reportCount = 0;

    @Override
    public void run() {

        generateReport();

    }

    // Synchronized method
    public static synchronized void generateReport() {

        reportCount++;

        System.out.println("Background Reporter Thread Started.");
        System.out.println("Report Number: " + reportCount);

        for (int i = 1; i <= 3; i++) {

            System.out.println("Generating background report... " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Background Reporter Thread Interrupted.");
            }
        }

        System.out.println("Background Reporter Thread Finished.");
    }
}