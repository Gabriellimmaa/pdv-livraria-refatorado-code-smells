create database livraria
default character set utf8
default collate utf8_general_ci;

use livraria;

create table if not exists Funcionario (
idFuncionario int not null auto_increment primary key, 
dataNascimento date, 
fcpf varchar(14)
) default charset = utf8;

create table if not exists Pessoas (
nome varchar(45) not null, 
cpf varchar(14) not null unique primary key,
email varchar(250) not null, 
endereco varchar(250) not null
) default charset = utf8;

create table if not exists Livros (
idLivro int not null auto_increment primary key,
titulo varchar(100) not null,
dataPublicaçao date,
genero varchar(20) not null,
autor varchar(45) not null,
qtdDeEstoque int,
valorUnitario float,
cnpjEdit varchar(18) not null
) default charset = utf8;

create table if not exists Pedido (
idPedido int not null auto_increment primary key,
dataPedido date,
tipoPedido varchar(100) not null,
codLivro int 
) default charset = utf8;

create table if not exists Cliente (
cnpjCliente varchar(18), 
clienteCpf varchar(14) primary key
) default charset = utf8;

create table if not exists Editora (
cnpjEditora varchar(18) not null primary key,
nomeEditora varchar(50) not null,
enderecoEditora varchar(255) not null 
) default charset = utf8;

create table if not exists Telefone (
telefoneCnpj varchar(18) not null,
numero int not null,
primary key(telefoneCnpj, numero)
) default charset = utf8;

create table if not exists Venda (
idVenda int not null auto_increment primary key,
dataVenda date,
codLivro int,
quantidade int,
codFuncionario int 
) default charset = utf8;

alter table Cliente 
add foreign key(clienteCpf)
references Pessoas(cpf);

alter table Funcionario 
add foreign key(fcpf)
references Pessoas(cpf);

alter table Livros 
add foreign key(cnpjEdit)
references Editora(cnpjEditora);

alter table Pedido 
add foreign key(codLivro)
references Livros(idLivro);

alter table Telefone
add foreign key(telefoneCnpj)
references Editora(cnpjEditora);

alter table Venda 
add foreign key(codLivro)
references Livros(idLivro);

alter table Venda
add foreign key(codFuncionario)
references Funcionario(idFuncionario);
