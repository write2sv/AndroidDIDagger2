package work.shaggy.didemo.di;


import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import work.shaggy.didemo.DIApplication;
import work.shaggy.didemo.model.DogModel;
import work.shaggy.didemo.model.DogModelImpl;

/**
 * Currently, the only provider of injections, application-wide.
 * Eventually, it would probably be good to have separate Modules to group related items.
 */
@Module
public class ApplicationModule {

    private final DIApplication application;

    public ApplicationModule(DIApplication application) {
        this.application = application;
    }

    @Provides @Singleton
    public DIApplication provideApplication() {
        return application;
    }

    @Provides @Singleton
    public DogModel provideDogModel() {
        return new DogModelImpl("Scooby-doo");
    }

}