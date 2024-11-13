package com.example.recipehub.ui.recipe.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recipehub.R
import com.example.recipehub.databinding.RecipeListItemBinding
import com.example.recipehub.repository.recipe.model.RecipeModel

class RecipesListAdapter(
    private var recipesList: List<RecipeModel>,
    private var context: Context,
    private val onclick: (RecipeModel) -> Unit
): RecyclerView.Adapter<RecipesListAdapter.RecipeItemViewHolder>() {

    inner class RecipeItemViewHolder(val binding: RecipeListItemBinding): RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener{
                onclick(recipesList[this.adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recipe_list_item, parent, false)
        return RecipeItemViewHolder(RecipeListItemBinding.bind(view))
    }

    override fun getItemCount(): Int  = recipesList.size

    override fun onBindViewHolder(holder: RecipeItemViewHolder, position: Int) {
        holder.binding.textView.text = recipesList[position].name
        holder.binding.textView4.text = recipesList[position].description
        Glide.with(context).load(recipesList[position].thumbnailUrl).into(holder.binding.imageView2)
    }
}