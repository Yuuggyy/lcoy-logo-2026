# Logo LCOY RDC 2026 — fichiers prêts à l'emploi

Dépôt d'images du logo officiel LCOY RDC 2026, avec un petit projet Android
pour le visualiser et vérifier son rendu sur téléphone.

## Ce que contient le dépôt

| Dossier | Contenu | Usage |
|---|---|---|
| `source/` | `lcoy-rdc-2026-logo.svg` | Fichier vectoriel corrigé (le `100%%` invalide de l'original est réparé). À garder pour toute nouvelle déclinaison. |
| `jpg/` | 1200 px, 2400 px, et 6880 px (10x) | Web et messagerie, impression courante, très grand tirage. |
| `android-logo-viewer/` | Projet Android Studio | Affiche le logo et sert d'exemple d'intégration. |
| `android-logo-viewer/app/src/main/res/mipmap-*` | `ic_launcher.png` en 5 densités | Icône de l'application. |
| `android-logo-viewer/app/src/main/res/drawable/` | `logo_lcoy.jpg` | Image utilisée dans l'écran d'exemple. |

Le logo a été rendu à partir du vectoriel, sans ajout de détails, avec un léger
renfort de netteté. Fond blanc : le format JPG ne gère pas la transparence (pour
un fond transparent, utiliser `source/lcoy-rdc-2026-logo.svg`).

## 1. Récupérer le dépôt en local

### Depuis Android Studio (méthode recommandée)

1. Ouvrir Android Studio.
2. `File` → `New` → `Project from Version Control`.
3. Coller l'adresse du dépôt :
   `https://github.com/Yuuggyy/lcoy-logo-2026.git`
4. Choisir le dossier de destination, puis `Clone`.
5. Le projet s'ouvre sur la racine du dépôt. Ouvrir le projet Android :
   `File` → `Open`, puis sélectionner le dossier **`android-logo-viewer`**
   (et non la racine du dépôt).
6. Accepter la synchronisation Gradle proposée, puis `Run ▶`.

### Depuis un terminal

```bash
git clone https://github.com/Yuuggyy/lcoy-logo-2026.git
cd lcoy-logo-2026/android-logo-viewer
./gradlew assembleDebug          # construit l'APK de test
```

L'APK est produit dans `app/build/outputs/apk/debug/app-debug.apk`.

## 2. Lancer dans Android Studio

- Prérequis : Android Studio récent (JDK 17 inclus), un SDK Android installé.
- Si Gradle signale un SDK manquant : `Tools` → `SDK Manager`, installer la
  plateforme **Android 14 (API 34)**.
- Lancer un émulateur (`Device Manager` → `Create device`) ou brancher un
  téléphone en débogage USB, puis `Run ▶`.
- Toucher le logo l'agrandit au double, un second appui revient à la normale.

## 3. Utiliser le logo dans un autre projet Android

- **Icône de l'application** : copier les cinq dossiers `mipmap-*/ic_launcher.png`
  dans `app/src/main/res/` du projet cible, puis vérifier dans le manifeste :
  `android:icon="@mipmap/ic_launcher"`.
- **Image à afficher** : copier `jpg/LCOY_RDC_2026_logo_2400.jpg` dans
  `res/drawable/` (nom en minuscules, sans tiret) et l'appeler avec
  `@drawable/nom_du_fichier`.
- **Logo net à toute taille** : préférer le SVG pour le web, et pour Android
  fournir des PNG par densité plutôt qu'un seul JPG étiré.

## 4. Utiliser le logo ailleurs

- **Web** : `source/lcoy-rdc-2026-logo.svg` (net à toutes les tailles, très léger).
- **WhatsApp, e-mail, réseaux** : `jpg/LCOY_RDC_2026_logo_1200.jpg`.
- **Affiche, bâche, impression** : `jpg/LCOY_RDC_2026_logo_10x.jpg` ou le SVG.

## License

Images et marque LCOY RDC 2026 : CJP-RDC et FANYA ASSOCIATION.
Projet Android d'exemple : libre d'utilisation.
