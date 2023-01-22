# JavaFX

## Documentation

-[] Commentaires
-[] Diagramme de classes

## Code

### Jointures

-[X] Fusionner branche Bipper & Master

### Fenêtres

-[] **(C)** Bouton "Fermer"
   -[] Changer nom "X" en "Fermer"
   -[] Déplacer bouton en bas de la fenêtre
   -[] Fermer la principale arrête le programme
   +[] Fermer la principale ferme les autres
-[] **(C)** Rajouter id capteur
-[~] **(D)** Actualisation de la TreeView
-[] **(F)**Flèche d'expension disgracieuse
-[] Détails Capteur Virtuel
-[] Binding TableView
   -[] Rendre poids modifiable
      -[X] Poids
      -[X] Icone
      -[X] Id
   -[] Bouton ajout capteur fils
      -[X] Bouton
      -[] Liste d'ajout ?
   -[] Clic droit => Possibilité supression capteur sélectionné
-[] Détails Capteur Actif
   -[] Binding Spinner
      -[] Mise par défaut à 1.5
   -[] Binding ComboBox
   -[V] Binding Binding Toggle Button


### Capteurs

-[X] Capteur Temp CPU
-[X] Générateur Temp CPU
 *Sur les systèmes Linux, il existe un répertoire `/sys/class/thermal/thermal_zone*` (pas toujours le même numéro à la fin) qui contient un fichier `type` dont le contenu est `x86_pkg_temp`. Ce même répertoire contient un fichier `temp` qui contient la température de votre CPU (mise à jour toutes les secondes).*