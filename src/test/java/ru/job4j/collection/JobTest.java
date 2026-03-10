package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {

    @Test
    public void whenAscByName() {
        Comparator<Job> cmp = new JobAscByName();
        int rsl = cmp.compare(new Job("A task", 0), new Job("B task", 0));
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenAscByPriority() {
        Comparator<Job> cmp = new JobAscByPriority();
        int rsl = cmp.compare(new Job("Task", 1), new Job("Task", 2));
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenDescByName() {
        Comparator<Job> cmp = new JobDescByName();
        int rsl = cmp.compare(new Job("A task", 0), new Job("B task", 0));
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenDescByPriority() {
        Comparator<Job> cmp = new JobDescByPriority();
        int rsl = cmp.compare(new Job("Task", 1), new Job("Task", 2));
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCombinedDescNameAndPriority() {
        Comparator<Job> cmp = new JobDescByName().thenComparing(new JobDescByPriority());

        int rsl = cmp.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCombinedDescNameThenAscPriority() {
        Comparator<Job> cmp = new JobDescByName().thenComparing(new JobAscByPriority());

        Job job1 = new Job("Fix bug", 5);
        Job job2 = new Job("Fix bug", 1);

        int rsl = cmp.compare(job1, job2);
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCombinedAscNameThenDescPriority() {
        Comparator<Job> cmp = new JobAscByName().thenComparing(new JobDescByPriority());

        Job job1 = new Job("Fix bug", 1);
        Job job2 = new Job("Fix bug", 5);

        int rsl = cmp.compare(job1, job2);
        assertThat(rsl).isGreaterThan(0);
    }
}