INSERT INTO db_scrumBan_test.tb_user (txt_email,txt_name,txt_password) VALUES ("felipe@gmail.com", "Felipe", "123456");
INSERT INTO db_scrumBan_test.tb_project (dt_createdDate,txt_description,txt_title,createdByUser_id) VALUES ("2013-07-08","Just a hit","ScrumBan",1);
INSERT INTO db_scrumBan_test.tb_project_member (project_id, user_id) VALUES ('1', '1');

INSERT INTO db_scrumBan_test.tb_status (txt_name) VALUES ("To do");
INSERT INTO db_scrumBan_test.tb_status (txt_name) VALUES ("Doing");
INSERT INTO db_scrumBan_test.tb_status (txt_name) VALUES ("Done");