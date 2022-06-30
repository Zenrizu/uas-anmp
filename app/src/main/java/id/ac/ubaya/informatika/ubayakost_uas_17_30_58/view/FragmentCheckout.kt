package id.ac.ubaya.informatika.ubayakost_uas_17_30_58.view

import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.R
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.Util.loadImage
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.databinding.FragmentCheckoutBinding
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.databinding.FragmentDetailKostBinding
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.Global
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.Kost
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.MyKost
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.viewModel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_checkout.*
import kotlinx.android.synthetic.main.fragment_detail_kost.*

class FragmentCheckout : Fragment(), ButtonSelesaiCheckoutListener {
    private lateinit var viewModel: DetailViewModel
    private lateinit var dataBinding: FragmentCheckoutBinding
    var idKost = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding= DataBindingUtil.inflate<FragmentCheckoutBinding>(inflater,R.layout.fragment_checkout, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        Global.idkost = FragmentCheckoutArgs.fromBundle(requireArguments()).id
        idKost = Global.idkost
        dataBinding.detailCheckout = Kost("","","","","","","","","", Global.idkost.toInt())
        dataBinding.booking = this
        viewModel.fetch(Global.idkost)
        observeViewModel()
        imageViewLogo.loadImage("http://4.bp.blogspot.com/-5xzWMlb-0_Q/VisDq1SA6CI/AAAAAAAAAp0/z1jNL7O--gE/w1200-h630-p-k-no-nu/logo%2Bbank%2BBCA%2Bcoreldraw.png", progressBarCheckout)

        buttonSelesai.setOnClickListener {
//            Global.id = id
        }
    }
    private fun observeViewModel() {
        viewModel.kostLiveData.observe(viewLifecycleOwner) {
            dataBinding.detailCheckout=it
        }
    }

    override fun onButtonSelesaiCheckoutListener(view: View) {
        val myKost = MyKost(Global.username, Global.username + Global.idkost, Global.deskripsi, Global.alamat, Global.foto, Global.idkost.toInt())
        val book = viewModel.booking(myKost)
        Navigation.findNavController(view).navigate(FragmentCheckoutDirections.actionFragmentCheckoutToItemHome())
    }

}