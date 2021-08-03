BEGIN TRANSACTION;

DROP TABLE IF EXISTS service_status CASCADE;
DROP TABLE IF EXISTS service CASCADE;
DROP TABLE IF EXISTS description CASCADE;
DROP TABLE IF EXISTS potholes CASCADE;
DROP TABLE IF EXISTS users CASCADE;


DROP SEQUENCE IF EXISTS seq_service_id CASCADE;
DROP SEQUENCE IF EXISTS seq_description_id CASCADE;
DROP SEQUENCE IF EXISTS seq_pothole_id CASCADE;
DROP SEQUENCE IF EXISTS seq_user_id CASCADE;




CREATE SEQUENCE seq_pothole_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE SEQUENCE seq_service_id
  INCREMENT BY 1
  START WITH 3001
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
  CREATE SEQUENCE seq_description_id
  INCREMENT BY 1
  START WITH 2001
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
  CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  START WITH 1001
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	
	CONSTRAINT PK_user PRIMARY KEY (user_id)
	
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');




CREATE TABLE potholes (
        pothole_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
        user_id int NOT NULL,
        date_reported date NOT NULL,
        time_reported timestamp NOT NULL,
        
        CONSTRAINT PK_potholes PRIMARY KEY (pothole_id),
        CONSTRAINT FK_pothole_user FOREIGN KEY (user_id) REFERENCES users (user_id)
);

    
 
CREATE TABLE pothole_description (
        description_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
        pothole_id int NOT NULL,
        formatted_address varchar NOT NULL,
        latitude decimal NOT NULL,
        longtitude decimal NOT NULL,
        size varchar NOT NULL,
        rank int NULL,
        
        CONSTRAINT PK_pothole_description PRIMARY KEY (description_id),
        CONSTRAINT FK_pothole_description FOREIGN KEY (pothole_id) REFERENCES potholes (pothole_id)        
);

CREATE TABLE service (
        service_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
        pothole_id int NOT NULL,
        date_reported date NOT NULL,
        date_inspected date NOT NULL,
        employee_id int NOT NULL,
        status int NOT NULL,
        repaired_date date NOT NULL,
        
        CONSTRAINT PK_service PRIMARY KEY (service_id),
        CONSTRAINT FK_pothole_id FOREIGN KEY (pothole_id) REFERENCES potholes (pothole_id)        
);


CREATE TABLE service_status (
        service_status int NOT NULL,
        service_type_description varchar NOT NULL,
        
        CONSTRAINT PK_service_status PRIMARY KEY (service_status)
              
);

COMMIT TRANSACTION;




