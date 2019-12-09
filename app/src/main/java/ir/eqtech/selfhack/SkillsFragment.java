package ir.eqtech.selfhack;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SkillsFragment extends Fragment {

    PlayerData playerData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.playerData = (PlayerData) getArguments().getSerializable("playerData");
        return inflater.inflate(R.layout.skills, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Character character = playerData.getCharacter();

        ((TextView) getView().findViewById(R.id.name)).setText(character.getName());
        ((TextView) getView().findViewById(R.id.role)).setText(character.getRole().toString());
        ((TextView) getView().findViewById(R.id.race)).setText(character.getRace().toString());

        ((TextView) getView().findViewById(R.id.level_value)).setText(character.getLvl()+"");
        ((TextView) getView().findViewById(R.id.xp_value)).setText(character.getXp()+"");

        ((TextView) getView().findViewById(R.id.attack_dmg_value)).setText(character.getAttack()+"");
        ((TextView) getView().findViewById(R.id.attack_speed_value)).setText(character.getSpeed()+"");
        ((TextView) getView().findViewById(R.id.health_value)).setText(character.getHealth()+"");
        ((TextView) getView().findViewById(R.id.armor_value)).setText(character.getArmor()+"");


    }
}
