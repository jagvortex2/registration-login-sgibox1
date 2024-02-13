--Create User Table
CREATE TABLE Users(
	id INT IDENTITY(1,1) PRIMARY KEY,
	name NVARCHAR(50) NOT NULL,
	email NVARCHAR(100) NOT NULL,
	password NVARCHAR(255) NOT NULL,
	--Enforce character length limit for name
	CONSTRAINT CHK_Name_Length CHECK (LEN(name) <= 50),
	--Validate email format
	CONSTRAINT CHK_Valid_Email_Format CHECK (email LIKE '%_@%._%'),
	--Enforce minimum password length
	CONSTRAINT CHK_Password_Length CHECK (LEN(password) >= 8),
	--Enforce uniqueness of the emails
	CONSTRAINT UQ_Email UNIQUE(email));

--Create Roles Table
CREATE TABLE Roles(
	id INT IDENTITY(1,1) PRIMARY KEY,
	name NVARCHAR(50) NOT NULL,
	--Enforce character length limit for role name
	CONSTRAINT CHK_Role_Name_Length CHECK (LEN(name) <= 50),
	--Enforce uniqueness of the roles
	CONSTRAINT UQ_RoleName UNIQUE(name)
);

--Create User_Roles Junction Table
CREATE TABLE User_Roles(
    user_id INT NOT NULL,
	role_id INT NOT NULL,
	PRIMARY KEY (user_id, role_id),
	FOREIGN KEY(user_id) REFERENCES Users(id),
	FOREIGN KEY (role_id) REFERENCES Roles(id)
);

--Indexes
CREATE INDEX IDX_User_Roles_user_id ON User_Roles(user_id);
CREATE INDEX IDX_User_Roles_role_id ON User_Roles(role_id);


--Documentation:
--This script creates tables and indexes for user authentication and role definition in a Microsoft SQL Server database. 
--It consists of the following components:

--Users Table: Stores user information including name, email, and password. 
--Each user has a unique identifier (id) and an email address (email) that must be unique across all users. The name, email, and password columns are 
--of type NVARCHAR(255) and cannot be null.

--Roles Table: Stores role information. Each role has a unique identifier (id) and a name (name) that must be unique across all roles.
--The name column is of type NVARCHAR(255) and cannot be null.

--User_Roles Junction Table: Establishes a many-to-many relationship between users and roles. Each row in this table represents a user-role association. 
--The user_id column references the id column of the Users table, and the role_id column references the id column of the Roles table. 
--Together, user_id and role_id form the primary key of this table.

--Indexes: Indexes are created on the user_id and role_id columns of the User_Roles table to improve query performance 
--for searching user-role associations by user ID or role ID.
