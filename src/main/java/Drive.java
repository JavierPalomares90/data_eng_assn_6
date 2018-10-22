import java.util.List;

public class Drive
{
    private static String TAB = "\t\t";
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
        Utils.dropTable();


        rows = null;
        System.gc();

        /** Variation II **/
        // Create the table
        Utils.createTable();
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
        // Drop  the table
        Utils.dropTable();

        System.out.print("\n\n");

        System.out.println("========VARIATION I==========");
        System.out.println(insertVar1/1000000000.0       + TAB + query1Var1/1000000000.0       + TAB + query2Var1/1000000000.0       + TAB + query3Var1/1000000000.0 + "\n");
        System.out.println(insertVar1IndexA/1000000000.0 + TAB + query1Var1IndexA/1000000000.0 + TAB + query2Var1IndexA/1000000000.0 + TAB + query3Var1IndexA/1000000000.0+ "\n");
        System.out.println(insertVar1IndexB/1000000000.0 + TAB + query1Var1IndexB/1000000000.0 + TAB + query2Var1IndexB/1000000000.0 + TAB + query3Var1IndexB/1000000000.0 + "\n");
        System.out.println(insertVar1IndexAB/1000000000.0 + TAB + query1Var1IndexAB/1000000000.0 + TAB + query2Var1IndexAB/1000000000.0 + TAB + query3Var1IndexAB/1000000000.0 + "\n");

        System.out.println("========VARIATION II==========");
        System.out.println(insertVar2/1000000000.0       + TAB + query1Var2/1000000000.0       + TAB + query2Var2/1000000000.0       + TAB + query3Var2/1000000000.0 + "\n");
        System.out.println(insertVar2IndexA/1000000000.0 + TAB + query1Var2IndexA/1000000000.0 + TAB + query2Var2IndexA/1000000000.0 + TAB + query3Var2IndexA/1000000000.0+ "\n");
        System.out.println(insertVar2IndexB/1000000000.0 + TAB + query1Var2IndexB/1000000000.0 + TAB + query2Var2IndexB/1000000000.0 + TAB + query3Var2IndexB/1000000000.0 + "\n");
        System.out.println(insertVar2IndexAB/1000000000.0 + TAB + query1Var2IndexAB/1000000000.0 + TAB + query2Var2IndexAB/1000000000.0 + TAB + query3Var2IndexAB/1000000000.0 + "\n");

        System.out.print("\n\n");
        System.out.println("========RELATIVE MEASUREMENTS==========");
        System.out.print("\n\n");

        System.out.println("========VARIATION I==========");
        System.out.println(insertVar1/insertVar1       + TAB + query1Var1/query1Var1       + TAB + query2Var1/query2Var1       + TAB + query3Var1/query3Var1 + "\n");
        System.out.println(insertVar1IndexA/insertVar1 + TAB + query1Var1IndexA/query1Var1 + TAB + query2Var1IndexA/query2Var1 + TAB + query3Var1IndexA/query3Var1+ "\n");
        System.out.println(insertVar1IndexB/insertVar1 + TAB + query1Var1IndexB/query1Var1 + TAB + query2Var1IndexB/query2Var1 + TAB + query3Var1IndexB/query3Var1 + "\n");
        System.out.println(insertVar1IndexAB/insertVar1 + TAB + query1Var1IndexAB/query1Var1 + TAB + query2Var1IndexAB/query2Var1 + TAB + query3Var1IndexAB/query3Var1 + "\n");

        System.out.println("========VARIATION II==========");
        System.out.println(insertVar2/insertVar1       + TAB + query1Var2/query1Var1       + TAB + query2Var2/query2Var1       + TAB + query3Var2/query3Var1 + "\n");
        System.out.println(insertVar2IndexA/insertVar1 + TAB + query1Var2IndexA/query1Var1 + TAB + query2Var2IndexA/query2Var1 + TAB + query3Var2IndexA/query3Var1+ "\n");
        System.out.println(insertVar2IndexB/insertVar1 + TAB + query1Var2IndexB/query1Var1 + TAB + query2Var2IndexB/query2Var1 + TAB + query3Var2IndexB/query3Var1 + "\n");
        System.out.println(insertVar2IndexAB/insertVar1 + TAB + query1Var2IndexAB/query1Var1 + TAB + query2Var2IndexAB/query2Var1 + TAB + query3Var2IndexAB/query3Var1 + "\n");


    }

}
