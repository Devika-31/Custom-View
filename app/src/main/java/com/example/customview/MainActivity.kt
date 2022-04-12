//Custom View Version 1

package com.example.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.CheckBox
import android.widget.CompoundButton

class MainActivity : AppCompatActivity() {
    lateinit var exitButton: ExitButton
    lateinit var chkBox: CheckBox
    private var backPressedtime=0L


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iniTUI()
        chkBox.setOnCheckedChangeListener(
            object :CompoundButton.OnCheckedChangeListener{
                override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
                    exitButton.exitables=p1
                }
            }
        )
        //by coding
        /*   exitButton = ExitButton(this)
           exitButton.text="Exit Application"
           setContentView(exitButton)*/
    }


    private fun iniTUI() {
        chkBox=findViewById(R.id.cbChkbx)
        exitButton=findViewById(R.id.btnCustomExit)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            if (((System.currentTimeMillis()-backPressedtime) /1000)<1){
                System.exit(0)
                return true
                }
                else{
                    backPressedtime=System.currentTimeMillis()
            }
        }
    return false
    //return super.onKeyUp(keyCode, event)
    }

}