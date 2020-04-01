package com.spring.tutorial.common;

public class RestApiEndpoints {
    private static final String BASE_PATH = "/api";

    public static final String ALL_EVENTS = BASE_PATH + "/all-events";
    public static final String EVENT = BASE_PATH + "/event";
    public static final String EVENT_ID = EVENT + "/{id}";
    public static final String ALL_EVENTS_START_DATE = ALL_EVENTS + "/start-date";
}
