-- criação dos script para o CRUD no banco de dados
use coma_bem_db;

show tables;

-- CREATE 
describe Produto;
 
insert into Produto (nome, preco) values ('carne', 23.57);

describe Pedidos;

insert into Pedidos (id_produto, quantidade, valor)	values (2, 3, 0);
	
select * from Pedidos;

-- READ
select * from Pedidos; 

select * from Produto;

select po.nome,po.preco as 'Preço unitário', pe.quantidade, pe.data, pe.quantidade * po.preco as 'Valor do Pedido'
	from Pedidos as pe
	inner join Produto as po on (pe.id_produto = po.id_produto);


-- UPDATE 
update Produto set preco = 3.78 where id_produto = 1;

update Pedidos set valor =(
		select po.preco * pe.quantidade 
		from Pedidos as pe
		inner join Produto as po 
			on (pe.id_produto = po.id_produto)
		where po.id_produto =1)
	where id_pedido = 1;

-- DELETE 
delete from Pedidos where id_pedido = 2;

 -- Deletando um produto que tem relação com outra tabela Pedido
delete from Pedidos where id_pedido = 1;

delete from Produto where id_produto  =1;