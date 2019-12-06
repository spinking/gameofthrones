package ru.skillbranch.gameofthrones.ui.stark

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_person.view.*
import ru.skillbranch.gameofthrones.R
import ru.skillbranch.gameofthrones.data.remote.res.CharacterRes
import ru.skillbranch.gameofthrones.data.remote.res.HouseRes

class StarkAdapter(
    private var personList: MutableList<CharacterRes> = mutableListOf(),
    private val clickListener: (Int) -> Unit
) : RecyclerView.Adapter<StarkAdapter.PersonHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHolder {
        return PersonHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false))
    }



    override fun getItemCount() = personList.size

    override fun onBindViewHolder(holder: PersonHolder, position: Int) {
        holder.bind(personList[position])
    }



    inner class PersonHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(person: CharacterRes) {
            itemView.userFullName.text = person.name
            itemView.userName.text = person.born
        }
    }
    fun showCharacters(char: List<CharacterRes>) {
        this.personList.clear()
        this.personList.addAll(char)
        notifyDataSetChanged()
    }
}
