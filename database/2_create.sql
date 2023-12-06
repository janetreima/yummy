-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-11-30 12:04:01.933

-- tables
-- Table: allergen
CREATE TABLE allergen
(
    id   serial       NOT NULL,
    name varchar(255) NOT NULL,
    CONSTRAINT allergen_pk PRIMARY KEY (id)
);

-- Table: course
CREATE TABLE course
(
    id   serial       NOT NULL,
    name varchar(255) NOT NULL,
    CONSTRAINT course_pk PRIMARY KEY (id)
);

-- Table: image
CREATE TABLE image
(
    id   serial NOT NULL,
    data bytea  NOT NULL,
    CONSTRAINT image_pk PRIMARY KEY (id)
);

-- Table: ingredient
CREATE TABLE ingredient
(
    id   serial       NOT NULL,
    name varchar(255) NOT NULL,
    CONSTRAINT ingredient_pk PRIMARY KEY (id)
);

-- Table: measure_unit
CREATE TABLE measure_unit
(
    id   serial       NOT NULL,
    name varchar(255) NOT NULL,
    CONSTRAINT measure_unit_pk PRIMARY KEY (id)
);

-- Table: profile
CREATE TABLE profile
(
    id       serial       NOT NULL,
    email    varchar(255) NOT NULL,
    user_id  int          NOT NULL,
    image_id int          NULL,
    CONSTRAINT profile_pk PRIMARY KEY (id)
);

-- Table: recipe
CREATE TABLE recipe
(
    id          serial        NOT NULL,
    user_id     int           NOT NULL,
    course_id   int           NOT NULL,
    image_id    int           NULL,
    name        varchar(255)  NOT NULL,
    time_minute int           NOT NULL,
    description varchar(1000) NOT NULL,
    status      char(1)       NOT NULL,
    CONSTRAINT recipe_pk PRIMARY KEY (id)
);

-- Table: recipe_allergen
CREATE TABLE recipe_allergen
(
    id          serial NOT NULL,
    recipe_id   int    NOT NULL,
    allergen_id int    NOT NULL,
    CONSTRAINT recipe_allergen_pk PRIMARY KEY (id)
);

-- Table: recipe_ingredient
CREATE TABLE recipe_ingredient
(
    id              serial NOT NULL,
    recipe_id       int    NOT NULL,
    ingredient_id   int    NOT NULL,
    measure_unit_id int    NOT NULL,
    CONSTRAINT recipe_ingredient_pk PRIMARY KEY (id)
);

-- Table: recipe_tag
CREATE TABLE recipe_tag
(
    id        serial NOT NULL,
    tag_id    int    NOT NULL,
    recipe_id int    NOT NULL,
    CONSTRAINT recipe_tag_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role
(
    id   serial       NOT NULL,
    name varchar(255) NOT NULL,
    CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: tag
CREATE TABLE tag
(
    id   serial       NOT NULL,
    name varchar(255) NOT NULL,
    CONSTRAINT tag_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user"
(
    id       serial       NOT NULL,
    role_id  int          NOT NULL,
    username varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: profile_image (table: profile)
ALTER TABLE profile
    ADD CONSTRAINT profile_image
        FOREIGN KEY (image_id)
            REFERENCES image (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: profile_user (table: profile)
ALTER TABLE profile
    ADD CONSTRAINT profile_user
        FOREIGN KEY (user_id)
            REFERENCES "user" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: recipe_allergen_recipe (table: recipe_allergen)
ALTER TABLE recipe_allergen
    ADD CONSTRAINT recipe_allergen_recipe
        FOREIGN KEY (recipe_id)
            REFERENCES recipe (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: recipe_course (table: recipe)
ALTER TABLE recipe
    ADD CONSTRAINT recipe_course
        FOREIGN KEY (course_id)
            REFERENCES course (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: recipe_image (table: recipe)
ALTER TABLE recipe
    ADD CONSTRAINT recipe_image
        FOREIGN KEY (image_id)
            REFERENCES image (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: recipe_ingredient_ingredient (table: recipe_ingredient)
ALTER TABLE recipe_ingredient
    ADD CONSTRAINT recipe_ingredient_ingredient
        FOREIGN KEY (ingredient_id)
            REFERENCES ingredient (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: recipe_ingredient_measure_unit (table: recipe_ingredient)
ALTER TABLE recipe_ingredient
    ADD CONSTRAINT recipe_ingredient_measure_unit
        FOREIGN KEY (measure_unit_id)
            REFERENCES measure_unit (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: recipe_ingredient_recipe (table: recipe_ingredient)
ALTER TABLE recipe_ingredient
    ADD CONSTRAINT recipe_ingredient_recipe
        FOREIGN KEY (recipe_id)
            REFERENCES recipe (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: recipe_tag_recipe (table: recipe_tag)
ALTER TABLE recipe_tag
    ADD CONSTRAINT recipe_tag_recipe
        FOREIGN KEY (recipe_id)
            REFERENCES recipe (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: recipe_tag_tag (table: recipe_tag)
ALTER TABLE recipe_tag
    ADD CONSTRAINT recipe_tag_tag
        FOREIGN KEY (tag_id)
            REFERENCES tag (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: recipe_user (table: recipe)
ALTER TABLE recipe
    ADD CONSTRAINT recipe_user
        FOREIGN KEY (user_id)
            REFERENCES "user" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: recipeallergen_allergen (table: recipe_allergen)
ALTER TABLE recipe_allergen
    ADD CONSTRAINT recipeallergen_allergen
        FOREIGN KEY (allergen_id)
            REFERENCES allergen (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: user_role (table: user)
ALTER TABLE "user"
    ADD CONSTRAINT user_role
        FOREIGN KEY (role_id)
            REFERENCES role (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- End of file.