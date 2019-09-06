CREATE TABLE users (
	id BIGSERIAL PRIMARY KEY,
	PASSWORD varchar(65) NOT NULL,
	email VARCHAR (200) NOT NULL
);

INSERT INTO users VALUES ('1','$2a$10$5e3dB36HeRcozRgp8xQfw.tfD3Qsut8xu/NT9g/DSpVKg9Kzuitrq','user@mail.com');
INSERT INTO users VALUES ('2','$2a$10$5e3dB36HeRcozRgp8xQfw.tfD3Qsut8xu/NT9g/DSpVKg9Kzuitrq','admin@mail.com');