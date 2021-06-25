-- create a table for customers
create table Customers
(
    id     BIGINT(20) NOT NULL AUTO_INCREMENT,
    name   VARCHAR(100) NOT NULL,
    family VARCHAR(100),
    active BOOLEAN,
    PRIMARY KEY (id)
);

-- alter a table just as a sample
ALTER TABLE Customers
    ADD description varchar(200) AFTER family;