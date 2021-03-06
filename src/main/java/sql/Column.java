package sql;

/**
 * Created by hejf on 2017/11/2.
 */
public class Column {
    private String table;
    private String name;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[" + table + "," + name + "]";
    }
}
