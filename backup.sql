PGDMP      	                |            postgres    16.2    16.2     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    5    postgres    DATABASE     {   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_India.1252';
    DROP DATABASE postgres;
                postgres    false            �           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    4785            �            1259    24602    website_summarize_logs    TABLE     �   CREATE TABLE public.website_summarize_logs (
    "timestamp" character varying NOT NULL,
    website character varying NOT NULL
);
 *   DROP TABLE public.website_summarize_logs;
       public         heap    postgres    false            �          0    24602    website_summarize_logs 
   TABLE DATA           F   COPY public.website_summarize_logs ("timestamp", website) FROM stdin;
    public          postgres    false    216   /       �   n  x���[N�`���*��:������Fjm)v�Ro��s�<~�x��3��Pg�S2��T +�������M���`ޯZh�	��jN��݄[�	�(&��O��Q�D�D��LS���|2���ߗ�j�v/�膾��e�l���E���Bnu�SM�K�n0Q|����/�OI�t����S�~���U�S,.�rz�˚쪎�H\�D��	1�<���)���}J�H�=�y��m��N�`PN��B���I�$�,ñ;�W�?��$���1_bT����7���AS%+�f���\���יMsn�����|ݾ��T�rbXS�x����u���ǻ�%*9�i��27*s�� �� ���l�=L&�O�61�     