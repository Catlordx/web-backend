package org.jianwen.webbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitRecord {
    private Integer visitId;
    private String cardId;
    private Date visitTime;
}
