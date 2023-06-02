package DefiningClassesExercises.P06PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> collectionOfPokemon; //collection of pokemon

    public Trainer(String name, int numberOfBadges, List<Pokemon> collectionOfPokemon) {
        this.name = name;
        this.numberOfBadges = 0;//по условие
        this.collectionOfPokemon = new ArrayList<>();
    }
}
