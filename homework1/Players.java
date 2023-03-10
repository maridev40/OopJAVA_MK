package homework1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Players {
    private List<Player> players = new ArrayList<>();

    public Players() {
        Thread backgroundSatietyManagement = new Thread(() -> {
            while (true) {

                RandomAttack();

                try {
                    Thread.sleep(300L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        backgroundSatietyManagement.setDaemon(true);
        backgroundSatietyManagement.start();
    }

    public void AddPlayer(Player player) {
        players.add(player);
    }

    private void RandomAttack() {
        int count = players.size();
        if (count > 1) {

            Random random = new Random();
            int index1 = random.nextInt(count);
            int index2 = random.nextInt(count);

            if (index1 != index2) {
                players.get(index1).Attack(players.get(index2));
            }
        }
    }

    public boolean GetAlive() {
        int count = 0;
        for (Player player: players) {
            if (player.isAlive()) {
                count++;
            }
        }

        return count > 1;
    }

    public List<Player> GetPlayers() {
        return players;
    }
}
