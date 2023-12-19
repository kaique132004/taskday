CREATE TABLE tasks(
    id_task varchar(255) UNIQUE NOT NULL PRIMARY KEY,
    name_task varchar(80) NOT NULL,
    status varchar(30) NOT NULL,
    data_cad_task TIMESTAMP NOT NULL,
    data_prv_task TIMESTAMP NOT NULL,
    active boolean not null
);