package work.shaggy.didemo.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

import javax.inject.Inject;

import work.shaggy.didemo.di.DependencyInjector;
import work.shaggy.didemo.model.DogModel;

public class DogSyncService extends IntentService {


    @Inject
    DogModel dogModel;

    @SuppressWarnings("unused")
    public DogSyncService() {
        super("DogSyncService");
    }

    @SuppressWarnings("unused")
    public DogSyncService(String name) {
        super(name);
    }

    @Override
    public void onCreate() {
        Log.d("DIDemo", "onCreate - DogSyncService");
        super.onCreate();

        DependencyInjector.applicationComponent().inject(this);
        Log.d("DIDemo", "Dogs Name via Service Injection: "+ dogModel.getName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        // Release the wake lock provided by the WakefulBroadcastReceiver.
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }

    /**
     * Immediately start a DogSyncService instance in the background, to perform....
     *
     * @param context Android Context
     */
    public static void SyncNow(Context context) {
        Intent startServiceIntent = new Intent(context, DogSyncService.class);

        context.startService(startServiceIntent);
    }

}