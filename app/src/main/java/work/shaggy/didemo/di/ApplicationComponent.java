package work.shaggy.didemo.di;

import javax.inject.Singleton;
import dagger.Component;
import work.shaggy.didemo.BaseActivity;
import work.shaggy.didemo.BaseFragment;
import work.shaggy.didemo.DIApplication;
import work.shaggy.didemo.service.DogSyncService;

/**
 * Currently, the only dependency injector, application-wide.
 * Eventually, it would probably be good to have separate Components to inject related targets (e.g. separate Components for Android Activities and non-Android Presenters
 */
@SuppressWarnings("unused")
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(DIApplication application);

    void inject(BaseActivity activity);
    void inject(BaseFragment fragment);

    void inject(DogSyncService service);
}
