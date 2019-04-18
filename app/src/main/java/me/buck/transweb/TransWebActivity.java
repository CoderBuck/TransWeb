package me.buck.transweb;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;
import saschpe.android.customtabs.CustomTabsHelper;
import saschpe.android.customtabs.WebViewFallback;
import timber.log.Timber;

public class TransWebActivity extends AppCompatActivity {

    private CustomTabsIntent mCustomTabsIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Timber.d("onCreate");
        super.onCreate(savedInstanceState);

        mCustomTabsIntent = new CustomTabsIntent.Builder()
                .addDefaultShareMenuItem()
                .setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimary))
                .setShowTitle(true)
                .build();

        handleIntent();

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Timber.d("onNewIntent");
        setIntent(intent);
        handleIntent();
    }

    private void handleIntent() {
        String httpUrl = getIntent().getStringExtra(Intent.EXTRA_TEXT);
        Timber.d("httpUrl = %s", httpUrl == null ? "null" : httpUrl);

        if (TextUtils.isEmpty(httpUrl)) {
            return;
        }

        CustomTabsHelper.openCustomTab(
                this,
                mCustomTabsIntent,
                wrap2googleTransUri(httpUrl),
                new WebViewFallback());

        finish();
    }


    private Uri wrap2googleTransUri(String uri) {
        String prefix = "https://translate.google.com/translate?sl=en&tl=zh-CN&u=";
        return Uri.parse(prefix + uri);
    }

}
