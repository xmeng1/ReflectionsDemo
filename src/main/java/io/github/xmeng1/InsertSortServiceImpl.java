package io.github.xmeng1;

/**
 * User:    mengxin
 * Date:    02/02/17
 * Project: ReflectionsDemo
 */
public class InsertSortServiceImpl extends AbstractSortService {
    @Override
    public String sort() {
        return "Insert Sort Service Strategy";
    }

    @Override
    public int getTime() {
        return 10;
    }
}
