package work.shaggy.didemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by shaggy on 12/23/16.
 */

public class DogFragment extends BaseFragment {

    public DogFragment() {
    }

    public static DogFragment newInstance() {
        return new DogFragment();
    }

    private TextView dogNameText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dog, container, false);
        dogNameText = (TextView) view.findViewById(R.id.dogName);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        dogNameText.setText(dogModel.getName());
    }
}
