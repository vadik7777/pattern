package gof.behavior.iterator;

import java.util.Arrays;
import java.util.List;

public class IteratorApp {
    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        Iterator iterator = aggregate.createIterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());

        aggregate = new ConcreteAggregate1();
        iterator = aggregate.createIterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}

interface Iterator<E> {
    E next();

    boolean hasNext();
}

interface Aggregate<E> {
    Iterator<E> createIterator();
}

class ConcreteAggregate implements Aggregate<Integer> {

    private List<Integer> integerList = Arrays.asList(0, 1, 2, 3, 4, 5, 6);

    @Override
    public Iterator<Integer> createIterator() {
        return new ConcreteIterator(integerList);
    }
}

class ConcreteAggregate1 implements Aggregate<Integer> {

    private List<Integer> integerList = Arrays.asList(0, 1, 2, 3, 4, 5, 6);

    @Override
    public Iterator<Integer> createIterator() {
        return new ConcreteIterator1(integerList);
    }
}

class ConcreteIterator implements Iterator<Integer> {
    List<Integer> integerList;
    int cursor;

    ConcreteIterator(List<Integer> integerList) {
        this.integerList = integerList;
    }


    @Override
    public Integer next() {
        return integerList.get(cursor++);
    }

    @Override
    public boolean hasNext() {
        return integerList.size() > cursor;
    }
}

class ConcreteIterator1 implements Iterator<Integer> {
    List<Integer> integerList;
    int cursor;

    ConcreteIterator1(List<Integer> integerList) {
        this.integerList = integerList;
    }

    @Override
    public Integer next() {
        return integerList.get(cursor += 2);
    }

    @Override
    public boolean hasNext() {
        return integerList.size() > cursor + 2;
    }
}
