create table ctc
(
    ctc_id   int auto_increment
        primary key,
    tc_id    int null,
    clazz_id int null
);

create index FK_Reference_5
    on ctc (tc_id);

create index FK_Reference_6
    on ctc (clazz_id);

INSERT INTO hmk_manager.ctc (ctc_id, tc_id, clazz_id) VALUES (6, 13, 1);
INSERT INTO hmk_manager.ctc (ctc_id, tc_id, clazz_id) VALUES (7, 13, 2);
