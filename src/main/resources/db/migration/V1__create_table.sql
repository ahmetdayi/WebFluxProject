CREATE TABLE employee
(
    id                   uuid         NOT NULL,
    name                 varchar(255) NOT NULL,
    description_metadata jsonb        ,
    PRIMARY KEY (id)
);

CREATE TABLE employer
(
    id                   uuid         NOT NULL,
    name                 varchar(255) ,
    description_metadata jsonb        ,
    employee_id_list     VARCHAR[]    ,
    PRIMARY KEY (id)
);