insert into roles(name)
values ('ROLE_USER'),
       ('ROLE_ADMIN') on conflict do nothing;

-- password for Admin: vFantasticFour4

insert into users(name, surname, email, password, is_user_non_locked)
values ('Administrator',
        'Blank',
        '228@s.cpm',
        '$2a$10$/Q65ZqFqk.oE9YiNCjMJSOl4bvmFZJ1JhsARSfxFJOGJvWbjIUaWe',
        true) on conflict(email) do nothing;

-- Insuring Administrator will have exact Admin_Role id
update users
set role_id = (select id from roles where name = 'ROLE_ADMIN')
where name = 'Administrator';

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
        '') ON CONFLICT DO NOTHING;
