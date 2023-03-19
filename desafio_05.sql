create schema coma_bem_db;

show databases;

use coma_bem_db;

create table Produto (
	id_produto int not null auto_increment primary key,
	nome varchar(60) not null,
	preco double not null
	);
	

create table Pedidos (
	id_produto int not null,
	id_pedido int not null,
	quantidade double not null,
	data dateSt not null,
	constraint fk_produto foreign key(id_produto)
	references Produto (id_produto)
	);
	
show tables;

insert into Produto (nome, preco) values ('Pão', 1.20);
 
select * from Produto;

describe Pedidos;

alter table Pedidos modify column id_pedido int not null auto_increment primary key;

describe Pedidos;

alter table Pedidos modify column data timestamp default current_timestamp;

describe Pedidos;

insert into Pedidos (id_produto, quantidade) values (1, 3);

select * from Pedidos;

-- Alterando de DOUBLE para DECIMAL  na tabela Produtos
alter table Produto modify column preco decimal(10,2) not null;

describe Produto;

-- Adicionando a tabela Pedidos mais um campo, o valor;
alter table Pedidos add valor decimal(10,2) not null;

describe Pedidos;

-- Alterando um dado na tabela Pedidos.
select * from Pedidos;

update Pedidos set valor = (
		select pe.quantidade * po.preco 
		from Pedidos as pe 
		inner join Produto as po on (pe.id_produto = po.id_produto)
	)
	where id_pedido = 1;
	
select * from Pedidos;

select po.nome, pe.quantidade, pe.data, pe.valor
	from Pedidos as pe
	inner join Produto as po on (pe.id_produto = po.id_produto); 
