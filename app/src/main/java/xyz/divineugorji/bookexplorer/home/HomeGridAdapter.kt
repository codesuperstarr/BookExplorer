package xyz.divineugorji.bookexplorer.home


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import xyz.divineugorji.bookexplorer.databinding.GridViewBinding
import xyz.divineugorji.bookexplorer.network.BookProperty

class HomeGridAdapter(val onClickListener: OnClickListener) : ListAdapter<BookProperty, HomeGridAdapter.BookPropertyViewHolder>(DiffCallback) {
    class BookPropertyViewHolder(private var binding: GridViewBinding) :
            RecyclerView.ViewHolder(binding.root){
        fun bind(marsProperty: BookProperty) {
            binding.property = marsProperty
            binding.executePendingBindings()
        }
    }

    object DiffCallback:  DiffUtil.ItemCallback<BookProperty>(){
        override fun areItemsTheSame(oldItem: BookProperty, newItem: BookProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: BookProperty, newItem: BookProperty): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeGridAdapter.BookPropertyViewHolder {
        return BookPropertyViewHolder(GridViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: HomeGridAdapter.BookPropertyViewHolder, position: Int) {
        val marsProperty = getItem(position)
        holder.bind(marsProperty)

        holder.itemView.setOnClickListener {
            onClickListener.onClick(marsProperty)
        }
    }

    class OnClickListener(val clickListener: (marsProperty:BookProperty) -> Unit) {
        fun onClick(marsProperty:BookProperty) = clickListener(marsProperty)
    }
}


