create table if not exists users(
                      username varchar(50) not null primary key,
                      password text not null,
                      enabled boolean not null
);

create table if not exists authorities (
                             username varchar(50) not null,
                             authority varchar(50) not null,
                             constraint fk_authorities_users foreign key(username) references users(username)
);

create unique index if not exists ix_auth_username on authorities (username,authority);

/* Si on travaille avec jpa alors "spring.jpa.hibernate.ddl-auto=none" permet de voir si il ya un fichier schema.sql on l'execute au dbt */