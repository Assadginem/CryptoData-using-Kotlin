package com.example.retrocrypto0827.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrocrypto0827.Model.Crypto
import com.example.retrocrypto0827.R

        class CryptoAdapter(internal val context: Context, internal val postList: List<Crypto>)
            :RecyclerView.Adapter<CryptoViewHolder>()
        {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
                var itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.retro_coin_card, parent, false)
                return CryptoViewHolder(itemView)
            }

            override fun getItemCount(): Int {
                return postList.size
            }

            override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
                holder.txtCurrency.text = postList[position].currency.toString()
                holder.txtPrice.text = postList[position].price.toString()
            }
        }