create or replace table ModulOmdome
(
    modulBetygID int         not null,
    canvasID     int         not null,
    modulID      int         not null,
    omdome       varchar(45) null,
    primary key (modulBetygID),
    constraint ModulBetyg1
        foreign key (canvasID) references Canvas (canvasID),
    constraint ModulBetyg2
        foreign key (modulID) references Modul (modulID)
);

create or replace index ModulBetyg1_idx
    on ModulOmdome (canvasID);

create or replace index ModulBetyg2_idx
    on ModulOmdome (modulID);

