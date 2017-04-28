-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Client :  localhost:8889
-- Généré le :  Ven 28 Avril 2017 à 13:08
-- Version du serveur :  5.6.35
-- Version de PHP :  7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `gestionStage`
--

-- --------------------------------------------------------

--
-- Structure de la table `administrateur`
--

CREATE TABLE `administrateur` (
  `id` int(11) NOT NULL,
  `nom` varchar(45) NOT NULL,
  `prenom` varchar(45) NOT NULL,
  `adresseNoRue` int(11) NOT NULL,
  `adresseRue` varchar(45) NOT NULL,
  `adresseComplement` varchar(45) DEFAULT NULL,
  `adresseCdePostal` int(11) NOT NULL,
  `adresseVille` varchar(45) NOT NULL,
  `adressePays` varchar(45) NOT NULL,
  `mail` varchar(45) NOT NULL,
  `tel` int(11) NOT NULL,
  `idUtilisateur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `administrateur`
--

INSERT INTO `administrateur` (`id`, `nom`, `prenom`, `adresseNoRue`, `adresseRue`, `adresseComplement`, `adresseCdePostal`, `adresseVille`, `adressePays`, `mail`, `tel`, `idUtilisateur`) VALUES
(3, 'MOHAMED', 'Allam', 13, 'Rue de la Grange aux Cerfs', NULL, 91700, 'Ste-Geneviève-des-Bois', 'France', 'mohamedallam31@hotmail.com', 669181106, 7),
(4, 'DRAME', 'Arouna', 5, 'Rue de Liers', NULL, 91800, 'Brunoy', 'France', 'dramearouna@gmail.com', 753929059, 8);

-- --------------------------------------------------------

--
-- Structure de la table `candidature`
--

CREATE TABLE `candidature` (
  `id` int(11) NOT NULL,
  `idOffre` int(11) NOT NULL,
  `idEtudiant` int(11) NOT NULL,
  `dateCandidature` varchar(100) DEFAULT NULL,
  `isAccept` int(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `candidature`
--

INSERT INTO `candidature` (`id`, `idOffre`, `idEtudiant`, `dateCandidature`, `isAccept`) VALUES
(15, 6, 2, '28-04-2017', 1),
(16, 4, 2, '28-04-2017', 0);

-- --------------------------------------------------------

--
-- Structure de la table `droit_utilisateur`
--

CREATE TABLE `droit_utilisateur` (
  `idDroit` int(11) NOT NULL,
  `droit` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `droit_utilisateur`
--

INSERT INTO `droit_utilisateur` (`idDroit`, `droit`) VALUES
(1, 'Administrateur'),
(2, 'Entreprise'),
(3, 'Etudiant');

-- --------------------------------------------------------

--
-- Structure de la table `entreprise`
--

CREATE TABLE `entreprise` (
  `id` int(11) NOT NULL,
  `raisonSociale` varchar(45) DEFAULT NULL,
  `adresseVille` varchar(45) DEFAULT NULL,
  `adresseRue` varchar(50) DEFAULT NULL,
  `adresseCdePostal` int(11) DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `tel` int(11) DEFAULT NULL,
  `secteurActivite` varchar(45) DEFAULT NULL,
  `idUtilisateur` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `entreprise`
--

INSERT INTO `entreprise` (`id`, `raisonSociale`, `adresseVille`, `adresseRue`, `adresseCdePostal`, `mail`, `tel`, `secteurActivite`, `idUtilisateur`) VALUES
(2, 'A2 Industries', 'Paris', '5 Chemin des Villiers', 75014, 'contact@a2industrie.fr', 102030405, 'Informatique', 9),
(3, 'Sanva Corporation', 'Brunoy', '5 rue du toumbouctou', 91800, 'contact@s-corporation.fr', 103020405, 'Informatique', 10),
(4, 'SFR', 'Paris', '20 impasse Jean Moulin', 75001, 'contact@sfr.fr', 104030205, 'Telecommunication', 11),
(5, 'Bouygues Telecom', 'Paris', '4 Bd Voltaire', 75001, 'contact@b-telecom.fr', 105040302, 'Telecommunication', 12),
(6, 'Tinalyzer', 'Etampes', '4 rue d\'Etampes', 91150, 'contact@tinalyzer.fr', 105040302, 'Economie', 13),
(7, 'Carbu Sarle Service', 'Paris', '1 avenue de la resistance', 75014, 'contact@carbu-sarle.fr', 102020405, 'Carburant', 14);

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `id` int(11) NOT NULL,
  `nom` varchar(20) DEFAULT NULL,
  `prenom` varchar(20) DEFAULT NULL,
  `domEtude` varchar(45) DEFAULT NULL,
  `niveauEtude` varchar(45) DEFAULT NULL,
  `cv` varchar(300) DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `tel` int(11) DEFAULT NULL,
  `idUtilisateur` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `etudiant`
--

INSERT INTO `etudiant` (`id`, `nom`, `prenom`, `domEtude`, `niveauEtude`, `cv`, `mail`, `tel`, `idUtilisateur`) VALUES
(2, 'Andr', 'Tina', 'Informatique', 'Bac+3', NULL, 'tina.andr@gmail.com', 607080910, 15),
(4, 'Salim', 'Bertrand', 'Economie', 'Bac+4', NULL, 's.bertrand@gmail.com', 607080910, 17),
(5, 'Said', 'Yann', 'Automobile', 'Bac+5', NULL, 'syann@gmail.com', 607080910, 18),
(6, 'Anigo', 'Joseph', 'Football', 'Bac+2', NULL, 'josea@gmail.com', 607080910, 19),
(7, 'Lampard', 'Franck', 'Medecine', 'Bac+5', NULL, 'lampard.f@gmail.com', 607080910, 20),
(9, 'Soidik', 'Soilahouddine', 'Gestion', 'Bac+5', NULL, 'ssoidik@gmail.com', 607080910, 22),
(10, 'Petit', 'Jeremy', 'Electronique', 'Bac+2', NULL, 'jpetit@gmail.com', 607080910, 23),
(11, 'Poutou', 'Philipe', 'Politique', 'Bac', NULL, 'p.poutou@gmail.com', 606060606, 24),
(14, 'Sakho', 'Mamadou', 'Sciences', 'Bac+5', NULL, 'msakhp@gmail.com', 603010208, 28);

-- --------------------------------------------------------

--
-- Structure de la table `offre_stage`
--

CREATE TABLE `offre_stage` (
  `id` int(11) NOT NULL,
  `libelle` varchar(45) DEFAULT NULL,
  `domaine` varchar(45) DEFAULT NULL,
  `descriptif` varchar(200) DEFAULT NULL,
  `dateDebut` varchar(15) DEFAULT NULL,
  `duree` varchar(45) DEFAULT NULL,
  `cheminStockage` varchar(150) DEFAULT NULL,
  `valide` int(1) DEFAULT '0',
  `idEntreprise` int(11) NOT NULL,
  `commentaire` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `offre_stage`
--

INSERT INTO `offre_stage` (`id`, `libelle`, `domaine`, `descriptif`, `dateDebut`, `duree`, `cheminStockage`, `valide`, `idEntreprise`, `commentaire`) VALUES
(4, 'Stage Developpement Informatique', 'INFORMATIQUE', 'Recherche un/une stagiaire pour le développement d\'une application mobilie', '23-04-2017', '3 mois', NULL, 1, 2, NULL),
(5, 'Stage Developpement', 'INFORMATIQUE', 'Recherche un/une stagiaire pour le developpment d\'une application web', '02-05-2017', '3 mois', NULL, 1, 2, NULL),
(6, 'Stage Developpement', 'INFORMATIQUE', 'Recherche un/une stagiare pour le développement d\'un site web e-commerce', '30-04-2017', '2 mois', '/Users/sanva/Desktop/bigData.pdf', 1, 3, NULL),
(7, 'Stage Gestion', 'GESTION', 'Recherche un(e) étudiant(e) pour la gestion des suivies clients', '04-08-2017', '4 mois', NULL, 0, 4, NULL),
(8, 'Stage Agent Financier', 'FINANCE', 'Recherche un agent pour gerer les finances de l\'entreprise', '15-05-2017', '5 mois', NULL, 0, 7, NULL),
(12, 'Stage Developpement', 'INFORMATIQUE', 'Recherche un/une stagiare pour le développement d\'un site web e-commerce', '30-04-2017', '2 mois', '/Users/sanva/Desktop/bigData.pdf', 0, 3, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `pseudo` varchar(25) DEFAULT NULL,
  `mdp` varchar(50) DEFAULT NULL,
  `idDroit` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `pseudo`, `mdp`, `idDroit`) VALUES
(7, 'allam', 'allam', 1),
(8, 'arouna', 'arouna', 1),
(9, 'a2industries', 'a2industries', 2),
(10, 'sanvacorp', 'sanvacorp', 2),
(11, 'sfr', 'sfr', 2),
(12, 'bouygues', 'bouygues', 2),
(13, 'tinalyzer', 'tinalyzer', 2),
(14, 'total', 'total', 2),
(15, 'tina', 'tina', 3),
(16, 'adil', 'adil', 3),
(17, 'salim', 'salim', 3),
(18, 'yann', 'yann', 3),
(19, 'jose', 'jose', 3),
(20, 'franck', 'franck', 3),
(21, 'amine', 'amine', 3),
(22, 'soilah', 'soilah', 3),
(23, 'jeremy', 'jeremy', 3),
(24, 'poutou', 'poutou', 3),
(25, 'mlepen', 'mlepen', 3),
(26, 'sylvie', 'sylvie', 3),
(28, 'sakho', 'sakho', 3);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `administrateur`
--
ALTER TABLE `administrateur`
  ADD PRIMARY KEY (`id`,`idUtilisateur`),
  ADD KEY `fk_administrateur_utilisateur1_idx` (`idUtilisateur`);

--
-- Index pour la table `candidature`
--
ALTER TABLE `candidature`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_offre_stage_has_etudiant_etudiant1_idx` (`idEtudiant`),
  ADD KEY `fk_offre_stage_has_etudiant_offre_stage1_idx` (`idOffre`);

--
-- Index pour la table `droit_utilisateur`
--
ALTER TABLE `droit_utilisateur`
  ADD PRIMARY KEY (`idDroit`);

--
-- Index pour la table `entreprise`
--
ALTER TABLE `entreprise`
  ADD PRIMARY KEY (`id`,`idUtilisateur`),
  ADD KEY `fk_entreprise_utilisateur1_idx` (`idUtilisateur`);

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`id`,`idUtilisateur`),
  ADD UNIQUE KEY `etudiantNomFormation_UNIQUE` (`domEtude`),
  ADD KEY `fk_etudiant_utilisateur1_idx` (`idUtilisateur`),
  ADD KEY `domEtude` (`domEtude`),
  ADD KEY `domEtude_2` (`domEtude`),
  ADD KEY `domEtude_3` (`domEtude`);

--
-- Index pour la table `offre_stage`
--
ALTER TABLE `offre_stage`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idEntreprise` (`idEntreprise`),
  ADD KEY `idEntreprise_2` (`idEntreprise`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`,`idDroit`),
  ADD UNIQUE KEY `pseudo_unique_key` (`pseudo`),
  ADD KEY `fk_utilisateur_fonction_idx` (`idDroit`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `administrateur`
--
ALTER TABLE `administrateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `candidature`
--
ALTER TABLE `candidature`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT pour la table `droit_utilisateur`
--
ALTER TABLE `droit_utilisateur`
  MODIFY `idDroit` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `entreprise`
--
ALTER TABLE `entreprise`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT pour la table `etudiant`
--
ALTER TABLE `etudiant`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT pour la table `offre_stage`
--
ALTER TABLE `offre_stage`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `administrateur`
--
ALTER TABLE `administrateur`
  ADD CONSTRAINT `fk_administrateur_utilisateur1` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `candidature`
--
ALTER TABLE `candidature`
  ADD CONSTRAINT `fk_offre_stage_has_etudiant_etudiant1` FOREIGN KEY (`idEtudiant`) REFERENCES `etudiant` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_offre_stage_has_etudiant_offre_stage1` FOREIGN KEY (`idOffre`) REFERENCES `offre_stage` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `entreprise`
--
ALTER TABLE `entreprise`
  ADD CONSTRAINT `fk_entreprise_utilisateur1` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `fk_etudiant_utilisateur1` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `fk_utilisateur_fonction` FOREIGN KEY (`idDroit`) REFERENCES `droit_utilisateur` (`idDroit`) ON DELETE NO ACTION ON UPDATE NO ACTION;
