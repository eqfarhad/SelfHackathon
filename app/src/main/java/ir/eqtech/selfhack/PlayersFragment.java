package ir.eqtech.selfhack;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import org.w3c.dom.Text;

public class PlayersFragment extends Fragment {

    PlayerData playerData = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.playerData = (PlayerData) getArguments().getSerializable("playerData");
        Gson gson = new Gson();
        System.out.println(gson.toJson(playerData));
        this.playerData.addDetectedPlayer(new PlayerData(1, new Character("Farhad", Race.HUMAN, Role.PRIEST)));
        return inflater.inflate(R.layout.detected_players, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new RecyclerView.Adapter() {
            class PlayersViewHolder extends RecyclerView.ViewHolder {
                public TextView textView;
                public PlayersViewHolder(TextView v){
                    super(v);
                    textView = v;
                }
            }

            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                TextView v = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.player_item, parent, false);
                return new PlayersViewHolder(v);
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                PlayersViewHolder h = (PlayersViewHolder) holder;
                h.textView.setText(playerData.getDetectedPlayers().get(position).getName());
            }

            @Override
            public int getItemCount() {
                return playerData.getDetectedPlayers().size();
            }
        });

    }
}
