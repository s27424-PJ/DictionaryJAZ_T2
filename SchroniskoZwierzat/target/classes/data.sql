CREATE TABLE IF NOT EXISTS Animal (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    species VARCHAR(255) NOT NULL,
    age INT NOT NULL
);
INSERT INTO Animal (id, name, species, age) VALUES ('ecb7fa7d-f6a1-4e6b-b1f6-8eb46b65d0a1', 'Burek', 'Pies', 3);
INSERT INTO Animal (id, name, species, age) VALUES ('3acdd65b-14ff-47ae-bb89-3629f05d014c', 'Filemon', 'Kot', 5);
INSERT INTO Animal (id, name, species, age) VALUES ('d1a04ed7-8db9-474d-a132-d8706c3682cb', 'Rex', 'Pies', 2);
INSERT INTO Animal (id, name, species, age) VALUES ('2b8f3a65-1d2c-4462-a78b-9a0768f7ad29', 'Rex', 'Pies', 2);


INSERT INTO ANIMAL_TYPE (id, type) VALUES ('1','Kot');
INSERT INTO ANIMAL_TYPE (id, type) VALUES ('2','Pies');
