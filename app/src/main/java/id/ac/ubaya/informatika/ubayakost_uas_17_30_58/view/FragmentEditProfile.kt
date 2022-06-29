package id.ac.ubaya.informatika.ubayakost_uas_17_30_58.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.R
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.Util.accountDb
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.Util.loadImage
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.Account
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.viewModel.AccountDetailViewModel
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.viewModel.AccountViewModel
import kotlinx.android.synthetic.main.fragment__profile.*
import kotlinx.android.synthetic.main.fragment_edit_profile.*
import kotlinx.android.synthetic.main.fragment_my_kost.*
import kotlinx.android.synthetic.main.fragment_register.*

class FragmentEditProfile : Fragment() {

    private lateinit var viewModel: AccountViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(AccountViewModel::class.java)
        val username = FragmentEditProfileArgs.fromBundle(requireArguments()).username
        viewModel.profile(username)
        observeViewModel()


        buttonSave.setOnClickListener {
            viewModel.editAccount(editProfileEmail.text.toString(), editProfileNama.text.toString(), editProfilePhoneNumber.text.toString(), username)
            Toast.makeText(view.context, "Profile Updated Successfully", Toast.LENGTH_SHORT).show()

            Navigation.findNavController(it).popBackStack()
        }
    }

    private fun observeViewModel(){
        viewModel.accountDetailLD.observe(viewLifecycleOwner)  {
            editProfileEmail.setText(it.email)
            editProfileNama.setText(it.name)
            editProfilePhoneNumber.setText(it.phoneNumber)
            editProfileUsername.setText(it.username)
        }

    }
}