package work.shaggy.didemo;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.View;
import android.widget.TextView;

import work.shaggy.didemo.service.DogSyncService;

public class MainActivity extends BaseActivity {

    TextView dogName;

    View fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        fragmentContainer = findViewById(R.id.fragmentContainer);

        dogName = (TextView) findViewById(R.id.dogName);
        dogName.setText(dogModel.getName());

        showFragment();

        DogSyncService.SyncNow(this);
    }

    private void showFragment() {

        Fragment fragment = DogFragment.newInstance();

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentContainer, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commitAllowingStateLoss();
    }

}
