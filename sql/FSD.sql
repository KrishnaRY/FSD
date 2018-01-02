
DROP TABLE IF EXISTS  ParentTask  ;
DROP TABLE IF EXISTS  TASK  ;
DROP TABLE IF EXISTS  PROJECT  ;
DROP TABLE IF EXISTS  USER  ;


CREATE  TABLE IF NOT EXISTS  ParentTask  
(
   Parent_ID int PRIMARY KEY NOT NULL AUTO_INCREMENT,
   Parent_Task varchar(100) NOT NULL
);

CREATE  TABLE IF NOT EXISTS  USER
(
   User_ID int PRIMARY KEY NOT NULL AUTO_INCREMENT,
   First_Name varchar(100) NOT NULL,
   Last_Name varchar(100) NOT NULL,
   Employee_ID varchar(100) NOT NULL

);

CREATE  TABLE IF NOT EXISTS  PROJECT
(
   Project_ID int PRIMARY KEY NOT NULL AUTO_INCREMENT,
   Project varchar(100) NOT NULL,
   Start_Date DATE NOT NULL,
   End_Date DATE NOT NULL,
   Priority int NOT NULL ,
   User_ID int NOT NULL,
   CONSTRAINT fk_User_ID_PROJECT
 	FOREIGN KEY (User_ID)
	REFERENCES USER(User_ID)
	ON DELETE CASCADE
);

CREATE  TABLE IF NOT EXISTS  TASK
(
   Task_ID int PRIMARY KEY NOT NULL AUTO_INCREMENT,
   Parent_ID int,
   Project_ID int NOT NULL,
   Task varchar(100) NOT NULL,
   Start_Date DATE NOT NULL,
   End_Date DATE NOT NULL,
   Priority int NOT NULL ,
   Status varchar(100) NOT NULL,
   User_ID int NOT NULL,
    CONSTRAINT fk_Project_ID
 	FOREIGN KEY (Project_ID)
	REFERENCES PROJECT(Project_ID)
	ON DELETE CASCADE,
	  CONSTRAINT fk_User_ID_TASK
 	FOREIGN KEY (User_ID)
	REFERENCES USER(User_ID)
	ON DELETE CASCADE
);


insert into ParentTask(Parent_Task) values ('parent task1');




