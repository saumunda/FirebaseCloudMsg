package com.saurabhbhola.cameraandgalleryapi

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.content.FileProvider
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        capture.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if (checkSelfPermission(Manifest.permission.CAMERA)==PackageManager.PERMISSION_DENIED){
                    val permissions = arrayOf(Manifest.permission.CAMERA)
                    requestPermissions(permissions, PERMISSION_CODE)
                } else{
                    chooseCamera()

                }
            }else{
                Toast.makeText(this,"Camera Permission Denied", Toast.LENGTH_SHORT).show()

            }
        }

        selectfile.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)==PackageManager.PERMISSION_DENIED){
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
                    requestPermissions(permissions, PERMISSION_CODE1)
                } else{
                    chooseImageGallery()

                }
            }else{
                Toast.makeText(this,"Read Permission Denied", Toast.LENGTH_SHORT).show()

            }

        }
    }

    private fun chooseCamera() {

        val takePhotoIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        filePhoto = getPhotoFile(FILE_NAME)


        val providerFile =FileProvider.getUriForFile(this,"com.saurabhbhola.cameraandgalleryapi", filePhoto)
        takePhotoIntent.putExtra(MediaStore.EXTRA_OUTPUT, providerFile)
        if (takePhotoIntent.resolveActivity(this.packageManager) != null){
            startActivityForResult(takePhotoIntent, REQUEST_CODE)
        }else {
            Toast.makeText(this,"Camera could not open", Toast.LENGTH_SHORT).show()
        }
    }

    private fun chooseImageGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        if (intent.resolveActivity(this.packageManager) != null){
            startActivityForResult(intent, IMAGE_CHOOSE)
        }else {
            Toast.makeText(this,"Camera could not open", Toast.LENGTH_SHORT).show()
        }
     //   startActivityForResult(intent, IMAGE_CHOOSE)
    }

    companion object {
        private val IMAGE_CHOOSE = 1000;
        private val PERMISSION_CODE = 1001;

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                chooseCamera()
            }

            else {
                Toast.makeText(this,"Permission denied For Camera", Toast.LENGTH_SHORT).show()
            }
        }
        else if (requestCode == PERMISSION_CODE1) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                chooseImageGallery()
            }

            else {
                Toast.makeText(this,"Permission denied For Read Storage", Toast.LENGTH_SHORT).show()
            }
        }
    }




    private fun getPhotoFile(fileName: String): File {
        val directoryStorage = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(fileName, ".jpg", directoryStorage)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
            val takenPhoto = BitmapFactory.decodeFile(filePhoto.absolutePath)
            imageView.setImageBitmap(takenPhoto)
        }
        else if(requestCode == IMAGE_CHOOSE && resultCode == Activity.RESULT_OK){
            imageView.setImageURI(data?.data)
        }

    }
}

private const val REQUEST_CODE = 13
private val PERMISSION_CODE1 = 1002
private lateinit var filePhoto: File
private const val FILE_NAME = "photo.jpg"