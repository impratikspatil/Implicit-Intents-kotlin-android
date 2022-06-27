package com.example.imlicitintentkotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.imlicitintentkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        //this is the main code for imiplicit intent
        binding.btn.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type="image/*"
                startActivityForResult(it,0)
                // though this method is deprecated but I have used here
            }
        }


    }

    //this method will receive data from device through intent and we can display that data wherever we want
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode== Activity.RESULT_OK && requestCode==0)
        {
          val uri=data?.data
           binding.img.setImageURI(uri)
        }
    }
}

//buildFeatures{
//    dataBinding true
//}
//

//the use <layout> and use binding in activity so that we can fast easily access id

///then used ActivityMainbinding and user binding onject anywhere we want