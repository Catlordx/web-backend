package org.jianwen.webbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Integer bookId;   // 书籍唯一ID
    private String title;     // 书名
    private String author;    // 作者
    private String isbn;      // ISBN编号
    private String category;  // 书籍类别
    private String publisher; // 出版社
    private Integer year;     // 出版年份
    private Integer layer;    // 存放楼层
}
