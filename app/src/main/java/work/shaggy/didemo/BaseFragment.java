package work.shaggy.didemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;

import javax.inject.Inject;

import work.shaggy.didemo.di.ApplicationComponent;
import work.shaggy.didemo.di.DependencyInjector;
import work.shaggy.didemo.model.DogModel;

/**
 * Created by shaggy on 12/23/16.
 */

public class BaseFragment extends Fragment {

    @Inject
    protected DogModel dogModel;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        onInject(DependencyInjector.applicationComponent());
    }

    /**
     * Performs dependency injection, using the applicationComponent as the injector.
     * If a Fragment only needs injection into this base class, it does not need to override this method.
     * However, if a Fragment requires extra injections (has one ore more @Inject annotations in it's source code),
     * then it must override this method, and invoke <code>applicationComponent.inject(this);</code>
     * @param applicationComponent injector class
     */
    @SuppressWarnings("WeakerAccess")
    protected void onInject(ApplicationComponent applicationComponent) {
        applicationComponent.inject(this);
    }
}
