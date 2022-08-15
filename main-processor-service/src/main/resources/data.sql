insert into products(id, name, description, category)
values (1, 'testProduct1', 'just for testing purpose 1', 'ANY'),
       (2, 'testProduct2', 'just for testing purpose 2', 'ANY'),
       (3, 'testProduct3', 'just for testing purpose 3', 'ANY') on conflict(id) do nothing;

insert into suppliers(id, name, address, description, rating)
values (1, 'testSupplier1', 'ssww', 'just for testing purpose 1', 10),
       (2, 'testSupplier2', 'eeqq', 'just for testing purpose 2', 9),
       (3, 'testSupplier3', 'aadd', 'just for testing purpose 3', 8) on conflict(id) do nothing;

insert into carts(id, user_id)
values (1, 1) on conflict(id) do nothing;

insert into products_cost_and_suppliers(id, product_id, supplier_id, cost, amount)
values (1, 1, 1, 12.2, 10),
       (2, 3, 3, 1.2, 11),
       (3, 2, 2, 123.2, 12) on conflict(id) do nothing;

BEGIN;

LOCK TABLE products, carts, suppliers, products_cost_and_suppliers IN ACCESS EXCLUSIVE MODE;
-- updating cursor to prevent exception with violation *_pkey = *
SELECT setval('products_id_seq', COALESCE((SELECT MAX(id) + 1 FROM products), 1), false);
SELECT setval('carts_id_seq', COALESCE((SELECT MAX(id) + 1 FROM carts), 1), false);
SELECT setval('suppliers_id_seq', COALESCE((SELECT MAX(id) + 1 FROM suppliers), 1), false);
SELECT setval('products_cost_and_suppliers_id_seq', COALESCE((SELECT MAX(id) + 1 FROM products_cost_and_suppliers), 1), false);

COMMIT;