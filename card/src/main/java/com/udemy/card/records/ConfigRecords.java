package com.udemy.card.records;

import org.springframework.boot.context.properties.*;

import java.util.*;

@ConfigurationProperties(prefix = "accounts")
public record ConfigRecords(String message, HashMap<String,String> contactDetails, List<String> onCallSupoort) {
}
