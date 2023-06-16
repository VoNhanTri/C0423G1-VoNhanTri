create database Furama;
CREATE TABLE job_position (
    id_position INT PRIMARY KEY,
    name_position VARCHAR(45)
);
CREATE TABLE level (
    id_level INT PRIMARY KEY,
    name_level VARCHAR(45)
);
CREATE TABLE part (
    id_part INT PRIMARY KEY,
    name_part VARCHAR(45)
);
CREATE TABLE staff (
    id_staff INT PRIMARY KEY,
    name_staff VARCHAR(45) NOT NULL,
    date DATE NOT NULL,
    identity_staff VARCHAR(45) NOT NULL,
    salary_staff DOUBLE NOT NULL,
    number_phone_staff VARCHAR(45) NOT NULL,
    email_staff VARCHAR(45),
    dress_staff VARCHAR(45),
    id_position INT,
    id_level INT,
    id_part INT,
    FOREIGN KEY (id_position)
        REFERENCES job_position (id_position),
    FOREIGN KEY (id_level)
        REFERENCES level (id_level),
    FOREIGN KEY (id_part)
        REFERENCES part (id_part)
);
CREATE TABLE customer_type (
    id_type_customer INT PRIMARY KEY,
    name_type_customer VARCHAR(45)
);
CREATE TABLE customer (
    id_customer INT PRIMARY KEY,
    id_type_customer INT,
    FOREIGN KEY (id_type_customer)
        REFERENCES customer_type (id_type_customer),
    name_customer VARCHAR(45) NOT NULL,
    date_customer DATE NOT NULL,
    gender_customer BIT NOT NULL,
    identity_customer VARCHAR(45) NOT NULL,
    number_phone_customer VARCHAR(45) NOT NULL,
    email_customer VARCHAR(45),
    dress_customer VARCHAR(45)
);
CREATE TABLE rental_type (
    id_rental_type INT PRIMARY KEY,
    name_rental_type VARCHAR(45)
);
CREATE TABLE type_service (
    id_type_service INT PRIMARY KEY,
    name_type_service VARCHAR(45)
);
CREATE TABLE service (
    id_service INT PRIMARY KEY,
    name_service VARCHAR(45) NOT NULL,
    area_service INT,
    expense_service DOUBLE NOT NULL,
    maximum_service INT,
    id_rental_type INT,
    id_type_service INT,
    FOREIGN KEY (id_rental_type)
        REFERENCES rental_type (id_rental_type),
    FOREIGN KEY (id_type_service)
        REFERENCES type_service (id_type_service),
    room_standart VARCHAR(45),
    describe_service VARCHAR(45),
    area_pool DOUBLE,
    floors INT
);
CREATE TABLE contract (
    id_contract INT PRIMARY KEY,
    date_contract DATETIME NOT NULL,
    date_end DATETIME NOT NULL,
    deposits DOUBLE NOT NULL,
    id_staff INT,
    id_customer INT,
    id_service INT,
    FOREIGN KEY (id_staff)
        REFERENCES staff (id_staff),
    FOREIGN KEY (id_customer)
        REFERENCES customer (id_customer),
    FOREIGN KEY (id_service)
        REFERENCES service (id_service)
);
CREATE TABLE accompanied_service (
    id_accompanied_service INT PRIMARY KEY,
    name_accomanied_service VARCHAR(45),
    price DOUBLE NOT NULL,
    unit VARCHAR(10) NOT NULL,
    status VARCHAR(45)
);
drop table contract_detailed;
CREATE TABLE contract_detailed (
    id_contract_detailed INT PRIMARY KEY,
    quantity INT,
    id_contract INT,
    id_accompanied_service INT,
    FOREIGN KEY (id_contract)
        REFERENCES contract (id_contract),
    FOREIGN KEY (id_accompanied_service)
        REFERENCES accompanied_service (id_accompanied_service)
);