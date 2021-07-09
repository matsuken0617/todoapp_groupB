package jp.ac.kobe_u.cs.itspecialist.todoapp.controller;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import jp.ac.kobe_u.cs.itspecialist.todoapp.dto.ToDoForm;
import jp.ac.kobe_u.cs.itspecialist.todoapp.entity.Member;
import jp.ac.kobe_u.cs.itspecialist.todoapp.entity.ToDo;
import jp.ac.kobe_u.cs.itspecialist.todoapp.service.MemberService;
import jp.ac.kobe_u.cs.itspecialist.todoapp.service.ToDoService;

@Controller
public class ToDoSortController {
    @Autowired
    MemberService mService;
    @Autowired
    ToDoService tService;

    @GetMapping("/{mid}/todos/sort/seq")
    String sortBySeq(@PathVariable String mid, @ModelAttribute(name = "ToDoForm") ToDoForm form, Model model) {
        Member m = mService.getMember(mid);
        model.addAttribute("member", m);
        model.addAttribute("ToDoForm", form);
        List<ToDo> todos = tService.getToDoList(mid);
        todos.sort(Comparator.comparing(ToDo::getSeq, Comparator.nullsLast(Comparator.naturalOrder())));
        model.addAttribute("todos", todos);
        List<ToDo> dones = tService.getDoneList(mid);
        model.addAttribute("dones", dones);
        return "list";
    }

    @GetMapping("/{mid}/todos/reverse-sort/seq")
    String reverseSortBySeq(@PathVariable String mid, @ModelAttribute(name = "ToDoForm") ToDoForm form, Model model) {
        Member m = mService.getMember(mid);
        model.addAttribute("member", m);
        model.addAttribute("ToDoForm", form);
        List<ToDo> todos = tService.getToDoList(mid);
        todos.sort(Comparator.comparing(ToDo::getSeq, Comparator.reverseOrder()));
        model.addAttribute("todos", todos);
        List<ToDo> dones = tService.getDoneList(mid);
        model.addAttribute("dones", dones);
        return "list";
    }

    @GetMapping("/{mid}/todos/sort/title")
    String sortByTitle(@PathVariable String mid, @ModelAttribute(name = "ToDoForm") ToDoForm form, Model model) {
        Member m = mService.getMember(mid);
        model.addAttribute("member", m);
        model.addAttribute("ToDoForm", form);
        List<ToDo> todos = tService.getToDoList(mid);
        todos.sort(Comparator.comparing(ToDo::getTitle, Comparator.nullsLast(Comparator.naturalOrder())));
        model.addAttribute("todos", todos);
        List<ToDo> dones = tService.getDoneList(mid);
        model.addAttribute("dones", dones);
        return "list";
    }

    @GetMapping("/{mid}/todos/reverse-sort/title")
    String reverseSortByTitle(@PathVariable String mid, @ModelAttribute(name = "ToDoForm") ToDoForm form, Model model) {
        Member m = mService.getMember(mid);
        model.addAttribute("member", m);
        model.addAttribute("ToDoForm", form);
        List<ToDo> todos = tService.getToDoList(mid);
        todos.sort(Comparator.comparing(ToDo::getTitle, Comparator.reverseOrder()));
        model.addAttribute("todos", todos);
        List<ToDo> dones = tService.getDoneList(mid);
        model.addAttribute("dones", dones);
        return "list";
    }

    @GetMapping("/{mid}/todos/sort/date")
    String sortByDate(@PathVariable String mid, @ModelAttribute(name = "ToDoForm") ToDoForm form, Model model) {
        Member m = mService.getMember(mid);
        model.addAttribute("member", m);
        model.addAttribute("ToDoForm", form);
        List<ToDo> todos = tService.getToDoList(mid);
        todos.sort(Comparator.comparing(ToDo::getCreatedAt, Comparator.nullsLast(Comparator.naturalOrder())));
        model.addAttribute("todos", todos);
        List<ToDo> dones = tService.getDoneList(mid);
        model.addAttribute("dones", dones);
        return "list";
    }

    @GetMapping("/{mid}/todos/reverse-sort/date")
    String reverseSortByDate(@PathVariable String mid, @ModelAttribute(name = "ToDoForm") ToDoForm form, Model model) {
        Member m = mService.getMember(mid);
        model.addAttribute("member", m);
        model.addAttribute("ToDoForm", form);
        List<ToDo> todos = tService.getToDoList(mid);
        todos.sort(Comparator.comparing(ToDo::getCreatedAt, Comparator.reverseOrder()));
        model.addAttribute("todos", todos);
        List<ToDo> dones = tService.getDoneList(mid);
        model.addAttribute("dones", dones);
        return "list";
    }
}
