PGDMP                         x            endpoint_info    12.0    12.0                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16705    endpoint_info    DATABASE     �   CREATE DATABASE endpoint_info WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_India.1252' LC_CTYPE = 'English_India.1252';
    DROP DATABASE endpoint_info;
                postgres    false            �            1259    16708 	   endpoints    TABLE     �   CREATE TABLE public.endpoints (
    endpoint_id integer NOT NULL,
    endpoint_name character varying(50),
    is_occupied boolean,
    occupied_by character varying(50),
    occupied_for character varying(100),
    is_deleted boolean
);
    DROP TABLE public.endpoints;
       public         heap    postgres    false            �            1259    16706    endpoints_endpoint_id_seq    SEQUENCE     �   CREATE SEQUENCE public.endpoints_endpoint_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.endpoints_endpoint_id_seq;
       public          postgres    false    203                       0    0    endpoints_endpoint_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.endpoints_endpoint_id_seq OWNED BY public.endpoints.endpoint_id;
          public          postgres    false    202            
           2604    16711    endpoints endpoint_id    DEFAULT     ~   ALTER TABLE ONLY public.endpoints ALTER COLUMN endpoint_id SET DEFAULT nextval('public.endpoints_endpoint_id_seq'::regclass);
 D   ALTER TABLE public.endpoints ALTER COLUMN endpoint_id DROP DEFAULT;
       public          postgres    false    202    203    203                      0    16708 	   endpoints 
   TABLE DATA           s   COPY public.endpoints (endpoint_id, endpoint_name, is_occupied, occupied_by, occupied_for, is_deleted) FROM stdin;
    public          postgres    false    203   �       	           0    0    endpoints_endpoint_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.endpoints_endpoint_id_seq', 8, true);
          public          postgres    false    202            �
           2606    16713    endpoints endpoints_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.endpoints
    ADD CONSTRAINT endpoints_pkey PRIMARY KEY (endpoint_id);
 B   ALTER TABLE ONLY public.endpoints DROP CONSTRAINT endpoints_pkey;
       public            postgres    false    203               :   x�3�,I-.q-�L���4.cL!L!SL!3L!sN$�� 	��(����� Y�$q     