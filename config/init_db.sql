create table resume
(
  uuid      text primary key not null,
  full_name text
);

create table contact
(
  id          serial,
  type        text not null,
	value       text not null,
	resume_uuid text not null,
	constraint contact_resume_uuid_fk foreign key(resume_uuid)
	references resume(uuid) on delete cascade
);

create unique index contact_uuid_type_index
  on contact (resume_uuid, type);

create table section
(
   id          serial primary key,
   type        text,
   content     text,
   resume_uuid text not null,
   constraint section_resume_uuid_fk foreign key(resume_uuid)
	 references resume(uuid) on delete cascade
);

create unique index section_idx
  ON section (resume_uuid, type);