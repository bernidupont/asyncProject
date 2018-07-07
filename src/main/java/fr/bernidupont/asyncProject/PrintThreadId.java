package fr.bernidupont.asyncProject;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class PrintThreadId {

    @Async("specificTaskExecutor")
    public static Long runFromAnotherThreadPool() {
        Long threadId = Thread.currentThread().getId();
        System.out.println("Thread Id :" + threadId);
        return threadId;
    }

}
