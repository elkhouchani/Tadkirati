package com.management.restcontrollers;


import com.management.entities.Feedback;

import com.management.services.FeedbackService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class FeedbackRestController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/feedbacks")
    public List<Feedback> getAllFeedbacks() {return feedbackService.getAllFeedbacks();}

    @GetMapping("/feedbacks/{feedbackId}")
    public Feedback getFeedbackById(@PathVariable("feedbackId") Long feedbackId) {
        return feedbackService.getFeedbackById(feedbackId);
    }


    @PostMapping("/feedbacks/save")
    public Feedback createFeedback(@RequestBody Feedback feedback) {
        return feedbackService.saveFeedback(feedback);
    }

    @PutMapping("/feedbacks/update")
    public Feedback updateFeedback(@RequestBody Feedback feedback) {
        return feedbackService.updateFeedback(feedback);
    }

    @DeleteMapping("/feedbacks/{feedbackId}")
    public void deleteFeedbackById(@PathVariable("feedbackId") Long feedbackId) {
        feedbackService.deleteFeedbackById(feedbackId);
    }
}