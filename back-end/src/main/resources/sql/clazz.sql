create table clazz
(
    clazz_id int auto_increment
        primary key,
    name     varchar(50) null,
    major_id int         null,
    contacts varchar(50) null,
    phone    varchar(50) null,
    constraint FK_Reference_4
        foreign key (major_id) references major (major_id)
);

INSERT INTO hmk_manager.clazz (clazz_id, name, major_id, contacts, phone) VALUES (1, '202016', 1, '孙宇', '18534907896');
INSERT INTO hmk_manager.clazz (clazz_id, name, major_id, contacts, phone) VALUES (2, '202017', 1, '陈杰', '18534907896');
