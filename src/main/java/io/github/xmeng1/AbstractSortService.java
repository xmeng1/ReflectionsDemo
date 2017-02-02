package io.github.xmeng1;

import org.reflections.Reflections;

import java.util.Set;

/**
 * User:    mengxin
 * Date:    02/02/17
 * Project: ReflectionsDemo
 */
public abstract class AbstractSortService implements SortService{

    public String sort() {
        return null;
    }

    public int getTime() {
        return 0;
    }

    public static String bestSort() throws IllegalAccessException, InstantiationException {
        System.out.println("Start to find the best strategies for sort!\n");
        Reflections reflections = new Reflections("io.github.xmeng1");
        int lowestTime=100000;
        Class<? extends AbstractSortService> bestStrategy = null;
        Set<Class<? extends AbstractSortService>> subTypes = reflections.getSubTypesOf(AbstractSortService.class);
        int size = subTypes.size();
        System.out.println("There are " + size + " strategies to compare!\n");
        int i=0;
        for (Class<? extends AbstractSortService> subType : subTypes) {
            System.out.println("Check the " + (i+1) + " strategy!\n");
            AbstractSortService strategy = subType.newInstance();
            if (strategy.getTime() <= lowestTime) {
                System.out.println("The strategy time of " + strategy.getClass().getSimpleName() +
                        " is lower than current lowest time.\n");
                bestStrategy = subType;
                lowestTime = strategy.getTime();
            }else{
                System.out.println("The strategy time of " + strategy.getClass().getSimpleName() +
                        " is higher than current lowest time.\n");
            }
            i++;
        }
        assert bestStrategy != null;
        AbstractSortService strategy = bestStrategy.newInstance();
        return strategy.sort();
    }
}
