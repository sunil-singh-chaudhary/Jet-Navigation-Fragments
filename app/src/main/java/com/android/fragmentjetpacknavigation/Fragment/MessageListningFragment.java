package com.android.fragmentjetpacknavigation.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.fragmentjetpacknavigation.R;
import com.android.fragmentjetpacknavigation.adapter.RecyclerItemClickListener;
import com.android.fragmentjetpacknavigation.adapter.SubCategoryAdapter;

import java.util.ArrayList;

public class MessageListningFragment extends Fragment  {
    private static RecyclerView.Adapter msg_adapter;
    private RecyclerView.LayoutManager msg_layoutManager;
    private static RecyclerView msg_recyclerView;
    private View root;
    public static int checkedItem = 0;

    private ArrayList<String>  name_list;
  /*  @Override
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
*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        root = inflater.inflate( R.layout.fragment_message_listning, container, false );
        name_list=new ArrayList<>(  );
        name_list.add( "jai ho" );
        name_list.add( "jai prabhu" );

        SetRecyclerView( root );


        msg_recyclerView.addOnItemTouchListener( new RecyclerItemClickListener( getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int pos) {
                Log.e("Click","full frag");
                Navigation.findNavController(root).navigate(R.id.fullMsgViewFragment);

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




}
