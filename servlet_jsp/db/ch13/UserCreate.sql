/***********************************************************
* Create the table named User
************************************************************/

CREATE TABLE User (
  UserID INT NOT NULL AUTO_INCREMENT,
  FirstName VARCHAR(50),
  LastName VARCHAR(50),
  EmailAddress VARCHAR(50),  
  PRIMARY KEY(UserID) 
)