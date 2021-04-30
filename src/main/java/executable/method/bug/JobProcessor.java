package executable.method.bug;

import io.micronaut.core.annotation.Indexed;

@Indexed(JobProcessor.class)
public interface JobProcessor<T extends Job> {
    void processJob(T job);
}
