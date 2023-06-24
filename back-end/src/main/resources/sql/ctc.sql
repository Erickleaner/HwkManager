create table ctc
(
    ctc_id   int auto_increment
        primary key,
    tc_id    int null,
    clazz_id int null,
    constraint FK_Reference_5
        foreign key (tc_id) references tc (tc_id),
    constraint FK_Reference_6
        foreign key (clazz_id) references clazz (clazz_id)
);

