create table team_leader
(
    team_leader_id int not null
        primary key,
    team_assign_id int not null
);

create index FK_Reference_9
    on team_leader (team_assign_id);

INSERT INTO hmk_manager.team_leader (team_leader_id, team_assign_id) VALUES (1, 1);
INSERT INTO hmk_manager.team_leader (team_leader_id, team_assign_id) VALUES (2, 5);
INSERT INTO hmk_manager.team_leader (team_leader_id, team_assign_id) VALUES (3, 9);
INSERT INTO hmk_manager.team_leader (team_leader_id, team_assign_id) VALUES (4, 13);
INSERT INTO hmk_manager.team_leader (team_leader_id, team_assign_id) VALUES (5, 17);
INSERT INTO hmk_manager.team_leader (team_leader_id, team_assign_id) VALUES (6, 21);
INSERT INTO hmk_manager.team_leader (team_leader_id, team_assign_id) VALUES (7, 25);
INSERT INTO hmk_manager.team_leader (team_leader_id, team_assign_id) VALUES (8, 29);
