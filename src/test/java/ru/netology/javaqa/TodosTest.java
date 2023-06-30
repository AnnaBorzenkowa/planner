package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(10, "Позвонить");

        String[] subtasks = {"milk", "bread", "eggs"};
        Epic epic = new Epic(48, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldFindWordInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(10, "Позвонить");

        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindWordInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(10, "Позвонить");

        boolean expected = false;
        boolean actual = simpleTask.matches("Купить");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldFindWordInSEpic() {
        String[] subtasks = {"milk", "bread", "eggs"};
        Epic epic = new Epic(48, subtasks);


        boolean expected = true;
        boolean actual = epic.matches("milk");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindWordInSEpic() {
        String[] subtasks = {"milk", "bread", "eggs"};
        Epic epic = new Epic(48, subtasks);


        boolean expected = false;
        boolean actual = epic.matches("Позвонить");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindWordInSMeetingProject() {
        Meeting meeting = new Meeting( 555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");


        boolean expected = true;
        boolean actual = meeting.matches("НетоБанка");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindWordInSMeetingTopic() {
        Meeting meeting = new Meeting( 555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");


        boolean expected = true;
        boolean actual = meeting.matches("приложения");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldТNotFindWordInSMeetingTopic() {
        Meeting meeting = new Meeting( 555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");


        boolean expected = false;
        boolean actual = meeting.matches("bread");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindInTaskTwo() {
        SimpleTask simpleTask = new SimpleTask(10, "eggs");

        String[] subtasks = {"milk", "bread", "eggs"};
        Epic epic = new Epic(48, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask,epic};
        Task[] actual = todos.search("eggs");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindInTaskOne() {
        SimpleTask simpleTask = new SimpleTask(10, "Позвонить");

        String[] subtasks = {"milk", "bread", "eggs"};
        Epic epic = new Epic(48, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic};
        Task[] actual = todos.search("eggs");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindInTask() {
        SimpleTask simpleTask = new SimpleTask(10, "eggs");

        String[] subtasks = {"milk", "bread", "eggs"};
        Epic epic = new Epic(48, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("banana");
        Assertions.assertArrayEquals(expected, actual);
    }
}