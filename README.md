# Simulation

Simulation of a 2D world populated by herbivores and predators. In addition to the creatures, the world contains resources that the herbivores feed on, and static objects that cannot be interacted with - they just take up space.

## Prerequisites

- Java 17
- Maven

## Getting Started

To get a copy of the project up and running on your local machine, follow these steps.

### Installation

1. **Clone the repository**

    ```sh
    git clone https://github.com/PavelOkhrimchuk/Simulation.git
    cd Simulation
    ```

2. **Build the project using Maven**

    ```sh
    ./mvnw clean install
    ```

### Running the Simulation

1. **Run the simulation**

    By default, the simulation uses a 10x10 grid. 



  You can run the simulation directly from your IDE. Make sure to set the main class to `com.ohrim.AppRunner`.

### Customizing the Grid Size

To customize the grid size, you can modify the constructor of the `Map` class. The default constructor sets the grid size to 10x10. You can change it to your desired dimensions.

**Example:**

```java
public class Map {
    private int width;
    private int height;
    private HashMap<Coordinates, Entity> cells;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new HashMap<>();
    }

    public Map() {
        this(10, 10); // Change these values to set a different default size
    }

    // Rest of the Map class
}
