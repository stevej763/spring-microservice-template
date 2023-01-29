package com.steve.core;

import java.util.Optional;

public interface ExampleRepositoryAdapter {

    Optional<ExampleData> storeState(ExampleData value);

}
