# main.xml
```
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter Name"
        android:id="@+id/imagename"/>
    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/submit"
        android:text="Submit"
        android:layout_gravity="center"
        android:textSize="20dp"/>
    <ImageView
        android:layout_width="match_parent"
        android:layout_height="200dp"
        android:id="@+id/imageview"
        android:src="@drawable/ic_baseline_android_24"
        android:layout_gravity="center"/>
    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/textview"
        android:textSize="20dp"/>


</LinearLayout>
```
```


#MainActivity

```
```

package com.example.asynktask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    EditText et;
    Button b1;
    ImageView iv;
    TextView tv;
    String myurl="https://pixabay.com/api/videos/?key=20988218-589c9585dd74b808c0bc17e2a&q=";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=findViewById(R.id.imagename);
        b1=findViewById(R.id.submit);
        iv=findViewById(R.id.imageview);
        tv=findViewById(R.id.textview);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ImageTask().execute();

            }
        });
    }
    class ImageTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url=new URL(myurl);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream =urlConnection.getInputStream();
                Scanner scanner  =new Scanner(inputStream);
                scanner.useDelimiter("vvv");
                if(scanner.hasNext()){
                    return scanner.next();
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(MainActivity.this,s , Toast.LENGTH_SHORT).show();
        }
    }
}

```
```


```
```

```
```
