package tw.com.abc.myfragment;


import android.app.Fragment;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class F2 extends Fragment {
    private View view;
    private MainActivity activity;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity=(MainActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (view == null) {
            //把原本的 return 用 view 取代
            view = inflater.inflate(R.layout.fragment_f2, container, false);
            Button test2 = (Button) view.findViewById(R.id.test2);
            test2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("geoff", "F2 Btn OK!!");
                    showMain();
                }
            });
        }
        return view;
    }
    private void showMain(){
        int rand= (int)( Math.random() *49+1);
        // 呼叫 MainActivity 中的setTextView()
        activity.setTextView("" + rand);

    }
}
