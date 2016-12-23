package work.shaggy.didemo.di;

import work.shaggy.didemo.DIApplication;

public class DependencyInjector {

    private static ApplicationComponent applicationComponent;

    public static void initialize(DIApplication diApplication) {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(diApplication))
                .build();
    }

    public static ApplicationComponent applicationComponent() {
        return applicationComponent;
    }

    private DependencyInjector(){}
}
