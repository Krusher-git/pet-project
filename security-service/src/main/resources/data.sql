insert into roles(id, name)
values (1, 'ROLE_USER'),
       (2, 'ROLE_ADMIN')
on conflict do nothing;

-- password for Admin: vFantasticFour4

insert into users(id, name, surname, email, password, is_user_non_locked, cart_id, role_id)
values (1,
        'Administrator',
        'Blank',
        '228@s.cpm',
        '$2a$10$/Q65ZqFqk.oE9YiNCjMJSOl4bvmFZJ1JhsARSfxFJOGJvWbjIUaWe',
        true,
        1,
        2)
on conflict(email) do nothing;

BEGIN;

LOCK TABLE users, roles IN ACCESS EXCLUSIVE MODE;
-- updating cursor to prevent exception with users_pkey = 1, the same for roles
SELECT setval('users_id_seq', COALESCE((SELECT MAX(id) + 1 FROM users), 1), false);
SELECT setval('roles_id_seq', COALESCE((SELECT MAX(id) + 1 FROM roles), 1), false);

COMMIT;

INSERT
INTO oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types,
                           web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity,
                           additional_information, autoapprove)
VALUES ('main-processor-service',
        '',
        '$2a$10$Jg6HxsecQ9bv0w3JuadWl.VAjjJ6WuLI2YWfUKgblS7HC9DhgI7Gy',
        'read,write',
        'refresh_token,client_credentials',
        '',
        '',
        3600,
        7200,
        '{}',
        ''),
--     client_secret == public
       ('browser',
        '',
        '$2a$10$uF8EnI9HyHeoF6yHYrLevOjfDFNMoUcKC4TaZfc61kGeeQYpKKEsa',
        'gg',
        'refresh_token,password',
        '',
        '',
        3600,
        7200,
        '{}',
        '')
ON CONFLICT DO NOTHING;
