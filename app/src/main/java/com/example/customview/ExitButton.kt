package com.example.customview

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.util.AttributeSet
import android.view.View
import android.widget.Button

@SuppressLint("AppCompatCustomView")
class ExitButton(context: Context,attributeSet: AttributeSet?=null) : Button(context,attributeSet) {
    //guaranteed to execute after primary const
    init {
        setOnClickListener {
            var exitAlertDialog:AlertDialog=getAlertDialog()
            exitAlertDialog.show()

        }


    }

    private fun getAlertDialog(): AlertDialog {
        var exitDialogBuilder = AlertDialog.Builder(context)
        exitDialogBuilder.setMessage("Exit?")
        exitDialogBuilder.setPositiveButton("Exit",

            object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    System.exit(0)
                }

            })
        exitDialogBuilder.setNegativeButton("No",
            object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    p0?.dismiss()
                }
            })
        //returns obj
        return exitDialogBuilder.create()

    }
}