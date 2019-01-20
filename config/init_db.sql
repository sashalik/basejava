create table resume
(
  uuid text not null,
  full_name text,
  constraint resume_pkey primary key (uuid)
);

create table contact
(
  id integer not null default nextval('contact_id_seq'::regclass),
  type text not null,
	value text not null,
	resume_uuid text not null,
	constraint contact_resume_uuid_fk foreign key(resume_uuid)
	references resume(uuid) on delete cascade
);

create index fki_contact_resume_uuid_fk
    on public.contact using btree
    (resume_uuid collate pg_catalog."default")
    TABLESPACE pg_default;

create table section
(
   type text,
   content text,
   resume_uuid text not null,
   constraint section_resume_uuid_fk foreign key(resume_uuid)
	 references resume(uuid) on delete cascade
);

create index fki_sections_resume_uuid_fk
    on public.section using btree
    (resume_uuid collate pg_catalog."default")
    TABLESPACE pg_default;