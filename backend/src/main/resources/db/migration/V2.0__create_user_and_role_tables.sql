CREATE TABLE if not exists roles
(
    id   BIGINT       NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT uk_roles_name UNIQUE (name)
    );

CREATE TABLE if not exists users
(
    id            BIGINT       NOT NULL AUTO_INCREMENT,
    email         VARCHAR(255) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    first_name    VARCHAR(100) NOT NULL,
    last_name     VARCHAR(100) NOT NULL,
    active        BIT          NOT NULL DEFAULT 1,
    created_at    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    CONSTRAINT uk_users_email UNIQUE (email)
    );

CREATE TABLE if not exists user_role
(
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    CONSTRAINT fk_user_role_user FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT fk_user_role_role FOREIGN KEY (role_id) REFERENCES roles (id)
    );

INSERT INTO roles (name)
VALUES ('CITIZEN'),
       ('ADMIN'),
       ('WORKER'),
       ('MODERATOR');