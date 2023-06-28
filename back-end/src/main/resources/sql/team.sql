create table team
(
    team_id     int auto_increment
        primary key,
    homework_id int null,
    constraint FK_Reference_8
        foreign key (homework_id) references homework (homework_id)
);

INSERT INTO hmk_manager.team (team_id, homework_id) VALUES (1, 7);
INSERT INTO hmk_manager.team (team_id, homework_id) VALUES (2, 7);
INSERT INTO hmk_manager.team (team_id, homework_id) VALUES (3, 7);
INSERT INTO hmk_manager.team (team_id, homework_id) VALUES (4, 7);
INSERT INTO hmk_manager.team (team_id, homework_id) VALUES (5, 7);
INSERT INTO hmk_manager.team (team_id, homework_id) VALUES (6, 7);
INSERT INTO hmk_manager.team (team_id, homework_id) VALUES (7, 7);
INSERT INTO hmk_manager.team (team_id, homework_id) VALUES (8, 7);
