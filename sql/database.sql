/* jdbc:mysql://localhost:3306/storedb */
CREATE DATABASE storedb;
use storedb;

create table Product (productID int, name varchar(20), category varchar(20), price float);

ALTER TABLE Product
    ADD CONSTRAINT PK_Product PRIMARY KEY (productId);

insert into Product values (101, 'Product 1', 'Category 1' , 12456.78);
insert into Product values (102, 'Product 2', 'Category 1' , 22456.78);
insert into Product values (103, 'Product 3', 'Category 1' , 32456.78);
insert into Product values (104, 'Product 4', 'Category 2' , 42456.78);
insert into Product values (105, 'Product 5', 'Category 2' , 52456.78);
insert into Product values (106, 'Product 6', 'Category 2' , 62456.78);

SELECT * from Product;