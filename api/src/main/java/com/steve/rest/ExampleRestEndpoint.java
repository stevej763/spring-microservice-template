package com.steve.rest;

import com.steve.core.CoreService;
import com.steve.core.ExampleDataDto;
import com.steve.core.ExampleDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ExampleRestEndpoint {

    private final CoreService coreService;

    public ExampleRestEndpoint(CoreService coreService) {
        this.coreService = coreService;
    }

    @GetMapping(value = "/", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getExample() {
        System.out.println("Example GET endpoint called");
        String coreResponse = coreService.getData();
        return ResponseEntity.ok("Example GET rest endpoint response: " + coreResponse);
    }

    @PostMapping(value = "/", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postExample(@RequestBody ExampleRequest request) {
        System.out.println("Example POST endpoint called");
        ExampleDataDto coreResponse = coreService.postData(new ExampleDto(request.text()));
        return ResponseEntity.ok("Example POST rest endpoint response: " + coreResponse);
    }
}
