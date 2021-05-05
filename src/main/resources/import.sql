use food;
START TRANSACTION;
insert into kitchens (id, name) values (1, 'Tailandesa');
insert into kitchens (id, name) values (2, 'Indiana');
insert into kitchens (id, name) values (3, 'Brasileira');

insert into restaurant (nome, taxa_frete, kitchen_id)  values('Castelo', 10.50, 1), ('Tapiocaria', 5.30, 3);

COMMIT;