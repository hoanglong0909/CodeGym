CREATE TABLE customers(
   id INT AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR(40),
   address VARCHAR(255),
   email VARCHAR(255)
);

CREATE TABLE orders(
   id INT AUTO_INCREMENT,
   staff VARCHAR(50),
   PRIMARY KEY(id),
	customer_id INT,
	FOREIGN KEY (customer_id) REFERENCES customers(id)
);
INSERT INTO customers
value(1,'long','hue','long113@gmail.com');
INSERT INTO customers
value(2,'huy','hue','hutle@gmail.com');
INSERT INTO customers
value(3,'quang','hue','quangcoi@gmail.com');

INSERT INTO orders
VALUE(1,'ha',1);
INSERT INTO orders
VALUE(2,'huy',2);
INSERT INTO orders
VALUE(3,'han',3)

