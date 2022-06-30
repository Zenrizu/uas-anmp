package id.ac.ubaya.informatika.ubayakost_uas_17_30_58.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.R
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.Kost
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.viewModel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_list_kost.*

class  FragmentListKost : Fragment() {
    private lateinit var viewModel: ListViewModel

    private val listKostAdapter  = ListKostAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_kost, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)

//        buttonAddKostData.setOnClickListener {
//            val dd1 = Kost(
//                "Sumber Bahagia",
//                "Kost ini merupakan sebuah kost yang terletak pada bagian terluar perumahan Rungkut Mejoyo Selatan. Untuk biaya listrik menggunakan token, sehingga pemiliki tidak menarik biaya listrik per bulannya. Biaya air sudah termasuk pada harga kost. Kamar mandi berada di dalam kamar.",
//                "putra",
//                "Rungkut Mejoyo Selatan AF-5",
//                "930.000 / bulan",
//                "031 75963421",
//                "Albertus Hendrawan Widjaja",
//                "2561189733",
//                "https://www.99.co/blog/indonesia/wp-content/uploads/2020/12/desain-kamar-tidur-minimalis-ukuran-3x4-header99.jpg",
//                0
//            )
//            val dd2 = Kost(
//                "Kos Serba Mura",
//                "Kost berada pada Rungkut Mejoyo Utara, dekat pintu gerbang. Kamar dengan luas 5 x 3 meter, dengan fasilitas AC, televisi, kamar mandi dalam, lemari, dan meja. Untuk biaya air include ke dalam biaya kos. Biaya listrik menggunakan sistem token.",
//                "putra",
//                "Rungkut Mejoyo Utara AN-5",
//                "950.000 / bulan",
//                "031 78124421",
//                "Muhammad Rafli Wahyudi",
//                "8805142395",
//                "https://cdn-cms.pgimgs.com/static/2021/03/8-Desain-Kamar-Tidur-Minimalis-Ukuran-3x4.png",
//                1
//            )
//            val dd3 = Kost(
//                "Kos Modern",
//                "Kost berada pada seberang parkiran mahasiswa S1 Ubaya. Biaya listrik dan air tergantung dengan pemakaian yang dibayarkan secara cash pada pemilik kos. Fasilitas yaitu parkiran mobil, lift, ac, kamar mandi dalam, meja, lemari, televisi, air minum, nasi, dan wifi.",
//                "putra/putri",
//                "Rungkut Mejoyo Utara AG-5",
//                "1.700.000 / bulan",
//                "031 75415531",
//                "Timothy Andreas",
//                "885061913",
//                "https://interiordesign.id/wp-content/uploads/2020/12/kamar-tidur-7-1.jpg",
//                2
//            )
//            val dd4 = Kost(
//                "Kos Putri AC",
//                "Kost berada pada Rungkut Mejoyo Selatan terletak di sebelah swalayan Alfamidi. Gedung Kost memiliki 3 warna sehingga dijuluki, kost warna warni. Parkiran mobil dan motor luas. Biaya listrik berupa token, sedangkan biaya air tergantung pemakaian yang ditransfer secara terpisah. Pada kamar terdapat lemari, ac, dan kamar mandi dalam. Terdapat wifi juga dengan bandwith besar sehingga tidak masalah jika digunakan untuk online meeting. Tidak mendapatkan nasi dan air minum",
//                "putri",
//                "Rungkut Mejoyo Utara AM-3",
//                "1.300.000 / bulan",
//                "031 798613845",
//                "Anastasia Karen",
//                "75961384",
//                "https://www.ruparupa.com/blog/wp-content/uploads/2021/08/Screenshot-2021-08-09-161737.png",
//                3
//            )
//            val list1 = listOf(dd1)
//            val list2 = listOf(dd2)
//            val list3 = listOf(dd3)
//            val list4 = listOf(dd4)
//
//            viewModel.insertData(list1)
//            viewModel.insertData(list2)
//            viewModel.insertData(list3)
//            viewModel.insertData(list4)
//        }
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.display()

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = listKostAdapter

        observeViewModel()

        refreshLayout.setOnRefreshListener {
            recyclerView.visibility = View.GONE
            textViewError.visibility = View.GONE
            progressBar.visibility = View.VISIBLE
            viewModel.display()
            refreshLayout.isRefreshing = false
        }

    }

    private fun observeViewModel() {
        viewModel.kostLiveData.observe(viewLifecycleOwner) {
            listKostAdapter.updateKostList(it)
        }
        viewModel.kostLoadErrorLiveData.observe(viewLifecycleOwner) {
            textViewError.visibility = if (it) View.VISIBLE else View.GONE
        }
        viewModel.loadingLiveData.observe(viewLifecycleOwner) {
            if(it) {
                recyclerView.visibility = View.GONE
                progressBar.visibility = View.VISIBLE
            } else {
                recyclerView.visibility = View.VISIBLE
                progressBar.visibility = View.GONE
            }
        }
    }
}