DROP TABLE IF EXISTS tgovernor;

CREATE TABLE tgovernor (
  governor_id int IDENTITY NOT NULL,
  name    VARCHAR(50) NOT NULL,
  age    smallint NOT NULL,
   PRIMARY KEY (governor_id)
) ;
