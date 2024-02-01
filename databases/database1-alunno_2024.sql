create database prova_betacom_2024;
create table alunno{
IDalunno int(4) not null auto_increment,
nome string(30) not null,
cognome string(30) not null,
datanascita date,
primary key alunno(IDalunno),
};


-- Insert data into the 'alunno' table
INSERT INTO alunno (nome, cognome, datanascita) VALUES
('Mario', 'Rossi', '2002-03-15'),
('Anna', 'Bianchi', '2001-08-22'),
('Luca', 'Verdi', '2003-05-10');


select*from alunni where nome like"M%"

