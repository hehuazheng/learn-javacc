package sql;

import com.google.common.collect.Lists;

import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hejf on 2017/11/2.
 */
public class SqlParser {
    public static void main(String[] args) {
        validate("select ab");
    }

    public static void validate(String sql) {
        sql = normalize(sql);
        String[] tokens = sql.split("\\s+");
        if (tokens.length < 4 || !tokens[0].equals("select") || tokens[2].equals("from")) {
            throw new RuntimeException("illegal select statement");
        }

        int firstWhereIndex = -1;
        for (int i = 3; i < tokens.length; i++) {
            if(tokens[i].equals("select") || tokens[i].equals("from") || tokens[i].equals("union")) {
                throw new RuntimeException("illegal sql" + sql);
            }
            if(tokens[i].equals("where")) {
                firstWhereIndex = i;
            }
        }

        List<Column> columns = parseColumns(tokens[1]);

        int i = 4;
        boolean flag = true;
        boolean hasMoreTables = true;
        List<Table> tables = Lists.newArrayList();
        while (flag && i < tokens.length) {
            if (tokens[i].equals("left") || tokens[i].equals("right") || tokens[i].equals("inner") || tokens[i].equals("full") || tokens[i].equals("out")) {
                hasMoreTables = true;
                i++;
                continue;
            }

            if (i + 1 == tokens.length) {
                Table table = new Table();
                table.setName(tokens[i]);
                tables.add(table);
                break;
            } else if (i + 2 < tokens.length && tokens[i + 1].equals("as")) {
                Table table = new Table();
                table.setAlias(tokens[i + 2]);
                table.setName(tokens[i]);
                tables.add(table);
                i += 2;
            } else if (tokens[i + 1].equals("group") || tokens[i + 1].equals("order") || tokens[i + 1].equals("where") || tokens[i + 1].equals("limit")) {
                Table table = new Table();
                table.setName(tokens[i]);
                tables.add(table);
                tables.add(table);
                break;
            }
        }
    }

    public static String normalize(String sql) {
        sql = sql.toLowerCase().replaceAll("\\s+", " ").replaceAll("\\s*,\\s*", ",");
        for (String f : FUNCS) {
            sql = sql.replaceAll(f + "\\(", "").replaceAll("\\)", "");
        }
        return sql;
    }

    public static List<Column> parseColumns(String columnStr) {
        for (int i = 0; i < columnStr.length(); i++) {
            char c = columnStr.charAt(i);
            if (c == '_' || c == '.' || c == '(' || c == ')' || c == ',' || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                continue;
            }
            throw new RuntimeException("illegal sql");
        }
        String[] columns = columnStr.split(",");
        return Arrays.stream(columns).map(x -> {
            if (x.indexOf('.') == -1) {
                Column column = new Column();
                column.setName(x);
                return column;
            } else {
                String[] arr = x.split("\\.");
                if (arr.length > 2) {
                    throw new RuntimeException("illegal column: " + columnStr);
                }
                Column column = new Column();
                column.setTable(arr[0]);
                column.setName(arr[1]);
                return column;
            }
        }).collect(Collectors.toList());
    }

    static final String[] RESERVED_KEYWORDS = {"select", "from", "where", "on"};
    static final String[] FUNCS = {"count", "avg", "sum"};

    public static final int SELECT = 0;
    public static final int COLUMN = 1;
    public static final int FROM = 1;
    public static final int WHERE = 2;
}
