import java.util.*;    

public class SnakeGame {
    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);

        // Snake (list of coordinates)
        ArrayList<int[]> snake = new ArrayList<>();
        snake.add(new int[]{10, 10});
        snake.add(new int[]{10, 9});

        String direction = "right";

        while (true) {

            // clear screen (fake)
            for (int k = 0; k < 30; k++) {
                System.out.println();
            }

            // print grid
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {

                    boolean isSnake = false;

                    // check snake body
                    //for (int[] s : snake) {

		            for (int k = 0; k < snake.size(); k++) {
   		            int[] s = snake.get(k);
                        if (i == s[0] && j == s[1]) {
                            isSnake = true;
                            break;
                        }
                    }

                    if (isSnake) System.out.print("# ");
                    else System.out.print(". ");
                }
                System.out.println();
            }

            // input (optional, doesn’t block always)
            if (in.hasNext()) {
                String dir = in.nextLine();

                if (dir.equals("w")) direction = "up";
                else if (dir.equals("s")) direction = "down";
                else if (dir.equals("a")) direction = "left";
                else if (dir.equals("d")) direction = "right";
            }

            // movement
            int[] head = snake.get(0);
            int[] newHead = new int[2];

            if (direction.equals("right")) {
                newHead[0] = head[0];
                newHead[1] = head[1] + 1;
            } else if (direction.equals("left")) {
                newHead[0] = head[0];
                newHead[1] = head[1] - 1;
            } else if (direction.equals("up")) {
                newHead[0] = head[0] - 1;
                newHead[1] = head[1];
            } else if (direction.equals("down")) {
                newHead[0] = head[0] + 1;
                newHead[1] = head[1];
            }

            // update snake
            snake.add(0, newHead);
            snake.remove(snake.size() - 1);

            // delay
            int speed = 200;
            Thread.sleep(speed);
        }
    }
}