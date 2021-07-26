CREATE DATABASE IF NOT EXISTS springblog_db;

CREATE USER springblog_user@localhost IDENTIFIED BY 'p@$$w0rd';
GRANT ALL ON springblog_db.* TO springblog_user@localhost;

USE springblog_db;

INSERT INTO posts (id, title, body) VALUES(1, 'BlogPost1', 'This is the 1st Blog Post');
INSERT INTO posts (id, title, body) VALUES(2, 'BlogPost2', 'This is the 2nd Blog Post');
INSERT INTO posts (id, title, body) VALUES(3, 'BlogPost3', 'This is the 3rd Blog Post');