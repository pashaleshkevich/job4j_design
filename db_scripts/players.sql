CREATE TABLE players (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
	birth_date DATE,
    field_position VARCHAR(50),
	university VARCHAR(100),
    height INTEGER,
    weight INTEGER,
    strengths TEXT,     
    weaknesses TEXT     
);
INSERT INTO players (
    name, 
    birth_date, 
    field_position,
	university, 
    height, 
    weight, 
    strengths, 
    weaknesses
) VALUES (
    'Фернандо Мендоса',
    '2003-10-01',  
    'Quarterback',
    'Indiana Hoosiers',
    196,
    102,
    'Сильная рука. Хорошо читает поле.',
    'Средний атлетизм.'
);
UPDATE players SET 
    strengths = 'Сильная рука. Хорошо читает поле. Отличная защита мяча. Не боится контакта. Готов к НФЛ.',
    weaknesses = 'Средний атлетизм. Не является настоящим dual-threat QB для НФЛ.';
DELETE FROM players;
SELECT * FROM players;