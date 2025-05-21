package org.example.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks = new HashSet<>();
    private Set<Task> bobsTasks = new HashSet<>();
    private Set<Task> carolsTasks = new HashSet<>();
    private Set<Task> unassignedTasks = new HashSet<>();

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String name) {
        if (name.equals("ann")) {
            return annsTasks;
        } else if (name.equals("bob")) {
            return bobsTasks;
        } else if (name.equals("carol")) {
            return carolsTasks;
        } else if (name.equals("all")) {
            return unassignedTasks;
        } else {
            return null;
        }
    }

    public Set<Task> getUnion(Set<Task>... sets) {
        Set<Task> allTasks = new HashSet<>();
        for(Set<Task> set : sets) {
            allTasks.addAll(set);
        }
        return allTasks;
    }

    public Set<Task> getIntersection(Set<Task> set1, Set<Task> set2) {
        Set<Task> intersectTasks = new HashSet<>(set1);
        intersectTasks.retainAll(set2);
        return intersectTasks;
    }

    public Set<Task> getDifferences(Set<Task> set1, Set<Task> set2) {
        Set<Task> differenceTasks = new HashSet<>(set1);
        differenceTasks.removeAll(set2);
        return differenceTasks;
    }
}
