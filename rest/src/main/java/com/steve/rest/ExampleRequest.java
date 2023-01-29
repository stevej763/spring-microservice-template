package com.steve.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ExampleRequest(@JsonProperty("text") String text) {
}
