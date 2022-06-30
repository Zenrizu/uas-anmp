package id.ac.ubaya.informatika.ubayakost_uas_17_30_58.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.R
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.viewModel.AccountViewModel
import kotlinx.android.synthetic.main.fragment_login.*

class FragmentLogin : Fragment() {
    private lateinit var viewModel: AccountViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonLogin.setOnClickListener{
            viewModel.login(editTextUsernameLogin.toString(), editTextPasswordLogin.toString())

            Navigation.findNavController(it).navigate(FragmentLoginDirections.actionListKost())
        }
        buttonRegisterNow.setOnClickListener {
            Navigation.findNavController(it).navigate(FragmentLoginDirections.actionRegister())
        }
    }
}