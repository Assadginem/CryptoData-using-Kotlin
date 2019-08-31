package com.example.retrocrypto0827.Adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.retro_coin_card.view.*

            class CryptoViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

                val txtCurrency = itemView.txtCurrency
                val txtPrice = itemView.txtPrice
            }