CREATE TABLE `account` (
username varchar(100) PRIMARY KEY ,
`password` varchar(250) 
);
CREATE TABLE profile(
`name` varchar(100),
 dob DATE,
 aadress varchar(250),
 username varchar(100),
 FOREIGN KEY (username) REFERENCES `account`(username)
);
