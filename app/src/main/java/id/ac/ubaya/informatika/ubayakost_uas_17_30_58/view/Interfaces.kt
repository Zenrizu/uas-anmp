package id.ac.ubaya.informatika.ubayakost_uas_17_30_58.view

import android.view.View
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.Account

interface ButtonDetailClickListener {
    fun onDetailClickListener(view: View)
}

interface ButtonEditProfilClickListener {
    fun onEditProfileClickListener(view: View)
}

interface ButtonSaveProfilClickListener {
    fun onSaveProfileClickListener(view: View, obj:Account)
}

interface ButtonLoginClickListener {
    fun onButtonLoginClickListener(view: View)
}

interface ButtonRegisterNowListener {
    fun onButtonRegisterNowListener(view: View)
}

interface ButtonSaveRegisterListener {
    fun onButtonSaveRegisterListener(view: View)
}

interface ButtonCheckoutListener {
    fun onButtonCheckoutListener(view: View)
}

interface ButtonSelesaiCheckoutListener {
    fun onButtonSelesaiCheckoutListener(view: View)
}

interface ButtonCancelBookListener {
    fun onButtonCancelBookListener(view: View)
}