import Model.TowerControl;

public class Main {
    public static void main(String[] args) {
        TowerControl tc = new TowerControl();

        int operator = -1;

        while(operator != 6){
            operator = tc.ShowControls();

            switch (operator){
                case 1:
                case 3:
                    break;
                case 2:
                    tc.AddLandQueue();
                    break;
                case 4:
                    tc.Land();
                    break;
                case 5:
                    tc.ShowAirportStatus();
                    break;
                case 6:
                    System.out.println("Até logo!");
                    break;
            }
        }

    }
}