package webcrawler.Models.comparators;

import webcrawler.Models.Student;

import java.util.Comparator;

public class AgeComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1,Student o2)
    {
        int cmp=(o1.getAge()>o2.getAge()) ? +1 : o1.getAge()<o2.getAge() ? -1:0;
        return cmp;
    }
}
