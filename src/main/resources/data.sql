INSERT INTO post (title, creation_date)
VALUES ('The first post', NOW());
INSERT INTO post (title, creation_date)
VALUES ('The second post', NOW());
INSERT INTO post (title, creation_date)
VALUES ('The third post', NOW());
INSERT INTO post (title, creation_date)
VALUES ('The fourth post', NOW());

INSERT INTO post_comment (review, post_id)
VALUES ('the first comment', 1);
INSERT INTO post_comment (review, post_id)
VALUES ('the second comment', 1);
INSERT INTO post_comment (review, post_id)
VALUES ('the thrird comment', 1);
INSERT INTO post_comment (review, post_id)
VALUES ('the fourth comment', 1);
INSERT INTO post_comment (review, post_id)
VALUES ('the fifth comment', 2);
INSERT INTO post_comment (review, post_id)
VALUES ('the sixth comment', 2);

INSERT INTO tag(name) VALUES ('tag1');
INSERT INTO tag(name) VALUES ('tag2');
INSERT INTO tag(name) VALUES ('tag3');
INSERT INTO tag(name) VALUES ('tag4');

INSERT INTO post_details(created_by, valid_until, post_id) VALUES ('josep', '2023-10-12', 1);