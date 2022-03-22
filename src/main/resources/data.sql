insert into User(userId, email, userName, password, profileImg, birthDate, gender, videoSet, notificationSet, nickname, introduce)
values (1, 'jinwoo@codepresso.com', 'Cho jinwoo', 'asdf1', 'http://dummyimage.com/246x100.png/cc0000/ffffff', '2021-11-22', false, true, false, 'jinwoo', 'Hi, My name is jinwoo');
insert into User(userId, email, userName, password, profileImg, birthDate, gender, videoSet, notificationSet, nickname, introduce)
values (2, 'jaemin@codepresso.com', 'Choi jaemin', 'asdf2', 'http://dummyimage.com/163x100.png/ff4444/ffffff', '2022-10-21', false, true, false, 'jaemin', 'Hi, My name is jaemin');
insert into User(userId, email, userName, password, profileImg, birthDate, gender, videoSet, notificationSet, nickname, introduce)
values (3, 'jiwon@codepresso.com', 'Yum jiwon', 'asdf3', 'http://dummyimage.com/216x100.png/cc0000/ffffff', '2022-03-11', true, true, true, 'jiwon', 'Hi, My name is jiwon');
insert into User(userId, email, userName, password, profileImg, birthDate, gender, videoSet, notificationSet, nickname, introduce)
values (4, 'jinsol@codepresso.com', 'Jeong jinsol', 'asdf4', 'http://dummyimage.com/206x100.png/dd0000/ffffff', '2022-03-30', true, true, true, 'jinsol', 'Hi, My name is jinsol');

insert into Post(postId, userId, content)
values (1, 1, 'BB&T Corporation');
insert into Post(postId, userId, content)
values (2, 1, 'Deutsche Bank AG');
insert into Post(postId, userId, content)
values (3, 2, 'FlexShopper, Inc.');
insert into Post(postId, userId, content)
values (4, 2, 'Innovative Industrial Properties, Inc.');
insert into Post(postId, userId, content)
values (5, 3, 'Rite Aid Corporation');
insert into Post(postId, userId, content)
values (6, 3, 'Summer Infant, Inc.');


insert into Comment(commentId, userId, postId, content)
values (1, 1, 6, 'hi one');
insert into Comment(commentId, userId, postId, content)
values (2, 2, 5, 'hi two');
insert into Comment(commentId, userId, postId, content)
values (3, 3, 4, 'hi three');
insert into Comment(commentId, userId, postId, content)
values (4, 4, 3, 'yes one');
insert into Comment(commentId, userId, postId, content)
values (5, 1, 2, 'yes two');
insert into Comment(commentId, userId, postId, content)
values (6, 2, 1, 'yes three');
insert into Comment(commentId, userId, postId, content)
values (7, 3, 6, 'wow one');
insert into Comment(commentId, userId, postId, content)
values (8, 4, 5, 'wow two');
insert into Comment(commentId, userId, postId, content)
values (9, 1, 4, 'wow one');
insert into Comment(commentId, userId, postId, content)
values (10, 2, 3, 'test comment');
insert into Comment(commentId, userId, postId, content)
values (11, 3, 2, 'test comment');
insert into Comment(commentId, userId, postId, content)
values (12, 4, 1, 'test comment');
insert into Comment(commentId, userId, postId, content)
values (13, 1, 6, 'test comment');
insert into Comment(commentId, userId, postId, content)
values (14, 2, 6, 'test comment');


insert into Post(postId, userId, content)
values (7, 4, 'First Internet Bancorp');
insert into Post(postId, userId, content)
values (8, 4, 'U.S. Energy Corp.');

