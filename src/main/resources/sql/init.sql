CREATE TABLE orders (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        user_id BIGINT NOT NULL COMMENT '用户ID，关联 user.id',
                        amount DECIMAL(10,2) NOT NULL COMMENT '订单金额',
                        create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '下单时间'
);
INSERT INTO orders (user_id, amount) VALUES (1, 100.50), (1, 200.00), (2, 50.00);

CREATE TABLE comment (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         parent_id BIGINT DEFAULT 0 COMMENT '父级ID，0表示顶级评论',
                         content TEXT NOT NULL COMMENT '评论内容',
                         create_time DATETIME DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO comment (parent_id, content) VALUES
                                             (0, '这是一条顶级评论'),
                                             (0, '这是另一条顶级评论'),
                                             (1, '回复第一条顶级评论'),
                                             (1, '也是回复第一条顶级评论'),
                                             (3, '回复第二条评论的子评论');

drop table orders

