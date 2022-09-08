CREATE DATABASE `listadetarefas`;
USE `listadetarefas`;
CREATE TABLE `tarefas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT 'Sem título.',
  `description` text,
  `priority` enum('BAIXA','MEDIANA','ALTA') DEFAULT 'MEDIANA',
  `completed` tinyint DEFAULT '0',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `expires_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;