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
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.databinding.FragmentLoginBinding
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.Account
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.viewModel.AccountViewModel
import kotlinx.android.synthetic.main.fragment__profile.view.*
import kotlinx.android.synthetic.main.fragment_edit_profile.view.*
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*

class FragmentLogin : Fragment(), ButtonLoginClickListener, ButtonRegisterNowListener {
    private lateinit var viewModel: AccountViewModel
    private lateinit var dataBinding:FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater, R.layout.fragment_login, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(AccountViewModel::class.java)
        dataBinding.login = this
        dataBinding.registerNow = this
        dataBinding.account = Account("","","","","")
    }

    override fun onButtonLoginClickListener(view: View) {

        viewModel.login(dataBinding?.account!!.username, dataBinding?.account!!.password)
        Toast.makeText(view.context, "Welcome!!", Toast.LENGTH_LONG).show()
        Navigation.findNavController(view).navigate(FragmentLoginDirections.actionListKost())

//        else if(viewModel.result=="OK")
//        {
//            Toast.makeText(v.context, "Welcome!!", Toast.LENGTH_LONG).show()
//            val action = FragmentLoginDirections.actionMainActivity()
//            Navigation.findNavController(v).navigate(action)
//            Global.username=dataBinding?.user!!.username
//
//            /*Toast.makeText(v.context, "${Global.username}", Toast.LENGTH_LONG).show()*/
//        }
    }

    override fun onButtonRegisterNowListener(view: View) {
        Navigation.findNavController(view).navigate(FragmentLoginDirections.actionRegister())
    }
}