package id.ac.ubaya.informatika.ubayakost_uas_17_30_58.view

import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.R
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.databinding.DetailKostCardBinding
import id.ac.ubaya.informatika.ubayakost_uas_17_30_58.model.Kost
import java.util.zip.Inflater

class listKostAdapt(val listKostAdapter: ArrayList<Kost>) : RecyclerView.Adapter<ListKostAdapter.ListKostViewHolder>(), ButtonDetailClickListener{
    class ListKostViewHolder(var view: DetailKostCardBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,viewType: Int): ListKostViewHolder {
        val view = DataBindingUtil.inflate<DetailKostCardBinding>(inflater, R.layout.detail_kost_card, parent, false)
        return ListKostViewHolder(view)
    }


    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ListKostViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun onDetailClickListener(view: View) {
        TODO("Not yet implemented")
    }
}