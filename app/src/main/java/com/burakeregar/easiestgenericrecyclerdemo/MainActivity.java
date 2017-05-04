package com.burakeregar.easiestgenericrecyclerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.burakeregar.easiestgenericrecycleradapter.base.GenericAdapterBuilder;
import com.burakeregar.easiestgenericrecycleradapter.base.GenericRecyclerAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_rv)
    RecyclerView mMainRv;
    GenericRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initAdapter();
        ArrayList<ContactModel> mList = createDummyData();

        mAdapter.setList(mList);
    }

    private void initAdapter() {
        mMainRv.setLayoutManager(new LinearLayoutManager(this)); //set your layout manager
        mAdapter = new GenericAdapterBuilder().addModel(
                R.layout.row_contact, //set your row's layout file
                ContactViewHolder.class, //set your view holder class
                ContactModel.class) // set your model class(If you use just String list, it can be just String.class)
                .execute();
        mMainRv.setAdapter(mAdapter);
    }

    @Subscribe
    public void onRowClicked(ContactModel pModel) {
        Toast.makeText(this, "Name: " + pModel.getName() + " Surname: " + pModel.getSurname(), Toast.LENGTH_SHORT).show();
    }

    private ArrayList<ContactModel> createDummyData() {
        ArrayList<ContactModel> lList = new ArrayList<>();
        for (int i = 1; i < 80; i++) {
            lList.add(new ContactModel("Name" + i, "Surname" + i));
        }
        return lList;
    }
}
