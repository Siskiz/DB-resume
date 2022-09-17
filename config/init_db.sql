create table "public".resume
(
  uuid_pk char(36) primary key,
  full_name text not null
);

create table "public".contact
(
    id_pk serial primary key,
    type text not null,
    value text not null,
    resume_uuid char(36) not null,
    constraint contact_resume_uuid_fk foreign key(resume_uuid) references resume(uuid_pk) on delete cascade
);

create unique index contact_uuid_type_index
on "public".contact(resume_uuid, type);

select * from resume;

select * from contact;

delete from resume;

insert into contact (resume_uuid, "type", "value")
values
('7de882da-02f2-4d16-8daa-60660aaf4071', 'PHONE', '123456'),
('7de882da-02f2-4d16-8daa-60660aaf4071', 'SKYPE', 'skype');

SELECT * FROM resume r
LEFT JOIN contact c ON r.uuid_pk = c.resume_uuid;
