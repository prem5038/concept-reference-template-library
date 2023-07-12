-- DROP SCHEMA pandora;

CREATE SCHEMA pandora AUTHORIZATION postgres;

-- pandora.employee definition

-- Drop table

-- DROP TABLE pandora.employee;

CREATE TABLE pandora.employee (
	id int8 NOT NULL,
	"name" varchar NULL,
	address varchar NULL,
	CONSTRAINT employee_pk PRIMARY KEY (id)
);