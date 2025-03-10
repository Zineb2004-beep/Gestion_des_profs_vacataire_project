
-- Base de données : `gestiondesprofsvacataires`

-- Structure de la table `affectaioncours`


CREATE TABLE `affectaioncours` (
  `prof_id` int(11) DEFAULT NULL,
  `cour_id` int(11) DEFAULT NULL
) ;

-- --------------------------------------------------------

-- Structure de la table `cours`


CREATE TABLE `cours` (
  `id_Cour` int(11) NOT NULL,
  `intitule` varchar(40) NOT NULL,
  `salle` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------


-- Structure de la table `professeur`


CREATE TABLE `professeur` (
  `id_Prof` int(20) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `specialite` varchar(30) NOT NULL
);

-- --------------------------------------------------------
-- Index pour les tables déchargées

-- Index pour la table `affectaioncours`

ALTER TABLE `affectaioncours`
  ADD KEY `professeur_fk_1` (`prof_id`),
  ADD KEY `cours_fk_1` (`cour_id`);

-- --------------------------------------------------------

-- Index pour la table `cours`

ALTER TABLE `cours`
  ADD PRIMARY KEY (`id_Cour`),
  ADD UNIQUE KEY `id_Cour` (`id_Cour`);
-- --------------------------------------------------------

-- Index pour la table `professeur`

ALTER TABLE `professeur`
  ADD PRIMARY KEY (`id_Prof`),
  ADD UNIQUE KEY `id_Prof` (`id_Prof`);

-- --------------------------------------------------------

-- Contraintes pour les tables déchargées

-- Contraintes pour la table `affectaioncours`

ALTER TABLE `affectaioncours`
  ADD CONSTRAINT `cours_fk_1` FOREIGN KEY (`cour_id`) REFERENCES `cours` (`id_Cour`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `professeur_fk_1` FOREIGN KEY (`prof_id`) REFERENCES `professeur` (`id_Prof`) ON DELETE CASCADE ON UPDATE CASCADE;
