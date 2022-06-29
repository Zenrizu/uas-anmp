package id.ac.ubaya.informatika.ubayakost_uas_17_30_58.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.R
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.Util.loadImage
import kotlinx.android.synthetic.main.fragment__profile.*
import kotlinx.android.synthetic.main.fragment_edit_profile.*
import kotlinx.android.synthetic.main.fragment_my_kost.*

class FragmentEditProfile : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments != null) {
            val nama = FragmentEditProfileArgs.fromBundle(requireArguments()).nama
            val phone = FragmentEditProfileArgs.fromBundle(requireArguments()).phone
            val email = FragmentEditProfileArgs.fromBundle(requireArguments()).email

            editProfileEmail.setText(nama)
            editProfilePhoneNumber.setText(phone)
            editProfileNama.setText(email)
        }

        buttonSave.setOnClickListener {
            Navigation.findNavController(it).navigate(FragmentEditProfileDirections.actionFragmentEditProfileToItemProfile(editProfileEmail.text.toString(),editProfilePhoneNumber.text.toString(),editProfileNama.text.toString()))
        }
    }
}