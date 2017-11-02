package aguaevida.projeto.mikeias.aguavida;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.example.mikeias.aguavida.R;

import java.util.Calendar;

import br.com.goncalves.pugnotification.notification.PugNotification;

/**
 * Created by user on 07/09/16.
 */
public class AlarmReciever extends BroadcastReceiver

{
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            Calendar cal = Calendar.getInstance();
            int hora = cal.get(Calendar.HOUR_OF_DAY);

            if (hora >= 9 && hora <= 22) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("fromNotification", true);

                PugNotification.with(context)
                        .load()
                        .title("Vamos beber Água?")
                        .message("Que tal se hidratar com apenas 200 ml de água?")
                        .flags(Notification.DEFAULT_ALL)
                        .smallIcon(R.mipmap.ic_launcher)
                        .largeIcon(R.mipmap.ic_launcher)
                        .flags(Notification.DEFAULT_ALL)
                        .autoCancel(true)
                        .click(MeuConsumo.class, bundle)
                        .simple()
                        .build();

                Context contexto = context.getApplicationContext();
                String texto = "DEU CERTO";
                int duracao = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(contexto, texto, duracao);
                toast.show();
            } else {
                final SharedPreferences dados = PreferenceManager.getDefaultSharedPreferences(context);
                SharedPreferences.Editor editor = dados.edit();
                editor.putInt("consumo", 0);
                editor.apply();

                Context contexto = context.getApplicationContext();
                String texto = "NAO DEU CERTO";
                int duracao = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(contexto, texto, duracao);
                toast.show();
            }

        }
    }



}