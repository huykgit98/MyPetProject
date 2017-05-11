package maks.sample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by user on 23.04.2017.
 */
@Component("testComponent")
public class TestComponent {
    @Value("${app.name}")
    private String appName;

    @Override
    public String toString() {
        return "app name "+ appName;
    }
}
