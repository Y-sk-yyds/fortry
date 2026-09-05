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

drop table dish;

CREATE TABLE dish (
                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                      name VARCHAR(100) NOT NULL COMMENT '菜品名称' unique,
                      price DECIMAL(10,2) NOT NULL COMMENT '价格',
                      description VARCHAR(255) COMMENT '描述',
                      create_time DATETIME DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO dish (name, price, description) VALUES
                                                ('番茄炒蛋', 28.00, '经典家常菜'),
                                                ('酸辣土豆丝', 18.00, '酸辣开胃'),
                                                ('红烧肉', 48.00, '肥而不腻');
-- 插入几个菜品
INSERT INTO dish (name, price, description) VALUES
                                                ('麻婆豆腐', 22.00, '麻辣鲜香，下饭神器'),
                                                ('清炒时蔬', 15.00, '清淡爽口，健康首选');


CREATE TABLE order_item (
                            id BIGINT PRIMARY KEY AUTO_INCREMENT,
                            order_id BIGINT NOT NULL COMMENT '订单ID',
                            dish_id BIGINT NOT NULL COMMENT '菜品ID',
                            quantity INT NOT NULL DEFAULT 1 COMMENT '数量',
                            price DECIMAL(10,2) NOT NULL COMMENT '下单时单价',
                            create_time DATETIME DEFAULT CURRENT_TIMESTAMP
);