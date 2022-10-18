CREATE TABLE resume
(
    uuid_pk   char(36) PRIMARY KEY,
    full_name text NOT NULL
);

CREATE TABLE contact
(
    id_pk       serial PRIMARY KEY,
    type        text     NOT NULL,
    value       text     NOT NULL,
    resume_uuid char(36) NOT NULL,
    CONSTRAINT contact_resume_uuid_fk FOREIGN KEY (resume_uuid) REFERENCES resume (uuid_pk) ON DELETE CASCADE
);

CREATE TABLE section
(
    id_pk       serial PRIMARY KEY,
    resume_uuid char(36) NOT NULL,
    type        text     NOT NULL,
    content     text     NOT NULL,
    CONSTRAINT section_resume_uuid_fk FOREIGN KEY (resume_uuid) REFERENCES resume (uuid_pk) ON DELETE CASCADE
);

CREATE UNIQUE INDEX section_uuid_type_index ON section (resume_uuid, type);

CREATE UNIQUE INDEX contact_uuid_type_index ON contact (resume_uuid, type);

INSERT INTO contact (resume_uuid, "type", "value")
VALUES ('7de882da-02f2-4d16-8daa-60660aaf4071', 'PHONE', '123456'),
       ('7de882da-02f2-4d16-8daa-60660aaf4071', 'SKYPE', 'skype');

SELECT *
FROM resume;

SELECT *
FROM contact;

SELECT *
FROM section;

SELECT *
FROM resume r
         LEFT JOIN contact c ON r.uuid_pk = c.resume_uuid;