package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        double sum = 0;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                count++;
            }
        }
        return count == 0 ? 0 : sum / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            double average = pupil.subjects().isEmpty() ? 0 : sum / pupil.subjects().size();
            rsl.add(new Label(pupil.name(), average));
        }
        return rsl;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        List<Label> rsl = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            double average = pupils.isEmpty() ? 0 : entry.getValue() / (double) pupils.size();
            rsl.add(new Label(entry.getKey(), average));
        }
        return rsl;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            list.add(new Label(pupil.name(), sum));
        }
        if (list.isEmpty()) {
            return null;
        }
        Collections.sort(list);
        return list.get(list.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        List<Label> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(new Label(entry.getKey(), entry.getValue()));
        }
        if (list.isEmpty()) {
            return null;
        }
        Collections.sort(list);
        return list.get(list.size() - 1);
    }
}