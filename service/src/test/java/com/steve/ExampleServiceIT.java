package com.steve;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.*;

@SpringBootTest
public class ExampleServiceIT {
    @Test
    public void contextLoads(ApplicationContext context) {
        assertThat(context, is(notNullValue()));
    }
}