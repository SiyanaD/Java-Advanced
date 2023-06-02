package DefiningClassesExercises.P05CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;


    public Car(String model, Engine engine, int weight, String color) {//Engine engine - като втори параметър искаме да получаваме обект от класа Engine
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //"{CarModel}:
        sb.append(this.model).append(":").append(System.lineSeparator());//append(System.lineSeparator()) - нов ред

        //{EngineModel}:
        sb.append(this.engine.getModel()).append(":").append(System.lineSeparator());

        //Power: {EnginePower}
        sb.append("Power: ").append(this.engine.getPower()).append(System.lineSeparator());

        //Displacement: {EngineDisplacement}
        sb.append("Displacement: ");
        //нямаме = 0; имаме = цяло число
        if (this.engine.getDisplacement()==0){
            sb.append("n/a").append(System.lineSeparator());
        }
        else {
            sb.append(this.engine.getDisplacement()).append(System.lineSeparator());
        }

        //Efficiency: {EngineEfficiency}
        sb.append("Efficiency: ");
        //нямаме = null; имаме = текст
        if (this.engine.getEfficiency()==null){
            sb.append("n/a").append(System.lineSeparator());
        }
        else {
            sb.append(this.engine.getEfficiency()).append(System.lineSeparator());
        }

        //Weight: {CarWeight}
        sb.append("Weight: ");
        //нямаме = 0; имаме = цяло число
        if (this.weight==0){
            sb.append("n/a").append(System.lineSeparator());
        }
        else {
            sb.append(this.weight).append(System.lineSeparator());
        }


        //Color: {CarColor}"
        sb.append("Color: ");
        //нямаме = null; имаме = текст
        if (this.color==null){
            sb.append("n/a").append(System.lineSeparator());
        }
        else {
            sb.append(this.color).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
