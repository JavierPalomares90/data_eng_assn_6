import java.util.List;

public class Drive
{
    public static void main(String[] args) {
        /** Variation I **/
        Utils.load();
        // Create the table
        Utils.createTable();
        // Insert the data
        List<TableRow> rows = VariationI.generateRows(Utils.NUM_ROWS);
        double insertVar1 = Utils.insertData(rows);

        // Clear the cache
        // query 1
        Utils.clearCache();
        double query1Var1 = Utils.query1();
        // query 2
        Utils.clearCache();
        double query2Var1 = Utils.query2();
        // query 3
        Utils.clearCache();
        double query3Var1 = Utils.query3();

        // createIndexA
        Utils.createIndexA();
        // query 1
        Utils.clearCache();
        double query1Var1IndexA = Utils.query1();
        // query 2
        Utils.clearCache();
        double query2Var1IndexA = Utils.query2();
        // query 3
        Utils.clearCache();
        double query3Var1IndexA = Utils.query3();

        // drop Index a
        Utils.dropIndexA();

        // create Index B
        Utils.createIndexB();
        // query 1
        Utils.clearCache();
        double query1Var1IndexB = Utils.query1();
        // query 2
        Utils.clearCache();
        double query2Var1IndexB = Utils.query2();
        // query 3
        Utils.clearCache();
        double query3Var1IndexB = Utils.query3();

        // drop Index B
        Utils.dropIndexB();

        // create index AB
        Utils.createIndexAB();
        // query 1
        Utils.clearCache();
        double query1Var1IndexAB = Utils.query1();
        // query 2
        Utils.clearCache();
        double query2Var1IndexAB = Utils.query2();
        // query 3
        Utils.clearCache();
        double query3Var1IndexAB = Utils.query3();

        // Drop the table
        Utils.dropTable();
        // create the table;
        Utils.createTable();
        // create index A
        Utils.createIndexA();
        // load the date
        double insertVar1IndexA = Utils.insertData(rows);

        // Drop  the table
        Utils.dropTable();
        // create the table;
        Utils.createTable();
        // create index B
        Utils.createIndexB();
        // load the date
        double insertVar1IndexB = Utils.insertData(rows);

        // Drop  the table
        Utils.dropTable();
        // create the table;
        Utils.createTable();
        // create index AB
        Utils.createIndexAB();
        // load the date
        double insertVar1IndexAB = Utils.insertData(rows);



        /** Variation II **/
        rows = VariationII.generateRows(Utils.NUM_ROWS);
        double insertVar2 = Utils.insertData(rows);

        // Clear the cache
        // query 1
        Utils.clearCache();
        double query1Var2 = Utils.query1();
        // query 2
        Utils.clearCache();
        double query2Var2 = Utils.query2();
        // query 3
        Utils.clearCache();
        double query3Var2 = Utils.query3();

        // createIndexA
        Utils.createIndexA();
        // query 1
        Utils.clearCache();
        double query1Var2IndexA = Utils.query1();
        // query 2
        Utils.clearCache();
        double query2Var2IndexA = Utils.query2();
        // query 3
        Utils.clearCache();
        double query3Var2IndexA = Utils.query3();

        // drop Index a
        Utils.dropIndexA();

        // create Index B
        Utils.createIndexB();
        // query 1
        Utils.clearCache();
        double query1Var2IndexB = Utils.query1();
        // query 2
        Utils.clearCache();
        double query2Var2IndexB = Utils.query2();
        // query 3
        Utils.clearCache();
        double query3Var2IndexB = Utils.query3();

        // drop Index B
        Utils.dropIndexB();

        // create index AB
        Utils.createIndexAB();
        // query 1
        Utils.clearCache();
        double query1Var2IndexAB = Utils.query1();
        // query 2
        Utils.clearCache();
        double query2Var2IndexAB = Utils.query2();
        // query 3
        Utils.clearCache();
        double query3Var2IndexAB = Utils.query3();

        // Drop the table
        Utils.dropTable();
        // create the table;
        Utils.createTable();
        // create index A
        Utils.createIndexA();
        // load the date
        double insertVar2IndexA = Utils.insertData(rows);

        // Drop  the table
        Utils.dropTable();
        // create the table;
        Utils.createTable();
        // create index B
        Utils.createIndexB();
        // load the date
        double insertVar2IndexB = Utils.insertData(rows);

        // Drop  the table
        Utils.dropTable();
        // create the table;
        Utils.createTable();
        // create index AB
        Utils.createIndexAB();
        // load the date
        double insertVar2IndexAB = Utils.insertData(rows);
    }

}
