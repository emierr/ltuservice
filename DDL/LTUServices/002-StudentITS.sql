create or replace table StudentITS
(
    studentID int         not null,
    personNr  varchar(45) null,
    canvasID  int         not null,
    primary key (studentID, canvasID),
    constraint StudentITS1
        foreign key (canvasID) references Canvas (canvasID)
);

create or replace index StudentITS1_idx
    on StudentITS (canvasID);

