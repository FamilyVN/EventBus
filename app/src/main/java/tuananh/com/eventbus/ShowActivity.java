package tuananh.com.eventbus;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;

import tuananh.com.eventbus.databinding.ActivityShowBinding;

public class ShowActivity extends AppCompatActivity {
    private ActivityShowBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_show);
        int typePost = getIntent().getIntExtra("typePost", 0);
        switch (typePost) {
            case 0:
                // non-sticky event
                EventBus.getDefault().post(new NoteEvent("non-sticky event"));
                break;
            default:
                // postSticky
                EventBus.getDefault().postSticky(new NoteEvent("postSticky"));
                break;
        }
    }
}
