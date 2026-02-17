package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.TaskEntity;
import com.example.demo.form.TaskForm;
import com.example.demo.service.TaskService;

import lombok.RequiredArgsConstructor;

/**
 * タスク情報 Controllerクラス
 * 
 * 画面リクエストを受け取り、
 * Serviceを呼び出して処理を行うクラス
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    /** Service */
    private final TaskService service;

    /**
     * タスク一覧表示
     */
    @GetMapping
    public String list(Model model) {
        List<TaskForm> forms = service.findAll().stream().map(e -> {
            TaskForm f = new TaskForm();
            f.setTaskId(e.getTaskId());
            f.setTaskName(e.getTaskName());
            f.setTaskStatus(e.getTaskStatus());
            f.setStartDate(e.getStartDate());
            f.setEndDate(e.getEndDate());
            return f;
        }).collect(Collectors.toList());

        model.addAttribute("tasks", forms);
        return "task-list";
    }

    /**
     * 新規登録画面表示
     */
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("task", new TaskForm());
        return "task-form";
    }

    /**
     * 登録・更新処理
     */
    @PostMapping
    public String save(@Valid @ModelAttribute TaskForm form,
                       BindingResult result) {

        if (result.hasErrors()) {
            return "task-form";
        }

        TaskEntity entity = new TaskEntity();
        entity.setTaskId(form.getTaskId());
        entity.setTaskName(form.getTaskName());
        entity.setTaskStatus(form.getTaskStatus());
        entity.setStartDate(form.getStartDate());
        entity.setEndDate(form.getEndDate());

        service.save(entity);

        return "redirect:/tasks";
    }

    /**
     * 編集画面表示
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {

        TaskEntity entity = service.findById(id);

        TaskForm form = new TaskForm();
        form.setTaskId(entity.getTaskId());
        form.setTaskName(entity.getTaskName());
        form.setTaskStatus(entity.getTaskStatus());
        form.setStartDate(entity.getStartDate());
        form.setEndDate(entity.getEndDate());

        model.addAttribute("task", form);

        return "task-form";
    }

    /**
     * 削除処理
     */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/tasks";
    }
}