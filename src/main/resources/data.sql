INSERT INTO USER_DATA (USER_ID, FIRST_NAME, LAST_NAME, AGE, COUNTRY) VALUES 
	(1, 'Zubin', 'Shah', 31, 'SG'),
	(2, 'Kartik', 'Patel', 25, 'IND'),
	(3, 'Gautam', 'Joshi', 29, 'AUS'),
	(4, 'Chirag', 'Shah', 35, 'IND'),
	(5, 'Irfan', 'Kapadia', 39, 'USA');

INSERT INTO VEHICLE_DATA (VEHICLE_ID, VEHICLE_TYPE, VEHICLE_NUMBER, MANUFACTURE_YEAR, USER_ID) VALUES
	(51, 'Sedan', 'V7896', 2010, 1),
	(52, 'SUV', 'N1256', 2012, 2),
	(53, 'Truck', 'Z7564', 2014, 3),
	(54, 'Hetchback', 'M1242', 2017, 4),
	(55, 'MPV', 'G8654', 2019, 5);
	
INSERT INTO VEHICLE_MAINTAINANCE_DATA (VEH_MAINTAINANCE_ID, MAINTAINANCE_COST, MAINTAINANCE_DATE, COMMENTS, VEHICLE_ID) VALUES
	(81, 1000, TO_DATE('2014-05-03', 'yyyy-mm-dd'), 'test1', 51),
	(82, 500, TO_DATE('2016-12-17', 'yyyy-mm-dd'), 'test1 comments', 51),
	(83, 300, TO_DATE('2017-03-12', 'yyyy-mm-dd'), 'test12 comments', 51);