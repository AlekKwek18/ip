import java.util.ArrayList;
import java.util.Scanner;

public class SilverWolf {
    // using arraylist
    private static ArrayList<Todo> list = new ArrayList<>();
    // prints the line
    private static void printDivider() {
        System.out.println("____________________________________________________________");
    }
    // output the list
    private static void outputList(){
        int index = 1;
        for(Todo t : list){
            System.out.println(index + "[" + t.type() + "]" + "["+t.getStatusIcon()+"] "+t.getDescription());
            index++;
        }
    }

    public static void main(String[] args) {
        // initialize the scanner to read user input

        String logo = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⡴⠶⠒⠋⠉⠉⠉⠛⠓⠶⡶⠶⠒⠒⠲⠶⠶⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⡴⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⢶⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⠾⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠶⠦⢤⣀⡀⠉⠻⢦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠳⢦⣄⠙⣷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⠟⠁⢀⡤⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⢿⡿⣷⡂⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡾⠁⢀⡔⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢾⣷⡤⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⠟⠀⢠⠏⠀⠀⠀⠀⡄⠀⠀⠀⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⣿⡀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⠏⠀⢰⠃⠀⠀⠀⢠⣾⠁⠀⠀⠀⣸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡀⠀⠀⠀⠀⠀⠀⠀⢄⠀⠀⠀⠀⠀⠀⠀⠘⢷⡀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡟⠀⢠⡇⠀⠀⠀⣰⢿⠇⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡄⠀⠀⠀⠀⢧⠀⠀⠀⠀⠀⠀⠀⠈⣧⠀⠀⠀⠀⠀⠀⠀⠈⢿⡄⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⠁⠀⣾⠀⠀⠀⢠⢏⡏⢀⡆⠀⢀⡴⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢱⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⢸⡀⠀⠀⠀⠀⠀⠀⠀⠈⣷⠀⠀⠀⠀\n" +
                "⣿⣿⣶⡤⣀⠀⠀⢀⡴⣺⣿⡀⠀⡇⠀⠀⠀⡟⢸⣇⡞⠀⣴⠏⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⡆⠀⢸⠀⢸⡄⠀⠀⠀⠀⠀⠀⠀⠈⡇⠀⠀⠀⠀⠀⠀⠀⠀⠘⣧⠀⠀⠀\n" +
                "⠻⣿⣎⠙⠳⢯⣟⡵⠛⠉⠛⢷⣼⣃⡀⠀⢸⠁⢸⡝⢠⡾⢥⣄⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⡄⢸⠀⢸⠃⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⡀⠀⠀\n" +
                "⠀⠈⢿⣷⡀⠀⠀⠀⠀⢸⠀⠈⠻⣿⡄⠀⣾⠀⣿⢠⠏⠀⡄⠉⠻⢾⡆⠀⠀⠀⡄⠀⠀⠀⠀⠀⠀⣿⢳⡟⠀⣾⠀⠀⠀⡁⠀⠀⠀⠀⠀⠁⠀⡄⠀⠀⠀⠀⢶⠀⠀⠘⣇⠀⠀\n" +
                "⠀⠀⠀⠹⣿⣦⠀⠀⣠⣾⣶⣦⣄⡈⢣⡀⣿⠀⣷⣯⣤⣾⣿⣄⡀⠀⢿⡀⠀⠸⣅⠀⠀⠀⠀⠀⠀⢹⣼⠃⢠⡏⠀⠀⠀⡄⠀⠀⠀⠀⠀⡆⠀⡇⠀⠀⠀⠀⢸⣧⠀⠀⣿⠀⠀\n" +
                "⠀⠀⠀⠀⠈⢺⣷⣞⡿⣿⢀⠀⢸⠺⡅⠓⣿⠀⣿⣿⣿⣿⣿⣿⣿⣷⣜⢷⡀⠀⣿⣆⠀⠀⠀⠀⠀⢸⡟⠀⡾⣇⠀⠀⢀⡇⠀⠀⠀⠀⠀⡇⢸⠁⢀⣠⣤⡀⢸⡿⣇⠀⢸⡄⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠈⠉⠀⣿⢸⣆⠈⣇⣷⠀⢹⠀⡿⠋⠁⢰⠟⠀⣾⠙⢻⣷⡻⣦⣻⡙⢷⣄⠀⣀⠀⡼⠁⣼⠃⢹⡆⠀⣼⣧⠀⠀⠀⢀⣤⣇⣯⣴⡿⠛⣾⠁⢸⠃⣿⠀⢸⡇⠀\n" +
                "⠀⠀⠀⠀⠀⢠⣤⣖⣲⣿⠟⢈⣙⣻⢹⣇⠈⣇⣷⠀⠀⣿⠀⠁⢿⣀⣸⢻⠁⠈⠉⠁⠙⠛⠳⢽⡿⢁⣾⣁⣴⣿⣧⣾⣥⣿⠀⠀⢀⣞⡼⠫⢚⣉⡀⠀⠿⠶⠾⠿⠿⢶⣾⣷⣏\n" +
                "⠀⠀⠀⠀⠀⠈⠻⣿⣦⣄⣀⡿⠉⣿⠈⠹⣆⠹⣿⡄⠀⢹⡄⠒⠀⠉⠡⡿⠀⠀⠀⠀⠀⠀⢀⣾⣷⡿⠿⠿⠿⠿⣿⣿⣿⣿⠀⢀⠎⢸⡧⠉⢩⣽⠇⠀⠀⣀⣤⣴⣾⣿⢹⡇⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⢠⡿⠉⠙⠁⠀⡟⢧⣀⠙⢷⣹⣷⡀⠀⠛⠒⠦⠖⠚⠁⢀⣀⣘⣀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠄⣀⠙⡋⣇⣴⠋⢀⡾⠁⠀⣼⣛⣤⠶⠛⣽⡿⠋⠀⣿⣼⠁⠀\n" +
                "⠀⠀⠀⠀⠀⠀⢀⡾⠁⠀⠀⠀⡼⣱⢰⣿⣿⣟⣿⡛⠃⠀⠀⠀⠀⠀⠀⠀⠀⣏⠉⠈⠉⢹⠀⠀⠀⠀⠀⠐⠃⠜⠡⠞⠀⢩⡏⣠⠟⠀⣠⣾⠙⠋⠀⠀⣰⡏⣧⠀⠀⣿⠟⠀⠀\n" +
                "⠀⠀⠀⠀⠀⢀⡾⠁⠀⠀⢠⡞⣡⠇⠀⠛⠛⠹⣾⣿⡷⣤⣀⠀⠀⠀⠀⠀⠀⠸⡄⠀⠀⣸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣾⡵⠃⣠⣾⡯⣾⠘⠀⠀⣠⣿⡀⢿⠀⠀⠉⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⣼⠁⠀⢀⡴⣻⢠⡯⠖⠛⠉⠉⠛⠺⣿⣿⣆⠉⠛⠷⣶⣤⣤⣤⣀⣻⣄⣠⡇⢀⣀⣀⣀⣀⣠⣤⣤⠶⣻⣟⣫⣴⠟⣹⠀⢉⡟⠀⠀⣰⠟⠀⠙⢾⡆⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⢰⡇⠀⡴⠋⢀⣿⠟⢷⣄⣀⠀⠀⠀⠀⠈⠙⢿⣧⠀⠀⠘⡻⣶⢿⠹⠿⣿⣿⣿⢿⣟⣿⣿⡟⠁⠀⠈⠳⣏⠉⢸⣽⢠⠏⠀⣸⠃⣠⣾⠋⠀⠀⠀⠀⠙⠶⣄⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠘⣧⢰⣧⣀⣼⠃⢠⡟⠀⠀⠑⠲⠆⠀⠀⠀⢸⡟⡇⠀⢀⣧⠘⣿⣧⣀⡀⠀⢀⣿⣽⣿⣿⠁⠀⠀⢀⣠⣞⣿⣾⣿⣿⠀⢰⣯⡶⣿⡟⠀⠀⠀⠀⠀⠀⠀⠈⢷⡄⠀\n" +
                "⠀⠀⠀⠀⠀⠹⣦⠇⣼⠃⠀⠸⣦⠀⠀⠀⠀⠀⠀⠀⢀⣾⢧⡇⣠⡾⢹⠀⣿⡉⠁⠳⣿⣿⣽⣿⣿⣿⣿⣄⡴⣫⣿⣿⣿⣽⣿⡿⣗⡮⠥⣾⡿⠁⠀⢰⣤⣀⠀⠀⠀⠀⠀⠹⡆\n" +
                "⠀⠀⠀⠀⠀⠀⠈⢻⠇⠀⠀⠀⠘⢧⣀⡀⠀⠀⣀⣴⢟⡟⢸⣿⡟⢡⣯⠾⠃⠹⣄⠀⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣽⣿⣿⡉⠉⠁⠀⠀⠀⣸⠃⠙⠳⣤⡀⠀⠀⠀⣿\n" +
                "⠀⠀⠀⠀⠀⠀⠀⢸⡄⠀⠀⠀⠀⢸⠻⣍⣩⠽⠋⣡⠏⠀⠸⣿⣇⠀⠈⠳⣶⡶⠈⢦⡀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢿⣿⣿⣿⣿⡂⠀⠀⠀⣴⠏⠀⠀⠀⣸⠳⡄⠀⢠⠟\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠈⠛⠶⣤⣤⣤⣬⣷⣦⣤⣠⠜⠃⠀⠀⠀⢈⣟⣷⠒⣿⠉⠀⠀⠀⠱⣜⣿⣿⣿⣿⣿⣿⣿⣿⣯⣿⣧⡳⣽⣿⣿⣿⣿⣦⡴⠟⠃⠀⠀⣀⡴⠋⠀⣿⣴⠟⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠷⠤⠤⠤⠤⠴⠟⠛⠛⠛⠛⠛⠶⠶⠾⠭⠿⠿⢿⣿⠿⠟⠻⠿⠿⠟⠋⠻⠟⠛⠛⠛⠉⠉⠁⠀⠀⠀⠀⠀⠙⠛⠛⠛⠉⠀⠀⠀";
        System.out.println(logo);
        System.out.println("____________________________________________________________\n" +
                " Hello! I'm Silver Wolf\n" +
                " What can I help you with?\n" +
                "____________________________________________________________\n");
        Scanner scanner = new Scanner(System.in);
        while(true) {
            // reading the user input
            String input = scanner.nextLine();

            // exit if the user types "bye" or "list"
            if (input.equals("bye")) {
                printDivider();
                System.out.println(" Till we meet again! May this journey lead us starward!");
                printDivider();
                break;
                // display the list that the user entered
            } else if (input.equals("list")) {
                printDivider();
                System.out.println("Here are the tasks in your list:");
                outputList();
                printDivider();
            } else if (input.startsWith("mark ")){
                //extract the input number
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                // retrieve the specific task from the arraylist
                Todo specificTask = list.get(index);
                // mark the task as done
                specificTask.markAsDone();
                printDivider();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("[" + specificTask.type() + "]["+specificTask.getStatusIcon()+"] " + specificTask.getDescription());
                printDivider();
            } else if (input.startsWith("unmark ")){
                //extract the input number
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                // retrieve the specific task from the arraylist
                Todo specificTask = list.get(index);
                // mark the task as undone
                specificTask.unmarkTask();
                printDivider();
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println("[" + specificTask.type() + "]["+specificTask.getStatusIcon()+"] " + specificTask.getDescription());
                printDivider();
            } else if (input.startsWith("todo")){
                //taking in the input
                String descrption = input.substring(5);

                printDivider();
                System.out.println("Got it. I've added this task:");
                Todo newTodo = new Todo(descrption);
                list.add(newTodo);
                System.out.println(" ["+newTodo.type()+"] ["+newTodo.getStatusIcon()+"] "+ newTodo.getDescription());
                System.out.println("Now you have " + list.size() + " tasks in the list.");

                printDivider();

            } else if (input.startsWith("deadline")){
                //TODO

            } else if (input.startsWith("event")){
                //TODO

            }
            else {
                // echo the input back to the user
                printDivider();
                System.out.println("added: " + input);
                list.add(new Todo(input));
                printDivider();
            }
        }

        // close the scanner
        scanner.close();

    }
}
