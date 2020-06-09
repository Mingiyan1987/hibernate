-- Table: public.students

-- DROP TABLE public.students;

CREATE TABLE public.students
(
    id bigint NOT NULL,
    name character varying(2500000) COLLATE pg_catalog."default",
    mark integer
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.students
    OWNER to postgres;


-- DROP SEQUENCE public.hibernate_sequence;

CREATE SEQUENCE public.hibernate_sequence
    INCREMENT 1
    START 74169
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.hibernate_sequence
    OWNER TO postgres;