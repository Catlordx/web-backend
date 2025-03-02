package org.jianwen.webbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowRecord {
    private Integer recordId;
    private Integer cardId;
    private Integer copyId;
    private Date borrowTime;
    private Date dueDate;
    private Date returnTime;
}
