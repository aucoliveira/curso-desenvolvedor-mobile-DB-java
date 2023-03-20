create schema coma_bem_db;

show databases;

-- Selecionando o Banco de dados
use coma_bem_db;

-- Criando as Tabelas

create table Produto (
	id_produto int not null auto_increment primary key,
	nome varchar(60) not null,
	preco double not null
	);
	

create table Pedidos (
	id_produto int not null,
	id_pedido int not null,
	quantidade double not null,
	data date not null,
	constraint fk_produto foreign key(id_produto)
	references Produto (id_produto)
	);

-- Listando as Tabelas
	
show tables;


-- Alterando dados de uma tabela
describe Pedidos;

alter table Pedidos modify column id_pedido int not null auto_increment primary key;

describe Pedidos;

alter table Pedidos modify column data timestamp default current_timestamp;

describe Pedidos;

-- Alterando de DOUBLE para DECIMAL  na tabela Produtos
alter table Produto modify column preco decimal(10,2) not null;

describe Produto;

-- Adicionando a tabela Pedidos mais um campo, o valor;
alter table Pedidos add valor decimal(10,2) not null;

describe Pedidos;


