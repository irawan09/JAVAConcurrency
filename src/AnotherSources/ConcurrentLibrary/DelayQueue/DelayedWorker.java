package AnotherSources.ConcurrentLibrary.DelayQueue;

import static AnotherSources.ConcurrentLibrary.DelayQueue.ThreadColor.*;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedWorker implements Delayed {

    private long duration;
    private String message;

    public DelayedWorker(long duration, String message) {
        this.duration = System.currentTimeMillis()+duration;
        this.message = message;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }

    @Override
    public String toString() {
        return this.message;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
