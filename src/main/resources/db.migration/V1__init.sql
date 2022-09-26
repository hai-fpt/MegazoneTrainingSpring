CREATE TABLE users
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255),
    email    VARCHAR(255)
);
CREATE TABLE roles
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);
CREATE TABLE user_roles
(
    user_id BIGINT,
    role_id INT,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id)
);
