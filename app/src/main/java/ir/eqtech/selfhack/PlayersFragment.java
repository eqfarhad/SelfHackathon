package ir.eqtech.selfhack;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

public class PlayersFragment extends Fragment {

    PlayerData playerData = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.playerData = (PlayerData) getArguments().getSerializable("playerData");
        Gson gson = new Gson();
        System.out.println(gson.toJson(playerData));
        Character farhad = new Character("Farhad", Race.HUMAN, Role.PRIEST);
        Character hammad = new Character("Hammad", Race.ORK, Role.KNIGHT);
        hammad.addAttack();
        this.playerData.addDetectedPlayer(new PlayerData(1, farhad));
        this.playerData.addDetectedPlayer(new PlayerData(2, hammad));
        this.playerData.addDetectedPlayer(new PlayerData(3, new Character("Juba", Race.ELB, Role.HUNTER)));
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
                public Button attack_button;

                public PlayersViewHolder(RelativeLayout rl){
                    super(rl);
                    textView = rl.findViewById(R.id.player_item_text_view);
                    attack_button = rl.findViewById(R.id.player_item_attack_button);
                }
            }

            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                RelativeLayout v = (RelativeLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.player_item, parent, false);
                return new PlayersViewHolder(v);
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                PlayersViewHolder h = (PlayersViewHolder) holder;
                final PlayerData enemy = playerData.getDetectedPlayers().get(position);
                h.textView.setText("You detected enemy " + enemy.getName());
                h.attack_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Fight fight = new Fight(playerData, enemy);
                        Toast.makeText(PlayersFragment.this.getActivity(), fight.nextFight(), Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public int getItemCount() {
                return playerData.getDetectedPlayers().size();
            }
        });

    }
}
