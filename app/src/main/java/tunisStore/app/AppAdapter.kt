package tunisStore.app



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import tunisStore.app.databinding.ItemAppBinding


class AppAdapter(private val apps: List<AppModel>) :
    RecyclerView.Adapter<AppAdapter.AppViewHolder>() {

    inner class AppViewHolder(val binding: ItemAppBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val binding = ItemAppBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AppViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        val app = apps[position]
        holder.binding.appName.text = app.name
        holder.binding.appCategory.text = app.category
        holder.binding.appRating.text = "${app.rating} ★"

        Glide.with(holder.itemView)
            .load(app.imageUrl)
            .placeholder(R.drawable.sample_app)
            .into(holder.binding.appImage)
    }

    override fun getItemCount(): Int = apps.size
}
