package com.example.upload;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class IssueBulk {
    private List<Issue> issueUpdates;
}
