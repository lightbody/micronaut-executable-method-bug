package executable.method.bug;

import javax.inject.Singleton;

@Singleton
public class SampleService {
    @JobListener
    void onJob(SampleJob sampleJob) {
        // do stuff
    }
}
