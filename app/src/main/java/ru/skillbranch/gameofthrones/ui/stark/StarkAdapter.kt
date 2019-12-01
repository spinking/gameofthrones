package ru.skillbranch.gameofthrones.ui.stark

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.skillbranch.gameofthrones.R

class StarkAdapter(
    private var personList: MutableList<Character> = mutableListOf(),
    private val clickListener: (Int) -> Unit
) : RecyclerView.Adapter<StarkAdapter.PersonHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHolder {
        return PersonHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false))
    }

    override fun getItemCount() = personList.size

    override fun onBindViewHolder(holder: PersonHolder, position: Int) {
        holder.bind(personList[position])
    }

/*    fun setEvents(event: List<EventResponse>) {
        this.event.clear()
        this.event.addAll(event)
        notifyDataSetChanged()
    }
    fun addEvents(event: List<EventResponse>){
        this.event.addAll(event)
        notifyDataSetChanged()
    }*/


    inner class PersonHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(person: Character) {

        }
    }
}