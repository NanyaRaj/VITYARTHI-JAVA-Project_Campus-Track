package campustracker;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ProjectInfo {

    String author();

    String version();

    String description();
}