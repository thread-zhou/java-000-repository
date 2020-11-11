package demo.jvm0104;

public class ForLoopTest {

    private static int[] NUMBERS = {1, 6, 8};

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage();
        for (int number : NUMBERS) {
            movingAverage.submit(number);
        }
        double avg = movingAverage.getAvg();
    }
}