package factory;

import java.util.Objects;

public class BeanEntry {
    private String name;
    private Class<?> cl;

    public BeanEntry(String name, Class<?> cl) {
        this.name = name;
        this.cl = cl;
    }

    public String getName() {
        return name;
    }

    public Class<?> getCl() {
        return cl;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof BeanEntry){
            BeanEntry beanEntry = (BeanEntry) o;
            return Objects.equals(name, beanEntry.name) && Objects.equals(cl, beanEntry.cl);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cl);
    }
}
