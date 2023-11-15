create or replace table Examination
(
    examinationID int         not null,
    datum         varchar(45) null,
    typ           varchar(45) null,
    modulID       int         not null,
    primary key (examinationID),
    constraint Examination1
        foreign key (modulID) references Modul (modulID)
);

create or replace index Examination1_idx
    on Examination (modulID);

