package reference2.producer_consumer;

import java.util.Random;

public class Reader implements Runnable{

    private Message message;

    public Reader(Message message){
        this.message=message;
    }

    @Override
    public void run() {
        Random random = new Random();
        for(String lastestMessage = message.read();
            !lastestMessage.equals("Finished");
            lastestMessage = message.read()){
            System.out.println(lastestMessage);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e){

            }
        }
    }
}
