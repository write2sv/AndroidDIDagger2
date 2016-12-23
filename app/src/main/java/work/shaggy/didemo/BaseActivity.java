package work.shaggy.didemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import javax.inject.Inject;
import work.shaggy.didemo.di.ApplicationComponent;
import work.shaggy.didemo.di.DependencyInjector;
import work.shaggy.didemo.model.DogModel;

/**
 * Created by shaggy on 12/23/16.
 */

public class BaseActivity extends AppCompatActivity {

    @Inject
    protected DogModel dogModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        onInject(DependencyInjector.applicationComponent());
    }

    /**
     * Performs dependency injection, using the applicationComponent as the injector.
     * If an Activity only needs injection into this base class, it does not need to override this method.
     * However, if an Activity requires extra injections (has one ore more @Inject annotations in it's source code),
     * then it must override this method, and invoke <code>applicationComponent.inject(this);</code>
     * @param applicationComponent the component being injected
     */
    protected void onInject(ApplicationComponent applicationComponent) {
        applicationComponent.inject(this);
    }

}
