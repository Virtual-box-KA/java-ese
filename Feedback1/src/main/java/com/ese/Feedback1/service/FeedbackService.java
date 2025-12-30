package com.ese.Feedback1.service;

import com.ese.Feedback1.model.Feedback;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class FeedbackService {

    private final Map<Long, Feedback> feedbackStore = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    // CREATE
    public Feedback createFeedback(Feedback feedback) {
        Long id = idCounter.getAndIncrement();
        feedback.setId(id);
        feedbackStore.put(id, feedback);
        return feedback;
    }

    // READ ALL
    public List<Feedback> getAllFeedbacks() {
        return new ArrayList<>(feedbackStore.values());
    }

    // UPDATE
    public Feedback updateFeedback(Long id, Feedback feedback) {
        if (!feedbackStore.containsKey(id)) {
            return null;
        }
        feedback.setId(id);
        feedbackStore.put(id, feedback);
        return feedback;
    }

    // DELETE
    public boolean deleteFeedback(Long id) {
        return feedbackStore.remove(id) != null;
    }
}
