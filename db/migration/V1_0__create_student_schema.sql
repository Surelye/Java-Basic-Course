CREATE TABLE IF NOT EXISTS "student" (
    "id" BIGSERIAL PRIMARY KEY,
    "firstname" VARCHAR(32) NOT NULL,
    "lastname" VARCHAR(32) NOT NULL,
    "birthdate" DATE NOT NULL,
    "email" VARCHAR(64) UNIQUE
);

INSERT INTO student (firstname, lastname, birthdate, email)
VALUES ('John', 'Doe', '2000-01-01', 'john.doe@example.com');