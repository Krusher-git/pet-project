insert into products(name, description, category)
values ('testProduct1', 'just for testing purpose 1', 'ANY'),
       ('testProduct2', 'just for testing purpose 2', 'ANY'),
       ('testProduct3', 'just for testing purpose 3', 'ANY') on conflict(name) do nothing;

insert into suppliers(name, address, description, rating)
values ('testSupplier1', 'ssww', 'just for testing purpose 1', 10),
       ('testSupplier2', 'eeqq', 'just for testing purpose 2', 9),
       ('testSupplier3', 'aadd', 'just for testing purpose 3', 8) on conflict(name) do nothing;

insert into products_cost_and_suppliers(id, product_id, supplier_id, cost, amount)
values (1, 1, 1, 12.2, 10),
       (2, 3, 3, 1.2, 11),
       (3, 2, 2, 123.2, 12) on conflict(id) do nothing;