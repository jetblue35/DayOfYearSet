/**
 * This class keeps DayOfYearSet information.
 * @author Muhammet_Emrah_Kucuk_1801042100
*/

package hw7;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;



public class DayOfYearSet
{
    public static class DayOfYear
    {
        /**
	    * Initializes day and month and increase numOfObj.
        */
        public DayOfYear()
        {
            day = 1;
            month = 1;
            ++numOfObj;
        }
        /**
	    * Initializes day and month and increase numOfObj.
        * @param newMonth .
        */
        public DayOfYear(int newMonth)
        {
            if(newMonth < 1 || newMonth > 12)
            {
                System.out.println("Illegal Month!!!\n");
                System.exit(1);
            }
            day = 1;
            month = newMonth;
            ++numOfObj;
        }
        /**
	    * Initializes day and month and increase numOfObj.
        * @param newDay and newMonth.
        */
        public DayOfYear(int newDay, int newMonth)
        {
            if(!check(newDay, newMonth))
            {
                System.out.println("Illegal Day or Month!!!\n");
                System.exit(1);
            }
            day = newDay;
            month = newMonth;
            ++numOfObj;
        }
        /**
	    * Sets day.
        * @param newDay .
        */
        public void setDay(int newDay){day = newDay;}
        /**
	    * Sets month.
        * @param newMonth .
        */
        public void setMonth(int newMonth){month = newMonth;}
        /**
	    * Returns day.
        * @return day.
        */
        public int getDay(){return day;}
        /**
	    * Returns month.
        * @return month.
        */
        public int getMonth(){return month;}
        /**
	    * Checks the day and month.
        * @return true or false if given date is valid or not.
        */
        public boolean check(int newDay, int newMonth)
        {
            if(newMonth < 1 || newMonth > 12)
                return false;
            if( (newMonth == 1) && (newDay < 1 || newDay > 31) )
                return false;
            else if( (newMonth == 2) && (newDay < 1 || newDay > 28) )
                return false;
            else if( (newMonth == 3) && (newDay < 1 || newDay > 31) )
                return false;        
            else if( (newMonth == 4) && (newDay < 1 || newDay > 30) )
                return false;
            else if( (newMonth == 5) && (newDay < 1 || newDay > 31) )
                return false;
            else if( (newMonth == 6) && (newDay < 1 || newDay > 30) )
                return false;
            else if( (newMonth == 7) && (newDay < 1 || newDay > 31) )
                return false;
            else if( (newMonth == 8) && (newDay < 1 || newDay > 31) )
                return false;
            else if( (newMonth == 9) && (newDay < 1 || newDay > 30) )
                return false;
            else if( (newMonth == 10) && (newDay < 1 || newDay > 31) )
                return false;
            else if( (newMonth == 11) && (newDay < 1 || newDay > 30) )
                return false;
            else if( (newMonth == 12) && (newDay < 1 || newDay > 31) )
                return false;   
            return true;
        }
        private int day;
        private int month;
        private static int numOfObj;
        /**
	    * Returns num of obj.
        * @return numOfObj.
        */
        public static int getNumOfObj(){return numOfObj;}

    }
    /**
	 * Returns size.
    */
    public int size(){return arrSize;}
    /**
	 * Returns capacity.
    */
    public int getCapacity(){return arrCapacity;}
    /**
	 * Constructor get capacity.
     * @param int given capacity.
	*/
    public DayOfYearSet(int newCapacity)
    {
        arrCapacity = newCapacity;
        arrSize = 0;
        if(newCapacity < 1)
        {
            System.out.println("Illegal capacity! Capacity is greater than 0!!!\n");
            System.exit(1);
        }
        arr = new DayOfYear[arrCapacity];
        
        for(int i = 0; i < arrCapacity; ++i)
        {
            arr[i] = new DayOfYear();
            arr[i].setDay(-1);
            arr[i].setMonth(-1);
        }
        
    }
    /**
	 * Constructor with ArrayList.
     * @param ArrayList<DayOfYear> given list.
	*/
    public DayOfYearSet(ArrayList<DayOfYear> doyList)
    {
        if(doyList.size() == 0)
        {
            System.out.println("ERROR! Day of Year list is empty!\n");
            System.exit(1);
        }
        arr = new DayOfYear[doyList.size()];
        for(int i = 0; i < doyList.size(); ++i)
        {
            arr[i] = new DayOfYear();
            arr[i] = doyList.get(i);
        }
            
        arrSize = doyList.size();
        arrCapacity = doyList.size();    
    }
    /**
	 * cpy constructor.
    */
    public DayOfYearSet(DayOfYearSet doyObj)
    {
        arrCapacity = doyObj.getCapacity();
        arrSize = doyObj.size();
        arr = new DayOfYear[arrCapacity];
        for(int i = 0; i < arrSize; ++i)
        {
            arr[i] = new DayOfYear();
            arr[i] = doyObj.arr[i];
        }
            
    }
    /**
	 * Returns the DayOfYear arr.
	 * @return arr.
    */
    public DayOfYear[] getArr(){return arr;}
    /**
	 * Returns true if add elements, return false if can not add.
	 * @return boolean.
     * @param DayOfYear given DayOfYear. 
     */
    public boolean add(DayOfYear newDoy)
    {
        if(arrSize < arrCapacity)
        {
            arr[arrSize].setDay(newDoy.getDay());
            arr[arrSize].setMonth(newDoy.getMonth());
            arrSize++;
            return true;
        }
        DayOfYear[] temp = new DayOfYear[arrCapacity * 2];
        
        for(int i = 0; i < arrSize; ++i)
        {
            temp[i] = new DayOfYear();
            temp[i].setDay(arr[i].getDay());
            temp[i].setMonth(arr[i].getMonth());
        }
        arr = null;
        arr = temp;
        arrCapacity *= 2;
        arr[arrSize].setDay(newDoy.getDay());
        arr[arrSize].setMonth(newDoy.getMonth());
        arrSize++;
        return true;
        
    }
    /**
	 * Remove the element of array in given index.
	 * @param index int given index. 
     */
    public void remove(int index)
    {
        for(int i = index; i < arrSize - 1; ++i)
        {
            arr[i].setDay(arr[i + 1].getDay());
            arr[i].setMonth(arr[i + 1].getMonth());
        }
        arr[arrSize - 1].setDay(-1);
        arr[arrSize - 1].setMonth(-1);
        arrSize--;
    }
    /**
	 * Returns a true or false if sets are equal or not.
	 * @return boolean.
     * @param DayOfYearSet given set. 
     */
    public boolean equals(DayOfYearSet other)
    {
        int counter = 0;
        if(this.size() != other.size())
            return false;
        for(int i = 0; i < this.size(); ++i)
            for(int j = 0; j < other.size(); ++j)
                if(this.getArr()[i].getDay() == other.getArr()[j].getDay() 
                    && this.getArr()[i].getMonth() == other.getArr()[j].getMonth())
                {
                    counter++;
                    break;
                }
        if(counter == this.size())
            return true;
        else
            return false;                    
    }
    /**
	 * Returns a union DayOfYearSet of the set.
	 * @return DayOfYearSet.
     * @param DayOfYearSet given set. 
     */
    public DayOfYearSet union(DayOfYearSet other)
    {
        int counter;
        DayOfYearSet newSet = new DayOfYearSet(this.size() + other.size());
        //newSet.arrSize = this.size() + other.size();
        for(int k = 0; k < this.size(); ++k)
            newSet.add(this.getArr()[k]);
        for(int i = 0; i < other.size(); ++i)
        {
            counter = 0;
            for(int j = 0; j < this.size(); ++j)
                if(this.getArr()[j].getDay() == other.getArr()[i].getDay()
                    && this.getArr()[j].getMonth() == other.getArr()[i].getMonth())
                    counter++;
            if(counter == 0)
                newSet.add(other.getArr()[i]);                
        }
        return newSet;    
    }
    /**
	 * Returns a difference DayOfYearSet of the set.
	 * @return DayOfYearSet.
     * @param DayOfYearSet given set. 
     */
    public DayOfYearSet difference(DayOfYearSet other)
    {
        int counter;
        DayOfYearSet newSet = new DayOfYearSet(this.size() + other.size());
        for(int i = 0; i < this.size(); ++i)
        {
            counter = 0;
            for(int j = 0; j < other.size(); ++j)
                if(this.getArr()[i].getDay() == other.getArr()[j].getDay()
                    && this.getArr()[i].getMonth() == other.getArr()[j].getMonth())
                    counter++;
            if(counter == 0)
                newSet.add(this.getArr()[i]);     
        }
        for(int i = 0; i < other.size(); ++i)
        {
            counter = 0;
            for(int j = 0; j < this.size(); ++j)
                if(this.getArr()[j].getDay() == other.getArr()[i].getDay()
                    && this.getArr()[j].getMonth() == other.getArr()[i].getMonth())
                    counter++;
            if(counter == 0)
                newSet.add(other.getArr()[i]);        
        }
        return newSet;
    }
    /**
	 * Returns a intersection DayOfYearSet of the set.
	 * @return DayOfYearSet.
     * @param DayOfYearSet given set. 
     */
    public DayOfYearSet intersection(DayOfYearSet other)
    {
        DayOfYearSet newSet = new DayOfYearSet(this.size());
        for(int i = 0; i < this.size(); ++i)
            for(int j = 0; j < other.size(); ++j)
                if(this.getArr()[i].getDay() == other.getArr()[j].getDay()
                    && this.getArr()[i].getMonth() == other.getArr()[j].getMonth())
                    newSet.add(this.getArr()[i]);
        return newSet;            
    }
    /**
	 * Returns a complement DayOfYearSet of the set.
	 * @return DayOfYearSet.
     */
    public DayOfYearSet complement()
    {
        DayOfYearSet newSet = new DayOfYearSet(365);
        DayOfYear newDoy = new DayOfYear();
        for(int i = 1; i <= 12; ++i)
        {
            for(int j = 1; j <= 31; ++j)
            {
                if( (i == 4 || i == 6 || i == 9 || i == 11) && j > 30 || (i == 2 && j > 28))
                    break;
                else
                {
                    if(arr[i].getDay() != i || arr[j].getMonth() != j)
                    {
                        newDoy.setDay(j);
                        newDoy.setMonth(i);
                        newSet.add(newDoy);
                    }
                }
            }
        }
        return newSet;
    }
    /**
	 * Returns a reference given position.
	 * @return a reference given position.
     * @param index integer index of array.
	 */
    public DayOfYear get(int index)
    {
        if(index < 0 || index >= arrSize)
        {
            System.out.println("Invalid index!!!\n");
            System.exit(1);
        }
        return arr[index];    
    }
    /**
	 * Returns a string representation of the object.
	 * @return a string representation of the object.
	 */
    @Override
    public String toString()
    {
        String newStr = new String();
        if(arrSize != 0)
        {
            for(int i = 0; i < arrSize; ++i)
            {
                newStr += "Day: " + arr[i].getDay() + " " + "Month: " + arr[i].getMonth(); 
                newStr += "\n";
            }
        }
        return newStr;
    }
    /**
	 * Writes to given file name.
	 * @param fileName file name to write.
	 */
    public void saveFile(String fileName)
    {
        try
        {
            FileWriter myFile = new FileWriter(fileName);
            if(arrSize != 0)
            {
                for(var i = 0; i < arrSize; ++i)
                {
                    myFile.write("Day: " + arr[i].getDay() + " " + "Month: " + arr[i].getMonth());
                    myFile.write("\n");
                }
            }
            myFile.close();
        }
        catch(IOException e)
        {
            System.out.println("Error occured.\n");
            e.printStackTrace();
        }
    }
    private DayOfYear[] arr;
    private int arrSize;
    private int arrCapacity;
        
}
