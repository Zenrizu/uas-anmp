package id.ac.ubaya.informatika.ubayakost_uas_17_30_58.view

import android.os.Bundle
import android.provider.Settings
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
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.Kost
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.viewModel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_checkout.*
import kotlinx.android.synthetic.main.fragment_detail_kost.*

class FragmentCheckout : Fragment() {
    private lateinit var viewModel: DetailViewModel
    var id = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_checkout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null) {
            viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
            val id = FragmentCheckoutArgs.fromBundle(requireArguments()).id
            viewModel.fetch(id)
        }
        observeViewModel()
        imageViewLogo.loadImage("http://4.bp.blogspot.com/-5xzWMlb-0_Q/VisDq1SA6CI/AAAAAAAAAp0/z1jNL7O--gE/w1200-h630-p-k-no-nu/logo%2Bbank%2BBCA%2Bcoreldraw.png", progressBarCheckout)

        buttonSelesai.setOnClickListener {
            Navigation.findNavController(it).navigate(FragmentCheckoutDirections.actionFragmentCheckoutToItemHome())
//            Global.id = id
        }
    }
    private fun observeViewModel() {
        viewModel.kostLiveData.observe(viewLifecycleOwner){
            val kost = it
            kost?.let {
                id = it.idKost.toString()
                textViewNoRek.setText(it.rekening)
                textViewNamaTujuan.setText(it.pemilik)
            }
        }
    }

}