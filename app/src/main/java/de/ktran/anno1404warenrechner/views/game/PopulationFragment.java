package de.ktran.anno1404warenrechner.views.game;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.ktran.anno1404warenrechner.R;
import de.ktran.anno1404warenrechner.data.DataManager;
import de.ktran.anno1404warenrechner.data.Game;


public class PopulationFragment extends GameFragment {

    @BindView(R.id.populationList)
    RecyclerView populationList;

    @Inject
    DataManager dataManager;

    @Inject
    PopulationAdapter adapter;

    @Inject
    Game game;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_population;
    }

    @Override
    protected void onViewCreated(View parent) {
        getGameActivity().component().inject(this);

        registerLifecycle(adapter);
        populationList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        populationList.setItemAnimator(new DefaultItemAnimator());
        populationList.setAdapter(adapter);
    }
}
