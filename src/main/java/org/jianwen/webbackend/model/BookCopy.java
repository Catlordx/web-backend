package org.jianwen.webbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookCopy {
    private Integer copyId;
    private Integer bookId;
    private String shelfId;
    private String status;
}
