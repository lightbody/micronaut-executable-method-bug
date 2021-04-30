package executable.method.bug;

import io.micronaut.context.processor.ExecutableMethodProcessor;
import io.micronaut.inject.BeanDefinition;
import io.micronaut.inject.ExecutableMethod;

import javax.inject.Singleton;

@Singleton
public class JobService implements ExecutableMethodProcessor<JobListener> {
    @Override
    public void process(BeanDefinition<?> beanDefinition, ExecutableMethod<?, ?> method) {
        @SuppressWarnings("unchecked") final Class<? extends Job> jobType = method.getArgumentTypes()[0];
        if (jobType == Job.class) {
            throw new RuntimeException("Unexpected: got a Job class when should have seen a SampleJob!");
        } else if (jobType == SampleJob.class) {
            System.out.println("**************************************");
            System.out.println("Saw the correct SampleJob -- hurray!");
            System.out.println("**************************************");
        } else {
            throw new RuntimeException("Unknown job!");
        }
    }
}
