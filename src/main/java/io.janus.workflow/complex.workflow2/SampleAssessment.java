package io.janus.workflow.complex.workflow2;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

@ApplicationScoped
public class SampleAssessment {
    public WorkflowOptions execute(String sampleText) {
        WorkflowOptions workflowOptions = new WorkflowOptions();
        if (null != sampleText && !sampleText.isEmpty()) { // basic check on the user's input "sampleText" to mimic an assessment
            workflowOptions.setCurrentVersion(new WorkflowOption("complex.workflow2", "complex.workflow2"));
            return workflowOptions;
        }
        return workflowOptions;
    }
}
