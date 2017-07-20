package com.hs.choosepictrue.demo;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.hs.choosepictrue.PickPhotoView;
import com.hs.choosepictrue.R;
import com.hs.choosepictrue.adapter.SpaceItemDecoration;
import com.hs.choosepictrue.util.PickConfig;
import com.hs.choosepictrue.util.PickUtils;
import com.werb.permissionschecker.PermissionChecker;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SampleAdapter adapter;
    private PermissionChecker permissionChecker;
    private String[] PERMISSIONS = new String[]{
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        permissionChecker = new PermissionChecker(this);

        findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(permissionChecker.isLackPermissions(PERMISSIONS)){
                    permissionChecker.requestPermissions();
                }else {
                    startPickPhoto();
                }
            }
        });

        RecyclerView photoList = (RecyclerView) findViewById(R.id.photo_list);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 4);
        photoList.setLayoutManager(layoutManager);
        photoList.addItemDecoration(new SpaceItemDecoration(PickUtils.getInstance(MainActivity.this).dp2px(PickConfig.ITEM_SPACE), 4));
        adapter = new SampleAdapter(this,null);
        photoList.setAdapter(adapter);
    }

    private void startPickPhoto(){
        new PickPhotoView.Builder(MainActivity.this)
                .setPickPhotoSize(1)
                .setShowCamera(true)
                .setSpanCount(4)
                .setLightStatusBar(true)
                .setStatusBarColor("#ffffff")
                .setToolbarColor("#ffffff")
                .setToolbarIconColor("#000000")
                .start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 0){
            return;
        }
        if(data == null){
            return;
        }
        if (requestCode == PickConfig.PICK_PHOTO_DATA) {
            List<String> selectPaths = (List<String>) data.getSerializableExtra(PickConfig.INTENT_IMG_LIST_SELECT);
            adapter.updateData(selectPaths);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PermissionChecker.PERMISSION_REQUEST_CODE:
                if (permissionChecker.hasAllPermissionsGranted(grantResults)) {
                    startPickPhoto();
                } else {
                    permissionChecker.showDialog();
                }
                break;
        }
    }
}
