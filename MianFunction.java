package lpDictionary;

public class MianFunction {
    public static void main(String [] args) {
        //CreateDictionary lp_a = new CreateDictionary();
        //lp_a.linkMySQlDatabase();
        //lp_a.CloseDatabase();


        InputInformation lp_b = new InputInformation();
        lp_b.linkMySQlDatabase();
        lp_b.CloseDatabase();

        OutputInformation lp_c = new OutputInformation();
        lp_c.linkMySQlDatabase();
        lp_c.CloseDatabase();
    }
}

