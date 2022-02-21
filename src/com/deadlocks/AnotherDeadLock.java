package com.deadlocks;

public class AnotherDeadLock {

    public static void main(String[] args){
        PolitePerson robert = new PolitePerson("Robert");
        PolitePerson anna = new PolitePerson("Anna");

        new Thread(() -> robert.sayHello(anna)).start();
        new Thread(() -> anna.sayHello(robert)).start();
    }
    // 1. Thread1 acquires the lock on the robert object and enters the sayHello() method.
    // It prints to the console, then suspends.
    // 2. Thread2 acquires the lock on the anna object and enters the sayHello() method.
    // It prints to the console, then suspends.
    // 3. Thread1 runs again and wants to say hello back to the anna object. It tries to call the sayHelloBack() method
    // using the anna object that was passed into the sayHello() method,
    // but Thread2 is holding the anna lock, so Thread1 suspends.
    // 4. Thread2 runs again and wants to say hello back to the robert object. It tries to call the sayHelloBack() method
    // using the robert object that was passed into the sayHello() method,
    // but Thread1 is holding the robert lock, so Thread2 suspends.

    static class PolitePerson{
        private final String name;

        public PolitePerson(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void sayHello(PolitePerson person){
            System.out.format("%s: %s"+" has said hello to me!%n", this.name, person.getName());
            person.sayHelloBack(this);
        }

        public synchronized void sayHelloBack(PolitePerson person){
            System.out.format("%s: %s"+ " has said hello back to me!%n", this.name, person.getName());
        }
    }
}
