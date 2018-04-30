package com.usermindarchive.h.wallpapersearchringtone

import android.app.WallpaperInfo
import android.app.WallpaperManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import java.io.File

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val file= File("")

        moveRingtone(file)
    }

    private fun moveRingtone(file: File) {

        val path=File(Environment.getExternalStorageDirectory().parentFile.absolutePath)
        Log.i("files","file path:${path},directory:${path.isDirectory}")
        directory(path)

    }

    private fun directory(path: File) {

        path.listFiles().forEach { file-> if(file.isDirectory){
            Log.i("files","Directory path:{${path.absolutePath}}")
            directory(file)
        }else{
            Log.i("files","file path:{${path.absolutePath}}")
        } }
    }
}
