package com.steve.core;

import java.util.Optional;

public class CoreService {

    private final ExampleRepositoryAdapter exampleRepositoryAdapter;

    public CoreService(ExampleRepositoryAdapter exampleRepositoryAdapter) {
        this.exampleRepositoryAdapter = exampleRepositoryAdapter;
        System.out.println("Core service constructed");
    }

    public String getData() {
        return "data retrieved";
    }

    public ExampleDataDto postData(ExampleDto exampleDto) {
        ExampleData exampleData = new ExampleData(exampleDto.getText());
        Optional<ExampleData> exampleDataResult = exampleRepositoryAdapter.storeState(exampleData);
        System.out.println(exampleDataResult);
        return new ExampleDataDto(exampleDataResult.get().getText());
    }
}
