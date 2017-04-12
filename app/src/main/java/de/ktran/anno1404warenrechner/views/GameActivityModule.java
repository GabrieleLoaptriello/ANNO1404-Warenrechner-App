package de.ktran.anno1404warenrechner.views;

import org.greenrobot.eventbus.EventBus;

import dagger.Module;
import dagger.Provides;
import de.ktran.anno1404warenrechner.data.DataManager;
import de.ktran.anno1404warenrechner.data.Game;
import de.ktran.anno1404warenrechner.views.game.ChainsAdapter;
import de.ktran.anno1404warenrechner.views.game.ChainsDetailAdapter;
import de.ktran.anno1404warenrechner.views.game.GameActivity;
import de.ktran.anno1404warenrechner.views.game.MaterialDetailAdapter;
import de.ktran.anno1404warenrechner.views.game.MaterialOverviewAdapter;
import de.ktran.anno1404warenrechner.views.game.PopulationAdapter;

@Module
public class GameActivityModule {
    private final GameActivity activity;
    private final int gameId;

    private Game game;

    public GameActivityModule(GameActivity activity, int gameId) {
        this.activity = activity;
        this.gameId = gameId;
    }

    @PerActivity
    @Provides
    GameActivity provideActivity() {
        return activity;
    }

    @Provides
    Game provideGame(DataManager dataManager) {
        if (game == null) {
            game = dataManager.getGameById(gameId);
        }

        return game;
    }

    @Provides
    PopulationAdapter providePopulationAdapter(GameActivity activity, Game game, EventBus bus) {
        return new PopulationAdapter(game, activity, bus);
    }

    @Provides
    ChainsAdapter provideChainsAdapter(GameActivity activity, Game game, EventBus bus, DataManager dataManager) {
        return new ChainsAdapter(game, activity, bus, dataManager);
    }

    @Provides
    ChainsDetailAdapter provideChainsDetailAdapter(DataManager dataManager, Game game, GameActivity activity, EventBus bus) {
        return new ChainsDetailAdapter(dataManager, game, activity, bus);
    }

    @Provides
    MaterialOverviewAdapter provideOtherGoodsOverviewAdapter(EventBus bus, Game game, GameActivity activity, DataManager dataManager) {
        return new MaterialOverviewAdapter(bus, game, activity, dataManager);
    }

    @Provides
    MaterialDetailAdapter provideOtherGoodsDetailAdapter(DataManager dataManager, Game game, GameActivity activity, EventBus bus) {
        return new MaterialDetailAdapter(dataManager, game, activity, bus);
    }
}
