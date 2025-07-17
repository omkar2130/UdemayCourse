package com.udemy.accounts.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.*;


@Data
@MappedSuperclass
@ToString
public class BaseEntity {

    @Column(updatable = false)
    private LocalDateTime createdAt;
    @Column(updatable = false)
    private String createdBy;

    @Column(insertable = false)
    private LocalDateTime updatedAt;
    @Column(insertable = false)
    private String updatedBy;
}
