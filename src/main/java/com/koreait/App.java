package com.koreait;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private Scanner sc;
    private ArrayList<Todo> todos;
    private long todosLastId;

    public App() {
        sc = new Scanner(System.in);
        todos = new ArrayList<>();
        todosLastId = 0;
    }

    public void run() {
        System.out.println("Todo App 시작");
            while (true) {
                System.out.println("명령) ");
                String cmd = sc.nextLine().trim();
                if (cmd.equals("exit")) break;
                else if (cmd.equals("add")) {
                    add();
                } else if (cmd.equals("list")) {
                    list();
                } else if (cmd.equals("del")) {
                    del();
                } else if (cmd.equals("modify")) {
                    modify();
                }
            }

        System.out.println("Todo App 끝");
        sc.close();
    }

    private void modify() {
        System.out.printf("수정할 할 일의 번호 : ");
        long id = Long.parseLong(sc.nextLine().trim());

        // stream
        Todo foundTodo = todos.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);

        if (foundTodo == null) {
            System.out.printf("%d번 할일은 존재하지 않습니다.\n", id);
            return;
        }

        System.out.printf("기존 할일 : %s\n", foundTodo.getContent());
        System.out.print("새 할 일 : ");
        foundTodo.setContent(sc.nextLine().trim());

        System.out.printf("%d번 할 일이 수정 되었습니다.\n", id);
    }

    private void del() {
        System.out.printf("삭제할 할일의 번호 : " );
        long id = Long.parseLong(sc.nextLine().trim());

        boolean isRemoved = todos.removeIf(todo -> todo.getId() == id);

        if (!isRemoved) {
            System.out.printf("%d번 할일은 존재하지 않습니다.\n", id);
            return;
        }
        System.out.printf("%d번 할일이 삭제되었습니다.\n",id);
    }

    private void list() {
        System.out.println("번호   /      내용     ");

//                    for(Todo todo : todos) {
//                        System.out.printf("%d   /   %s       \n", todo.getId(),todo.getContent());
//                    }

        // 람다 표현식 사용.
        todos.forEach(todo -> System.out.printf("%d   /   %s       \n", todo.getId(),todo.getContent()));
    }

    private void add() {
        long id = todosLastId + 1;
        System.out.print("할 일 : ");
        String content = sc.nextLine().trim();

        Todo todo = new Todo(id, content);
        todos.add(todo);
        todosLastId++;

        System.out.printf("%d번 todo가 생성되었습니다\n.",id);
    }
}
