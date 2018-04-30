package com.usermindarchive.h.wallpapersearchringtone

import android.os.Environment
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import android.util.Log

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import java.io.File

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        val path=File(Environment.getExternalStorageDirectory().absolutePath)
        Log.i("files","file path:${path},directory:${path.isDirectory}, files${path.listFiles().size}")
//        directory(path)
        pathfiles(path)
    }

    private fun pathfiles(path: File) {
        path.walk().forEach {path->
            val directory = path.toString().substringBeforeLast("/")
            val fullName = path.toString().substringAfterLast("/")
            val fileName = fullName.substringBeforeLast(".")
            val extension = fullName.substringAfterLast(".")
            if(path.isFile&&path.toString().toLowerCase().contains("ringtone"))
            Log.i("files006","${path}")
            Log.i("test_print", "dir: $directory | fileName: $fileName | extension: $extension")
        }
    }

    private fun directory(path: File) {

        path.listFiles().forEach { file-> if(file.isDirectory){
//            Log.i("files","Directory path:{${path.absolutePath}}")
            directory(file)
            path.walk().forEach {path->
                val directory = path.toString().substringBeforeLast("/")
                val fullName = path.toString().substringAfterLast("/")
                val fileName = fullName.substringBeforeLast(".")
                val extension = fullName.substringAfterLast(".")

                Log.i("files006","${path}")
                Log.i("test_print", "dir: $directory | fileName: $fileName | extension: $extension")
            }
        }else{
            Log.i("files406","file path:${path.toString()}")

        } }
    }


    @Test
    fun testTransfer(){
        val file=File("/storage/emulated/0/Download/04-You Are My Love.mp3")
        val pathTransfer=File("/storage/emulated/0/Ringtones/")

        Log.i("test01","file name:${file.name}")
        Log.i("test01", "Path name:${pathTransfer}")

        try {
            if(pathTransfer.exists())
            file.copyTo(pathTransfer)
            else{
                pathTransfer.mkdir()
                file.copyTo(pathTransfer)
            }
        }catch(e:FileAlreadyExistsException){
            Log.i("test01", "File is already present")

        }
    }
}
