package vtc.room.a101.openbrowser;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class OpenBrowser extends AppCompatActivity {

    private Button goSearch;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_browser);
        goSearch = (Button) findViewById(R.id.goSearch);
        editText = (EditText) findViewById(R.id.editText);

        goSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String search = editText.getText().toString();
                if (!search.endsWith(".com") || ! search.endsWith(".ru")) {
                    final Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    intent.putExtra(SearchManager.QUERY, search);
                    startActivity(intent);
                }else {
                    WebView webView = new WebView(OpenBrowser.this);
                    setContentView(webView);
                    webView.loadUrl(String.valueOf(editText.getText()));
                }
            }
        });

    }
}
