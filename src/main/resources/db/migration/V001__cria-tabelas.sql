create table funcionario(
id bigint not null auto_increment primary key,
nome varchar(255) not null,
email varchar(255) not null,
cargo varchar(255) not null,
status_participacao boolean not null

);

create table pergunta (
id bigint not null auto_increment primary key,
descricao varchar(255) not null,
tipo_resposta varchar(50) not null,
pesquisa_id bigint not null

);

create table pesquisa (
id bigint not null auto_increment primary key,
titulo varchar(255) not null,
data_inicio date not null,
data_fim date not null

);

create table resposta (
id bigint not null auto_increment primary key, 
pontuacao bigint,
resposta_livre TEXT,
pergunta_id bigint not null,
funcionario_id bigint not null

);