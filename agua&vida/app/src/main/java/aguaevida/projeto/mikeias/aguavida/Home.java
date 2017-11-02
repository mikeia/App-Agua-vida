package aguaevida.projeto.mikeias.aguavida;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.mikeias.aguavida.R;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Home extends AppCompatActivity {

    int contador = 0;
    private Button sobre;
    private Button consumo;
    private Button beneficio;
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sobre = (Button) findViewById(R.id.btnSobre);
        consumo = (Button) findViewById(R.id.btnConsumo);
        beneficio = (Button) findViewById(R.id.btnBeneficio);

        sobre.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Sobre.class);
                startActivity(intent);
            }
        });

        consumo.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent cons = new Intent(getBaseContext(), MeuConsumo
                        .class);
                startActivity(cons);
            }
        });

        beneficio.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ben = new Intent(getBaseContext(), Beneficios.class);
                startActivity(ben);
            }
        });

        scheduleAlarm();

    }


    public void scheduleAlarm() {

            Long time = new GregorianCalendar().getTimeInMillis() + 60 * 60 * 1000;

            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) + 1);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);


            Intent intentAlarm = new Intent(this, AlarmReciever.class);
            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            PendingIntent pIntent = PendingIntent.getBroadcast(this, 0, intentAlarm, 0);
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), time, pIntent);



    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();

    }


}
