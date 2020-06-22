create database oms_database;

use oms_database;

CREATE TABLE `user` (
  `userid` int NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(30) NOT NULL,
  `address` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `phone` varchar(10) NOT NULL
);

INSERT INTO `user` (`userid`, `email`, `password`, `address`, `name`, `phone`) VALUES(901, 'aastha_shah@google.com', 'aastha123', 'kolkata', 'Aastha Shah', '987889790');
INSERT INTO `user` (`userid`, `email`, `password`, `address`, `name`, `phone`) VALUES(902, 'alka_prasad@google.com', 'alka123', 'kolkata', 'Alka Prasad', '78906808');
INSERT INTO `user` (`userid`, `email`, `password`, `address`, `name`, `phone`) VALUES(903, 'saloni_lohia@google.com', 'saloni123', 'kolkata', 'Saloni Lohia', '790648533');
INSERT INTO `user` (`userid`, `email`, `password`, `address`, `name`, `phone`) VALUES(904, 'pritha_hazra@google.com', 'pritha123', 'kolkata', 'Pritha Hazra', '685309882');
INSERT INTO `user` (`userid`, `email`, `password`, `address`, `name`, `phone`) VALUES(905, 'aniruddh_kotecha@google.com', 'aniruddh12', 'kolkata', 'Aniruddh Kotecha', '797680089');
INSERT INTO `user` (`userid`, `email`, `password`, `address`, `name`, `phone`) VALUES(906, 'pulkit_vatsal@google.com', 'pulkit123', 'kolkata', 'Pulkit Vatsal', '980969075');
INSERT INTO `user` (`userid`, `email`, `password`, `address`, `name`, `phone`) VALUES(907, 'rashmi_prasad@google.com', 'rashmi123', 'kolkata', 'Rashmi Prasad', '989788987');
INSERT INTO `user` (`userid`, `email`, `password`, `address`, `name`, `phone`) VALUES(908, 'avnish_kumara@google.com', 'avnish123', 'kolkata', 'Avnish Kumar', '9908674135');
INSERT INTO `user` (`userid`, `email`, `password`, `address`, `name`, `phone`) VALUES(909, 'abhishek_das@google.com', 'abhishek12', 'kolkata', 'Abhishek Das', '9978956410');
INSERT INTO `user` (`userid`, `email`, `password`, `address`, `name`, `phone`) VALUES(910, 'mohit_kumar@google.com', 'mohit123', 'kolkata', 'Mohit Kumar', '9089056490');
INSERT INTO `user` (`userid`, `email`, `password`, `address`, `name`, `phone`) VALUES(911, 'adarsh_kumar@google.com', 'adarsh123', 'kolkata', 'Adarsh Kuamr', '8979890123');
INSERT INTO `user` (`userid`, `email`, `password`, `address`, `name`, `phone`) VALUES(912, 'aman_kumar@google.com', 'aman123', 'kolkata', 'Aman Kumar', '9834534511');

CREATE TABLE `product` (
  `ProductId` int NOT NULL primary key,
  `productcode` varchar(4) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(100) NOT NULL,
  `price` int NOT NULL,
  `category` int NOT NULL
) ;

insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(1,"A001","Spoon","Stainless steel", 80, 1);
insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(2,"A002","Milk boiler","Stainless steel item", 300, 1);
insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(3,"A003","Belan","Wooden, slim", 80, 1);
insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(4,"A004","Chakla","Wooden", 300 , 1);
insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(5,"A005","Dough maker","Plastic", 120, 1);

insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(6,"B006","Bhujiya","Haldiram's Prabhuji bhujiya", 90, 2);
insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(7,"B007","Choco fills","Dark Fantasy", 30, 2);
insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(8,"B008","Hide and Seek","Choco chip cookies", 30, 2);
insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(9,"B009","Oreo","Chocolate cookies", 30, 2);
insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(10,"B010","Maggi masala","Jumbo pack", 40, 2);

insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(11,"C011","Tea","Tata tea", 60, 3);
insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(12,"C011","Coffee","Brew", 50, 3);
insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(13,"C012","Green Tea","Red label", 100, 3);
insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(14,"C014","Soup","Knorr", 10, 3);
insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(15,"C015","Sugar","1 kg packet", 40, 3);

insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(16,"C016","White powder","Amul",197, 4);
insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(17,"C017","toned milk","packaged tetra pack", 70, 4);
insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(18,"C018","bread","fresh packeet", 10, 4);
insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(19,"C019","butter","Amul", 20, 4);
insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(20,"C020","cheese","Amul", 14, 4);

insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(021,"E021","Wheat Flour","Aashirvaad", 45, 5);
insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(022,"E022","Rice","India Gate", 100, 5);
insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(023,"E023","Soya Chunks","Mother's Choice", 220, 5);
insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(024,"E024","Soya Bean Refined Oil","Fortune", 130, 5);
insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(025,"E025","Toor Dal","Tata Sampann", 150, 5);

insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(026,"F026","Onions","Fresho", 23, 6);
insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(027,"F027","Cherry Tomato","Fresho", 375, 6);
insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(028,"F028","Banana","Fresho", 40, 6);
insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(029,"F029","Musk Melon","Fresho", 35, 6);
insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(030,"F030","Broccoli","Fresho", 200, 6);

insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(031,"G031","Cocoa Body Lotion","Nivea", 940, 7);
insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(032,"G032","Shampoo","Sunsilk Thick and Long", 640, 7);
insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(033,"G033","Face Wash","Everyuth Tulsi Turmeric", 130, 7);
insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(034,"G034","Lip Balm","Nivea Cherry Shine", 940, 7);
insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(035,"G035","Deodrant","Fogg Napolean Men's", 940, 7);

insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(036,"H036","Detergent Powder","Ariel Complete", 145, 8);
insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(037,"H037","Liquid Detergent","Ezee", 180, 8);
insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(038,"H038","Toilet Cleaner","Harpic Power Plus", 180, 8);
insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(039,"H039","Room Freshner Spray","Godrej Aer Fresh", 150, 8);
insert into product(ProductId, ProductCode, Name, Description, Price, Category) values(040,"H040","Mosquito Killer Spray","Baygon Fly Lime Scent", 240, 8);


create table category(CategoryId Integer primary key, CategoryName varchar(50));

Insert into category(CategoryId, CategoryName) values(1,"HOME_AND_KITCHEN" );
Insert into category(CategoryId, CategoryName) values(2,"BISCUITS_SNACKS_CHOCOLATES" );
Insert into category(CategoryId, CategoryName) values(3,"BEVERAGES" );
Insert into category(CategoryId, CategoryName) values(4,"BREAKFAST_AND_DAIRY" );
Insert into category(CategoryId, CategoryName) values(5,"GROCERY_AND_STAPLES" );
Insert into category(CategoryId, CategoryName) values(6,"VEGETABLES_AND_FRUITS" );
Insert into category(CategoryId, CategoryName) values(7,"PERSONAL_CARE" );
Insert into category(CategoryId, CategoryName) values(8,"HOUSEHOLD_ITEMS" );

CREATE TABLE stock (ProductId Integer primary key, CategoryId Integer, StockAmount Integer);

Insert into stock values (1, 1, 30);
Insert into stock values (2, 1, 66);
Insert into stock values (3, 1, 18);
Insert into stock values (4, 1, 83);
Insert into stock values (5, 1, 62);
Insert into stock values (6, 2, 64);
Insert into stock values (7, 2, 38);
Insert into stock values (8, 2, 60);
Insert into stock values (9, 2, 89);
Insert into stock values (10, 2, 18);
Insert into stock values (11, 3, 77);
Insert into stock values (12, 3, 85);
Insert into stock values (13, 3, 41);
Insert into stock values (14, 3, 90);
Insert into stock values (15, 3, 34);
Insert into stock values (16, 4, 38);
Insert into stock values (17, 4, 50);
Insert into stock values (18, 4, 83);
Insert into stock values (19, 4, 85);
Insert into stock values (20, 4, 41);
Insert into stock values (21, 5, 70);
Insert into stock values (22, 5, 68);
Insert into stock values (23, 5, 89);
Insert into stock values (24, 5, 65);
Insert into stock values (25, 5, 72);
Insert into stock values (26, 6, 93);
Insert into stock values (27, 6, 44);
Insert into stock values (28, 6, 50);
Insert into stock values (29, 6, 63);
Insert into stock values (30, 6, 17);
Insert into stock values (31, 7, 57);
Insert into stock values (32, 7, 83);
Insert into stock values (33, 7, 73);
Insert into stock values (34, 7, 28);
Insert into stock values (35, 7, 28);
Insert into stock values (36, 8, 88);
Insert into stock values (37, 8, 45);
Insert into stock values (38, 8, 20);
Insert into stock values (39, 8, 10);
Insert into stock values (40, 8, 33);

CREATE TABLE `orders` (
  `orderId` int NOT NULL,
  `orderNum` varchar(15) NOT NULL,
  `orderedOn` date NOT NULL,
  `orderedBy` int NOT NULL,
  `status` varchar(20) NOT NULL,
  `amount` int NOT NULL 
);
INSERT INTO ORDERS VALUES (501, 'OD1234501', '2019-02-02', 912, 'PACKED', 4104);
INSERT INTO ORDERS VALUES (502, 'OD1234502', '2020-04-27', 901, 'CONFIRMED', 3964);
INSERT INTO ORDERS VALUES (503, 'OD1234503', '2019-07-25', 911, 'OUT_FOR_DELIVERY', 1050);
INSERT INTO ORDERS VALUES (504, 'OD1234504', '2019-07-04', 904, 'CONFIRMED', 4035);
INSERT INTO ORDERS VALUES (505, 'OD1234505', '2020-03-16', 909, 'OUT_FOR_DELIVERY', 2190);
INSERT INTO ORDERS VALUES (506, 'OD1234506', '2020-05-11', 905, 'PACKED', 3335);
INSERT INTO ORDERS VALUES (507, 'OD1234507', '2019-01-05', 910, 'PACKED', 3191);
INSERT INTO ORDERS VALUES (508, 'OD1234508', '2019-05-09', 903, 'BILLED', 2798);
INSERT INTO ORDERS VALUES (509, 'OD1234509', '2019-12-04', 909, 'CONFIRMED', 4194);
INSERT INTO ORDERS VALUES (510, 'OD1234510', '2019-12-15', 907, 'BILLED', 2442);
INSERT INTO ORDERS VALUES (511, 'OD1234511', '2019-03-27', 905, 'BILLED', 2507);
INSERT INTO ORDERS VALUES (512, 'OD1234512', '2019-09-06', 907, 'CONFIRMED', 2926);
INSERT INTO ORDERS VALUES (513, 'OD1234513', '2019-05-04', 911, 'OUT_FOR_DELIVERY', 4437);
INSERT INTO ORDERS VALUES (514, 'OD1234514', '2019-07-26', 909, 'OUT_FOR_DELIVERY', 1280);
INSERT INTO ORDERS VALUES (515, 'OD1234515', '2019-04-05', 904, 'BILLED', 753);
INSERT INTO ORDERS VALUES (516, 'OD1234516', '2019-01-24', 903, 'PACKED', 3719);
INSERT INTO ORDERS VALUES (517, 'OD1234517', '2019-04-01', 902, 'CONFIRMED', 1227);
INSERT INTO ORDERS VALUES (518, 'OD1234518', '2020-01-02', 906, 'OUT_FOR_DELIVERY', 1725);
INSERT INTO ORDERS VALUES (519, 'OD1234519', '2019-05-14', 911, 'CONFIRMED', 1121);
INSERT INTO ORDERS VALUES (520, 'OD1234520', '2019-03-08', 901, 'OUT_FOR_DELIVERY', 2588);
INSERT INTO ORDERS VALUES (521, 'OD1234521', '2019-08-08', 911, 'PACKED', 1261);
INSERT INTO ORDERS VALUES (522, 'OD1234522', '2020-01-29', 909, 'BILLED', 2514);
INSERT INTO ORDERS VALUES (523, 'OD1234523', '2019-10-26', 908, 'CONFIRMED', 1576);
INSERT INTO ORDERS VALUES (524, 'OD1234524', '2019-12-25', 904, 'CONFIRMED', 2262);
INSERT INTO ORDERS VALUES (525, 'OD1234525', '2019-10-11', 909, 'BILLED', 263);
INSERT INTO ORDERS VALUES (526, 'OD1234526', '2020-04-19', 903, 'CONFIRMED', 3970);
INSERT INTO ORDERS VALUES (527, 'OD1234527', '2020-03-07', 909, 'PACKED', 992);
INSERT INTO ORDERS VALUES (528, 'OD1234528', '2019-11-10', 902, 'PACKED', 3457);
INSERT INTO ORDERS VALUES (529, 'OD1234529', '2019-04-20', 911, 'CONFIRMED', 1595);
INSERT INTO ORDERS VALUES (530, 'OD1234530', '2020-02-12', 908, 'PACKED', 4744);
INSERT INTO ORDERS VALUES (531, 'OD1234531', '2019-01-30', 901, 'CONFIRMED', 1490);
INSERT INTO ORDERS VALUES (532, 'OD1234532', '2019-04-12', 905, 'BILLED', 1742);
INSERT INTO ORDERS VALUES (533, 'OD1234533', '2019-06-16', 903, 'BILLED', 3515);
INSERT INTO ORDERS VALUES (534, 'OD1234534', '2019-06-18', 910, 'BILLED', 2453);
INSERT INTO ORDERS VALUES (535, 'OD1234535', '2020-02-23', 907, 'CONFIRMED', 4626);
INSERT INTO ORDERS VALUES (536, 'OD1234536', '2019-02-18', 909, 'OUT_FOR_DELIVERY', 4256);
INSERT INTO ORDERS VALUES (537, 'OD1234537', '2019-02-16', 909, 'CONFIRMED', 2178);
INSERT INTO ORDERS VALUES (538, 'OD1234538', '2020-04-26', 903, 'BILLED', 3405);
INSERT INTO ORDERS VALUES (539, 'OD1234539', '2019-03-18', 905, 'BILLED', 2691);
INSERT INTO ORDERS VALUES (540, 'OD1234540', '2019-02-25', 903, 'BILLED', 4819);

CREATE TABLE items(OrderId int not NULL, ProductId int NOT NULL);

INSERT INTO items VALUES (501, 23);
INSERT INTO items VALUES (501, 10);
INSERT INTO items VALUES (502, 23);
INSERT INTO items VALUES (502, 26);
INSERT INTO items VALUES (502, 24);
INSERT INTO items VALUES (503, 15);
INSERT INTO items VALUES (503, 12);
INSERT INTO items VALUES (504, 4);
INSERT INTO items VALUES (505, 27);
INSERT INTO items VALUES (506, 1);
INSERT INTO items VALUES (506, 5);
INSERT INTO items VALUES (506, 33);
INSERT INTO items VALUES (507, 18);
INSERT INTO items VALUES (508, 27);
INSERT INTO items VALUES (508, 40);
INSERT INTO items VALUES (509, 13);
INSERT INTO items VALUES (509, 30);
INSERT INTO items VALUES (509, 17);
INSERT INTO items VALUES (509, 25);
INSERT INTO items VALUES (510, 11);
INSERT INTO items VALUES (510, 37);
INSERT INTO items VALUES (511, 18);
INSERT INTO items VALUES (511, 4);
INSERT INTO items VALUES (512, 18);
INSERT INTO items VALUES (512, 8);
INSERT INTO items VALUES (512, 36);
INSERT INTO items VALUES (512, 31);
INSERT INTO items VALUES (513, 28);
INSERT INTO items VALUES (514, 40);
INSERT INTO items VALUES (514, 39);
INSERT INTO items VALUES (514, 10);
INSERT INTO items VALUES (514, 8);
INSERT INTO items VALUES (515, 25);
INSERT INTO items VALUES (515, 39);
INSERT INTO items VALUES (516, 16);
INSERT INTO items VALUES (516, 35);
INSERT INTO items VALUES (516, 31);
INSERT INTO items VALUES (517, 32);
INSERT INTO items VALUES (518, 30);
INSERT INTO items VALUES (518, 17);
INSERT INTO items VALUES (518, 31);
INSERT INTO items VALUES (518, 30);
INSERT INTO items VALUES (519, 34);
INSERT INTO items VALUES (520, 13);
INSERT INTO items VALUES (520, 8);
INSERT INTO items VALUES (520, 18);
INSERT INTO items VALUES (520, 32);
INSERT INTO items VALUES (521, 34);
INSERT INTO items VALUES (521, 23);
INSERT INTO items VALUES (521, 30);
INSERT INTO items VALUES (521, 16);
INSERT INTO items VALUES (522, 2);
INSERT INTO items VALUES (522, 29);
INSERT INTO items VALUES (522, 28);
INSERT INTO items VALUES (522, 19);
INSERT INTO items VALUES (523, 4);
INSERT INTO items VALUES (523, 36);
INSERT INTO items VALUES (524, 32);
INSERT INTO items VALUES (525, 15);
INSERT INTO items VALUES (525, 9);
INSERT INTO items VALUES (525, 30);
INSERT INTO items VALUES (525, 14);
INSERT INTO items VALUES (526, 14);
INSERT INTO items VALUES (526, 5);
INSERT INTO items VALUES (526, 4);
INSERT INTO items VALUES (527, 39);
INSERT INTO items VALUES (527, 33);
INSERT INTO items VALUES (527, 23);
INSERT INTO items VALUES (528, 21);
INSERT INTO items VALUES (528, 28);
INSERT INTO items VALUES (529, 31);
INSERT INTO items VALUES (529, 11);
INSERT INTO items VALUES (530, 13);
INSERT INTO items VALUES (530, 23);
INSERT INTO items VALUES (531, 32);
INSERT INTO items VALUES (532, 2);
INSERT INTO items VALUES (532, 11);
INSERT INTO items VALUES (532, 15);
INSERT INTO items VALUES (533, 20);
INSERT INTO items VALUES (533, 24);
INSERT INTO items VALUES (534, 26);
INSERT INTO items VALUES (534, 35);
INSERT INTO items VALUES (534, 9);
INSERT INTO items VALUES (534, 30);
INSERT INTO items VALUES (535, 20);
INSERT INTO items VALUES (536, 17);
INSERT INTO items VALUES (537, 35);
INSERT INTO items VALUES (537, 31);
INSERT INTO items VALUES (538, 34);
INSERT INTO items VALUES (538, 23);
INSERT INTO items VALUES (538, 27);
INSERT INTO items VALUES (539, 40);
INSERT INTO items VALUES (540, 16);
INSERT INTO items VALUES (540, 19);
INSERT INTO items VALUES (540, 8);
INSERT INTO items VALUES (540, 19);