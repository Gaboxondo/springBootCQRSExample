CREATE TABLE IF NOT EXISTS accounts (
id varchar(255) NOT NULL,
account_holder varchar(100) NULL,
creation_date timestamp NULL,
opening_balance float4 NULL,
version int8 NULL);
