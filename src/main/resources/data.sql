INSERT INTO post (title, creation_date)
VALUES ('The first post', NOW());
INSERT INTO post (title, creation_date)
VALUES ('The second post', NOW());
INSERT INTO post (title, creation_date)
VALUES ('The third post', NOW());
INSERT INTO post (title, creation_date)
VALUES ('The fourth post', NOW());


INSERT INTO post_comment (review)
VALUES ('the first comment');
INSERT INTO post_comment (review)
VALUES ('the second comment');
INSERT INTO post_comment (review)
VALUES ('the thrird comment');
INSERT INTO post_comment (review)
VALUES ('the fourth comment');
INSERT INTO post_comment (review)
VALUES ('the fifth comment');
INSERT INTO post_comment (review)
VALUES ('the sixth comment');


/*
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
*/


INSERT INTO post_post_comments (Post_id, post_Comments_id)
VALUES (1, 1);
INSERT INTO post_post_comments (Post_id, post_Comments_id)
VALUES (1, 2);
INSERT INTO post_post_comments (Post_id, post_Comments_id)
VALUES (1, 3);
INSERT INTO post_post_comments (Post_id, post_Comments_id)
VALUES (1, 4);
INSERT INTO post_post_comments (Post_id, post_Comments_id)
VALUES (2, 5);
INSERT INTO post_post_comments (Post_id, post_Comments_id)
VALUES (2, 6);
