INSERT INTO Users (user_name, password, name, phonenumber)
VALUES ('admin','admin','admin','8000000'),
('user','user','user','7000000');

INSERT INTO Roles (role_name, description)
VALUES ('ROLE_ADMIN', 'ADMIN'),
('ROLE_USER', 'USER');

INSERT INTO UsersRoles (user_id, role_id)
VALUES (1, 1),
(2, 2);