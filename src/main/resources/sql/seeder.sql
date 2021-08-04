TRUNCATE springblog_db.ads;
TRUNCATE springblog_db.ads_categories;
TRUNCATE springblog_db.posts;
TRUNCATE springblog_db.users;
DROP TABLE springblog_db.ads_categories;
DROP TABLE springblog_db.ads;

INSERT INTO springblog_db.users(username, email, password)
VALUES ('admin', 'admin@email.com', 'password');

INSERT INTO springblog_db.ads (description, title, user_id)
VALUES ('Lorem ipsum dolor sit amet, ex pericula persequeris eam, quo quem saperet cu. Ne epicurei periculis nec. Nostrud fastidii eu vim.',
        '3 Easy Ways To Make LOREM IPSUM Faster', 1),
       ('Lorem ipsum dolor sit amet, ex pericula persequeris eam, quo quem saperet cu. Ne epicurei periculis nec. Nostrud fastidii eu vim.',
        'Get Rid of LOREM IPSUM For Good', 1 ),
       ('Lorem ipsum dolor sit amet, ex pericula persequeris eam, quo quem saperet cu. Ne epicurei periculis nec. Nostrud fastidii eu vim.',
        '10 Best Practices For LOREM IPSUM', 1),
       ('Lorem ipsum dolor sit amet, ex pericula persequeris eam, quo quem saperet cu. Ne epicurei periculis nec. Nostrud fastidii eu vim.',
        'Use LOREM IPSUM To Make Someone Fall In Love With You', 1),
       ('Lorem ipsum dolor sit amet, ex pericula persequeris eam, quo quem saperet cu. Ne epicurei periculis nec. Nostrud fastidii eu vim.',
        'It''s All About LOREM IPSUM', 1);

INSERT INTO springblog_db.posts (body, title, user_id)
VALUES ('Lorem ipsum dolor sit amet, ex pericula persequeris eam, quo quem saperet cu. Ne epicurei periculis nec. Nostrud fastidii eu vim.',
        '3 Easy Ways To Make LOREM IPSUM Faster', 1),
       ('Lorem ipsum dolor sit amet, ex pericula persequeris eam, quo quem saperet cu. Ne epicurei periculis nec. Nostrud fastidii eu vim.',
        'Get Rid of LOREM IPSUM For Good', 1),
       ('Lorem ipsum dolor sit amet, ex pericula persequeris eam, quo quem saperet cu. Ne epicurei periculis nec. Nostrud fastidii eu vim.',
        '10 Best Practices For LOREM IPSUM', 1),
       ('Lorem ipsum dolor sit amet, ex pericula persequeris eam, quo quem saperet cu. Ne epicurei periculis nec. Nostrud fastidii eu vim.',
        'Use LOREM IPSUM To Make Someone Fall In Love With You', 1),
       ('Lorem ipsum dolor sit amet, ex pericula persequeris eam, quo quem saperet cu. Ne epicurei periculis nec. Nostrud fastidii eu vim.',
        'It''s All About LOREM IPSUM', 1);

DROP table ads;
DROP table posts;
DROP table users;
DROP table ad_images;
