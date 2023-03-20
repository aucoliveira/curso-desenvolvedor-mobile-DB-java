use coma_bem_db;

-- Criação do usuário administrador do banco de dados, o mesmo não possuei nem acesso ainda ao shell do MySQL ou MariaDB
create user administrador_db@localhost identified by '123456';

-- Adicionando os previlégios ao usuário recém criado.
grant all privileges on coma_bem_db.* to administrador_db@localhost;

-- Criando um usuário comum, o mesmo só terá acesso somente a pesquisa, inserção e atualização de dados
create user usuario_db@localhost identified by '1234';

-- Adicionando os previlégios ao usuário
grant  create, select, update on coma_bem_db.* to usuario_db;


