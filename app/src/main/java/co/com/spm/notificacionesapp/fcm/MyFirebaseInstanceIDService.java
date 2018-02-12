package co.com.spm.notificacionesapp.fcm;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Nelsy Acuña on 12/02/2018.
 */

public class MyFirebaseInstanceIDService  extends FirebaseInstanceIdService {

    private static final String LOG_ACTIVITY = "MyFirebaseIIDService";

    @Override
    public void onTokenRefresh() {

        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(LOG_ACTIVITY, "Refreshed token: " + refreshedToken);


    }

}
