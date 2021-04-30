package executable.method.bug;

import io.micronaut.aop.Adapter;
import io.micronaut.context.annotation.Executable;
import io.micronaut.core.annotation.Indexed;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Adapter(JobProcessor.class)
@Indexed(JobProcessor.class)
@Executable(processOnStartup = true)
public @interface JobListener {
}
