package com.secondworld.buenas.testingonandroid.ui.screens.questions

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView
import com.secondworld.buenas.testingonandroid.R
import com.secondworld.buenas.testingonandroid.core.extension.click
import com.secondworld.buenas.testingonandroid.databinding.HolderQuestionsAdapterBinding

@SuppressLint("NotifyDataSetChanged,SetTextI18n")
class QuestionsAdapter : RecyclerView.Adapter<QuestionsAdapter.ViewHolder>() {

    var items = listOf<AnswerUi>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var answerCallback: ((numberAnswer: Int) -> Unit)? = null

    inner class ViewHolder(private val binding: HolderQuestionsAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: AnswerUi) {
            binding.answerText.text = "${absoluteAdapterPosition + 1}. ${item.answer}"

            when (item.checkedStatus) {
                CheckedStatus.COMMON -> binding.root.setBackgroundResource(R.drawable.bg_holder_question_clean)
                CheckedStatus.SELECTED -> binding.root.setBackgroundResource(R.drawable.bg_holder_question)
                CheckedStatus.RIGHT_ANSWER -> binding.root.setBackgroundResource(R.drawable.bg_holder_question_correct_answer)
                CheckedStatus.WRONG_ANSWER -> binding.root.setBackgroundResource(R.drawable.bg_holder_question_wrong_answer)
            }

            binding.root.click { answerCallback?.invoke(absoluteAdapterPosition) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        HolderQuestionsAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}