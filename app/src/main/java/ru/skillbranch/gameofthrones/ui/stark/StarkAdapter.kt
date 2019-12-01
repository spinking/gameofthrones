package ru.skillbranch.gameofthrones.ui.stark

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_person.view.*
import ru.skillbranch.gameofthrones.R
import ru.skillbranch.gameofthrones.data.remote.res.HouseRes

class StarkAdapter(
    private var personList: MutableList<HouseRes> = mutableListOf(),
    private val clickListener: (Int) -> Unit
) : RecyclerView.Adapter<StarkAdapter.PersonHolder>() {

    private var houses = mutableListOf<HouseRes>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHolder {
        return PersonHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false))
    }

    override fun getItemCount() = personList.size

    override fun onBindViewHolder(holder: PersonHolder, position: Int) {
        holder.bind(personList[position])
    }

    fun setHouses(houses: List<HouseRes>) {
        this.houses.clear()
        this.houses.addAll(houses)
        notifyDataSetChanged()
    }
    /*fun addEvents(event: List<EventResponse>){
        this.event.addAll(event)
        notifyDataSetChanged()
    }*/


    inner class PersonHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(person: HouseRes) {
            itemView.userFullName.text = person.name
            itemView.userName.text = person.region
        }
    }
}