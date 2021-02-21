INSERT INTO `users` (`birthday`, `email`, `firstname`, `lastname`, `password`, `phone`, `username`)
    VALUE (CURRENT_TIMESTAMP, 'test@test.com', 'Artem', 'Senchenko', '$2a$10$uedJ6jkBS08x5mxZY6gV6.LAKSd202CiVutxz5VDq3TIyj9alkmIq', '+7(000)000-00-00', 'admin');

GO

INSERT INTO `roles` (`title`)
    VALUE ('ROLE_ADMIN');

GO

INSERT INTO `users_roles`(`user_id`, `role_id`)
SELECT (SELECT id FROM `users` WHERE `username` = 'admin'), (SELECT id FROM `roles` WHERE `title` = 'ROLE_ADMIN');

GO