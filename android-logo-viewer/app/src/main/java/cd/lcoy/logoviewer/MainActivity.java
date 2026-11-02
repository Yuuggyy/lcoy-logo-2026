package cd.lcoy.logoviewer;

import android.app.Activity;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Aperçu du logo LCOY RDC 2026.
 *
 * Sert à visualiser le logo à l'écran et à contrôler le rendu selon la densité.
 * Un appui agrandit le logo au double de sa taille d'affichage, un second appui
 * revient à l'ajustement normal.
 *
 * Aucune dépendance externe : projet Android minimal (Java + framework),
 * ouvrable et exécutable directement dans Android Studio.
 */
public class MainActivity extends Activity {

    private ImageView logo;
    private boolean agrandi = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = findViewById(R.id.logo);
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agrandi = !agrandi;
                if (agrandi) {
                    appliquerZoom(2f);
                } else {
                    logo.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    logo.setImageMatrix(null);
                }
            }
        });
    }

    /** Agrandit le logo en le gardant centré, sans déformer l'image. */
    private void appliquerZoom(float facteur) {
        Drawable dessin = logo.getDrawable();
        if (dessin == null || logo.getWidth() == 0 || logo.getHeight() == 0) {
            return;
        }

        float largeurImage = dessin.getIntrinsicWidth();
        float hauteurImage = dessin.getIntrinsicHeight();
        float ajustement = Math.min(logo.getWidth() / largeurImage, logo.getHeight() / hauteurImage);
        float echelle = ajustement * facteur;

        float dx = (logo.getWidth() - largeurImage * echelle) / 2f;
        float dy = (logo.getHeight() - hauteurImage * echelle) / 2f;

        Matrix matrice = new Matrix();
        matrice.setScale(echelle, echelle);
        matrice.postTranslate(dx, dy);

        logo.setScaleType(ImageView.ScaleType.MATRIX);
        logo.setImageMatrix(matrice);
    }
}
