package reference1.StreamAPI.SerialAndParallelStream;

import reference1.ForkJoinFramework.ForkJoinSimple1.App;

import java.util.stream.IntStream;

import static reference1.StreamAPI.ThreadColor.*;

public class SerialAndParallelStream {

    public static void main(String[] args){

        long currentTime = System.currentTimeMillis();

        int numberOfPrime = (int) IntStream
                .rangeClosed(2, Integer.MAX_VALUE/100)
                .filter(SerialAndParallelStream::isPrime)
                .count();
        System.out.println(ANSI_BLUE+"-------Sequential Stream-------");
        System.out.println(ANSI_BLUE+"Number of primes: "+numberOfPrime);
        System.out.println(ANSI_BLUE+"Time Take: "+(System.currentTimeMillis()-currentTime));

        currentTime = System.currentTimeMillis();
        numberOfPrime = (int) IntStream
                .rangeClosed(2, Integer.MAX_VALUE/100)
                .parallel()
                .filter(SerialAndParallelStream::isPrime)
                .count();
        System.out.println(ANSI_RED+"-------Parallel Stream-------");
        System.out.println(ANSI_RED+"Number of primes: "+numberOfPrime);
        System.out.println(ANSI_RED+"Time Take: "+(System.currentTimeMillis()-currentTime));
    }

    public static boolean isPrime(long num){

        long maxDivisor = (long) Math.sqrt(num);

        if(num<=1){
            return false;
        } else if (num==2){
            return true;
        } else if (num%2==0){
            return false;
        }

        for(int i=3; i<maxDivisor;i+=2){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}

