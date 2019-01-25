package com.bytedance.camera.demo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        findViewById(R.id.btn_picture).setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, TakePictureActivity.class));
        });

        findViewById(R.id.btn_camera).setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, RecordVideoActivity.class));
        });

        findViewById(R.id.btn_custom).setOnClickListener(v -> {
            //todo 在这里申请相机、麦克风、存储的权限
            int permisson_0 = ContextCompat.checkSelfPermission(getApplication(),Manifest.permission.CAMERA);
            int permisson_1 = ContextCompat.checkSelfPermission(getApplication(),Manifest.permission.WRITE_EXTERNAL_STORAGE);
            int permisson_2 = ContextCompat.checkSelfPermission(getApplication(),Manifest.permission.RECORD_AUDIO);
            if(permisson_1 != PackageManager.PERMISSION_GRANTED
                    || permisson_0 != PackageManager.PERMISSION_GRANTED
                    || permisson_2 != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this , new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE
                        ,Manifest.permission.CAMERA
                        ,Manifest.permission.RECORD_AUDIO},1);
            }
            startActivity(new Intent(MainActivity.this, CustomCameraActivity.class));

        });
    }

}
