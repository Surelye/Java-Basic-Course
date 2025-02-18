CREATE TABLE IF NOT EXISTS "student" (
    "id" BIGSERIAL PRIMARY KEY,
    "firstname" VARCHAR(32) NOT NULL,
    "lastname" VARCHAR(32) NOT NULL,
    "birthdate" DATE NOT NULL,
    "email" VARCHAR(64) UNIQUE,
    "created_at" TIMESTAMP NOT NULL,
    "last_modified_at" TIMESTAMP NOT NULL
);

INSERT INTO student (firstname, lastname, birthdate, email, created_at, last_modified_at)
VALUES ('John', 'Doe', '2000-01-01', 'john.doe@example.com', NOW(), NOW());