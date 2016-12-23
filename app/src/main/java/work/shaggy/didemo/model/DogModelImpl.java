package work.shaggy.didemo.model;

/**
 * Created by shaggy on 12/23/16.
 */

public class DogModelImpl implements DogModel {

    private String mName;

    public DogModelImpl(String name) {
        this.mName = name;
    }

    @Override
    public String getName() {
        return mName;
    }
}
