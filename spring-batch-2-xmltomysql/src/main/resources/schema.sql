drop table if exists spring_batch.TUTORIALS;

CREATE TABLE spring_batch.TUTORIALS( 
   tutorial_id int(10) NOT NULL, 
   tutorial_author VARCHAR(20), 
   tutorial_title VARCHAR(50), 
   submission_date VARCHAR(20), 
   tutorial_icon VARCHAR(200), 
   tutorial_description VARCHAR(1000) 
);