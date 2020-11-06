package com.example.insurance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    //Global variable
    private var premium: Int = 0
    private var malePremium: Int = 0
    private var smokerPremium: Int = 0
    private var total: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //todo 1:link ui to code
        val spinnerAge: Spinner = findViewById(R.id.spinnerAge)
        val radioButtonMale: RadioButton = findViewById(R.id.radioButtonMale)
        val checkBoxSmoker:CheckBox = findViewById(R.id.checkBoxSmoker)
        //todo 2:set listener
        spinnerAge.onItemSelectedListener = this


        //first method
        radioButtonMale.setOnClickListener{
            val male = it.isSelected //it = refers to current view
            if(male){
                //TODO:calc male premium

            }
        }
        checkBoxSmoker.setOnCheckedChangeListener{ compoundButton, b->
            if(compoundButton.isChecked){
                //todo:calc smoker premium
            }
        }
    }

    //second method
    fun calculatePremium(view:View){
        val radioGroupGender: RadioGroup = findViewById(R.id.radioGroupGender)
        val gender = radioGroupGender.checkedRadioButtonId
        if(gender == R.id.radioButtonMale){
            //todo:calculate male premium
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, index: Int, p3: Long) {
        //Toast.makeText(this, "Item selected = $index", Toast.LENGTH_SHORT).show()
        when(index){
            0-> premium = 60
            1-> premium = 70
            2-> premium = 90
            3-> premium = 120
            4, 5-> premium = 150
            //todo: complete
        }
    }
}