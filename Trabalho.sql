--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.10
-- Dumped by pg_dump version 9.4.10
-- Started on 2017-03-11 10:38:03 AMT

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

DROP DATABASE loja;
--
-- TOC entry 2054 (class 1262 OID 16398)
-- Name: loja; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE loja WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'pt_BR.UTF-8' LC_CTYPE = 'pt_BR.UTF-8';


ALTER DATABASE loja OWNER TO postgres;

\connect loja

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 1 (class 3079 OID 11861)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2057 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 179 (class 1259 OID 16435)
-- Name: Acessorios; Type: TABLE; Schema: public; Owner: thayna; Tablespace: 
--

CREATE TABLE "Acessorios" (
    nome character varying(128) NOT NULL,
    descricao character varying(1024),
    precocusto numeric NOT NULL,
    percentlucro numeric NOT NULL,
    quantidade integer NOT NULL,
    id integer NOT NULL
);


ALTER TABLE "Acessorios" OWNER TO thayna;

--
-- TOC entry 178 (class 1259 OID 16427)
-- Name: Cosmeticos; Type: TABLE; Schema: public; Owner: thayna; Tablespace: 
--

CREATE TABLE "Cosmeticos" (
    nome character varying(128) NOT NULL,
    descricao character varying(1024),
    precocusto numeric NOT NULL,
    percentlucro numeric NOT NULL,
    quantidade integer NOT NULL,
    id integer NOT NULL
);


ALTER TABLE "Cosmeticos" OWNER TO thayna;

--
-- TOC entry 175 (class 1259 OID 16407)
-- Name: Endereco; Type: TABLE; Schema: public; Owner: thayna; Tablespace: 
--

CREATE TABLE "Endereco" (
    rua character varying(64) NOT NULL,
    numero integer NOT NULL,
    cep character varying(9) NOT NULL,
    complemento character varying(16),
    bairro character varying(32) NOT NULL,
    cidade character varying(32) NOT NULL,
    proprietario character varying(14) NOT NULL
);


ALTER TABLE "Endereco" OWNER TO thayna;

--
-- TOC entry 180 (class 1259 OID 16443)
-- Name: Estoque; Type: TABLE; Schema: public; Owner: thayna; Tablespace: 
--

CREATE TABLE "Estoque" (
    nome character varying(128) NOT NULL,
    quantidade integer NOT NULL,
    id integer NOT NULL
);


ALTER TABLE "Estoque" OWNER TO thayna;

--
-- TOC entry 176 (class 1259 OID 16414)
-- Name: Gerente; Type: TABLE; Schema: public; Owner: thayna; Tablespace: 
--

CREATE TABLE "Gerente" (
    nome character varying(128) NOT NULL,
    celular character varying(14) NOT NULL,
    id integer NOT NULL,
    senha integer NOT NULL
);


ALTER TABLE "Gerente" OWNER TO thayna;

--
-- TOC entry 177 (class 1259 OID 16419)
-- Name: Perfumaria; Type: TABLE; Schema: public; Owner: thayna; Tablespace: 
--

CREATE TABLE "Perfumaria" (
    nome character varying(128) NOT NULL,
    descricao character varying(1024),
    precocusto numeric NOT NULL,
    percentlucro numeric NOT NULL,
    quantidade integer NOT NULL,
    id integer NOT NULL
);


ALTER TABLE "Perfumaria" OWNER TO thayna;

--
-- TOC entry 174 (class 1259 OID 16404)
-- Name: cliente; Type: TABLE; Schema: public; Owner: thayna; Tablespace: 
--

CREATE TABLE cliente (
    nome character varying(128) NOT NULL,
    rg character varying(11) NOT NULL,
    cpf character varying(14) NOT NULL,
    telefonefixo character varying(13),
    celular character varying(14) NOT NULL
);


ALTER TABLE cliente OWNER TO thayna;

--
-- TOC entry 173 (class 1259 OID 16399)
-- Name: vendedor; Type: TABLE; Schema: public; Owner: thayna; Tablespace: 
--

CREATE TABLE vendedor (
    nome character varying(128) NOT NULL,
    rg character varying(11) NOT NULL,
    cpf character varying(14) NOT NULL,
    telefonefixo character varying(13),
    celular character varying(14) NOT NULL,
    id integer NOT NULL
);


ALTER TABLE vendedor OWNER TO thayna;

--
-- TOC entry 2048 (class 0 OID 16435)
-- Dependencies: 179
-- Data for Name: Acessorios; Type: TABLE DATA; Schema: public; Owner: thayna
--



--
-- TOC entry 2047 (class 0 OID 16427)
-- Dependencies: 178
-- Data for Name: Cosmeticos; Type: TABLE DATA; Schema: public; Owner: thayna
--



--
-- TOC entry 2044 (class 0 OID 16407)
-- Dependencies: 175
-- Data for Name: Endereco; Type: TABLE DATA; Schema: public; Owner: thayna
--



--
-- TOC entry 2049 (class 0 OID 16443)
-- Dependencies: 180
-- Data for Name: Estoque; Type: TABLE DATA; Schema: public; Owner: thayna
--



--
-- TOC entry 2045 (class 0 OID 16414)
-- Dependencies: 176
-- Data for Name: Gerente; Type: TABLE DATA; Schema: public; Owner: thayna
--



--
-- TOC entry 2046 (class 0 OID 16419)
-- Dependencies: 177
-- Data for Name: Perfumaria; Type: TABLE DATA; Schema: public; Owner: thayna
--



--
-- TOC entry 2043 (class 0 OID 16404)
-- Dependencies: 174
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: thayna
--

INSERT INTO cliente (nome, rg, cpf, telefonefixo, celular) VALUES ('desertov', '001903197', '057.128.371-37', '(67)3391-1613', '(67)99220-1391');
INSERT INTO cliente (nome, rg, cpf, telefonefixo, celular) VALUES ('Victor Deserto', '001.903.197', '123.456.789-00', '', '(67)98131-4953');
INSERT INTO cliente (nome, rg, cpf, telefonefixo, celular) VALUES ('Everton de Aquino', '120.345.31', '012.292.801-91', 'null', '(83)93214-1421');
INSERT INTO cliente (nome, rg, cpf, telefonefixo, celular) VALUES ('alguem', '001924342', '012.253.123-43', 'null', '(67)98141-2342');
INSERT INTO cliente (nome, rg, cpf, telefonefixo, celular) VALUES ('Jose', '01293124', '423.567.432-30', 'null', '(45)92344-1239');


--
-- TOC entry 2042 (class 0 OID 16399)
-- Dependencies: 173
-- Data for Name: vendedor; Type: TABLE DATA; Schema: public; Owner: thayna
--



--
-- TOC entry 1919 (class 2606 OID 16411)
-- Name: Endereco_pkey; Type: CONSTRAINT; Schema: public; Owner: thayna; Tablespace: 
--

ALTER TABLE ONLY "Endereco"
    ADD CONSTRAINT "Endereco_pkey" PRIMARY KEY (proprietario);


--
-- TOC entry 1915 (class 2606 OID 16403)
-- Name: Funcionario_pkey; Type: CONSTRAINT; Schema: public; Owner: thayna; Tablespace: 
--

ALTER TABLE ONLY vendedor
    ADD CONSTRAINT "Funcionario_pkey" PRIMARY KEY (id);


--
-- TOC entry 1917 (class 2606 OID 16413)
-- Name: cpf_pkey; Type: CONSTRAINT; Schema: public; Owner: thayna; Tablespace: 
--

ALTER TABLE ONLY cliente
    ADD CONSTRAINT cpf_pkey PRIMARY KEY (cpf);


--
-- TOC entry 1927 (class 2606 OID 16442)
-- Name: idAcess_pkey; Type: CONSTRAINT; Schema: public; Owner: thayna; Tablespace: 
--

ALTER TABLE ONLY "Acessorios"
    ADD CONSTRAINT "idAcess_pkey" PRIMARY KEY (id);


--
-- TOC entry 1925 (class 2606 OID 16434)
-- Name: idCosm_pkey; Type: CONSTRAINT; Schema: public; Owner: thayna; Tablespace: 
--

ALTER TABLE ONLY "Cosmeticos"
    ADD CONSTRAINT "idCosm_pkey" PRIMARY KEY (id);


--
-- TOC entry 1929 (class 2606 OID 16447)
-- Name: idEstoque_pkey; Type: CONSTRAINT; Schema: public; Owner: thayna; Tablespace: 
--

ALTER TABLE ONLY "Estoque"
    ADD CONSTRAINT "idEstoque_pkey" PRIMARY KEY (id);


--
-- TOC entry 1923 (class 2606 OID 16426)
-- Name: idPerf_pkey; Type: CONSTRAINT; Schema: public; Owner: thayna; Tablespace: 
--

ALTER TABLE ONLY "Perfumaria"
    ADD CONSTRAINT "idPerf_pkey" PRIMARY KEY (id);


--
-- TOC entry 1921 (class 2606 OID 16418)
-- Name: id_pkey; Type: CONSTRAINT; Schema: public; Owner: thayna; Tablespace: 
--

ALTER TABLE ONLY "Gerente"
    ADD CONSTRAINT id_pkey PRIMARY KEY (id);


--
-- TOC entry 1932 (class 2606 OID 16448)
-- Name: acess_fkey; Type: FK CONSTRAINT; Schema: public; Owner: thayna
--

ALTER TABLE ONLY "Estoque"
    ADD CONSTRAINT acess_fkey FOREIGN KEY (id) REFERENCES "Estoque"(id);


--
-- TOC entry 1931 (class 2606 OID 16458)
-- Name: cosm_fkey; Type: FK CONSTRAINT; Schema: public; Owner: thayna
--

ALTER TABLE ONLY "Cosmeticos"
    ADD CONSTRAINT cosm_fkey FOREIGN KEY (id) REFERENCES "Estoque"(id);


--
-- TOC entry 1930 (class 2606 OID 16453)
-- Name: perf_fkey; Type: FK CONSTRAINT; Schema: public; Owner: thayna
--

ALTER TABLE ONLY "Perfumaria"
    ADD CONSTRAINT perf_fkey FOREIGN KEY (id) REFERENCES "Estoque"(id);


--
-- TOC entry 2056 (class 0 OID 0)
-- Dependencies: 7
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2017-03-11 10:38:03 AMT

--
-- PostgreSQL database dump complete
--

