package aguaevida.projeto.mikeias.aguavida;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;

import com.example.mikeias.aguavida.R;

/**
 * Created by Mikeias on 05/09/2016.
 */
public class AppCompatActivity extends android.support.v7.app.AppCompatActivity {
    private int contador = 0;
    protected void OnCreate(Bundle savedInstanceState) {
        onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        NotificationManager nt = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nt.cancel(R.drawable.fundo);

//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Vamos beber Água?");
//        builder.setMessage("Que tal se hidrata com apenas 200 ml de água?");
//        builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface arg0, int arg1) {
//                TextView info = (TextView) findViewById(R.id.infoConsu);
//                contador = contador + 200;
//                String contado_string = contador + "";
//                String resultado = contador + " ml";
//                info.setText(resultado);
//
////                Intent
////                Bundle
//            }
//        });
//        builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface arg0, int arg1) {
//            }
//        });
//        AlertDialog alerta = builder.create();
//        alerta.show();
    }
}
