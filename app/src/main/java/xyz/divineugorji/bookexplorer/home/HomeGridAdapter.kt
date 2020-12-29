package xyz.divineugorji.bookexplorer.home


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import xyz.divineugorji.bookexplorer.databinding.GridViewBinding
import xyz.divineugorji.bookexplorer.network.BookProperty

class HomeGridAdapter(private val onClickListener: OnClickListener) : ListAdapter<BookProperty, HomeGridAdapter.BookPropertyViewHolder>(DiffCallback) {
    class BookPropertyViewHolder(private var binding: GridViewBinding) :
            RecyclerView.ViewHolder(binding.root){
        fun bind(bookProperty: BookProperty) {
            binding.property = bookProperty
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
        val bookProperty = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(bookProperty)
        }
        holder.bind(bookProperty)
    }

    class OnClickListener(val clickListener: (bookProperty: BookProperty) -> Unit) {
        fun onClick(bookProperty:BookProperty) = clickListener(bookProperty)
    }
}


