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

    // todoをseqでsort
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

    // todoをseqで逆sort
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

    // doneをseqでsort
    @GetMapping("/{mid}/todos/sort/done-seq")
    String sortByDoneSeq(@PathVariable String mid, @ModelAttribute(name = "ToDoForm") ToDoForm form, Model model) {
        Member m = mService.getMember(mid);
        model.addAttribute("member", m);
        model.addAttribute("ToDoForm", form);
        List<ToDo> todos = tService.getToDoList(mid);
        model.addAttribute("todos", todos);
        List<ToDo> dones = tService.getDoneList(mid);
        dones.sort(Comparator.comparing(ToDo::getSeq, Comparator.nullsLast(Comparator.naturalOrder())));
        model.addAttribute("dones", dones);
        return "list";
    }

    // doneをseqで逆sort
    @GetMapping("/{mid}/todos/reverse-sort/done-seq")
    String reverseSortByDoneSeq(@PathVariable String mid, @ModelAttribute(name = "ToDoForm") ToDoForm form, Model model) {
        Member m = mService.getMember(mid);
        model.addAttribute("member", m);
        model.addAttribute("ToDoForm", form);
        List<ToDo> todos = tService.getToDoList(mid);
        model.addAttribute("todos", todos);
        List<ToDo> dones = tService.getDoneList(mid);
        dones.sort(Comparator.comparing(ToDo::getSeq, Comparator.reverseOrder()));
        model.addAttribute("dones", dones);
        return "list";
    }

    // todoをtitleでソート
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

    // todoをtitleで逆ソート
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

    // doneをtitleでソート
    @GetMapping("/{mid}/todos/sort/done-title")
    String sortByDoneTitle(@PathVariable String mid, @ModelAttribute(name = "ToDoForm") ToDoForm form, Model model) {
        Member m = mService.getMember(mid);
        model.addAttribute("member", m);
        model.addAttribute("ToDoForm", form);
        List<ToDo> todos = tService.getToDoList(mid);
        model.addAttribute("todos", todos);
        List<ToDo> dones = tService.getDoneList(mid);
        dones.sort(Comparator.comparing(ToDo::getTitle, Comparator.nullsLast(Comparator.naturalOrder())));
        model.addAttribute("dones", dones);
        return "list";
    }

    // doneをtitleで逆ソート
    @GetMapping("/{mid}/todos/reverse-sort/done-title")
    String reverseSortByDoneTitle(@PathVariable String mid, @ModelAttribute(name = "ToDoForm") ToDoForm form, Model model) {
        Member m = mService.getMember(mid);
        model.addAttribute("member", m);
        model.addAttribute("ToDoForm", form);
        List<ToDo> todos = tService.getToDoList(mid);
        model.addAttribute("todos", todos);
        List<ToDo> dones = tService.getDoneList(mid);
        dones.sort(Comparator.comparing(ToDo::getTitle, Comparator.reverseOrder()));
        model.addAttribute("dones", dones);
        return "list";
    }    

    // todoをdateでソート
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

    // todoをdateで逆ソート
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

    // doneをdateでソート
    @GetMapping("/{mid}/todos/sort/done-date")
    String sortByDoneDate(@PathVariable String mid, @ModelAttribute(name = "ToDoForm") ToDoForm form, Model model) {
        Member m = mService.getMember(mid);
        model.addAttribute("member", m);
        model.addAttribute("ToDoForm", form);
        List<ToDo> todos = tService.getToDoList(mid);
        model.addAttribute("todos", todos);
        List<ToDo> dones = tService.getDoneList(mid);
        dones.sort(Comparator.comparing(ToDo::getCreatedAt, Comparator.nullsLast(Comparator.naturalOrder())));
        model.addAttribute("dones", dones);
        return "list";
    }

    // doneをdateで逆ソート
    @GetMapping("/{mid}/todos/reverse-sort/done-date")
    String reverseSortByDoneDate(@PathVariable String mid, @ModelAttribute(name = "ToDoForm") ToDoForm form, Model model) {
        Member m = mService.getMember(mid);
        model.addAttribute("member", m);
        model.addAttribute("ToDoForm", form);
        List<ToDo> todos = tService.getToDoList(mid);
        model.addAttribute("todos", todos);
        List<ToDo> dones = tService.getDoneList(mid);
        dones.sort(Comparator.comparing(ToDo::getCreatedAt, Comparator.reverseOrder()));
        model.addAttribute("dones", dones);
        return "list";
    }

    // doneをdateでソート
    @GetMapping("/{mid}/todos/sort/done")
    String sortByDone(@PathVariable String mid, @ModelAttribute(name = "ToDoForm") ToDoForm form, Model model) {
        Member m = mService.getMember(mid);
        model.addAttribute("member", m);
        model.addAttribute("ToDoForm", form);
        List<ToDo> todos = tService.getToDoList(mid);
        model.addAttribute("todos", todos);
        List<ToDo> dones = tService.getDoneList(mid);
        dones.sort(Comparator.comparing(ToDo::getDoneAt, Comparator.nullsLast(Comparator.naturalOrder())));
        model.addAttribute("dones", dones);
        return "list";
    }

    // doneをdateで逆ソート
    @GetMapping("/{mid}/todos/reverse-sort/done")
    String reverseSortByDone(@PathVariable String mid, @ModelAttribute(name = "ToDoForm") ToDoForm form, Model model) {
        Member m = mService.getMember(mid);
        model.addAttribute("member", m);
        model.addAttribute("ToDoForm", form);
        List<ToDo> todos = tService.getToDoList(mid);
        model.addAttribute("todos", todos);
        List<ToDo> dones = tService.getDoneList(mid);
        dones.sort(Comparator.comparing(ToDo::getDoneAt, Comparator.reverseOrder()));
        model.addAttribute("dones", dones);
        return "list";
    }
}
