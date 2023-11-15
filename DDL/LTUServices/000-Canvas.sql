create or replace table Canvas
(
    canvasID         int         not null,
    fNamn            int         null,
    eNamn            varchar(45) null,
    studentAnvandare varchar(45) null,
    primary key (canvasID)
);

