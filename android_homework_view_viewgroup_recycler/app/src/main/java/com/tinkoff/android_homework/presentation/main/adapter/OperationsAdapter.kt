package com.tinkoff.android_homework.presentation.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tinkoff.android_homework.R
import com.tinkoff.android_homework.domain.main.entities.Operation
import com.tinkoff.android_homework.domain.main.entities.Operations
import com.tinkoff.android_homework.presentation.model.operations.OperationItem

class OperationsAdapter : RecyclerView.Adapter<OperationsAdapter.OperationsViewHolder>() {

    var data: List<OperationItem> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class OperationsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val operationImage: ImageView = itemView.findViewById(R.id.operation_icon)
        val operationName: TextView = itemView.findViewById(R.id.operation_name)
        val operationSum: TextView = itemView.findViewById(R.id.operation_sum)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OperationsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.operation_recycler_item, parent, false)
        return OperationsViewHolder(itemView)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: OperationsViewHolder, position: Int) {
        data[position].let {
            val iconRes = when (it.operationType.name) {
                "INCOME" -> R.drawable.income_icon
                else -> R.drawable.spending_icon
            }
            holder.operationImage.setImageResource(iconRes)
            holder.operationName.text = it.operationTitle
            holder.operationSum.text = it.operationSum.toString()
        }
    }

}