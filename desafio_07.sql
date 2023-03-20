-- criação dos script para o CRUD no banco de dados
use coma_bem_db;

show tables;
-- CREATE 
describe Produto;
 
insert into Produto (nome, preco) values ('carne', 23.57);

select * from Produto;

describe Pedidos;

insert into Pedidos (
	id_produto, quantidade, valor)
	values (
	2, 3,(select po.preco
		from Pedidos as pe
		inner join Produto as po
		on (pe.id_produto = po.id_produto)
		where po.id_produto =2)
	);
	
select * from Pedidos;


delete from Pedidos where id_pedido = 4;