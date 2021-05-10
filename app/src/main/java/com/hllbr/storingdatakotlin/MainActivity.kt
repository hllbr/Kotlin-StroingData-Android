package com.hllbr.storingdatakotlin

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    /*
        Storage of small information
         */
    // var sharedPreferences : SharedPreferences? = null
    lateinit var sharedPreferences : SharedPreferences
    var ageFromPreferences : Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //SharedPreferences == basic Hashmap /SharedPreferences acitivity üzerinden üretiliyor.
    //SharedPreferences initialize
         sharedPreferences = this.getSharedPreferences("com.hllbr.storingdatakotlin",
            Context.MODE_PRIVATE)//2 parametreye ihtiyacım var bir isim ve bir adet mod bu parameterelerim
        ageFromPreferences = sharedPreferences.getInt("age",-1)
        if(ageFromPreferences == -1 ){
            textView.text = "YOUR AGE : "
        }else{
            textView.text = "Your Age :  "+ageFromPreferences
        }
    }
    fun Save(view : View){

    val myAge = editText.text.toString().toIntOrNull()
        if(myAge != null){
            textView.text = "MyAge : ${myAge}"
           sharedPreferences.edit().putInt("age",myAge).apply()//yapının hashmap ile benzer kısmı bu alan burada veriyi saklamak için bir anahtar bir değer soruyor olması

        }
    }
    fun Delete(view : View){
        ageFromPreferences = sharedPreferences.getInt("age",-1)
        if (ageFromPreferences != -1){
            sharedPreferences.edit().remove("age").apply()//edit anahtar kelimesini çağırdığımda apply ibaresini de eklemem gerekiyor.
            textView.text = "Your Age : !"
        }
    }
}