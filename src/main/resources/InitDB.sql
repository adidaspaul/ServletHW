CREATE TABLE developers (
    id serial primary key,
    name varchar(255) NOT null,
    sex varchar(6) NOT null,
    salary decimal
);

CREATE TABLE skills(
    id serial primary key,
    rank varchar(255) NOT NULL,
    syntax varchar (255)
);

CREATE TABLE projects(
    id serial primary key,
    project_name varchar(255) NOT NULL,
    start_date date NOT NULL,
    cost decimal
);

CREATE TABLE companies(
    id serial primary key,
    company_name varchar(255) NOT null,
    city varchar(255) NOT null
);

CREATE TABLE clients(
    id serial primary key,
    name varchar(255) NOT null,
    country varchar(255) NOT null,
    category varchar(255) NOT null
);
