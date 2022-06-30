package id.ac.ubaya.informatika.ubayakost_uas_17_30_58.view

import android.os.Bundle
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
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.databinding.FragmentDetailKostBinding
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.databinding.FragmentRegisterBinding
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.Account
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.Kost
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.viewModel.AccountViewModel
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.viewModel.DetailViewModel
import kotlinx.android.synthetic.main.detail_kost_card.*
import kotlinx.android.synthetic.main.fragment_detail_kost.*

class FragmentDetailKost : Fragment() {
    private lateinit var viewModel: DetailViewModel
    private lateinit var dataBinding: FragmentDetailKostBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding= DataBindingUtil.inflate<FragmentDetailKostBinding>(inflater,R.layout.fragment_detail_kost, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        dataBinding.detailKost = Kost("","","","","","","","","", 0)

//        buttonBooking.setOnClickListener {
//            val action = FragmentDetailKostDirections.actionCheckout(textViewID.text.toString())
//            Navigation.findNavController(it).navigate(action)
//        }
    }
//    private fun observeViewModel() {
//        viewModel.kostLiveData.observe(viewLifecycleOwner){
//            val kost = it
//            kost?.let {
//                imageViewDetailKost.loadImage(
//                    kost.foto, progressBarDetail
//                )
//                textViewID.setText(it.idKost)
//                textViewID.isVisible = false
//                textViewDetailNamaKost.setText(it.namaKost)
//                textViewDeskripsiKost.setText(it.deskripsi)
//                textViewHargaDetail.setText("Rp. " + it.harga)
//                buttonLocationDetail.setText(it.alamat)
//                buttonPhoneDetail.setText(it.telepon)
//                buttonMessageDetail.setText(it.telepon)
//            }
//        }
//    }
}