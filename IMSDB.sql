create database imsdb;
use imsdb;
CREATE TABLE Courses
(
 `course_id`         INT NOT NULL PRIMARY KEY ,
 `course_name`       VARCHAR(100) NOT NULL ,
 `course_duration`   VARCHAR(30) NOT NULL ,
 `course_fees`       DOUBLE NOT NULL ,
 `created_by`        VARCHAR(50)  NULL ,
 `created_on`        DATETIME  NULL DEFAULT CURRENT_TIMESTAMP,
 `updated_by`        VARCHAR(50) NULL ,
 `updated_on`        DATETIME NULL DEFAULT  CURRENT_TIMESTAMP 
 );
CREATE TABLE Course_Details
(
 `course_details_id`  INTEGER NOT NULL PRIMARY KEY ,
 `course_contents`    VARCHAR(5000) NOT NULL ,
 `course_description` VARCHAR(200) NOT NULL ,
 `course_id`          INT NOT NULL ,
 `created_by`     VARCHAR(50) NULL ,
 `created_on`     DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
 `updated_by`     VARCHAR(50) NULL ,
 `updated_on`     DATETIME NULL DEFAULT CURRENT_TIMESTAMP ,
  FOREIGN KEY (`course_id`)
  REFERENCES Courses(`course_id`)
);
INSERT INTO Courses Values(123,'JAVA','3 months',7500.0,'ABC','2017-12-20','XYZ',now());
INSERT INTO Courses Values(456,'Python','2 months',5500.0,'ABC','2017-11-20','XYZ',now());

INSERT INTO Course_Details(course_details_id,course_contents,course_description,course_id) Values(111,'Overview,Basic Introduction,OOP Concepts','Java is a highly used programming language for development',123);
INSERT INTO Course_Details(course_details_id,course_contents,course_description,course_id) Values(222,'Overview,Basic Introduction,Data Science','Python is a highly used software tool for exploring data sciences',456);

CREATE TABLE Organization
(
 `org_id`         INTEGER NOT NULL PRIMARY KEY ,
 `org_name`       VARCHAR(50) NOT NULL ,
`created_by`     VARCHAR(50) NULL ,
 `created_on`     DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
 `updated_by`     VARCHAR(50) NULL ,
 `updated_on`     DATETIME NULL DEFAULT CURRENT_TIMESTAMP 

);

 INSERT INTO Organization Values(0231,'S2P Eductech','ABC','2017-12-20','XYZ',now());
 INSERT INTO Organization Values(0256,'ICE GATE Academy','ABC','2017-12-20','XYZ',now());
 
 CREATE TABLE Organization_Details
(
 `org_id`          INTEGER NOT NULL ,
 `org_estd_date`   DATE NOT NULL ,
 `org_description` VARCHAR(100) NOT NULL ,
 `org_owner`       VARCHAR(50) NOT NULL ,
 `org_address`     VARCHAR(50) NOT NULL ,
 `org_contact`     VARCHAR(50) NOT NULL ,
 `org_details_id`  INTEGER NOT NULL PRIMARY KEY ,
`created_by`     VARCHAR(50) NULL ,
 `created_on`     DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
 `updated_by`     VARCHAR(50) NULL ,
 `updated_on`     DATETIME NULL DEFAULT CURRENT_TIMESTAMP ,


 FOREIGN KEY (`org_id`) REFERENCES Organization(`org_id`)
);

INSERT INTO Organization_Details(org_id,org_estd_date,org_description,org_owner,org_address,org_contact,org_details_id) Values(0231,'2015-05-12','S2P Edutech strives to transform student to professional','Gandhar Patwardhan','Ram Nagar','9561033258',1122);
INSERT INTO Organization_Details(org_id,org_estd_date,org_description,org_owner,org_address,org_contact,org_details_id) Values(0256,'2012-02-12','ICE GATE Academy provides intensive GATE coaching','Srinivasan Iyer','IT Park','9658432235',3344);

CREATE TABLE Batches
(
 `batch_id`         INT NOT NULL PRIMARY KEY ,
 `batch_timings`    VARcHAR(20) NOT NULL ,
 `batch_start_date` DATE NOT NULL ,
 `batch_end_date`   DATE NOT NULL ,
 `course_id`        INT NOT NULL ,
`created_by`     VARCHAR(50) NULL ,
 `created_on`     DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
 `updated_by`     VARCHAR(50) NULL ,
 `updated_on`     DATETIME NULL DEFAULT CURRENT_TIMESTAMP ,

 FOREIGN KEY (`course_id`) REFERENCES Courses(`course_id`)
);
INSERT INTO Batches(batch_id,batch_timings,batch_start_date,batch_end_date,course_id) VALUES (121,'10 AM','2017/10/20','2018/01/20',123);
INSERT INTO Batches (batch_id,batch_timings,batch_start_date,batch_end_date,course_id)  VALUES (232,'4 PM','2018/01/05','2018/03/02',456);

CREATE TABLE Users
(
 `user_name`            VARCHAR(100) NOT NULL  ,
`user_password`		VARCHAR(15) NOT NULL,
 `org_id`          INTEGER NOT NULL ,
 `user_id`         INT NOT NULL PRIMARY KEY ,
`created_by`     VARCHAR(50) NULL ,
 `created_on`     DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
 `updated_by`     VARCHAR(50) NULL ,
 `updated_on`     DATETIME NULL DEFAULT CURRENT_TIMESTAMP ,

 FOREIGN KEY (`org_id`) REFERENCES Organization(`org_id`)
 );
 INSERT INTO Users(user_name,user_password,org_id,user_id) VALUES ('Gandhar Patwardhan','gandhar1984',0231,1245);
 INSERT INTO Users (user_name,user_password,org_id,user_id) VALUES ('Srinivasan Iyer','icegate2018',0256,2365);
 CREATE TABLE User_Details
(
 `user_details_id` INT NOT NULL PRIMARY KEY ,
 `user_contact`    VARCHAR(50) NOT NULL ,
 `user_address`    VARCHAR(200) NOT NULL ,
 `user_id`         INT NOT NULL ,
`created_by`     VARCHAR(50) NULL ,
 `created_on`     DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
 `updated_by`     VARCHAR(50) NULL ,
 `updated_on`     DATETIME NULL DEFAULT CURRENT_TIMESTAMP ,

 
 FOREIGN KEY (`user_id`) REFERENCES Users(`user_id`)
);
INSERT INTO User_Details(user_details_id,user_contact,user_address,user_id) VALUES(101,'0712-2556545','Pioneer Regency',1245);
INSERT INTO User_Details(user_details_id,user_contact,user_address,user_id) VALUES(202,'0712-2326265','Swapnil Yuthika',2365);
CREATE TABLE User_Roles
(
 `user_role_id`          INT NOT NULL PRIMARY KEY ,
 `user_id`               INT NOT NULL ,
 `user_role_type`        VARCHAR(50) NOT NULL ,
 `user_role_description` VARCHAR(50) NOT NULL ,
 `created_by`     VARCHAR(50) NULL ,
 `created_on`     DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
 `updated_by`     VARCHAR(50) NULL ,
 `updated_on`     DATETIME NULL DEFAULT CURRENT_TIMESTAMP ,

 FOREIGN KEY (`user_id`) REFERENCES Users(`user_id`)
);

INSERT INTO User_Roles(user_role_id,user_id,user_role_type,user_role_description) VALUES(147,1245,'Admin','Can do all important ooperations');
INSERT INTO User_Roles (user_role_id,user_id,user_role_type,user_role_description)VALUES(258,2365,'Admin','Can do all important ooperations');

CREATE TABLE Student
(
 `student_id`         INT NOT NULL PRIMARY KEY ,
 `student_name`       VARCHAR(50) NOT NULL ,
 `student_email`      VARCHAR(150) NOT NULL ,
 `student_college`    VARCHAR(200) NOT NULL ,
 `student_phone`      VARCHAR(50) NOT NULL ,
 `org_id`             INTEGER NOT NULL ,
`created_by`     VARCHAR(50) NULL ,
 `created_on`     DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
 `updated_by`     VARCHAR(50) NULL ,
 `updated_on`     DATETIME NULL DEFAULT CURRENT_TIMESTAMP ,

  
 FOREIGN KEY (`org_id`) REFERENCES Organization(`org_id`)
);
INSERT INTO Student(student_id,student_name,student_email,student_college,student_phone,org_id) VALUES(741,'Pranati Paidipati','pranati.pr18@gmail.com','JHULELAL INSTITUTE OF TECHNOLOGY','7741085344',0231);
INSERT INTO Student (student_id,student_name,student_email,student_college,student_phone,org_id) VALUES(852,'Ayushi Hiwarkar','ayushi.h6@gmail.com','S.B. JAIN INSTITUTE OF TECHNOLOGY','9762517985',0256);
INSERT INTO Student (student_id,student_name,student_email,student_college,student_phone,org_id) VALUES(254,'Faisal Syed','syed.faisal@yahoo.com','S.R INSTITUTE OF TECHNOLOGY','8149091962',0231);
INSERT INTO Student (student_id,student_name,student_email,student_college,student_phone,org_id) VALUES(846,'Sujay Modak','sujay.modak21@gmail.com','NATIONAL INSTITUTE OF TECHNOLOGY','9561023594',0256);
INSERT INTO Student (student_id,student_name,student_email,student_college,student_phone,org_id) VALUES(965,'Rucha Balamwar','rucha.bm21@gmail.com','RAISONI INSTITUTE OF TECHNOLOGY','8446441025',0231);
 drop table student_details;
CREATE TABLE Student_Details
(
 `student_details_id`       INTEGER NOT NULL PRIMARY KEY,
 `student_address`          VARCHAR(200) NOT NULL ,
 `student_ssc_score`        DOUBLE NOT NULL ,
 `student_ssc_passing_year` INT NOT NULL ,
 `student_hsc_score`        DOUBLE NOT NULL ,
 `student_hsc_passing_year` INT NOT NULL ,
 `student_degree_name`           VARCHAR(150) NOT NULL ,
 `student_degree_passing_year`    INT NOT NULL ,
 `student_id`               INT NOT NULL ,
`created_by`     VARCHAR(50) NULL ,
 `created_on`     DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
 `updated_by`     VARCHAR(50) NULL ,
 `updated_on`     DATETIME NULL DEFAULT CURRENT_TIMESTAMP ,

 
 FOREIGN KEY (`student_id`) REFERENCES Student(`student_id`)
);

INSERT INTO Student_Details(student_details_id,student_address,student_ssc_score,student_ssc_passing_year,student_hsc_score,student_hsc_passing_year,student_degree_name,student_degree_passing_year,student_id) VALUES(111,'Shree Ganesh Towers',87.50,2011,70.00,2013,'Bachelor of Engineering',2017,741);
INSERT INTO Student_Details(student_details_id,student_address,student_ssc_score,student_ssc_passing_year,student_hsc_score, student_hsc_passing_year,student_degree_name,student_degree_passing_year,student_id) VALUES(22,'Rajat Towers',72.50,2011,65.00,2013,'Bachelor of Engineering',2018,852);


CREATE TABLE Course_Enrolments
(
 `course_fees_id` INT NOT NULL PRIMARY KEY ,
 `student_id`    INT NOT NULL ,
 `batch_id`      INT NOT NULL ,
`created_by`     VARCHAR(50) NULL ,
 `created_on`     DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
 `updated_by`     VARCHAR(50) NULL ,
 `updated_on`     DATETIME NULL DEFAULT CURRENT_TIMESTAMP ,


 FOREIGN KEY (`student_id`) REFERENCES Student(`student_id`),
 FOREIGN KEY (`batch_id`) REFERENCES Batches(`batch_id`)
);
INSERT INTO Course_Enrolments(course_fees_id,student_id,batch_id) VALUES(1561,741,121);
INSERT INTO Course_Enrolments(course_fees_id,student_id,batch_id) VALUES(1789,852,232);
INSERT INTO Course_Enrolments(course_fees_id,student_id,batch_id) VALUES(2541,254,121);
INSERT INTO Course_Enrolments(course_fees_id,student_id,batch_id) VALUES(2354,965,232);
CREATE TABLE Installments
(
 `installment_number` INT NOT NULL ,
 `amount_paid`        DOUBLE NOT NULL ,
  `paid_date`          DATE NOT NULL ,
 `balance_amount`     DOUBLE NOT NULL ,
  `due_date`           DATE NOT NULL ,
 `fees_status`         BOOLEAN NOT NULL ,
  `course_fees_id`      INT NOT NULL ,
`created_by`     VARCHAR(50) NULL ,
 `created_on`     DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
 `updated_by`     VARCHAR(50) NULL ,
 `updated_on`     DATETIME NULL DEFAULT CURRENT_TIMESTAMP ,

 
 FOREIGN KEY (`course_fees_id`) REFERENCES Course_Enrolments(`course_fees_id`)
);

INSERT INTO Installments(installment_number,amount_paid,paid_date,balance_amount,due_date,fees_status,course_fees_id) VALUES (10,2000,'2017-12-12',3500,'2018-01-25',FALSE,1561);
INSERT INTO Installments(installment_number,amount_paid,paid_date,balance_amount,due_date,fees_status,course_fees_id) VALUES (10,6000,'2017-12-12',0,now(),TRUE,1789);

alter table organization_details add org_email_id varchar(150);
update Organization_Details set org_email_id='info@s2pedutech.com' where organization_details.org_id = 231;

update Organization_Details set org_email_id='info@icegateacademy.com' where Organization_Details.org_id = 256;
alter table Batches add org_id integer;

alter table Batches add foreign key(org_id) references Organization(org_id);

update Batches set org_id = 231 where batch_id =232;

SELECT * from Courses;
SELECT * from Course_Details;
SELECT * FROM Organization;
SELECT * FROM Organization_Details;
SELECT * FROM Batches;
SELECT * FROM Users;
SELECT * FROM User_Details;
SELECT * FROM User_Roles;
SELECT * FROM Student;
SELECT * FROM Student_Details;
