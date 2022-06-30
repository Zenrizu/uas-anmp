package id.ac.ubaya.informatika.ubayakost_uas_17_30_58.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.R
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.Util.loadImage
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.databinding.FragmentCheckoutBinding
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.databinding.FragmentDetailKostBinding
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.databinding.FragmentMyKostBinding
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.Global
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.Kost
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.MyKost
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.viewModel.DetailViewModel
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.viewModel.MyKostViewModel
import kotlinx.android.synthetic.main.fragment_detail_kost.*
import kotlinx.android.synthetic.main.fragment_my_kost.*
import java.text.FieldPosition

class FragmentMyKost : Fragment(), ButtonCancelBookListener {
    private lateinit var viewModel: MyKostViewModel
    private lateinit var dataBinding: FragmentMyKostBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding= DataBindingUtil.inflate<FragmentMyKostBinding>(inflater,R.layout.fragment_my_kost, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MyKostViewModel::class.java)

        val username = Global.username
        viewModel.displayMyKost(username)
        dataBinding.cancelBookingListener = this
        observeViewModel()

    }

    private fun observeViewModel() {
        viewModel.myKostLiveData.observe(viewLifecycleOwner){
            dataBinding.myKost = it
        }
    }

    override fun onButtonCancelBookListener(view: View) {

    }


}