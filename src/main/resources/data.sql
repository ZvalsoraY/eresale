
INSERT INTO Users (user_name, password, name, phone_number, role)
VALUES ('admin','admin','admin','8000000', 'ADMIN'),
('user','user','user','7000000', 'USER');

INSERT INTO Products (product_name, description, user_id, price, currency)
VALUES ('adminProduct','adminProduct',1, 10.02, 'RUB');

INSERT INTO Deals (seller_id, buyer_id, product_id, deal_date, deal_price, currency)
VALUES (1,2,1, '2024-01-01 00:00:00', 1110.02, 'RUB');

