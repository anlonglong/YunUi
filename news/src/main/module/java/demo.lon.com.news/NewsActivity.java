package demo.lon.com.news;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import javax.inject.Inject;

import dagger.internal.DaggerCollections;
import demo.lon.com.commonlibrary.RxBus.RxBus;
import demo.lon.com.commonlibrary.RxBus.RxBusManager;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;


public class NewsActivity extends AppCompatActivity {

    @Inject
    NewLogic mLogic;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        DaggerMainActivityComponemt.builder().moudle(new Moudle(this)).build().inject(this);
        mLogic.setPresenter(null);
        ViewCompat.animate((Button) findViewById(R.id.button)).translationX(100).start();
        ((Button) findViewById(R.id.button)).setOnClickListener((v) -> {
//            Subject<String> stringPublishSubject = PublishSubject.<String>create();
//            Disposable subscribe = stringPublishSubject.ofType(String.class).subscribe(new Consumer<String>() {
//                @Override
//                public void accept(String s) throws Exception {
//                    Toast.makeText(NewsActivity.this, s, Toast.LENGTH_SHORT).show();
//                }
//            });
//            stringPublishSubject.onNext("asssss");
//            RxBus.getInstance().registerEventWithError(this, String.class, new Consumer<String>() {
//                @Override
//                public void accept(String s) throws Exception {
//                    Toast.makeText(NewsActivity.this, s, Toast.LENGTH_SHORT).show();
//                }
//            });

            RxBusManager.getInstance().post("RxBusManager");
            RxBus.getInstance().post("RxBus");
            startActivity(new Intent(this, MainActivity.class));
        });

    }
}
