package com.example.upload;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Issue {
    private Fields fields;

    @Data
    @Builder
    public static class Fields {
        private Assignee assignee;
        private List<Component> components = new ArrayList<>();
        private Description description;
        private Environment environment;
        private IssueType issuetype;
        private List<String> labels;
        private Parent parent;
        private Priority priority;
        private Project project;
        private Reporter reporter;
        private Security security = null;
        private String summary;
        private TimeTracking timetracking;
        private List<Version> versions;
    }

    @Data
    @Builder
    public static class Assignee {
        private String id;
    }

    @Data
    @Builder
    public static class Component {
        private String id;
    }

    @Data
    @Builder
    public static class Content {
        private List<Content> content;
        private String text;
        private String type;
    }

    @Data
    @Builder
    public static class Environment {
        private List<Content> content;
        private String type;
        private int version;
    }

    @Data
    @Builder
    public static class FixVersion {
        private String id;
    }

    @Data
    @Builder
    public static class IssueType {
        private String id;
    }

    @Data
    @Builder
    public static class Parent {
        private String key;
    }

    @Data
    @Builder
    public static class Priority {
        private String id;
    }

    @Data
    @Builder
    public static class Project {
        private String id;
    }

    @Data
    @Builder
    public static class Reporter {
        private String id;
    }

    @Data
    @Builder
    public static class Security {
        private String id;
    }

    @Data
    @Builder
    public static class TimeTracking {
        private String originalEstimate;
        private String remainingEstimate;
    }

    @Data
    @Builder
    public static class Version {
        private String id;
    }

    @Data
    @Builder
    public static class Description {
        private List<Content> content;
        private String type;
        private int version;
    }

}

