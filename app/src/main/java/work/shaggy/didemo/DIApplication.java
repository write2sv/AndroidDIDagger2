package work.shaggy.didemo;

import android.app.Application;
import android.util.Log;

import javax.inject.Inject;

import work.shaggy.didemo.di.DependencyInjector;
import work.shaggy.didemo.model.DogModel;

/**
 * Created by shaggy on 12/23/16.
 */

public class DIApplication extends Application {

    @Inject
    protected DogModel dogModel;

    @Override
    public void onCreate() {
        super.onCreate();

        injectDependencies();

        Log.d("DIDemo", "Dog's Name via Application Injection "+ dogModel.getName());
    }

    private void injectDependencies() {
        DependencyInjector.initialize(this);
        DependencyInjector.applicationComponent().inject(this);
    }
}
