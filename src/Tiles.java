public class Tiles
{
    private final String propertyName;
    private boolean isSold;
    private final int cost;
    private final int houseCost;
    private final int hotelCost;
    private final int rent;
    private final int set;
    private int numberOwnedInTheSet;
    private int numberOfHouses; //internal value
    private int numberOfHotels; //internal value
    private final int rentIncreaseForHouse; //internal value
    private final int rentIncreaseForHotel; //internal value

    public Tiles(String propertyName, int set, int cost, int rent)
    {
        this.propertyName = propertyName;
        this.set = set;
        this.cost = cost;
        this.rent = rent;
        this.houseCost = (int)(cost * 0.1);
        this.hotelCost = (int)(cost * 0.3);
        this.isSold = false;
        this.numberOfHouses = 0;
        this.numberOfHotels = 0;
        this.rentIncreaseForHouse = (int)(rent * 0.1);
        this.rentIncreaseForHotel = (int)(rent * 0.3);
        this.numberOwnedInTheSet = 0;
    }

    public void addHouse()
    {
        this.numberOfHouses ++;
    }

    public void addHotel()
    {
        this.numberOfHotels ++;
    }

    public int getRent()
    {
        if(this.set != 0) //Regular Property
        {
            if (this.numberOfHotels == 1)
                return this.rent + this.rentIncreaseForHotel;
            else
                return this.rent + (this.rentIncreaseForHouse * this.numberOfHouses);
        }
        else //Railroads
        {
            if(this.numberOwnedInTheSet == 0)
                return this.rent;
            else if(this.numberOwnedInTheSet == 1)
                return this.rent * 2;
            else if(this.numberOwnedInTheSet == 2)
                return this.rent * 4;
            else
                return this.rent * 8;
        }

    }

    public String getPropertyName()
    {
        return this.propertyName;
    }

    public boolean getIsSold()
    {
        return this.isSold;
    }

    public void setSold()
    {
        this.isSold = true;
    }

    public int getCost()
    {
        return this.cost;
    }

    public int getHouseCost()
    {
        return this.houseCost;
    }

    public int getHotelCost()
    {
        return this.hotelCost;
    }

    public int getSet()
    {
        return this.set;
    }

    public int getUtilCost(int diceRoll)
    {
        if(this.numberOwnedInTheSet == 0)
            return diceRoll * 4;
        else
            return diceRoll * 10;
    }

    public void increaseNumberOwnedInTheSet()
    {
        this.numberOwnedInTheSet ++;
    }


}
