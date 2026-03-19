-- CREATE DATABASE IF NOT EXISTS inventory_management;

-- use inventory_management;

CREATE TABLE IF NOT EXISTS products (
    id VARCHAR(36) PRIMARY KEY,
    name VARCHAR(100),
    quantity INT,
    price DOUBLE
);