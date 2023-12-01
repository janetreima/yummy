-- Kustutab public schema (mis põhimõtteliselt kustutab kõik tabelid)
DROP SCHEMA project CASCADE;
-- Loob uue public schema vajalikud õigused
CREATE SCHEMA project
-- taastab vajalikud andmebaasi õigused
    GRANT ALL ON SCHEMA project TO postgres;
GRANT ALL ON SCHEMA project TO PUBLIC;
