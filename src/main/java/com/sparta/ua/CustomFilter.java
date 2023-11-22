package com.sparta.ua;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class CustomFilter implements Filter {

    String wordOrSentence;

    public CustomFilter(String wordOrSentence) {
        this.wordOrSentence = wordOrSentence;
    }

    @Override
    public boolean isLoggable(LogRecord record) {
        return record.getMessage().contains(wordOrSentence);
    }
}
