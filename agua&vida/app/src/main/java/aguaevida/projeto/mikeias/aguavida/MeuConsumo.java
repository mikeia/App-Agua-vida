package aguaevida.projeto.mikeias.aguavida;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.mikeias.aguavida.R;

public class MeuConsumo extends AppCompatActivity {

    int contador = 0;
    int consumo = 0;

    private TextView infoConsu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meu_consumo);


        infoConsu = (TextView) findViewById(R.id.infoConsu);

        final SharedPreferences dados = PreferenceManager.getDefaultSharedPreferences(this);
        consumo = dados.getInt("consumo", 0);
        infoConsu.setText(consumo + "ml");

        boolean fromNotification  = getIntent().getBooleanExtra("fromNotification", false);

        if (fromNotification) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Vamos beber Água?");
            builder.setMessage("Que tal se hidratar com apenas 200 ml de água?");
            builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    consumo = consumo + 200;
                    infoConsu.setText(consumo + "ml");

                    SharedPreferences.Editor editor = dados.edit();
                    editor.putInt("consumo", consumo);
                    editor.apply();

                }
            });
            builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                }
            });
            AlertDialog alerta = builder.create();
            alerta.show();
        }


    }

}
