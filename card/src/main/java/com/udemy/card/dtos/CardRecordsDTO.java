package com.udemy.card.dtos;

import lombok.*;

import java.util.*;

@Data
public class CardRecordsDTO {
    public String message;
    public HashMap<String,String> contactDetails;
    public List<String> onCallSupoort;
}
