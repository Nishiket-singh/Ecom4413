CREATE TABLE if not exists USERS(
   ID INT AUTO_INCREMENT PRIMARY KEY,
   FIRSTNAME VARCHAR(255),
   LASTNAME VARCHAR(255),
   EMAIL VARCHAR(255),
   PASSWORD VARCHAR(255),
   STREETADDRESS VARCHAR(255),
   POSTALCODE VARCHAR(255),
   CITY VARCHAR(255),
   COUNTRY VARCHAR(255)
);

CREATE TABLE if not exists TOKENS(
   ID INT AUTO_INCREMENT PRIMARY KEY,
   TOKEN VARCHAR(255),
   CREATEDDATE DATE,
   USERID INT
);
CREATE TABLE if not exists PRODUCTS(
   ID INT AUTO_INCREMENT PRIMARY KEY, 
   NAME VARCHAR(255),
   DESCRIPTION VARCHAR(255),
   INITIALPRICE INT,
   TOTALTIME BIGINT,
   AUCTIONTYPE VARCHAR(255),
   SHIPPINGTIME INT
);

CREATE TABLE if not exists BIDS(
   ID INT AUTO_INCREMENT PRIMARY KEY,
   BIDAMOUNT  INT,
   USERID INT,
   PRODUCTID INT
);

CREATE TABLE if not exists HIGHESTBIDS(
   ID INT AUTO_INCREMENT PRIMARY KEY,
   HIGHESTBIDAMOUNT  INT,
   USERID INT,
   PRODUCTID INT
);

CREATE TABLE if not exists ORDERS(
   ID INT AUTO_INCREMENT PRIMARY KEY,
   USERID INT,
   PRODUCTID INT
);
