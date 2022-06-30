package id.ac.ubaya.informatika.ubayakost_uas_17_30_58.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.R
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.Util.loadImage
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.Global
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.viewModel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_detail_kost.*
import kotlinx.android.synthetic.main.fragment_my_kost.*
import java.text.FieldPosition

class FragmentMyKost : Fragment() {
    private lateinit var viewModel: DetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_kost, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
//        val id = Global.id
//        viewModel.fetch(id)


        observeViewModel()

    }

    private fun observeViewModel() {
        viewModel.kostLiveData.observe(viewLifecycleOwner){
            val kost = it
            kost?.let {
                imageViewMyKost.loadImage(
                    kost.foto, progressBarMyKost
                )
                textViewMyKostNamaKost.setText(it.namaKost)
                textViewMyKostDeskripsiKost.setText(it.deskripsi)
                textViewMyKostHarga.setText("Rp. " + it.harga)
                buttonLocationMyKost.setText(it.alamat)
                buttonPhoneMyKost.setText(it.telepon)
                buttonMessageMyKost.setText(it.telepon)
            }
        }
    }


}