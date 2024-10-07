package Model;

public class AirplaneModel {
    public String Id;

    public String Type;

    public AirplaneModel(String id, String type){
        Id = id;
        Type = type;
    }

    @Override
    public String toString() {
        return "Id: " + Id + " | " + "Operação: " + Type;
    }
}
