package tuananh.com.eventbus;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import tuananh.com.eventbus.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setViewModel(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    public void onShow(int typePost) {
        Intent intent = new Intent(this, ShowActivity.class);
        intent.putExtra("typePost", typePost);
        startActivity(intent);
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(NoteEvent noteEvent) {
        mBinding.textNote.setText(noteEvent.getNote());
    }
//    @Subscribe(threadMode = ThreadMode.POSTING)
//    public void onEvent(NoteEvent noteEvent) {
//        mBinding.textNote.setText(noteEvent.getNote());
//    }
//
//    @Subscribe(sticky = true, threadMode = ThreadMode.BACKGROUND)
//    public void onEvent(NoteEvent noteEvent) {
//        mBinding.textNote.setText(noteEvent.getNote());
//    }
//
//    @Subscribe(sticky = true, threadMode = ThreadMode.ASYNC)
//    public void onEvent(NoteEvent noteEvent) {
//        mBinding.textNote.setText(noteEvent.getNote());
//    }
}
