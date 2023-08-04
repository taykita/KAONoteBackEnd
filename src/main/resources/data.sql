CREATE TABLE ACCOUNT (
    ID int NOT NULL,
    email varchar(50) NOT NULL,
    first_name varchar(30),
    last_name varchar(30),
    PRIMARY KEY (ID)
);

CREATE SEQUENCE ACCOUNT_SEQ
    MINVALUE 1
    MAXVALUE 99999999999
    START WITH 1
    INCREMENT BY 10
    CACHE 20;

CREATE TABLE NOTE (
    path varchar(1000) NOT NULL,
    text varchar(1000) NOT NULL,
    acc_ID int NOT NULL,
    PRIMARY KEY (path)
);

CREATE TABLE TASK (
    path varchar(1000) NOT NULL,
    text varchar(1000) NOT NULL,
    date_start date NOT NULL,
    date_end date,
    is_done bool,
    priority int,
    acc_ID int NOT NULL,
    PRIMARY KEY (path)
)


