
/*

package com.vinsup.fms.service;
import com.vinsup.fms.model.Checklist;
import com.vinsup.fms.model.User;
import com.vinsup.fms.repository.ChecklistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChecklistService {

    private final ChecklistRepository checklistRepository;

    public ChecklistService(ChecklistRepository checklistRepository) {
        this.checklistRepository = checklistRepository;
    }

    public Checklist createChecklist(Checklist checklist) {
        return checklistRepository.save(checklist);
    }

    public List<Checklist> getChecklistsByManager(User manager) {
        return checklistRepository.findByManager(manager);
    }
} 
*/ 