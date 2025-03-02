-- 1. 用户表（只有拥有校园卡的人可以借书）
CREATE TABLE users
(
    card_id   CHAR(6) PRIMARY KEY,                -- 校园卡号，6位
    name      VARCHAR(50)               NOT NULL, -- 姓名
    user_type ENUM ('student', 'staff') NOT NULL, -- 用户类型（学生/教职工）
    email     VARCHAR(100) UNIQUE,                -- 邮箱（可选）
    phone     VARCHAR(20) UNIQUE                  -- 手机号码（可选）
);

-- 2. 书籍信息表（存储每本书的基本信息）
CREATE TABLE books
(
    book_id   INT PRIMARY KEY AUTO_INCREMENT,   -- 书籍唯一ID
    title     VARCHAR(255) NOT NULL,            -- 书名
    author    VARCHAR(255) NOT NULL,            -- 作者
    isbn      VARCHAR(20) UNIQUE,               -- 国际标准书号
    category  VARCHAR(100) NOT NULL,            -- 书籍类别
    publisher VARCHAR(255),                     -- 出版社
    year      INT,                              -- 出版年份
    layer     INT CHECK (layer BETWEEN 1 AND 7) -- 存放楼层（1-7层）
);

-- 3. 书籍副本表（每本书的具体副本信息）
CREATE TABLE book_copies
(
    copy_id  INT PRIMARY KEY AUTO_INCREMENT,                     -- 副本唯一ID
    book_id  INT         NOT NULL,                               -- 书籍ID
    shelf_id VARCHAR(20) NOT NULL,                               -- 书架编号
    status   ENUM ('available', 'borrowed') DEFAULT 'available', -- 副本状态（可借/已借）
    FOREIGN KEY (book_id) REFERENCES books (book_id) ON DELETE CASCADE
);

-- 4. 借阅记录表（存储图书借阅情况）
CREATE TABLE borrow_records
(
    record_id   INT PRIMARY KEY AUTO_INCREMENT, -- 借阅记录ID
    card_id     CHAR(6) NOT NULL,               -- 借书人校园卡号
    copy_id     INT     NOT NULL,               -- 借阅的副本ID
    borrow_date DATE    NOT NULL,               -- 借书日期
    due_date    DATE    NOT NULL,               -- 归还期限（借出后+30天）
    return_date DATE    NULL,                   -- 归还日期（未归还则为NULL）
    FOREIGN KEY (card_id) REFERENCES users (card_id) ON DELETE CASCADE,
    FOREIGN KEY (copy_id) REFERENCES book_copies (copy_id) ON DELETE CASCADE
);

-- 5. 到访记录表（存储用户进出图书馆的记录）
CREATE TABLE visit_records
(
    visit_id   INT PRIMARY KEY AUTO_INCREMENT,     -- 访问记录ID
    card_id    CHAR(6) NOT NULL,                   -- 访问者校园卡号
    visit_time DATETIME DEFAULT CURRENT_TIMESTAMP, -- 进入时间
    FOREIGN KEY (card_id) REFERENCES users (card_id) ON DELETE CASCADE
);

-- 6. 系统日志表（记录关键操作）
CREATE TABLE logs
(
    log_id    INT PRIMARY KEY AUTO_INCREMENT,     -- 日志ID
    card_id   CHAR(6)     NOT NULL,               -- 操作人校园卡号
    action    VARCHAR(50) NOT NULL,               -- 操作类型（借书、还书、到访等）
    copy_id   INT         NULL,                   -- 相关副本ID（如果涉及书籍）
    timestamp DATETIME DEFAULT CURRENT_TIMESTAMP, -- 操作时间
    FOREIGN KEY (card_id) REFERENCES users (card_id) ON DELETE CASCADE
);

-- Trigger To restrict a people can borrow 5 books at most.
