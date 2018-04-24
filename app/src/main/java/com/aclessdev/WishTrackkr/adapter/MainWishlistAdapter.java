package com.aclessdev.WishTrackkr.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aclessdev.WishTrackkr.R;
import com.aclessdev.WishTrackkr.model.product.GetProductByIdResponse;
import com.bumptech.glide.Glide;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import io.realm.Realm;

/**
 * Created by AlvinTan on 18/03/18.
 */

public class MainWishlistAdapter extends RecyclerView.Adapter<MainWishlistAdapter.ViewHolder>{
    //Add implement ItemTouchHelperAdapter

    Context ctx;
    List<GetProductByIdResponse> listProduct;

    Realm realm;


//    public MainWishlistAdapter(Context ctx, List<GetProductByIdResponse> listProduct, OnStartDragListener onStartDragListener, Realm realm) {
//        this.ctx = ctx;
//        this.listProduct = listProduct;
//        this.onStartDragListener = onStartDragListener;
//        this.realm = realm;
//    }

    public MainWishlistAdapter(Context ctx, List<GetProductByIdResponse> listProduct, Realm realm) {
        this.ctx = ctx;
        this.listProduct = listProduct;
        this.realm = realm;
    }

    public void setListProduct(List<GetProductByIdResponse> listProduct) {
        this.listProduct = listProduct;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.single_item_wish, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(listProduct.get(position), position, holder);
    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }
//
//    @Override
//    public boolean onItemMove(int fromPosition, int toPosition) {
//
//        GetProductByIdResponse prev = listProduct.remove(fromPosition);
//        listProduct.add(toPosition > fromPosition ? toPosition - 1 : toPosition, prev);
//        notifyItemMoved(fromPosition, toPosition);


//        String productInitialName = listProduct.get(fromPosition).getProduct().getName();
//        realm.beginTransaction();
//        RealmResults prev = realm.where(Product.class).equalTo("name",productInitialName).findAll();
//        prev.deleteFirstFromRealm();
//        realm.insert
//
//        notifyItemMoved(fromPosition, toPosition);
//        return true;
//        return false;
//    }

//    @Override
//    public void onItemDismiss(int position) {
//
//    }




    public class ViewHolder extends RecyclerView.ViewHolder{
        // implements ItemTouchHelperViewHolder
        @BindView(R.id.productImage)
        ImageView productImage;
        @BindView(R.id.productName)
        TextView productName;
        @BindView(R.id.productPrice)
        TextView productPrice;
        @BindView(R.id.productPosition)
        TextView productPosition;
        @BindView(R.id.iconReorder)
        ImageView iconReorder;
//        View itemView;
        GetProductByIdResponse product;


        @OnClick(R.id.container)
        public void onClick() {
//            Toast.makeText(ctx, product.getProduct().getProductLink(), Toast.LENGTH_SHORT).show();
        }

        @OnLongClick(R.id.container)
        boolean onLongClick(){
//            Toast.makeText(ctx, "longclick"+product.getProduct().getName(), Toast.LENGTH_SHORT).show();
            return true;
        }




        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(GetProductByIdResponse product, int position, final ViewHolder holder) {
            this.product = product;
            productPosition.setText((position + 1) + "");
            productName.setText(product.getProduct().getName());
//            String currency = Currency.getInstance(Locale.getDefault()).getSymbol()+" ";
//            String price = NumberFormat.getNumberInstance(Locale.getDefault()).format(product.getProduct().getPrice());
//            String showedPrice = currency+price;
//            productPrice.setText(showedPrice);

            productPrice.setText("Rp."+NumberFormat.getNumberInstance(new Locale("in")).format(product.getProduct().getPrice()));
            Glide.with(ctx).load(product.getProduct().getImages().get(0)).into(productImage);

//            iconReorder.setOnTouchListener(new View.OnTouchListener() {
//                @Override
//                public boolean onTouch(View v, MotionEvent event) {
//                    if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
//                        onStartDragListener.onStartDrag(holder);
//                    }
//                    return false;
//                }
//            });

        }
//
//        @Override
//        public void onItemSelected() {
//            itemView.setBackgroundColor(Color.LTGRAY);
//        }
//
//        @Override
//        public void onItemClear() {
//            itemView.setBackgroundColor(0);
//        }
    }

}


