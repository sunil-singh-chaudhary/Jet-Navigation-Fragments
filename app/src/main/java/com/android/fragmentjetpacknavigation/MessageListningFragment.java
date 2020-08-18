package com.android.fragmentjetpacknavigation;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MessageListningFragment extends Fragment  {
    private static RecyclerView.Adapter msg_adapter;
    private RecyclerView.LayoutManager msg_layoutManager;
    private static RecyclerView msg_recyclerView;
    private View root;
    public static int checkedItem = 0;
    NavController navController;
    private ArrayList<String> tabTitle_list, name_list;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu( true );

        OnBackPressedCallback callback = new OnBackPressedCallback( true ) {
            @Override
            public void handleOnBackPressed() {
                checkedItem = 0;
                // Handle the back button event
                FragmentManager fm = getFragmentManager();
                if (fm != null) {
                    if (fm.getBackStackEntryCount() > 0) {
                        fm.popBackStack();
                        Log.e( "backpress", "MessageListningFragment" );

                    }

                    List<Fragment> fragList = fm.getFragments();
                    if (fragList != null && fragList.size() > 0) {
                        for (Fragment frag : fragList) {
                            if (frag == null) {
                                continue;
                            }
                            if (frag.isVisible()) {
                                Log.e( "bcprs isvisble", "MessageListning-" + frag.toString() );

                            }
                        }
                    }
                }


            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback( this, callback );
        super.onCreate( savedInstanceState );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        root = inflater.inflate( R.layout.fragment_message_listning, container, false );
        name_list=new ArrayList<>(  );
        name_list.add( "jai ho" );
        name_list.add( "jai prabhu" );

        SetRecyclerView( root );
        navController = Navigation.findNavController( getActivity(), R.id.nav_host_container );
        NavigationUI.setupActionBarWithNavController( (AppCompatActivity) getActivity(), navController );

        msg_recyclerView.addOnItemTouchListener( new RecyclerItemClickListener( getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int pos) {
                Log.e("Click","full frag");
                navController.navigate( R.id.fullMsgViewFragment );

            }
        } ) );
        return root;
    }


    private void SetRecyclerView(View root) {
        msg_recyclerView = root.findViewById( R.id.msg_recycler_view );
        msg_recyclerView.setHasFixedSize( true );
        msg_layoutManager = new LinearLayoutManager( getActivity() );
        msg_recyclerView.setLayoutManager( msg_layoutManager );
        msg_recyclerView.setItemAnimator( new DefaultItemAnimator() );
        SubCategoryAdapter sub_cat_adapter = new SubCategoryAdapter( getActivity(), name_list );
        msg_recyclerView.setAdapter( sub_cat_adapter );

    }

    private void enterFullMsgFragment() {



    }


}
