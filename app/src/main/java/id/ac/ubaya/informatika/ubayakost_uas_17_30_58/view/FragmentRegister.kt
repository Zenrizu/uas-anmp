package id.ac.ubaya.informatika.ubayakost_uas_17_30_58.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.R
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.Account
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.viewModel.AccountViewModel
import kotlinx.android.synthetic.main.fragment_register.*


class FragmentRegister : Fragment() {

    private lateinit var viewModel: AccountViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(AccountViewModel::class.java)

        buttonRegister.setOnClickListener {
            if (editTextPasswordRegister.text.toString() == editTextRetypePasswordRegister.text.toString()) {

                var regis = Account(
                    editTextUsernameRegister.text.toString(),
                    editTextEmailRegister.text.toString(),
                    editTextPasswordRegister.text.toString(),
                    editTextNameRegister.text.toString(),
                    editTextPhoneNumberRegister.text.toString()
                )
                val list = listOf(regis)
                viewModel.register(list)
                Toast.makeText(view.context, "Account Registered Successfully", Toast.LENGTH_LONG).show()
                Navigation.findNavController(it).popBackStack()

            }
            else {
                Toast.makeText(view.context, "Password is not match", Toast.LENGTH_LONG).show()
            }
        }
    }




}