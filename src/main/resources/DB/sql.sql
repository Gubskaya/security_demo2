---скрипт для варианта с JDBC auth
CREATE TABLE users(
                      username varchar(100) NOT NULL PRIMARY KEY,
                      password varchar(100) NOT NULL,
                      enabled boolean NOT NULL
);

CREATE TABLE authorities (
                             username varchar(100) NOT NULL UNIQUE ,
                             authority varchar(100) NOT NULL UNIQUE ,
                             foreign key (username) references users(username)
);




---

CREATE TABLE roles(
    id bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name varchar(100) NOT NULL UNIQUE
);

CREATE TABLE users(
    id bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    username varchar(100) NOT NULL,
    password varchar(100) NOT NULL,
    email varchar(100) NOT NULL,
    role_id bigint references roles(id)
);

CREATE TABLE users_roles(
    user_id bigint references users(id),
    role_id bigint references roles(id)
);