# desafio-sos
Desafio-sos
Foi usado o framework Spring boot para fazer a aplicação, junto com o Bootstrap e HTML5 para criar as interfaces. Os dados vão ser salvos no banco de dados Postgress.
Inicialmente adotei uma arquitetura MVC só que com o decorrer do projeto, acabei criando um service para ficar mais flexível e também adicionei um DTO para fazer a
validação dos campos que estão sendo enviados.
Na classe Marca o marcaId foi usado como o Id da classe e vai ser gerado automaticamente. A marca pode ser cadastrada, atualizada, deletada e obtida por meio da marcaId.  FOi colocado um meio de 
validar se existe duas marcas com o mesmo nome, caso já exista não será possível criar ou atualizar com esse mesmo nome.
Na classe Património o nDoTombo foi usado como o Id da classe onde ele também vai ser gerado automaticamente. O patrimônio pode ser cadastrado, atualizado, deletado e
obtido por meio do nDoTombo.

--------------------------------------------------------------
CREATE DATABASE 'sos'
USE DATABASE 'sos'

CREATE TABLE 'tb_marcas'(
marcaId UUID(5) PRIMARY KEY UNSIGNED NOT NULL AUTO_INCREMENT,
nome VARCHAR(100) NOT NULL
);

CREATE TABLE 'tb_patrimonio'(
nDoTombo UUID(6) PRIMARY KEY UNSIGNED NOT NULL AUTO_INCREMENT, 
decricao VARCHAR(300) NOT NULL,
nome VARCHAR(100) NOT NULL
);
