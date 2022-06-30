package id.ac.ubaya.informatika.ubayakost_uas_17_30_58.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.R
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.databinding.DetailKostCardBinding
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.Kost
import java.util.ArrayList

class ListKostAdapter(val listKost: ArrayList<Kost>) : RecyclerView.Adapter<ListKostAdapter.ListKostViewHolder>(), ButtonDetailClickListener {
    class ListKostViewHolder(var view: DetailKostCardBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListKostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
//        val view = DetailKostCardBinding.inflate(inflater, parent, false)
        val view = DataBindingUtil.inflate<DetailKostCardBinding>(inflater, R.layout.detail_kost_card, parent, false)
        return ListKostViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListKostViewHolder, position: Int) {
        holder.view.kostCard = listKost[position]

        val TAG = "myactivity2"
        Log.d(TAG, listKost[position].namaKost.toString())
        holder.view.detailListener = this

//        with(holder.view) {
//            kostCard = kost
//            textViewNamaKost.text = kost.namaKost
//            textViewGender.text = kost.tipeKost
//            buttonLocation.text = kost.alamat
//            buttonDetail.setOnClickListener {
//                val action = FragmentListKostDirections.actionDetailKost(listKost[position].idKost.toString())
//
//                Navigation.findNavController(it).navigate(action)
//            }
//            imageViewKost.loadImage(kost.foto, progressBarCard)
//        }
    }

    override fun getItemCount() =  listKost.size

    fun updateKostList(newKostList: List<Kost>) {
        listKost.clear()
        listKost.addAll(newKostList)
        notifyDataSetChanged()
    }

    override fun onDetailClickListener(view: View) {
        val action = FragmentListKostDirections.actionDetailKost(view.tag.toString())

        Navigation.findNavController(view).navigate(action)
    }

}