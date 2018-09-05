SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

CREATE SCHEMA schema;

ALTER SCHEMA schema OWNER TO ncollins;

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';

SET default_tablespace = '';

SET default_with_oids = false;


CREATE TABLE public.users (
    user_id integer NOT NULL,
    username character varying(30),
    email character varying(100),
    password character varying(50),
    firstname character varying(50),
    lastname character varying(50)
);

ALTER TABLE public.users OWNER TO ncollins;

CREATE SEQUENCE public.users_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.users_user_id_seq OWNER TO ncollins;

ALTER SEQUENCE public.users_user_id_seq OWNED BY public.users.user_id;

CREATE TABLE schema.users (
    user_id integer NOT NULL,
    username character varying(30),
    email character varying(100),
    password character varying(50),
    firstname character varying(50),
    lastname character varying(50)
);

ALTER TABLE schema.users OWNER TO ncollins;

CREATE SEQUENCE schema.users_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE schema.users_user_id_seq OWNER TO ncollins;

ALTER SEQUENCE schema.users_user_id_seq OWNED BY schema.users.user_id;

ALTER TABLE ONLY public.users ALTER COLUMN user_id SET DEFAULT nextval('public.users_user_id_seq'::regclass);

ALTER TABLE ONLY schema.users ALTER COLUMN user_id SET DEFAULT nextval('schema.users_user_id_seq'::regclass);

COPY public.users (user_id, username, email, password, firstname, lastname) FROM stdin;
\.

COPY schema.users (user_id, username, email, password, firstname, lastname) FROM stdin;
\.

SELECT pg_catalog.setval('public.users_user_id_seq', 1, false);

SELECT pg_catalog.setval('schema.users_user_id_seq', 1, false);

