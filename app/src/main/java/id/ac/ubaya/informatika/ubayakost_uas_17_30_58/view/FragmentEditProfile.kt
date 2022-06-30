package id.ac.ubaya.informatika.ubayakost_uas_17_30_58.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.R
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.databinding.FragmentEditProfileBinding
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.viewModel.AccountViewModel
import kotlinx.android.synthetic.main.fragment_edit_profile.*
import kotlinx.android.synthetic.main.fragment_edit_profile.view.*

class FragmentEditProfile : Fragment(), ButtonSaveProfilClickListener{

    private lateinit var viewModel: AccountViewModel
    private lateinit var dataBinding: FragmentEditProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate<FragmentEditProfileBinding>(inflater, R.layout.fragment_edit_profile, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(AccountViewModel::class.java)
        val username = view.editProfileUsername.text.toString()
        viewModel.profile(username)
        observeViewModel()


//        buttonSave.setOnClickListener {
//            viewModel.editAccount(editProfileEmail.text.toString(), editProfileNama.text.toString(), editProfilePhoneNumber.text.toString(), username)
//            Toast.makeText(view.context, "Profile Updated Successfully", Toast.LENGTH_SHORT).show()
//
//            Navigation.findNavController(it).popBackStack()
//        }
    }

    private fun observeViewModel(){
        viewModel.accountLD.observe(viewLifecycleOwner)  {
            dataBinding.editProfile = it
//            editProfileEmail.setText(it.email)
//            editProfileNama.setText(it.name)
//            editProfilePhoneNumber.setText(it.phoneNumber)
//            editProfileUsername.setText(it.username)
        }

    }

    override fun onSaveProfileClickListener(view: View) {
        val username = view.editProfileUsername.text.toString()
        viewModel.editAccount(view.editProfileEmail.text.toString(), view.editProfileNama.text.toString(), view.editProfilePhoneNumber.text.toString(), username)
        val action = FragmentEditProfileDirections.actionFragmentEditProfileToItemProfile(username)

        Navigation.findNavController(view).navigate(action)
    }
}