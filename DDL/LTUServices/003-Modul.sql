create or replace table Modul
(
    modulID     int         not null,
    Epok_kursID int         not null,
    aktiv       varchar(45) null,
    primary key (modulID, Epok_kursID),
    constraint Modul
        foreign key (Epok_kursID) references Epok (kursID)
);

create or replace index Modul_idx
    on Modul (Epok_kursID);

