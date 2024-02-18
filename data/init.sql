-- Table: public.contents2

-- DROP TABLE IF EXISTS public.contents2;

CREATE TABLE IF NOT EXISTS public.contents2
(
    contents_id integer NOT NULL DEFAULT nextval('id_seq'::regclass),
    user_id integer,
    title character varying(100) COLLATE pg_catalog."default",
    file_name text COLLATE pg_catalog."default",
    file bytea,
    description character varying(1000) COLLATE pg_catalog."default",
    file_name_2 text COLLATE pg_catalog."default",
    file_2 bytea,
    description_2 character varying(1000) COLLATE pg_catalog."default",
    created_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT pk_contents2 PRIMARY KEY (contents_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.contents2
    OWNER to postgres;


-- Table: public.mutters

-- DROP TABLE IF EXISTS public.mutters;

CREATE TABLE IF NOT EXISTS public.mutters
(
    id integer NOT NULL DEFAULT nextval('mutters_mutter_id_seq'::regclass),
    user_id integer,
    name character varying(30) COLLATE pg_catalog."default",
    text character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT mutters_pkey PRIMARY KEY (id),
    CONSTRAINT fkps6ittag3h4d9u0bk7a07g877 FOREIGN KEY (user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.mutters
    OWNER to postgres;


-- Table: public.users

-- DROP TABLE IF EXISTS public.users;

CREATE TABLE IF NOT EXISTS public.users
(
    id integer NOT NULL,
    password character varying(20) COLLATE pg_catalog."default" NOT NULL,
    mail character varying(50) COLLATE pg_catalog."default",
    name character varying(30) COLLATE pg_catalog."default",
    age integer NOT NULL,
    created_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT users_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.users
    OWNER to postgres;
