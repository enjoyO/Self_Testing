package com.controller;

import com.models.Answer;
import com.models.Student;
import com.models.TestPaper;
import com.service.AnswerService;
import com.service.QuestionBankService;
import com.service.StudentService;
import com.service.TestPaperService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AnswerController {
    private AnswerService answerService;
    private QuestionBankService questionBankService;
    private TestPaperService testPaperService;
    private StudentService studentService;

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public TestPaperService getTestPaperService() {
        return testPaperService;
    }

    public void setTestPaperService(TestPaperService testPaperService) {
        this.testPaperService = testPaperService;
    }

    public QuestionBankService getQuestionBankService() {
        return questionBankService;
    }

    public void setQuestionBankService(QuestionBankService questionBankService) {
        this.questionBankService = questionBankService;
    }

    public AnswerService getAnswerService() {
        return answerService;
    }

    public void setAnswerService(AnswerService answerService) {
        this.answerService = answerService;
    }

    @RequestMapping("/addAnswer")
    public void addAnswer(Answer answer, HttpServletRequest request, HttpServletResponse response) throws Exception{
        int paperId = answer.getPaperId();
        TestPaper paper = testPaperService.modifyPaper(paperId);
        String questionIds = paper.getQuestionId();
        String[] questionId = questionIds.split(",");
        int[] questionIdInt = new int[questionId.length];
        for (int k = 0; k < questionId.length; k++) {
            questionIdInt[k] = Integer.parseInt(questionId[k]);
        }
        String[] questionAnswers = new String[questionId.length];
        for (int i = 0; i < questionAnswers.length; i++) {
            questionAnswers[i] = questionBankService.modifyQuestion(questionIdInt[i]).getAnswer();
        }
        String[] studentAnswers = answer.getStudentAnswer().split(",");
        boolean[] bool = new boolean[questionAnswers.length];
        for (int j = 0; j < questionAnswers.length; j++) {
            if (studentAnswers[j].equals(questionAnswers[j])) {
                bool[j] = true;
            } else {
                bool[j] = false;
            }
        }
        request.setAttribute("bool", bool);
        request.setAttribute("studentAnswers", studentAnswers);
        request.setAttribute("questionAnswers", questionAnswers);
        int everyMark = testPaperService.modifyPaper(paperId).getScore();
        int score = 0;
        for (int s = 0; s < bool.length; s++) {
            if (bool[s] == true) {
                score += everyMark;
            }
        }
        answer.setScore(score);
        request.setAttribute("score", score);
        response.setContentType("text");
        response.getWriter().print(score);
        answerService.addAnswer(answer);
    }

    @RequestMapping("/findByStuId")
    public String findByStuId(@RequestParam(value = "stuId") int stuId,
                              HttpServletRequest request){
        List<Answer> list = answerService.findByStudentId(stuId);
        List<Student> list1 = new ArrayList<>();
        List<TestPaper> list2 = new ArrayList<>();
        for(int i = 0;i<list.size();i++){
            list1.add(studentService.modify(list.get(i).getStudentId()));
            list2.add(testPaperService.modifyPaper(list.get(i).getPaperId()));
        }
        request.setAttribute("answers",list);
        request.setAttribute("students",list1);
        request.setAttribute("papers",list2);
        return "right（成绩单）.jsp";
    }

    @RequestMapping("/examState")
    public void examState(HttpServletRequest request){
        int stuId = 1;
        List<Integer> list = answerService.examState(stuId);
        request.setAttribute("paperIds",list);
    }

    @RequestMapping("/getAllAnswer")
    public String getAllAnswer(HttpServletRequest request){
        List<Answer> list = answerService.getAllAnswers();
        List<Student> list1 = new ArrayList<>();
        List<TestPaper> list2 = new ArrayList<>();
        for(int i = 0;i<list.size();i++){
            list1.add(studentService.modify(list.get(i).getStudentId()));
            list2.add(testPaperService.modifyPaper(list.get(i).getPaperId()));
        }
        request.setAttribute("answers",list);
        request.setAttribute("students",list1);
        request.setAttribute("papers",list2);
        return "right（成绩单）.jsp";
    }
}
