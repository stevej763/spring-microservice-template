package com.steve.core.unit;

import com.steve.core.CoreService;
import com.steve.core.ExampleRepositoryAdapter;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.*;
import static org.mockito.Mockito.*;

public class CoreServiceTest {

    @Test
    public void shouldReturnText() {
        ExampleRepositoryAdapter repositoryAdapter = mock(ExampleRepositoryAdapter.class);
        CoreService underTest = new CoreService(repositoryAdapter);
        assertThat(underTest.getData(), is("data retrieved"));
    }

}