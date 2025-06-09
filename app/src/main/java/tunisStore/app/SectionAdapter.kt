package tunisStore.app


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tunisStore.app.databinding.ItemSectionBinding

class SectionAdapter(
    private val context: Context,
    private val data: Map<String, List<AppModel>>
) : RecyclerView.Adapter<SectionAdapter.SectionViewHolder>() {

    private val sectionTitles = data.keys.toList()

    inner class SectionViewHolder(val binding: ItemSectionBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        val binding = ItemSectionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SectionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        val sectionTitle = sectionTitles[position]
        val apps = data[sectionTitle] ?: emptyList()

        holder.binding.sectionTitle.text = sectionTitle
        holder.binding.recyclerApps.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = AppAdapter(apps)
        }

        // Voir plus
        holder.binding.seeMore.setOnClickListener {
            // Ajoute l’intent vers la section complète si besoin
        }
    }

    override fun getItemCount(): Int = sectionTitles.size
}
