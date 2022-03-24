package site.metacoding.test.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import site.metacoding.test.domain.post.BoardTbl;
import site.metacoding.test.domain.post.BoardTblRepository;

@RequiredArgsConstructor
@Controller
public class BoardTblController {

    private final BoardTblRepository boardTblRepository; // 생성자 주입

    @GetMapping("/search")
    public String search(@RequestParam(defaultValue = "") String keyword, Model model) { // keyword=스프링

        List<BoardTbl> boards = boardTblRepository.mSearch(keyword);
        // System.out.println("크기 : " + boards.size());
        model.addAttribute("boards", boards);
        return "list";
    }
}
