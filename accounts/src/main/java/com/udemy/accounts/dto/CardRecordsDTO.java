package com.udemy.accounts.dto;

import lombok.*;

import java.util.*;

@Data
public class CardRecordsDTO {
    public String message;
    public HashMap<String,String> contactDetails;
    public List<String> onCallSupoort;
}
