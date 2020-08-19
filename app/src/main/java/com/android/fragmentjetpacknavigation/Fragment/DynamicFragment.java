package com.android.fragmentjetpacknavigation.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.fragmentjetpacknavigation.R;
import com.android.fragmentjetpacknavigation.adapter.RecyclerItemClickListener;
import com.android.fragmentjetpacknavigation.adapter.SubCategoryAdapter;

import java.util.ArrayList;


public class DynamicFragment extends Fragment {
    private RecyclerView.LayoutManager sub_cat_layoutManager;
    private static RecyclerView sub_cat_recyclerView;
    public static DynamicFragment newInstance() {
        return new DynamicFragment();
    }
    private ArrayList<String>  name_list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View root = inflater.inflate( R.layout.fragment_dynamic, container, false );
        name_list = (ArrayList<String>) getArguments().getSerializable( "name_list" );
        initViews( root );



        sub_cat_recyclerView.addOnItemTouchListener( new RecyclerItemClickListener( getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int pos) {
                Log.e("Click","Go to Messaging frag");

                Navigation.findNavController(root).navigate(R.id.messageListningFragment);

            }
        } ) );

        return root;
    }


    private void initViews(View view) {

        sub_cat_recyclerView = view.findViewById( R.id.my_recycler_view );
        sub_cat_recyclerView.setHasFixedSize( true );
        sub_cat_layoutManager = new LinearLayoutManager( getActivity() );
        sub_cat_recyclerView.setLayoutManager( sub_cat_layoutManager );
        sub_cat_recyclerView.setItemAnimator( new DefaultItemAnimator() );
        //call adapter
        SubCategoryAdapter sub_cat_adapter = new SubCategoryAdapter( getActivity(), name_list );
        sub_cat_recyclerView.setAdapter( sub_cat_adapter );


    }


}