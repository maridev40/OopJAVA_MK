package homework1;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Players players = new Players();

        players.AddPlayer(new Tank("Tank1"));
        players.AddPlayer(new Tank("Tank2"));
        players.AddPlayer(new Plane("Plane1"));

        while (players.GetAlive()) {

            for (Player player : players.GetPlayers()) {
                System.out.println(player);
            }

            Thread.sleep(1000);

        }
        System.out.println("ИГРА ОКОНЧЕНА");
        for (Player player : players.GetPlayers()) {
            System.out.println(player);
        }

    }
}
