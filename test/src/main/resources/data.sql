INSERT INTO products (product_name, amount_of_credit, percent, duration, is_active, creation_date, last_update)
VALUES
    ('first_product', 200000, 6, 3, 1, '2024-05-18 00:00:00', '2024-05-18 00:00:00'),
    ('second_product', 0, 15, 0, 1, '2024-05-18 00:00:00', '2024-05-18 00:00:00'),
    ('third_product', 1000000, 12, 5, 1, '2024-05-18 00:00:00', '2024-05-18 00:00:00');
INSERT INTO rules (rule_name, min_salary, max_salary, creation_date, last_update, is_active, product_type)
VALUES
    ('first_rule_for_first_product', 0, 50000, '2024-05-18 00:00:00', '2024-05-18 00:00:00', 1, 1),
    ('first_rule_for_second_product', 0, 0, '2024-05-18 00:00:00', '2024-05-18 00:00:00', 1, 2),
    ('first_rule_for_third_product', 25000, 0, '2024-05-18 00:00:00', '2024-05-18 00:00:00', 1, 3);

