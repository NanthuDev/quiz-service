package com.nkspring.quiz_service.questionController;



import com.nkspring.quiz_service.model.QuestionWrapper;
import com.nkspring.quiz_service.model.QuizDto;
import com.nkspring.quiz_service.model.Response;
import com.nkspring.quiz_service.questionService.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
      return quizService.createQuiz(quizDto.getCategoryName(),quizDto.getNumOfQ(),quizDto.getTitle());
//        return new ResponseEntity<>("Quiz", HttpStatus.OK);
    }

    @GetMapping("get/{Id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer Id){

       return quizService.getQuestionsById(Id);

    };

    @PostMapping("submit/{id}")
    public  ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id,responses);
    }


}
