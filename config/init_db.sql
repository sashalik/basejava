create table resume
(
  uuid varchar(36) primary key not NULL,
  full_name text
);

create table contact
(
  id serial primary key,
  type text not null,
	value text not null,
	resume_uuid char(36) not null,
	constraint contact_resume_uuid_fk foreign key(resume_uuid)
	references resume(uuid) on delete cascade
);

create table section
(
   type text,
   content text,
   resume_uuid text not null,
   constraint section_resume_uuid_fk foreign key(resume_uuid)
	 references resume(uuid) on delete cascade
);