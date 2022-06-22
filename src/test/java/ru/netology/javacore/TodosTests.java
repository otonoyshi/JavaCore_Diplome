package ru.netology.javacore;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TodosTests {

    // ваши тесты для класса Todos
    Todos todos = new Todos();
    final List<String> taskList = new ArrayList<>();
    final String task = "Что-то делать";

    public static int i = 1;

    @BeforeAll
    public static void started() {
        System.out.println("Testing started");
    }

    @BeforeEach
    public void startAnyTeсst() {
        System.out.println("Test " + i + " started");
    }

    @AfterEach
    public void endAnyTecst() {
        System.out.println("Test " + i + " ended");
        i++;
    }

    @AfterAll
    public static void ended() {
        System.out.println("Testing ended");
    }

    @Test
    public void testAddTask() {
        taskList.add(task);
        todos.addTask(task);
        assertEquals(taskList.toString(), todos.tasks.toString());
    }

    @Test
    public void testRemoveTask() {
        //act
        todos.addTask(task);
        todos.removeTask(task);

        //assert
        assertTrue(todos.tasks.isEmpty());
    }

    @Test
    public void testGetAllTasks() {

        String expected = "Бег Отдых Танцы Что-то делать ";
        todos.addTask(task);
        todos.addTask("Танцы");
        todos.addTask("Отдых");
        todos.addTask("Бег");
        assertEquals(todos.getAllTasks(), expected);

    }
}
