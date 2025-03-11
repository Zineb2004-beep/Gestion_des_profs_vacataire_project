-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : mar. 11 mars 2025 à 08:16
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestiondesprofsvacataires`
--

-- --------------------------------------------------------

--
-- Structure de la table `affectationcours`
--

CREATE TABLE `affectationcours` (
  `prof_id` int(11) NOT NULL,
  `cour_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

CREATE TABLE `cours` (
  `id_Cour` int(11) NOT NULL,
  `intitule` varchar(40) NOT NULL,
  `salle` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `cours`
--

INSERT INTO `cours` (`id_Cour`, `intitule`, `salle`) VALUES
(38, 'Java', 'Salle I1'),
(39, 'Algèbre', 'Salle I2');

-- --------------------------------------------------------

--
-- Structure de la table `professeur`
--

CREATE TABLE `professeur` (
  `id_Prof` int(11) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `specialite` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `professeur`
--

INSERT INTO `professeur` (`id_Prof`, `nom`, `prenom`, `specialite`) VALUES
(31, 'ALAMI', 'Sara', 'Informatique'),
(32, 'BENANI', 'Bilal', 'Mathématiques');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `affectationcours`
--
ALTER TABLE `affectationcours`
  ADD PRIMARY KEY (`prof_id`,`cour_id`),
  ADD KEY `professeur_fk_1` (`prof_id`),
  ADD KEY `cours_fk_1` (`cour_id`);

--
-- Index pour la table `cours`
--
ALTER TABLE `cours`
  ADD PRIMARY KEY (`id_Cour`),
  ADD UNIQUE KEY `id_Cour` (`id_Cour`);

--
-- Index pour la table `professeur`
--
ALTER TABLE `professeur`
  ADD PRIMARY KEY (`id_Prof`),
  ADD UNIQUE KEY `id_Prof` (`id_Prof`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `cours`
--
ALTER TABLE `cours`
  MODIFY `id_Cour` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT pour la table `professeur`
--
ALTER TABLE `professeur`
  MODIFY `id_Prof` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `affectationcours`
--
ALTER TABLE `affectationcours`
  ADD CONSTRAINT `cours_fk_1` FOREIGN KEY (`cour_id`) REFERENCES `cours` (`id_Cour`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `professeur_fk_1` FOREIGN KEY (`prof_id`) REFERENCES `professeur` (`id_Prof`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
