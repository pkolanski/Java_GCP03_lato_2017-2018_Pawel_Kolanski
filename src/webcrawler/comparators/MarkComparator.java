package webcrawler.comparators;

import webcrawler.Student;

import java.util.Comparator;

public class MarkComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1,Student o2)
    {
        int cmp=o1.getMark()>o2.getMark()?+1:o1.getMark()<o2.getMark()?-1:0;
        return cmp;
    }
}
