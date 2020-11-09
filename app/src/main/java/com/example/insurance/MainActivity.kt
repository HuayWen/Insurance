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
        val radioButtonFemale: RadioButton = findViewById(R.id.radioButtonFemale)
        val checkBoxSmoker:CheckBox = findViewById(R.id.checkBoxSmoker)
        val textViewPremium : TextView = findViewById(R.id.textViewPremium)
        val textViewMalePremium : TextView = findViewById(R.id.textViewMalePremium)
        val textViewSmokerPremium : TextView = findViewById(R.id.textViewSmokerPremium)
        val textViewTotal : TextView = findViewById(R.id.textViewTotal)
        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)
        val buttonReset:Button = findViewById(R.id.buttonReset)

        //todo 2:set listener
        spinnerAge.onItemSelectedListener = this


        //first method
        radioButtonMale.setOnClickListener{
            val male = it.isSelected //it = refers to current view
            if(male){
                //TODO:calc male premium
                when(spinnerAge.getSelectedItemPosition()) {
                    0 -> malePremium = 0
                    1 -> malePremium = 50
                    2 -> malePremium = 100
                    3 -> malePremium = 150
                    4 -> malePremium = 200
                    5 -> malePremium = 200
                }
            }

        }

        checkBoxSmoker.setOnCheckedChangeListener{ compoundButton, b->
            if(compoundButton.isChecked){
                //todo:calc smoker premium
                when(spinnerAge.getSelectedItemPosition()) {
                    0 -> smokerPremium = 0
                    1 -> smokerPremium = 100
                    2 -> smokerPremium = 150
                    3 -> smokerPremium = 200
                    4 -> smokerPremium = 250
                    5 -> smokerPremium = 300
                }
            }
            else{
                smokerPremium = 0
            }

        }

        buttonCalculate.setOnClickListener{
            textViewPremium.text = premium.toString()
            textViewMalePremium.text = malePremium.toString()
            textViewSmokerPremium.text = smokerPremium.toString()
            total = premium + malePremium + smokerPremium
            textViewTotal.text = total.toString()
        }

        buttonReset.setOnClickListener{
            textViewPremium.text = null
            textViewMalePremium.text = null
            textViewSmokerPremium.text = null
            textViewTotal.text = null
            radioButtonMale.setChecked(false)
            radioButtonFemale.setChecked(false)
            checkBoxSmoker.setChecked(false)
        }
    }

    //second method
    fun calculatePremium(view:View){
        val radioGroupGender: RadioGroup = findViewById(R.id.radioGroupGender)
        val spinnerAge: Spinner = findViewById(R.id.spinnerAge)
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

        }

    }
}