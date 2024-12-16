CREATE TABLE student
(
    id SERIAL PRIMARY KEY,
    lastname character varying(30) NOT NULL,
    firstname character varying(30) NOT NULL,
    surname character varying(30) NOT NULL,
    phone character varying(15),
    email character varying(50),
    telegram character varying(30),
    git character varying(50)
)