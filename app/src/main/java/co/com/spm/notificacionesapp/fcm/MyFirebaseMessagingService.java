package co.com.spm.notificacionesapp.fcm;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import co.com.spm.notificacionesapp.MainActivity;
import co.com.spm.notificacionesapp.R;

/**
 * Created by Nelsy Acuña on 12/02/2018.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {


    private static final String LOG_SERVICE = "FMService";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Log.d(LOG_SERVICE, remoteMessage.getNotification().toString());

        sendNotification( remoteMessage.getNotification().getBody());

    }


    private void sendNotification(String messageBody) {
        Intent intent = new Intent(this, MainActivity.class);
        //intent.putExtra(SP_CURRENT_SCREEN, APP_SCREEN_FRAGMENT_SERVICIOS_DISPONIBLES);
        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT);

        //  String channelId = getString(R.string.default_notification_channel_id);
        // Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this, "App")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("FCM Message")
                        .setContentText(messageBody)
                        .setAutoCancel(true)
                        .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }



}
