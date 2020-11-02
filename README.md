## intent
### 主要代码
### activity1
``` Java
public class MainActivity extends AppCompatActivity {

    private Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1=findViewById(R.id.button);
        bt1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent in1= new Intent(Intent.ACTION_VIEW);
                EditText ed =findViewById(R.id.editText);
                final String net= ed.getText().toString();
                if(!net.equals("")&&net != ""){
                    in1.setData(Uri.parse(net));
                    startActivity(in1);
                }else {
                    Toast.makeText(getApplicationContext(),"please enter Url",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
```
``` Java
<EditText
        android:id="@+id/editText"
        android:layout_width="200dp"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toTopOf="@+id/button"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button"
        android:layout_width="150dp"
        android:layout_height="wrap_content"
        android:text="@string/webjump"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
```
### activity2
``` Java
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        webView=findViewById(R.id.web1);
        String url=getIntent().getExtras().getString("url");
        webView.loadUrl(url);
    }
```
``` Java
 <WebView
        android:id="@+id/web1"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
```
### AndroidManifest
``` Java
<activity android:name=".MainActivity2">
            <intent-filter tools:ignore="AppLinkUrlError">
                <action android:name="android.intent.action.VIEW"/>
                <category android:name="android.intent.category.DEFAULT"/>
                <data android:scheme="https"/>
            </intent-filter>
        </activity>
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
```
## Demo
![](https://github.com/fjnu-zs/intent/blob/master/image/demo1.png)
