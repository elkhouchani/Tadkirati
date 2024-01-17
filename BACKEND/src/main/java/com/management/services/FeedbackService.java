package com.management.services;

import com.management.entities.Feedback;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FeedbackService {

    Feedback saveFeedback(Feedback Feedback);
    Feedback updateFeedback(Feedback Feedback);
    Feedback getFeedbackById(Long id);
    List<Feedback> getAllFeedbacks();
    void deleteFeedbackById(Long id);




    List<Feedback> findAllFeedbacksByIdEvent(Long idEvent);




}