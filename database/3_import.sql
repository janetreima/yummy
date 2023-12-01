INSERT INTO project.role (id, name) VALUES (DEFAULT, 'admin');
INSERT INTO project.role (id, name) VALUES (DEFAULT, 'user');

INSERT INTO project."user" (id, role_id, username, password) VALUES (DEFAULT, 2, 'jane', '123');
INSERT INTO project."user" (id, role_id, username, password) VALUES (DEFAULT, 2, 'vitali', '123');
INSERT INTO project."user" (id, role_id, username, password) VALUES (DEFAULT, 2, 'evgeny', '123');

INSERT INTO project.course (id, name) VALUES (DEFAULT, 'supp');
INSERT INTO project.course (id, name) VALUES (DEFAULT, 'praad');
INSERT INTO project.course (id, name) VALUES (DEFAULT, 'dessert');

INSERT INTO project.recipe (id, user_id, course_id, image_id, name, time, description, status) VALUES (DEFAULT, 2, 1, null, 'Kanasupp', '02:30:00', 'Lõika 500 g kanarindu kuubikuteks ja pruunista need potis 2 spl õlis. Lisa hakitud sibul, küüslauk, porgand ja seller ning kuumuta köögiviljad pehmeks. Vala peale 1 liiter kanapuljongit ja lisa 1 tass riisi. Keeda umbes 15 minutit või kuni riis on pehme. Maitsesta soola, pipra, tüümiani ja rosmariiniga vastavalt maitsele. Sega juurde 1 tass külmutatud herneid ja hauta veel paar minutit, kuni herned on soojad. Serveeri kanasupp värskete ürtidega ja naudi maitsvat kodust einet.', 'A');
INSERT INTO project.recipe (id, user_id, course_id, image_id, name, time, description, status) VALUES (DEFAULT, 1, 3, null, 'Tiramisu', '01:30:00', 'Sega 250 g mascarpone juustu, 3 munakollast ja 100 g suhkrut ühtlaseks kreemjaks massiks. Vahusta eraldi 3 munavalget pehmeks vahuks ning sega ettevaatlikult mascarpone segusse. Kasta kiirelt 200 g ladyfingers küpsiseid esmalt kohvisse ja ladusta need 20x20 cm vormi põhjale. Kata küpsised pool mascarpone seguga ja korda kihtide ladumist. Puista peale kakaopulbrit ja jäta tiramisu vähemalt 4 tunniks külmkappi settima. Serveeri ja naudi mõnusat ja kreemjat tiramisut!', 'A');

INSERT INTO project.ingredient (id, name) VALUES (DEFAULT, 'Kana');
INSERT INTO project.ingredient (id, name) VALUES (DEFAULT, 'Porgand');
INSERT INTO project.ingredient (id, name) VALUES (DEFAULT, 'Kartul');
INSERT INTO project.ingredient (id, name) VALUES (DEFAULT, 'Mascarpone');
INSERT INTO project.ingredient (id, name) VALUES (DEFAULT, 'Muna');

INSERT INTO project.measure_unit (id, name) VALUES (DEFAULT, 'kg');
INSERT INTO project.measure_unit (id, name) VALUES (DEFAULT, 'g');
INSERT INTO project.measure_unit (id, name) VALUES (DEFAULT, 'l');
INSERT INTO project.measure_unit (id, name) VALUES (DEFAULT, 'tk');
INSERT INTO project.measure_unit (id, name) VALUES (DEFAULT, 'tl');

INSERT INTO project.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id) VALUES (DEFAULT, 1, 1, 2);
INSERT INTO project.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id) VALUES (DEFAULT, 1, 2, 4);
INSERT INTO project.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id) VALUES (DEFAULT, 1, 3, 1);
INSERT INTO project.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id) VALUES (DEFAULT, 2, 4, 2);
INSERT INTO project.recipe_ingredient (id, recipe_id, ingredient_id, measure_unit_id) VALUES (DEFAULT, 2, 5, 4);

INSERT INTO project.profile (id, email, user_id, image_id) VALUES (DEFAULT, 'jane@super.ee', 1, null);
INSERT INTO project.profile (id, email, user_id, image_id) VALUES (DEFAULT, 'vitali@super.ee', 2, null);
INSERT INTO project.profile (id, email, user_id, image_id) VALUES (DEFAULT, 'evgeny@super.ee', 3, null);

INSERT INTO project.allergen (id, name) VALUES (DEFAULT, 'Gluteenivaba');
INSERT INTO project.allergen (id, name) VALUES (DEFAULT, 'Laktoosivaba');
INSERT INTO project.allergen (id, name) VALUES (DEFAULT, 'Suhkruvaba');

INSERT INTO project.tag (id, name) VALUES (DEFAULT, 'kana');
INSERT INTO project.tag (id, name) VALUES (DEFAULT, 'vürtsikas');
INSERT INTO project.tag (id, name) VALUES (DEFAULT, 'kala');
INSERT INTO project.tag (id, name) VALUES (DEFAULT, 'tervislik');

INSERT INTO project.recipe_allergen (id, recipe_id, allergen_id) VALUES (DEFAULT, 1, 2);

INSERT INTO project.recipe_tag (id, tag_id, recipe_id) VALUES (DEFAULT, 1, 1);



