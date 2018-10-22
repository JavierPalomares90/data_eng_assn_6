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
        double query1Var = Utils.query1();
        // query 2
        Utils.clearCache();
        double query2Var = Utils.query2();
        // query 3
        Utils.clearCache();
        double query3Var = Utils.query3();

        // createIndexA
        Utils.createIndexA();
        double query1VarIndexA = Utils.query1();
        // query 2
        Utils.clearCache();
        double query2VarIndexA = Utils.query2();
        // query 3
        Utils.clearCache();
        double query3VarIndexA = Utils.query3();




        // Variation II
    }

}
