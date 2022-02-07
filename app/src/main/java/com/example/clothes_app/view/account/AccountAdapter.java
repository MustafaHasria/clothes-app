package com.example.clothes_app.view.account;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clothes_app.R;
import com.example.clothes_app.model.entity.Account;

import java.util.List;

public class AccountAdapter extends ListAdapter<Account, AccountAdapter.AccountViewHolder> {

    //region Variables
    List<Account> accountList;
    //endregion

    private static final DiffUtil.ItemCallback<Account> DIFF_CALLBACK = new DiffUtil.ItemCallback<Account>() {

        @Override
        public boolean areItemsTheSame(@NonNull Account oldItem, @NonNull Account newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Account oldItem, @NonNull Account newItem) {
            return oldItem.getEmail().equals(newItem.getEmail()) && oldItem.isGender() == newItem.isGender()
                    && oldItem.getIdAccountType() == newItem.getIdAccountType()
                    && oldItem.getCountry().equals(newItem.getCountry())
                    && oldItem.getMobile().equals(newItem.getMobile())
                    && oldItem.getPicture().equals(newItem.getPicture())
                    && oldItem.getUsername().equals(newItem.getUsername());
        }
    };
    //endregion

    //region Methods

    //region Constructor
    public AccountAdapter(List<Account> accountList) {
        super(DIFF_CALLBACK);
        this.accountList = accountList;
    }

    @NonNull
    @Override
    public AccountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.account_item, parent, false);
        return new AccountViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AccountViewHolder holder, int position) {
        Account currentAccount = getItem(position);

        holder.accountItemTextViewTitle.setText(currentAccount.getEmail());
        holder.accountItemTextViewDescription.setText(currentAccount.getPassword());
    }


    //endregion

    //region ViewHolder
    public class AccountViewHolder extends RecyclerView.ViewHolder {

        //region Components
        CardView accountItemCardViewMainContainer;
        TextView accountItemTextViewTitle;
        TextView accountItemTextViewDescription;
        //endregion

        //region Constructor
        public AccountViewHolder(@NonNull View itemView) {
            super(itemView);
            accountItemCardViewMainContainer = itemView.findViewById(R.id.account_item_card_view_main_container);
            accountItemTextViewTitle = itemView.findViewById(R.id.account_item_text_view_title);
            accountItemTextViewDescription = itemView.findViewById(R.id.account_item_text_view_description);
        }
        //endregion
    }
    //endregion
}
