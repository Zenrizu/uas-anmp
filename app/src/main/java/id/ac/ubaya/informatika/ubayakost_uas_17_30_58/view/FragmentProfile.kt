package id.ac.ubaya.informatika.ubayakost_uas_17_30_58.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.R
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.Util.loadImage
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.viewModel.AccountViewModel
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.viewModel.DetailViewModel
import kotlinx.android.synthetic.main.fragment__profile.*
import kotlinx.android.synthetic.main.fragment__profile.view.*
import kotlinx.android.synthetic.main.fragment_edit_profile.*
import kotlinx.android.synthetic.main.fragment_my_kost.*

class FragmentProfile : Fragment(), ButtonEditProfilClickListener {

    private lateinit var viewModel: AccountViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(AccountViewModel::class.java)
        val username = FragmentProfileArgs.fromBundle(requireArguments()).username
        viewModel.profile(username)
        observeViewModel()

        buttonEditProfile.setOnClickListener {

        }
    }

    private fun observeViewModel(){
        viewModel.accountDetailLD.observe(viewLifecycleOwner)  {
            textViewUsername.text = it.username
            textViewNama.text = it.name
            textViewEmail.text = it.email
            textViewPhoneNumber.text = it.phoneNumber
        }

    }

    override fun onEditProfileClickListener(view: View) {
        val username = view.textViewUsername.text.toString()
        val action = FragmentProfileDirections.actionItemProfileToFragmentEditProfile(username)
        Navigation.findNavController(view).navigate(action)
    }
}