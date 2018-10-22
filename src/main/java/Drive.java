import java.util.List;

public class Drive
{
    private static String TAB = "\t\t";
    private static double NANOS_TO_SEC = 1000000000.0;

    public static void main(String[] args) {
        /** Variation I **/
        Utils.load();
        Utils.createDB("C:/Users/javie/Documents/Data_Engineering/hw6.db");
        // Create the table
        Utils.createTable();
        // Insert the data with no index
        List<TableRow> rows = VariationI.generateRows(Utils.NUM_ROWS);
        double insertVar1 = Utils.insertData(rows);

        // query 1 with no indices
        double query1Var1 = Utils.query1();
        // query 2
        double query2Var1 = Utils.query2();
        // query 3
        double query3Var1 = Utils.query3();

        // createIndexA
        Utils.createIndexA();

        // Query with indices
        // query 1
        double query1Var1IndexA = Utils.query1();
        // query 2
        double query2Var1IndexA = Utils.query2();
        // query 3
        double query3Var1IndexA = Utils.query3();

        // drop Index a
        Utils.dropIndexA();

        // create Index B
        Utils.createIndexB();
        // Query with index B
        // query 1
        double query1Var1IndexB = Utils.query1();
        // query 2
        double query2Var1IndexB = Utils.query2();
        // query 3
        double query3Var1IndexB = Utils.query3();


        // drop Index B
        Utils.dropIndexB();

        // create index AB
        Utils.createIndexAB();
        // Query iwth Index AB
        // query 1
        double query1Var1IndexAB = Utils.query1();
        // query 2
        double query2Var1IndexAB = Utils.query2();
        // query 3
        double query3Var1IndexAB = Utils.query3();

        // Drop the table
        Utils.dropTable();

        // create the table;
        Utils.createTable();
        // create index A
        Utils.createIndexA();
        // load the date with index A
        double insertVar1IndexA = Utils.insertData(rows);

        // Drop  the table
        Utils.dropTable();
        // create the table;
        Utils.createTable();
        // create index B
        Utils.createIndexB();
        // load the date with indexB
        double insertVar1IndexB = Utils.insertData(rows);

        // Drop  the table
        Utils.dropTable();
        // create the table;
        Utils.createTable();
        // create index AB
        Utils.createIndexAB();
        // load the date with index AB
        double insertVar1IndexAB = Utils.insertData(rows);
        Utils.dropTable();


        rows = null;
        System.gc();

        /** Variation II **/
        // Create the table
        Utils.createTable();
        // Insert data with no index
        rows = VariationII.generateRows(Utils.NUM_ROWS);
        double insertVar2 = Utils.insertData(rows);

        // Query with no indicex
        // query 1
        double query1Var2 = Utils.query1();
        // query 2
        double query2Var2 = Utils.query2();
        // query 3
        double query3Var2 = Utils.query3();

        // createIndexA
        // Query with index A
        Utils.createIndexA();
        // query 1
        double query1Var2IndexA = Utils.query1();
        // query 2
        double query2Var2IndexA = Utils.query2();
        // query 3
        double query3Var2IndexA = Utils.query3();

        // drop Index a
        Utils.dropIndexA();

        // create Index B

        Utils.createIndexB();
        // Query with Index B
        // query 1
        double query1Var2IndexB = Utils.query1();
        // query 2
        double query2Var2IndexB = Utils.query2();
        // query 3
        double query3Var2IndexB = Utils.query3();

        // drop Index B
        Utils.dropIndexB();

        // create index AB
        Utils.createIndexAB();
        // Query with index AB
        // query 1
        double query1Var2IndexAB = Utils.query1();
        // query 2
        double query2Var2IndexAB = Utils.query2();
        // query 3
        double query3Var2IndexAB = Utils.query3();

        // Drop the table
        Utils.dropTable();
        // create the table;
        Utils.createTable();
        // create index A
        Utils.createIndexA();
        // load the date with index A
        double insertVar2IndexA = Utils.insertData(rows);

        // Drop  the table
        Utils.dropTable();
        // create the table;
        Utils.createTable();
        // create index B
        Utils.createIndexB();

        // load the data with index B
        double insertVar2IndexB = Utils.insertData(rows);

        // Drop  the table
        Utils.dropTable();
        // create the table;
        Utils.createTable();
        // create index AB
        Utils.createIndexAB();
        // load the date with index AB
        double insertVar2IndexAB = Utils.insertData(rows);
        // Drop  the table
        Utils.dropTable();

        System.out.print("\n\n");

        System.out.println("========VARIATION I==========");
        System.out.println(insertVar1/NANOS_TO_SEC       + TAB + query1Var1/NANOS_TO_SEC       + TAB + query2Var1/NANOS_TO_SEC       + TAB + query3Var1/NANOS_TO_SEC + "\n");
        System.out.println(insertVar1IndexA/NANOS_TO_SEC + TAB + query1Var1IndexA/NANOS_TO_SEC + TAB + query2Var1IndexA/NANOS_TO_SEC + TAB + query3Var1IndexA/NANOS_TO_SEC+ "\n");
        System.out.println(insertVar1IndexB/NANOS_TO_SEC + TAB + query1Var1IndexB/NANOS_TO_SEC + TAB + query2Var1IndexB/NANOS_TO_SEC + TAB + query3Var1IndexB/NANOS_TO_SEC + "\n");
        System.out.println(insertVar1IndexAB/NANOS_TO_SEC + TAB + query1Var1IndexAB/NANOS_TO_SEC + TAB + query2Var1IndexAB/NANOS_TO_SEC + TAB + query3Var1IndexAB/NANOS_TO_SEC + "\n");

        System.out.println("========VARIATION II==========");
        System.out.println(insertVar2/NANOS_TO_SEC       + TAB + query1Var2/NANOS_TO_SEC       + TAB + query2Var2/NANOS_TO_SEC       + TAB + query3Var2/NANOS_TO_SEC + "\n");
        System.out.println(insertVar2IndexA/NANOS_TO_SEC + TAB + query1Var2IndexA/NANOS_TO_SEC + TAB + query2Var2IndexA/NANOS_TO_SEC + TAB + query3Var2IndexA/NANOS_TO_SEC+ "\n");
        System.out.println(insertVar2IndexB/NANOS_TO_SEC + TAB + query1Var2IndexB/NANOS_TO_SEC + TAB + query2Var2IndexB/NANOS_TO_SEC + TAB + query3Var2IndexB/NANOS_TO_SEC + "\n");
        System.out.println(insertVar2IndexAB/NANOS_TO_SEC + TAB + query1Var2IndexAB/NANOS_TO_SEC + TAB + query2Var2IndexAB/NANOS_TO_SEC + TAB + query3Var2IndexAB/NANOS_TO_SEC + "\n");

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
