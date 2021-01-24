
/**
 * Write a description of class Map here.
 *
 * @author Charlie O'Sullivan
 * @version 1.0
 */
public class Map
{
    private Room building;
    private Room start;
    private Room theatre;
    private Room pub;
    private Room lab;
    private Room office;
    private Room grate;
    private Room forest;
    private Room river;
    private Room tunnel;
    private Room treasureRoom;
    private String description;

    /**
     * Construtor for objects of class Map.
     */

    public Map()
    {
        createStart();
        createBuilding();
        createTheatre();
        createPub();
        createLab();
        createOffice();
        createGrate();
        createForest();
        createRiver();
        createTunnel();
        createTreasureRoom();
    }

    /**
     *
     */
    public Room getStartRoom()
    {
        return start;
    }

    /**
     * Starting room for the player.
     */
    private void createStart()
    {
        start = new Room(0, " outside Brick Building");

        description =
        " standing at the end of a road before a brick building \n" +
        "Around you is a forest. A small stream flows out \n" +
        "of the building and down a gully.";

        start.setWater();
        start.setDescription(description);
        start.setItem(ItemTypes.BOTTLE, "\n There is an empty bottle of water on the ground you can take.");
    }
    /**
     * Building north of the starting room, contating various items which
     * need to be picked up.
     */
    private void createBuilding()
    {
        building = new Room(1, "inside Brick Building");

        description = " in a well house for a large spring. ";

        building.setDescription(description);
        building.setItem(ItemTypes.KEY, "\n On the floor there are some keys you can pick up.");
        connectRooms(start, "north", building);
    }

    /**
     *
     */
    private void createTheatre()
    {
        theatre = new Room(2, "an eerily quiet Theatre");

        description = " Just left of the brick building \n";
        description += "the path down leads to a theatre. \n";

        theatre.setDescription(description);
        connectRooms(start, "east", theatre);
    }

    /**
     *
     */
    private void createPub()
    {
        pub = new Room(3, "A small, abandonded Pub");

        description = " at a pub, which is rundown and old. \n  ";
        description += "glass is shattered all across the floor.";
        pub.setDescription(description);

        connectRooms(start, "west", pub);
    }

    /**
     *
     */
    private void createLab()
    {
        lab = new Room(4, "A modern science lab");

        description = " There are various different beakers and science \n";
        description += "equipment throughout the room.";
        lab.setDescription(description);
        lab.setItem(ItemTypes.FOOD,
            "\n There are some apples in a bowl you could take.");

        connectRooms(start, "south", lab);
    }

    /**
     *
     */
    private void createOffice()
    {
        office = new Room(5, "The office to the science lab");

        description = " A professional office with a big desk \n";
        description += "and comfortable chair.";
        office.setDescription(description);

        connectRooms(lab, "west", office);
    }

    /**
      *
      */
    private void createGrate()
    {
      grate = new Room(6, "Beside a large locked grate");

      description = " Behind the lab, in the dirt \n";
      description += "there is a large metal grate \n";
      description += "it is locked, but if you had keys..";
      grate.setDescription(description);

      connectRooms(lab, "south", grate);
    }

    /**
      *
      */
    private void createRiver()
    {
      river = new Room(7, "Alongside a riverbed");

      description = " A large river spans across \n";
      description += "it being seemly endless.";
      river.setDescription(description);
      river.setWater();

      connectRooms(grate, "east", river);
    }

    private void createForest()
    {
      forest = new Room(8, "An expansive forest, full of life");

      description = " Trees cover the whole area in \n";
      description += "a cool shade.";
      forest.setDescription(description);
      forest.setItem(ItemTypes.FOOD,
          "\n There are an assortment of fruit you could take with you.");

      connectRooms(grate, "west", forest);
    }

    /**
     * 
     */
    private void createTunnel()
    {
        tunnel = new Room(9, "A dark and musty tunnel, down the grate");
        
        description = "It is a tight squeeze, but there is some light \n";
        description += "at the end of the tunnel.";
        tunnel.setDescription(description);
        
        connectRooms(grate, "down", tunnel);
    }
    
    /**
     * 
     */
    private void createTreasureRoom()
    {
        treasureRoom = new Room(10, "A brightly lit, almost glowing area. full of antiques");
        
        description = " A room which has been hidden away for a long time. \n";
        description = "It has a magical aura all around it.";
        treasureRoom.setDescription(description);
        
        treasureRoom.setItem(ItemTypes.TREASURE, 
            "\n There is an old chest filled with treasure");        
        
        connectRooms(tunnel, "right", treasureRoom);
    }
    
    
    private void connectRooms(Room room, String direction, Room otherRoom)
    {
        room.setExit(direction, otherRoom);

        if(direction.equals("east"))
        {
            otherRoom.setExit("west", room);
        }
        else if(direction.equals("west"))
        {
            otherRoom.setExit("east", room);
        }
        else if(direction.equals("north"))
        {
            otherRoom.setExit("south", room);
        }
        else if(direction.equals("south"))
        {
            otherRoom.setExit("north", room);
        }
        else if(direction.equals("down"))
        {
            otherRoom.setExit("up", room);
        }
        else if(direction.equals("up"))
        {
            otherRoom.setExit("down", room);
        }
    }

}
