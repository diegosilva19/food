use food;
START TRANSACTION;
insert into kitchens (id, name) values (1, 'Tailandesa');
insert into kitchens (id, name) values (2, 'Indiana');
insert into kitchens (id, name) values (3, 'Brasileira');

insert into restaurant (nome, taxa_frete, kitchen_id)  values('Castelo', 10.50, 1), ('Tapiocaria', 5.30, 3);

insert into permissions (name, description) values ('insert-product', 'insere informação do produto');
insert into permissions (name, description) values ('edit-product', 'editar informação do produto');
insert into permissions (name, description) values ('exclude-product', 'excluir informação do produto');

insert into payment_type (name) values ('Cartão de crédito'), ('Dinheiro');

insert into states (name, uf) values ('São Paulo', 'SP');
insert into cities (name, state_id) values ('Diadema', 1 );

COMMIT;