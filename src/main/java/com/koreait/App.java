package com.koreait;

import java.util.Scanner;

public class App {

    private Scanner sc;
    private TodoController todoController;
    private SystemController systemController;

    public App() {
        sc = new Scanner(System.in);
         todoController = new TodoController();
        systemController = new SystemController();
    }

    public void run() {
        System.out.println("Todo App 시작");
            while (true) {
                System.out.println("명령) ");
                String cmd = sc.nextLine().trim();
                if (cmd.equals("exit")) {
                    systemController.exit();
                    break;
                }
                else if (cmd.equals("add")) {
                    todoController.add();
                } else if (cmd.equals("list")) {
                    todoController.list();
                } else if (cmd.equals("del")) {
                    todoController.del();
                } else if (cmd.equals("modify")) {
                    todoController.modify();
                }
            }
        sc.close();
    }
}
