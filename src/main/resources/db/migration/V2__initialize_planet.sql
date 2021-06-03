DROP TABLE IF EXISTS tplanet;

CREATE TABLE tplanet (
  planet_id  int identity NOT NULL,
  name    VARCHAR(50) NOT NULL,
  governor_id    smallint NOT NULL,
   PRIMARY KEY (planet_id),
   CONSTRAINT FK_tplanet_tgovernor FOREIGN KEY (planet_id)
  REFERENCES tgovernor (governor_id)
) ;
