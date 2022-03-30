package com.example.clothes_app.view.dashboard.account;

import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clothes_app.R;
import com.example.clothes_app.model.entity.Account;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AccountAdapter extends ListAdapter<Account, AccountAdapter.AccountViewHolder> {

    //region Variables
    List<Account> accountList;
    private static final DiffUtil.ItemCallback<Account> DIFF_CALLBACK = new DiffUtil.ItemCallback<Account>() {

        @Override
        public boolean areItemsTheSame(@NonNull Account oldItem, @NonNull Account newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Account oldItem, @NonNull Account newItem) {
            return oldItem.getEmail().equals(newItem.getEmail()) && oldItem.isGender() == newItem.isGender()
                    && oldItem.getIdAccountType() == newItem.getIdAccountType()
                    && oldItem.getAddress().equals(newItem.getAddress())
                    && oldItem.getMobile().equals(newItem.getMobile())
                    && oldItem.getPicture() == newItem.getPicture()
                    && oldItem.getUsername().equals(newItem.getUsername());
        }
    };

    OnAccountAdapterClickListeners onAccountAdapterClickListeners;
    //endregion

    //region Constructor
    public AccountAdapter(List<Account> accountList, OnAccountAdapterClickListeners onAccountAdapterClickListeners) {
        super(DIFF_CALLBACK);
        this.accountList = accountList;
        this.onAccountAdapterClickListeners = onAccountAdapterClickListeners;
    }

    @NonNull
    @Override
    public AccountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_account, parent, false);
        return new AccountViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AccountViewHolder holder, int position) {
        Account currentAccount = getItem(position);
        if (currentAccount.getUsername().equals("admin_boss"))
            holder.accountItemImageButtonDelete.setVisibility(View.GONE);
        holder.accountItemTextViewEmail.setText(currentAccount.getEmail());
        holder.accountItemTextViewUsername.setText(currentAccount.getUsername());
        holder.accountItemTextViewAddress.setText(currentAccount.getAddress());
        if (currentAccount.getPicture() != null)
            holder.accountItemCircleImageViewImage.setImageBitmap(BitmapFactory
                    .decodeByteArray(currentAccount.getPicture(), 0, currentAccount.getPicture().length));
//        if (!currentAccount.isGender())
//            holder.accountItemCardViewMainContainer.setBackgroundColor(Color.parseColor("#F7B4CC"));
    }


    //endregion

    //region Click listeners
    public interface OnAccountAdapterClickListeners {

        void onAccountItemCardViewMainContainerClickListener(Account account, int position);

        void onLongAccountItemCardViewMainContainerClickListener(Account account, int position);

        void onAccountItemImageButtonDeleteClickListener(Account account, int position);
    }
    //endregion

    //region ViewHolder
    public class AccountViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,
            View.OnLongClickListener {

        //region Components
        LinearLayout accountItemCardViewMainContainer;
        TextView accountItemTextViewUsername;
        TextView accountItemTextViewEmail;
        TextView accountItemTextViewAddress;
        CircleImageView accountItemCircleImageViewImage;
        ImageButton accountItemImageButtonDelete;
        //endregion

        //region Constructor
        public AccountViewHolder(@NonNull View itemView) {
            super(itemView);
            accountItemCardViewMainContainer = itemView.findViewById(R.id.account_item_card_view_main_container);
            accountItemTextViewUsername = itemView.findViewById(R.id.account_item_text_view_username);
            accountItemTextViewEmail = itemView.findViewById(R.id.account_item_text_view_email);
            accountItemTextViewAddress = itemView.findViewById(R.id.account_item_text_view_address);
            accountItemCircleImageViewImage = itemView.findViewById(R.id.account_item_circle_image_view_image);
            accountItemImageButtonDelete = itemView.findViewById(R.id.account_item_image_button_delete);
            accountItemCardViewMainContainer.setOnClickListener(this);
            accountItemImageButtonDelete.setOnClickListener(this);
            accountItemCardViewMainContainer.setOnLongClickListener(this);
            accountItemCircleImageViewImage.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            switch (view.getId()) {
                case R.id.account_item_card_view_main_container:
                    onAccountAdapterClickListeners.onAccountItemCardViewMainContainerClickListener(
                            getItem(position),
                            position);

                    break;
                case R.id.item_recycler_color_image_button_color:
                    onAccountAdapterClickListeners.onAccountItemImageButtonDeleteClickListener(
                            getItem(position),
                            position);
                    break;
            }
        }

        @Override
        public boolean onLongClick(View view) {
            if (view.getId() == R.id.account_item_card_view_main_container)
                onAccountAdapterClickListeners.onLongAccountItemCardViewMainContainerClickListener(
                        getItem(getAdapterPosition())
                        , getAdapterPosition());
            return false;
        }
        //endregion
    }
    //endregion


}

