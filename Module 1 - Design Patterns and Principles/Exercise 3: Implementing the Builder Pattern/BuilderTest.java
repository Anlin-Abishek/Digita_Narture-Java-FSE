public class BuilderTest {
    public static void main(String[] args) {
        Computer basicComputer = new Computer.ComputerBuilder("500 GB", "8 GB")
                .build();

        Computer gamingComputer = new Computer.ComputerBuilder("2 TB", "32 GB")
                .setGraphicsCardEnabled(true)
                .setBluetoothEnabled(true)
                .build();

        System.out.println("Basic Computer Config: RAM = " + basicComputer.getRam() + 
                ", Graphics Card = " + basicComputer.isGraphicsCardEnabled());
                
        System.out.println("Gaming Computer Config: RAM = " + gamingComputer.getRam() + 
                ", Graphics Card = " + gamingComputer.isGraphicsCardEnabled());
    }
}
