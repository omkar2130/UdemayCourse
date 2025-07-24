package com.udemy.card.services;

import com.udemy.card.dtos.*;
import com.udemy.card.records.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class CardService implements ICardService {

    @Autowired
    ConfigRecords records;
    @Override
    public CardRecordsDTO  getDetails(){
        CardRecordsDTO cardRecordsDTO=new CardRecordsDTO();
        cardRecordsDTO.setContactDetails(records.contactDetails());
        cardRecordsDTO.setMessage(records.message());
        cardRecordsDTO.setOnCallSupoort(records.onCallSupoort());
        return cardRecordsDTO;
    }
}
