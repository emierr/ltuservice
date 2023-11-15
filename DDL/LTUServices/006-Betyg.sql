create or replace table Betyg
(
    ladokID      int         not null,
    betyg        varchar(45) null,
    modulBetygID int         not null,
    canvasID     int         not null,
    status       varchar(45) null,
    primary key (ladokID),
    constraint Betyg1
        foreign key (modulBetygID) references ModulOmdome (modulBetygID),
    constraint Betyg2
        foreign key (canvasID) references Canvas (canvasID)
);

create or replace index Betyg1_idx
    on Betyg (modulBetygID);

create or replace index Betyg2_idx
    on Betyg (canvasID);

