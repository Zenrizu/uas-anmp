package id.ac.ubaya.informatika.ubayakost_uas_17_30_58.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.R
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.Util.loadImage
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.databinding.DetailKostCardBinding
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.Kost
import kotlinx.android.synthetic.main.detail_kost_card.view.*
import kotlinx.android.synthetic.main.fragment_list_kost.view.*
import java.util.ArrayList

class ListKostAdapter(val listKost: ArrayList<Kost>) : RecyclerView.Adapter<ListKostAdapter.ListKostViewHolder>(), ButtonDetailClickListener {
    class ListKostViewHolder(var view: DetailKostCardBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListKostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DetailKostCardBinding.inflate(inflater, parent, false)
        return ListKostViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListKostViewHolder, position: Int) {
        holder.view.kostCard = listKost[position]
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
        val idKost = view.tag.toString()
        val action = FragmentListKostDirections.actionDetailKost(idKost)

        Navigation.findNavController(view).navigate(action)
    }

}