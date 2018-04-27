package lpDictionary;

public class MianFunction {
    public static void main(String [] args) {
        CreateDictionary lp_a = new CreateDictionary();
        lp_a.linkMySQlDatabase();
        lp_a.CloseDatabase();
    }
}
