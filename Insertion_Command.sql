CREATE TABLE `product` (
  `ProductId` int(5) NOT NULL,
  `productcode` varchar(4) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(100) NOT NULL,
  `price` int(5) NOT NULL,
  `category` int(5) NOT NULL
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

CREATE TABLE `user` ( `userid` int(5) primary key NOT NULL, `email` varchar(50) NOT NULL, 
`password` varchar(10) NOT NULL,`address` varchar(20) NOT NULL,`name` varchar(20) NOT NULL,`phone` int(10) NOT NULL);

insert into user(userid, email, password, address, name, phone) values (901, "aastha_shah@persistent.com", "aastha123", "kolkata", "Aastha Shah", 987889790);
insert into user(userid, email, password, address, name, phone) values (902, "alka_prasad@persistent.com", "alka123", "kolkata", "Alka Prasad",78906808);
insert into user(userid, email, password, address, name, phone) values (903, "saloni_lohia@persistent.com", "saloni123", "kolkata", "Saloni Lohia", 790648533);
insert into user(userid, email, password, address, name, phone) values (904, "pritha_hazra@persistent.com", "pritha123", "kolkata", "Pritha Hazra",685309882);
insert into user(userid, email, password, address, name, phone) values (905, "aniruddh_kotecha@persistent.com", "aniruddh123", "kolkata", "Aniruddh Kotecha", 797680089);
insert into user(userid, email, password, address, name, phone) values (906, "pulkit_vatsal@persistent.com", "pulkit123", "kolkata", "Pulkit Vatsal",980969075);