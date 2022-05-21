package reference1.DiningPhilosopherProblem;

import static reference1.DiningPhilosopherProblem.ThreadColor.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    /**
     *The dining philosophers problem states that there are 5 philosophers sharing a circular table and
     * they eat and think alternatively. There is a bowl of rice for each of the philosophers and 5 chopsticks.
     * A philosopher needs both their right and left chopstick to eat.
     * A hungry philosopher may only eat if there are both chopsticks available.
     * Otherwise a philosopher puts down their chopstick and begin thinking again.
     */

    public static void main(String[] args) throws InterruptedException{

        ExecutorService executorService = null;
        Philosopher[] philosophers = null;

        try {
            philosophers = new Philosopher[Constants.NUMBER_OF_PHILOSOPHERS];
            ChopStick[] chopSticks = new ChopStick[Constants.NUMBER_OF_PHILOSOPHERS];

            for(int i=0; i<Constants.NUMBER_OF_CHOPSTICKS; i++){
                chopSticks[i] = new ChopStick(i);
            }

            executorService = Executors.newFixedThreadPool(Constants.NUMBER_OF_PHILOSOPHERS);
            for(int i=0; i<Constants.NUMBER_OF_PHILOSOPHERS;i++){
                philosophers[i] = new Philosopher(i, chopSticks[i], chopSticks[(i+1)% Constants.NUMBER_OF_PHILOSOPHERS]);
                executorService.execute(philosophers[i]);
            }

            Thread.sleep(Constants.SIMULATION_RUNNING_TIME);

            for(Philosopher philosopher : philosophers){
                philosopher.setFull(true);
            }
        } finally {
            executorService.shutdown();

            while(!executorService.isTerminated()){
                Thread.sleep(1000);
            }

            for(Philosopher philosopher : philosophers){
                System.out.println(ANSI_YELLOW+philosopher+" eat "+philosopher.getEatingCounter()+" times");
            }
        }
    }
}
