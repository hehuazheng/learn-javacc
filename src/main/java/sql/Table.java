package sql;

/**
 * Created by hejf on 2017/11/2.
 */
public class Table {
    private String name;
    private String alias;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public String toString() {
        return "[" + name + "," + alias + "]";
    }
}
